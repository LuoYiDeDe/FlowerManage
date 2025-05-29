package com.Luoyi.controller;

import com.coze.openapi.client.chat.CreateChatReq;
import com.coze.openapi.client.chat.model.ChatEvent;
import com.coze.openapi.client.chat.model.ChatEventType;
import com.coze.openapi.client.connversations.message.model.Message;
import com.coze.openapi.service.auth.TokenAuth;
import com.coze.openapi.service.service.CozeAPI;
import io.reactivex.Flowable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.util.Collections;

@RestController
@RequestMapping("/bot")
public class AIController {
    String token = "YouToken";
    String botID = "7509302961341431871";
    String userID = "@user6774265348";

    @RequestMapping("/ask")
    public SseEmitter get_ask(String mes) {
        // Get an access_token through personal access token or oauth.

        SseEmitter sseEmitter = new SseEmitter();

        TokenAuth authCli = new TokenAuth(token);

        // Init the Coze client through the access_token.
        CozeAPI coze =
                new CozeAPI.Builder()
                        .baseURL("https://api.coze.cn/v3/chat/")
                        .auth(authCli)
                        .readTimeout(60000)
                        .build();

        /*
         * Step one, create chat
         * Call the coze.chat().stream() method to create a chat. The create method is a streaming
         * chat and will return a Flowable ChatEvent. Developers should iterate the iterator to get
         * chat event and handle them.
         * */
        CreateChatReq req =
                CreateChatReq.builder()
                        .botID(botID)
                        .userID(userID)
                        .messages(Collections.singletonList(Message.buildUserQuestionText(mes)))
                        .build();

        Flowable<ChatEvent> resp = coze.chat().stream(req);
        resp.blockingForEach(
                event -> {
                    if (ChatEventType.CONVERSATION_MESSAGE_DELTA.equals(event.getEvent())) {
                        System.out.print(event.getMessage().getContent());
                        sseEmitter.send(SseEmitter.event().data(event.getMessage().getContent()));
                    }
                    if (ChatEventType.CONVERSATION_CHAT_COMPLETED.equals(event.getEvent())) {
                        System.out.println("Token usage:" + event.getChat().getUsage().getTokenCount());
                    }
                });
        System.out.println("done");
        coze.shutdownExecutor();

        //TODO
        System.out.println(sseEmitter);
        return sseEmitter;
    }
}
