package com.Luoyi.server;


import com.Luoyi.bean.User;

import java.util.List;

public interface UsersService {

    public List<User> getAllUsers();

    public void updateUser(User user);

}
