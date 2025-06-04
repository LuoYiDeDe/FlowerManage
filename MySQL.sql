# 用户信息表
CREATE TABLE users (
                       id INT PRIMARY KEY AUTO_INCREMENT COMMENT '用户ID，自增主键',
                       username VARCHAR(50) NOT NULL UNIQUE COMMENT '用户名，唯一标识',
                       password VARCHAR(100) NOT NULL COMMENT '加密后的用户密码',
                       phone VARCHAR(20) UNIQUE COMMENT '手机号，用于登录和联系',
                       role TINYINT DEFAULT 0 COMMENT '用户角色：0=普通用户，1=管理员',
                       level TINYINT DEFAULT 0 COMMENT '会员等级：0=普通会员，1=黄金会员'
) COMMENT '系统用户信息表';

INSERT INTO users (username, password, phone, role, level) VALUES
                                                               ('admin', '123123', '13800138000', 1, 1),
                                                               ('user1', '123123', '13800138001', 0, 0);
insert into users (username, password, phone, role, level) VALUES ('user2', '123123', '13800138891', 0, 1);

CREATE TABLE products (
                          id INT PRIMARY KEY AUTO_INCREMENT COMMENT '商品ID，自增主键',
                          name VARCHAR(100) NOT NULL COMMENT '商品名称',
                          description TEXT COMMENT '商品详细描述',
                          price DECIMAL(10,2) NOT NULL COMMENT '商品价格',
                          stock INT DEFAULT 0 COMMENT '库存数量',
                          category VARCHAR(50) COMMENT '商品分类',
                          image_url VARCHAR(255) COMMENT '商品图片URL',
                          status TINYINT DEFAULT 1 COMMENT '商品状态：1=上架，0=下架',
                          created_at DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '商品上架时间'
) COMMENT '商品信息表';

# 订单表
CREATE TABLE orders (
                        id INT PRIMARY KEY AUTO_INCREMENT COMMENT '订单ID，自增主键',
                        user_id INT NOT NULL COMMENT '关联用户ID',
                        order_no VARCHAR(32) NOT NULL UNIQUE COMMENT '订单号，唯一标识',
                        total_amount DECIMAL(10,2) NOT NULL COMMENT '订单总金额（已包含优惠）',
                        pay_status TINYINT DEFAULT 0 COMMENT '支付状态：0=未支付，1=已支付，2=已退款',
                        order_status TINYINT DEFAULT 0 COMMENT '订单状态：0=待发货，1=已发货，2=已完成',
                        address VARCHAR(255) NOT NULL COMMENT '收货地址',
                        created_at DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '订单创建时间',
                        pay_time DATETIME COMMENT '支付时间',
                        FOREIGN KEY (user_id) REFERENCES users(id)
) COMMENT '订单主表';

CREATE TABLE order_items (
                             id INT PRIMARY KEY AUTO_INCREMENT COMMENT '明细ID，自增主键',
                             order_id INT NOT NULL COMMENT '关联订单ID',
                             product_id INT NOT NULL COMMENT '关联商品ID',
                             quantity INT NOT NULL COMMENT '购买数量',
                             price DECIMAL(10,2) NOT NULL COMMENT '购买单价（下单时的商品价格）',
                             FOREIGN KEY (order_id) REFERENCES orders(id),
                             FOREIGN KEY (product_id) REFERENCES products(id)
) COMMENT '订单明细表，记录订单中的商品信息';

CREATE TABLE coupon_templates (
                                  id INT PRIMARY KEY AUTO_INCREMENT COMMENT '优惠券模板ID，自增主键',
                                  title VARCHAR(100) NOT NULL COMMENT '优惠券标题（如"满100减20"）',
                                  type TINYINT NOT NULL COMMENT '优惠券类型：0=满减，1=打折',
                                  discount_value DECIMAL(10,2) NOT NULL COMMENT '折扣值：满减金额或折扣比例（如20.00或0.8）',
                                  min_amount DECIMAL(10,2) NOT NULL COMMENT '最低消费金额（如100.00表示满100可用）'
) COMMENT '优惠券模板表，定义优惠券通用规则';

INSERT INTO coupon_templates (title, type, discount_value, min_amount) VALUES
                                                                           ('满100减20', 0, 20.00, 100.00),
                                                                           ('全场8折', 1, 0.80, 0.00);

CREATE TABLE user_coupons (
                              id INT PRIMARY KEY AUTO_INCREMENT COMMENT '用户优惠券ID，自增主键',
                              template_id INT NOT NULL COMMENT '关联优惠券模板ID',
                              user_id INT NOT NULL COMMENT '关联用户ID',
                              coupon_code VARCHAR(32) NOT NULL UNIQUE COMMENT '优惠券码，唯一标识',
                              is_used TINYINT DEFAULT 0 COMMENT '使用状态：0=未使用，1=已使用',
                              obtained_time DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '获取时间',
                              used_time DATETIME COMMENT '使用时间',
                              FOREIGN KEY (template_id) REFERENCES coupon_templates(id),
                              FOREIGN KEY (user_id) REFERENCES users(id)
) COMMENT '用户优惠券表，记录用户实际领取的优惠券';
-- 积分商品表
CREATE TABLE points_products (
                                 id INT PRIMARY KEY AUTO_INCREMENT COMMENT '商品ID，自增主键',
                                 name VARCHAR(100) NOT NULL COMMENT '商品名称',
                                 description TEXT COMMENT '商品详细描述',
                                 points_required INT NOT NULL COMMENT '兑换所需积分',
                                 stock INT DEFAULT 0 COMMENT '库存数量',
                                 category VARCHAR(50) COMMENT '商品分类',
                                 image_url VARCHAR(255) COMMENT '商品图片URL',
                                 status TINYINT DEFAULT 1 COMMENT '商品状态：1=上架，0=下架',
                                 created_at DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '商品上架时间'
) COMMENT '积分商城商品表';

INSERT INTO points_products (name, description, points_required, stock, category, image_url, status) VALUES
                                                                                                         ('智能手环', '多功能健康监测手环', 5000, 100, '电子产品', 'https://p5.itc.cn/q_70/images03/20210202/8a552d3f00e349b6abb7af1052ae98d0.png', 1),
                                                                                                         ('永生花礼盒', '永不凋谢的美丽，精致礼盒包装', 2000, 20, '礼盒', 'https://cbu01.alicdn.com/img/ibank/2018/714/283/10248382417_382876431.jpg', 1),
                                                                                                         ('花艺课程', '专业花艺师一对一教学', 3999, 20, '课程', 'https://ts1.tc.mm.bing.net/th/id/R-C.bc073e7970a1c5bf6d679c69bbe83b3f?rik=U5HmbKtapZ7MnA&riu=http%3a%2f%2fwww.fjglhs.com%2fimages%2fglhs%2fkt%2f7.jpg&ehk=4KfXx4K9MLRlLHyQkG9S5Op050u2qMvgWxN1yLf1tDY%3d&risl=&pid=ImgRaw&r=0', 1),
                                                                                                         ('蓝牙耳机', '无线立体声蓝牙耳机', 8000, 50, '电子产品', 'https://pic1.zhimg.com/v2-49a048616d42e56c459439a2a4eeb5d7_r.jpg', 1);

-- 用户积分账户表
CREATE TABLE user_points (
                             id INT PRIMARY KEY AUTO_INCREMENT COMMENT '记录ID',
                             user_id INT NOT NULL UNIQUE COMMENT '用户ID',
                             available_points INT DEFAULT 0 COMMENT '可用积分',
                             created_at DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                             FOREIGN KEY (user_id) REFERENCES users(id)
) COMMENT '用户积分账户表';

-- 积分兑换记录表
CREATE TABLE points_exchange (
                                 id INT PRIMARY KEY AUTO_INCREMENT COMMENT '记录ID',
                                 user_id INT NOT NULL COMMENT '用户ID',
                                 product_id INT NOT NULL COMMENT '商品ID',
                                 exchange_points INT NOT NULL COMMENT '消耗积分',
                                  exchange_time DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '兑换时间',
                                 status TINYINT DEFAULT 0 COMMENT '状态：0=待处理，1=已发货，2=已完成',
                                 tracking_number VARCHAR(50) COMMENT '物流单号',
                                 FOREIGN KEY (user_id) REFERENCES users(id),
                                 FOREIGN KEY (product_id) REFERENCES points_products(id)
) COMMENT '积分兑换记录表';

drop table user_coupons;

-- 删除现有外键约束
ALTER TABLE order_items DROP FOREIGN KEY order_items_ibfk_1;

-- 重新添加带有级联删除的外键约束
ALTER TABLE order_items
    ADD CONSTRAINT order_items_ibfk_1
        FOREIGN KEY (order_id) REFERENCES orders (id)
            ON DELETE CASCADE;

