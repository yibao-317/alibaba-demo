-- 用户表
CREATE TABLE `user`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `uname` varchar(30) CHARACTER SET utf8 DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '用户密码',
  `flag` int(0) DEFAULT 0 COMMENT '是否删除：0用户名存在 1用户已删除',
  PRIMARY KEY (`id`)
);

-- 订单表
CREATE TABLE `order`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `uid` int(0) DEFAULT NULL COMMENT '订单用户id',
  `price` decimal(10, 2) DEFAULT NULL COMMENT '订单价格',
  `detail` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '订单详情',
  `create_time` datetime(0) DEFAULT NULL COMMENT '订单创建时间',
  `update_time` datetime(0) DEFAULT NULL COMMENT '订单修改时间',
  `flag` int(0) DEFAULT 1 COMMENT '订单是否生效：0不生效 1生效',
  PRIMARY KEY (`id`)
);

-- 用户信息
insert into `user` (`uname`, `password`) values('admin','123');
insert into `user` (`uname`, `password`) values('张三','111');
insert into `user` (`uname`, `password`) values('李四','222');
insert into `user` (`uname`, `password`) values('王五','333');
insert into `user` (`uname`, `password`) values('南一','122');
insert into `user` (`uname`, `password`) values('怡宝','6766');


INSERT INTO `order` VALUES (1, 1, 99.99, 'PS5', '2022-11-11 11:22:43', '2022-11-11 11:22:45', 1);
INSERT INTO `order` VALUES (2, 1, 39.90, 'XBOX', '2022-11-11 11:25:31', '2022-11-11 11:25:33', 1);
INSERT INTO `order` VALUES (3, 2, 2388.00, '洗地机', '2022-11-11 11:25:52', '2022-11-11 11:25:54', 1);
INSERT INTO `order` VALUES (4, 3, 5684.00, '烘干机', '2022-11-11 11:26:16', '2022-11-11 11:26:18', 1);
