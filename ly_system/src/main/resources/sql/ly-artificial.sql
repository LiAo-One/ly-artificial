/*
 Navicat Premium Data Transfer

 Source Server         : 120.55.96.180_3306
 Source Server Type    : MySQL
 Source Server Version : 50635
 Source Host           : 120.55.96.180:3306
 Source Schema         : ly-artificial

 Target Server Type    : MySQL
 Target Server Version : 50635
 File Encoding         : 65001

 Date: 23/01/2021 15:31:08
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_admin
-- ----------------------------
DROP TABLE IF EXISTS `sys_admin`;
CREATE TABLE `sys_admin`  (
  `admin_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '管理员主键',
  `admin_account` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '账户',
  `admin_password` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '密码',
  `admin_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '姓名',
  `admin_sex` char(1) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '性别',
  `admin_avatar` varchar(500) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '头像连接',
  `admin_email` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '邮箱',
  `admin_nickname` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '昵称',
  `admin_remarks` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '备注',
  `version` int(10) NULL DEFAULT 1 COMMENT '乐观锁',
  `deleted` int(1) NULL DEFAULT 0 COMMENT '逻辑删除',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`admin_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1343485125261815810 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '管理员' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_admin
-- ----------------------------
INSERT INTO `sys_admin` VALUES (1, '123', '123', 'LiAo', '男', '789415', '12346578@qq.com', 'Mr.Wick', NULL, 1, 0, NULL, '2021-01-04 20:32:50');
INSERT INTO `sys_admin` VALUES (2, '123', '456', 'LiAo', '女', '78945', '123456@qq.com', 'Mr.Wick', NULL, 1, 0, NULL, '2020-12-28 16:09:16');
INSERT INTO `sys_admin` VALUES (3, '789', '789', NULL, NULL, NULL, NULL, NULL, NULL, 1, 0, NULL, NULL);
INSERT INTO `sys_admin` VALUES (4, '963', '963', NULL, NULL, NULL, NULL, NULL, NULL, 1, 0, NULL, NULL);
INSERT INTO `sys_admin` VALUES (5, '741', '741', NULL, NULL, NULL, NULL, NULL, NULL, 1, 0, NULL, NULL);
INSERT INTO `sys_admin` VALUES (1339032578400731137, 'liao', 'liao', 'LiAo', '女', '', 'liao991224@gmail.com', '冯秋阳是猪', NULL, 2, 0, '2020-12-16 10:20:19', '2021-01-11 20:26:57');
INSERT INTO `sys_admin` VALUES (1339052493551714305, '====>', '模板测试', 'LiAo', '男', '123', '132456789@qq.com', 'Mr.Wick', NULL, 1, 0, '2020-12-16 11:39:28', '2020-12-28 15:22:01');
INSERT INTO `sys_admin` VALUES (1339385442268663810, '测试', 'admin', NULL, NULL, NULL, NULL, NULL, NULL, 1, 0, '2020-12-17 09:42:29', '2020-12-17 09:44:07');
INSERT INTO `sys_admin` VALUES (1343475636072640513, '789', '789', '789', '男', '789', '789@aa.com', '789', NULL, 1, 0, '2020-12-28 16:35:27', '2020-12-28 16:35:27');
INSERT INTO `sys_admin` VALUES (1343477268881633281, '123', '123', '123', '男', '13', '123@123.com', '123', NULL, 1, 0, '2020-12-28 16:41:56', '2020-12-28 16:41:56');
INSERT INTO `sys_admin` VALUES (1343485125261815809, '2345', '2345', '2345', '男', '2345', '2345@2345.com', '2345', NULL, 1, 0, '2020-12-28 17:13:09', '2020-12-28 17:13:09');

-- ----------------------------
-- Table structure for sys_admin_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_admin_role`;
CREATE TABLE `sys_admin_role`  (
  `admin_id` bigint(20) NULL DEFAULT NULL COMMENT '用户id',
  `role_id` bigint(20) NULL DEFAULT NULL COMMENT '角色id',
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '管理员角色关联表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_admin_role
-- ----------------------------
INSERT INTO `sys_admin_role` VALUES (1339032578400731137, 1, 1);
INSERT INTO `sys_admin_role` VALUES (1339032578400731137, 1, 2);
INSERT INTO `sys_admin_role` VALUES (1339032578400731137, 1, 3);
INSERT INTO `sys_admin_role` VALUES (1339032578400731137, 1, 4);
INSERT INTO `sys_admin_role` VALUES (1339032578400731137, 1, 5);
INSERT INTO `sys_admin_role` VALUES (2, 1, 6);
INSERT INTO `sys_admin_role` VALUES (1343475636072640513, 1, 7);
INSERT INTO `sys_admin_role` VALUES (1343477268881633281, 1, 8);
INSERT INTO `sys_admin_role` VALUES (1343485125261815809, 1, 9);

-- ----------------------------
-- Table structure for sys_alarm_notice
-- ----------------------------
DROP TABLE IF EXISTS `sys_alarm_notice`;
CREATE TABLE `sys_alarm_notice`  (
  `notice_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '通知id',
  `notice_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '通知名称',
  `device_sn` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '设备SN',
  `notice_interval` double(10, 2) NULL DEFAULT 0.00 COMMENT '推送间隔 分钟',
  `notice_theway` varchar(250) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '推送方式 0：短信 1 微信 2 邮件 3 语音 多个用 “,” 隔开',
  `notice_people` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '推送人的id，多个用“,” 隔开',
  `version` int(10) NULL DEFAULT 1 COMMENT '乐观锁',
  `deleted` int(1) NULL DEFAULT 0 COMMENT '逻辑删除',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`notice_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1352099647908331523 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '报警通知' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_alarm_notice
-- ----------------------------
INSERT INTO `sys_alarm_notice` VALUES (1352096131454189570, '测试', '123', 1.00, '3,0,1', '1231', 1, 0, '2021-01-21 13:36:54', '2021-01-21 11:30:13');
INSERT INTO `sys_alarm_notice` VALUES (1352096400334241794, '测试啊', '456', 6.30, '2', '1452', 1, 0, '2021-01-21 13:36:46', '2021-01-21 11:31:17');
INSERT INTO `sys_alarm_notice` VALUES (1352099647908331522, '测', 'dasd', 1.00, '0,1', '1352087938862792705,1352088011210342401', 1, 0, '2021-01-21 14:16:05', '2021-01-21 11:44:12');

-- ----------------------------
-- Table structure for sys_alarm_record
-- ----------------------------
DROP TABLE IF EXISTS `sys_alarm_record`;
CREATE TABLE `sys_alarm_record`  (
  `record_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '设备id',
  `device_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '设备名称',
  `slave_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '从机名称',
  `variable_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '变量名称',
  `current_valuet` double(10, 2) NULL DEFAULT 0.00 COMMENT '当前值',
  `current_spark` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '触发条件',
  `student` int(1) NULL DEFAULT 0 COMMENT '当前状态 0正常 1异常',
  `is_process` int(1) NULL DEFAULT 0 COMMENT '是否处理 0处理 1 未处理',
  `version` int(10) NULL DEFAULT 1 COMMENT '乐观锁',
  `deleted` int(1) NULL DEFAULT 0 COMMENT '逻辑删除',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`record_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1352873157328945154 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '报警记录' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_alarm_record
-- ----------------------------
INSERT INTO `sys_alarm_record` VALUES (1352149386527838210, '设备名称', '从机名称', '变量名称', 1.00, '触发条件', 0, 0, 1, 0, '2021-01-21 15:01:50', '2021-01-21 15:01:50');
INSERT INTO `sys_alarm_record` VALUES (1352151440440758273, '设备名称', '从机名称', '变量名称', 1.00, '触发条件', 1, 0, 1, 0, '2021-01-21 15:10:03', '2021-01-21 15:10:00');
INSERT INTO `sys_alarm_record` VALUES (1352873157328945153, '测试', '测试', '测试', 12.00, '测试', 1, 0, 1, 0, '2021-01-23 14:57:51', '2021-01-23 14:57:51');

-- ----------------------------
-- Table structure for sys_alarmcontact
-- ----------------------------
DROP TABLE IF EXISTS `sys_alarmcontact`;
CREATE TABLE `sys_alarmcontact`  (
  `contact_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '联系人id',
  `contact_naem` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系人姓名',
  `contact_phon` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系人手机',
  `contact_email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `contact_wachat` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '微信',
  `contact_project` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所属项目',
  `remarks` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `version` int(10) NULL DEFAULT 1 COMMENT '乐观锁',
  `deleted` int(1) NULL DEFAULT 0 COMMENT '逻辑删除',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`contact_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1352872740310269954 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '报警联系人' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_alarmcontact
-- ----------------------------
INSERT INTO `sys_alarmcontact` VALUES (1352087938862792705, '姓名', '手机', 'asdasd', '微信', '核电站', NULL, 1, 0, '2021-01-21 10:57:40', '2021-01-21 10:59:11');
INSERT INTO `sys_alarmcontact` VALUES (1352088011210342401, ' 姓名', NULL, NULL, NULL, NULL, NULL, 1, 0, '2021-01-21 10:57:57', '2021-01-21 10:57:57');
INSERT INTO `sys_alarmcontact` VALUES (1352872740310269953, '测试', NULL, NULL, NULL, '核电站', NULL, 1, 0, '2021-01-23 14:56:11', '2021-01-23 14:56:11');

-- ----------------------------
-- Table structure for sys_alarmlog
-- ----------------------------
DROP TABLE IF EXISTS `sys_alarmlog`;
CREATE TABLE `sys_alarmlog`  (
  `alarmlog_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '日志id',
  `alarmlog_type` int(2) NULL DEFAULT 1 COMMENT '报警类型（0: 流量池-流量不足预警 1: 套餐到期提醒 2：套餐临期预警）',
  `alarmlog_content` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '报警内容',
  `relation_amount` int(10) NULL DEFAULT 1 COMMENT '警报关联数量',
  `state` int(2) NULL DEFAULT 0 COMMENT '状态（0: 未查看 1: 已查看）',
  `version` int(10) NULL DEFAULT 1 COMMENT '乐观锁',
  `deleted` int(1) NULL DEFAULT 0 COMMENT '逻辑删除',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`alarmlog_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1352876410812809218 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '报警日志表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_alarmlog
-- ----------------------------
INSERT INTO `sys_alarmlog` VALUES (1352852545910915073, 0, '报警内容', 1, 0, 1, 0, '2021-01-23 13:35:56', '2021-01-23 13:35:56');
INSERT INTO `sys_alarmlog` VALUES (1352852785346953218, 2, '报警内容', 12, 1, 1, 0, '2021-01-23 13:37:02', '2021-01-23 13:36:53');
INSERT INTO `sys_alarmlog` VALUES (1352852883057459201, 1, '报警内容', 12, 1, 1, 0, '2021-01-23 13:37:54', '2021-01-23 13:37:17');
INSERT INTO `sys_alarmlog` VALUES (1352876410812809217, 1, 'relationAmount', 1, 0, 1, 0, '2021-01-23 15:10:46', '2021-01-23 15:10:46');

-- ----------------------------
-- Table structure for sys_card_dealing
-- ----------------------------
DROP TABLE IF EXISTS `sys_card_dealing`;
CREATE TABLE `sys_card_dealing`  (
  `dealing_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '卡分配id',
  `dealing_userid` bigint(20) NULL DEFAULT NULL COMMENT '用户id',
  `dealing_account` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '账户',
  `dealing_iccid` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'ICCID',
  `operators` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '运营商',
  `billing_type` int(1) NULL DEFAULT 0 COMMENT '计费类型',
  `version` int(10) NULL DEFAULT 1 COMMENT '乐观锁',
  `deleted` int(1) NULL DEFAULT 0 COMMENT '逻辑删除',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`dealing_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1352874528480477187 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '卡分配表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_card_dealing
-- ----------------------------
INSERT INTO `sys_card_dealing` VALUES (1, 123123, '123123', 'ICCID', '运营商', 1, 1, 0, '2021-01-22 15:16:43', '2021-01-22 15:16:43');
INSERT INTO `sys_card_dealing` VALUES (1352516015237410818, 123123, '123123', '123123', '123123', 0, 1, 0, '2021-01-23 15:04:33', '2021-01-22 15:18:41');
INSERT INTO `sys_card_dealing` VALUES (1352874528480477186, 789, '测试', '测试', '测试', 1, 1, 0, '2021-01-23 15:03:17', '2021-01-23 15:03:17');

-- ----------------------------
-- Table structure for sys_card_dxnb
-- ----------------------------
DROP TABLE IF EXISTS `sys_card_dxnb`;
CREATE TABLE `sys_card_dxnb`  (
  `dxnb_card_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '电信NB卡主键',
  `dxnb_num` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '卡号',
  `dxnbiccid` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'ICCID',
  `dxnb_operators` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '运营商',
  `card_type` int(1) NULL DEFAULT 0 COMMENT '类别 0：年卡 ',
  `card_state` int(1) NULL DEFAULT 0 COMMENT '状态 0：正常',
  `card_acti_date` date NULL DEFAULT NULL COMMENT '激活时间',
  `card_timeout` date NULL DEFAULT NULL COMMENT '过期时间',
  `card_remind` int(1) NULL DEFAULT NULL COMMENT '提醒（0：开启:1：关闭）',
  `card_pms` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'pms模式',
  `card_batchnum` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '批次号',
  `card_lable` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '标签',
  `card_note` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `card_relation1` bigint(20) NULL DEFAULT NULL COMMENT ' 关联（用户）',
  `card_user_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户姓名',
  `version` int(10) NULL DEFAULT 1 COMMENT '乐观锁',
  `deleted` int(1) NULL DEFAULT 0 COMMENT '逻辑删除',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`dxnb_card_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1352874176439959555 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '电信NB卡表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_card_dxnb
-- ----------------------------
INSERT INTO `sys_card_dxnb` VALUES (1, '卡号', ' ICCID', '运营商', 0, 0, '2021-01-22', '2022-01-22', 0, 'pms模式', '批次号', '标签', ' 备注', 12346578, '用户姓名', 1, 0, '2021-01-22 13:37:33', '2021-01-22 13:37:33');
INSERT INTO `sys_card_dxnb` VALUES (1352491237847883778, '卡号', 'ICCID', '运营商', 1, 1, '2021-01-22', '2022-01-12', 1, 'pms模式', '批次号', '标签', '备注', 7894561, ' 用户姓名', 1, 0, '2021-01-22 13:40:14', '2021-01-22 13:40:14');
INSERT INTO `sys_card_dxnb` VALUES (1352874176439959554, '测试', '测试', '测试', 1, 1, '2021-01-23', '2021-01-29', 1, '测试', '测试', '测试', '测试', 789, '测试', 1, 0, '2021-01-23 15:01:54', '2021-01-23 15:01:54');

-- ----------------------------
-- Table structure for sys_card_flow
-- ----------------------------
DROP TABLE IF EXISTS `sys_card_flow`;
CREATE TABLE `sys_card_flow`  (
  `flow_card_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '流量卡主键',
  `card_num` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '卡号',
  `card_iccid` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'ICCID',
  `operators` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '运营商',
  `card_type` int(10) NULL DEFAULT 0 COMMENT '类别 0：年卡 ',
  `card_state` int(10) NULL DEFAULT 0 COMMENT '状态 0：正常',
  `card_tit_flow` double(10, 2) NULL DEFAULT NULL COMMENT '年流量',
  `card_used_flow` double(10, 2) NULL DEFAULT NULL COMMENT '已使用',
  `card_have_flow` double(10, 2) NULL DEFAULT NULL COMMENT '剩余流量',
  `card_acti_date` date NULL DEFAULT NULL COMMENT '激活时间',
  `card_timeout` date NULL DEFAULT NULL COMMENT '过期时间',
  `card_remind` int(1) NULL DEFAULT 1 COMMENT '提醒（0：开启:1：关闭）',
  `card_batchnum` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '批次号',
  `card_auth_state` int(1) NULL DEFAULT 0 COMMENT '认证状态（0：需要 1：不需要）',
  `card_lable` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '标签',
  `card_note` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `card_userid` bigint(20) NULL DEFAULT NULL COMMENT ' 用户id',
  `card_user_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户姓名',
  `version` int(10) NULL DEFAULT 1 COMMENT '乐观锁',
  `deleted` int(1) NULL DEFAULT 0 COMMENT '逻辑删除',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`flow_card_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1352874026166435843 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '流量卡表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_card_flow
-- ----------------------------
INSERT INTO `sys_card_flow` VALUES (1352458332178219009, '卡号', 'ICCID', '运营商', 0, 0, 1000.00, 500.00, 500.00, '2021-01-22', '2022-01-20', 0, '批次号', 0, '标签', '备注', 123456, '用户姓名', 1, 0, '2021-01-22 11:29:29', '2021-01-22 11:29:29');
INSERT INTO `sys_card_flow` VALUES (1352460681881845761, '卡号', 'ICCID', '运营商', 1, 1, 152.00, 25.00, 127.00, '2021-01-22', '2022-01-22', 1, '批次号', 1, '标签', '备注', 789456, '用户姓名', 1, 0, '2021-01-22 11:38:49', '2021-01-22 11:38:49');
INSERT INTO `sys_card_flow` VALUES (1352874026166435842, 'repairId', 'repairId', 'repairId', 1, 1, 123.00, 789.00, 456.00, '2021-01-15', '2021-01-04', 1, 'repairId', 1, 'repairId', 'repairId', 7897489, 'repairIdrepairId', 1, 0, '2021-01-23 15:01:18', '2021-01-23 15:01:18');

-- ----------------------------
-- Table structure for sys_card_flowpool
-- ----------------------------
DROP TABLE IF EXISTS `sys_card_flowpool`;
CREATE TABLE `sys_card_flowpool`  (
  `flowpool_card_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '流量池卡主键',
  `flowpool_pond_id` bigint(20) NULL DEFAULT NULL COMMENT '流量池id',
  `flowpool_num` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '卡号',
  `flowpool_iccid` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'ICCID',
  `operators` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '运营商',
  `card_type` int(1) NULL DEFAULT 0 COMMENT '类别 0：年卡 1：月卡',
  `card_state` int(1) NULL DEFAULT 0 COMMENT '状态 0：正常 1：停机',
  `card_tit_flow` double(10, 2) NULL DEFAULT 0.00 COMMENT '年流量',
  `card_used_flow` double(10, 2) NULL DEFAULT 0.00 COMMENT '已使用',
  `card_have_flow` double(10, 2) NULL DEFAULT 0.00 COMMENT '剩余流量',
  `card_acti_date` date NULL DEFAULT NULL COMMENT '激活时间',
  `card_timeout` date NULL DEFAULT NULL COMMENT '过期时间',
  `card_batchnum` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '批次号',
  `card_relation1` bigint(20) NULL DEFAULT NULL COMMENT '用户id',
  `card_user_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户姓名',
  `version` int(10) NULL DEFAULT 1 COMMENT '乐观锁',
  `deleted` int(1) NULL DEFAULT 0 COMMENT '逻辑删除',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`flowpool_card_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1352874314159931395 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '流量池卡表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_card_flowpool
-- ----------------------------
INSERT INTO `sys_card_flowpool` VALUES (1352496427388919809, 12345678, '卡号', 'ICCID', ' 运营商', 0, 0, 100.00, 25.25, 75.00, '2021-01-21', '2022-01-22', ' 批次号', 123123, '用户姓名', 1, 0, '2021-01-22 14:01:20', '2021-01-22 14:00:51');
INSERT INTO `sys_card_flowpool` VALUES (1352496771355402241, 132123, '卡号', 'ICCID', '运营商', 1, 1, 100.25, 75.25, 25.25, '2021-01-22', '2022-01-14', '批次号', 13123123, ' 用户姓名', 1, 0, '2021-01-22 14:02:13', '2021-01-22 14:02:13');
INSERT INTO `sys_card_flowpool` VALUES (1352874314159931394, 123121, '测试', '测试', '测试', 1, 1, 789.00, 456.00, 369.00, '2021-01-29', '2021-01-29', '测试', 789, '369', 1, 0, '2021-01-23 15:02:26', '2021-01-23 15:02:26');

-- ----------------------------
-- Table structure for sys_cardcancel
-- ----------------------------
DROP TABLE IF EXISTS `sys_cardcancel`;
CREATE TABLE `sys_cardcancel`  (
  `cancel_card_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '解绑记录表ID',
  `annal_cardnum` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '卡号',
  `annal_iccid` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'ICCID',
  `state` int(2) NULL DEFAULT NULL COMMENT '状态（0: 成功 1: 失败）',
  `version` int(10) NULL DEFAULT 1 COMMENT '乐观锁',
  `deleted` int(1) NULL DEFAULT 0 COMMENT '逻辑删除',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`cancel_card_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1352875980053594114 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '解绑卡机表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_cardcancel
-- ----------------------------
INSERT INTO `sys_cardcancel` VALUES (1352809129860775937, '卡号', 'ICCID', 0, 1, 0, '2021-01-23 10:43:25', '2021-01-23 10:43:25');
INSERT INTO `sys_cardcancel` VALUES (1352809159871021058, '卡号', 'ICCID', 1, 1, 0, '2021-01-23 10:43:32', '2021-01-23 10:43:32');
INSERT INTO `sys_cardcancel` VALUES (1352875980053594113, '测试', '测试', 1, 1, 0, '2021-01-23 15:09:04', '2021-01-23 15:09:04');

-- ----------------------------
-- Table structure for sys_cardlabel
-- ----------------------------
DROP TABLE IF EXISTS `sys_cardlabel`;
CREATE TABLE `sys_cardlabel`  (
  `label_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `label_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '标签名称',
  `member_amount` int(10) NULL DEFAULT NULL COMMENT '成员数量',
  `version` int(10) NULL DEFAULT 1 COMMENT '乐观锁',
  `deleted` int(1) NULL DEFAULT 0 COMMENT '逻辑删除',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`label_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1352507472312619011 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '标签表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_cardlabel
-- ----------------------------
INSERT INTO `sys_cardlabel` VALUES (1352507472312619010, '标签名称cc', 123456, 1, 0, '2021-01-22 14:47:14', '2021-01-22 14:44:44');

-- ----------------------------
-- Table structure for sys_cardwhitelist
-- ----------------------------
DROP TABLE IF EXISTS `sys_cardwhitelist`;
CREATE TABLE `sys_cardwhitelist`  (
  `white_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '白名单id',
  `white_ip` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '白名单ip',
  `dest_operators` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '运营商',
  `state` int(2) NULL DEFAULT 1 COMMENT '状态（0: 成功 1: 失败）',
  `version` int(10) NULL DEFAULT 1 COMMENT '乐观锁',
  `deleted` int(1) NULL DEFAULT 0 COMMENT '逻辑删除',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`white_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1352876038899679234 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '白名单表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_cardwhitelist
-- ----------------------------
INSERT INTO `sys_cardwhitelist` VALUES (1352821274329526274, '白名单ip', '运营商', 0, 1, 0, '2021-01-23 11:31:41', '2021-01-23 11:31:41');
INSERT INTO `sys_cardwhitelist` VALUES (1352821308068507649, '白名单ip', '运营商', 1, 1, 0, '2021-01-23 11:31:49', '2021-01-23 11:31:49');
INSERT INTO `sys_cardwhitelist` VALUES (1352876038899679233, '测试', '测试', 1, 1, 0, '2021-01-23 15:09:18', '2021-01-23 15:09:18');

-- ----------------------------
-- Table structure for sys_dept
-- ----------------------------
DROP TABLE IF EXISTS `sys_dept`;
CREATE TABLE `sys_dept`  (
  `dept_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '部门id',
  `parent_id` bigint(20) NULL DEFAULT 0 COMMENT '父部门id',
  `ancestors` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '祖级列表',
  `dept_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '部门名称',
  `order_num` int(4) NULL DEFAULT 0 COMMENT '显示顺序',
  `leader` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '负责人',
  `phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系电话',
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `status` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '部门状态（0正常 1停用）',
  `del_flag` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
  `create_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`dept_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 111 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '部门表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_dept
-- ----------------------------
INSERT INTO `sys_dept` VALUES (100, 0, '0', '核电站', 0, '', '15888888888', '', '0', '0', 'admin', '2020-12-27 14:45:34', '', '2021-01-20 18:24:30');
INSERT INTO `sys_dept` VALUES (101, 100, '0,100', '二二级项目', 1, '', '', '', '0', '0', 'admin', '2020-12-27 14:45:34', '', '2021-01-20 18:24:30');
INSERT INTO `sys_dept` VALUES (102, 100, '0,100', '二级项目', 2, '', '15888888888', '', '0', '0', 'admin', '2020-12-27 14:45:34', '', '2021-01-20 18:21:12');
INSERT INTO `sys_dept` VALUES (103, 101, '0,100,101', '研发部门', 1, '', '15888888888', '', '0', '2', 'admin', '2020-12-27 14:45:34', '', NULL);
INSERT INTO `sys_dept` VALUES (104, 101, '0,100,101', '三级', 2, '', '15888888888', '', '0', '0', 'admin', '2020-12-27 14:45:34', '', '2021-01-20 18:21:05');
INSERT INTO `sys_dept` VALUES (105, 101, '0,100,101', '测试部门', 3, '', '15888888888', '', '0', '2', 'admin', '2020-12-27 14:45:34', '', NULL);
INSERT INTO `sys_dept` VALUES (106, 101, '0,100,101', '财务部门', 4, '', '15888888888', '', '0', '2', 'admin', '2020-12-27 14:45:34', '', NULL);
INSERT INTO `sys_dept` VALUES (107, 101, '0,100,101', '运维部门', 5, '', '15888888888', '', '0', '2', 'admin', '2020-12-27 14:45:34', '', NULL);
INSERT INTO `sys_dept` VALUES (108, 102, '0,100,102', '三级', 1, '', '15888888888', '', '0', '0', 'admin', '2020-12-27 14:45:34', '', '2021-01-20 18:21:11');
INSERT INTO `sys_dept` VALUES (109, 102, '0,100,102', '财务部门', 2, '', '15888888888', '', '0', '2', 'admin', '2020-12-27 14:45:34', '', NULL);
INSERT INTO `sys_dept` VALUES (110, 100, '0,100', '测试', 2, 'ada', '18452341975', 'asdasd@qq.com', '0', '0', '', '2021-01-23 13:58:30', '', NULL);

-- ----------------------------
-- Table structure for sys_destroyapply
-- ----------------------------
DROP TABLE IF EXISTS `sys_destroyapply`;
CREATE TABLE `sys_destroyapply`  (
  `dest_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `dest_cardnum` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '卡号',
  `dest_iccid` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'ICCID',
  `dest_state` int(10) NULL DEFAULT NULL COMMENT '状态',
  `dest_operators` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '运营商',
  `dest_type` int(10) NULL DEFAULT NULL COMMENT '类型',
  `dest_meal` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '套餐名称',
  `dest_activation_time` date NULL DEFAULT NULL COMMENT '激活时间',
  `dest_timeout` date NULL DEFAULT NULL COMMENT '到期时间',
  `version` int(10) NULL DEFAULT 1 COMMENT '乐观锁',
  `deleted` int(1) NULL DEFAULT 0 COMMENT '逻辑删除',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`dest_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1352875328489439235 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '销卡申请表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_destroyapply
-- ----------------------------
INSERT INTO `sys_destroyapply` VALUES (1352531923557240833, '卡号', 'ICCID', 1, '运营商', 1, '套餐名称', '2021-01-05', '2021-01-11', 1, 0, '2021-01-22 16:21:54', '2021-01-22 16:21:54');
INSERT INTO `sys_destroyapply` VALUES (1352875328489439234, '测试', '测试', 1, '测试', 0, '测试', '2021-01-06', '2021-01-25', 1, 0, '2021-01-23 15:06:28', '2021-01-23 15:06:28');

-- ----------------------------
-- Table structure for sys_device
-- ----------------------------
DROP TABLE IF EXISTS `sys_device`;
CREATE TABLE `sys_device`  (
  `device_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '设备id',
  `device_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '设备名称',
  `device_sn` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'SN',
  `device_project` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所属项目名称',
  `device_grouping` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '分组',
  `device_address` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '地址',
  `device_label` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '标签',
  `version` int(10) NULL DEFAULT 1 COMMENT '乐观锁',
  `deleted` int(1) NULL DEFAULT 0 COMMENT '逻辑删除',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`device_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1352067002793017346 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '设备表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_device
-- ----------------------------
INSERT INTO `sys_device` VALUES (1, '测试asd', 'dasd', '核电站', '二二级项目', 'asd', 'asd', 1, 0, '2021-01-20 20:38:41', NULL);
INSERT INTO `sys_device` VALUES (1351861534933962754, NULL, 'adasd', '100', '108', NULL, NULL, 1, 0, '2021-01-20 19:58:01', '2021-01-20 19:58:01');
INSERT INTO `sys_device` VALUES (1351869964478369794, 'adas', 'dasd', '核电站', '三级', 'asdasd', 'asd', 1, 0, '2021-01-20 20:31:31', '2021-01-20 20:31:31');
INSERT INTO `sys_device` VALUES (1352067002793017345, '123123', 'adasd', '核电站', '三级', '123123', '123123', 1, 0, '2021-01-21 09:34:28', '2021-01-21 09:34:28');

-- ----------------------------
-- Table structure for sys_device_linkage
-- ----------------------------
DROP TABLE IF EXISTS `sys_device_linkage`;
CREATE TABLE `sys_device_linkage`  (
  `linkage_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '联动记录id',
  `linkage_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联动名称',
  `linkage_source` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联动来源',
  `linkagee_device` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联动设备',
  `slave_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '从机名称',
  `variable_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '变量名称',
  `spark_condition` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '触发条件',
  `device_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '触发设备名称',
  `version` int(10) NULL DEFAULT 1 COMMENT '乐观锁',
  `deleted` int(1) NULL DEFAULT 0 COMMENT '逻辑删除',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`linkage_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1352873421360381954 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '设备联动记录' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_device_linkage
-- ----------------------------
INSERT INTO `sys_device_linkage` VALUES (1352159421014245377, '联动名称', '联动来源', '联动来源', '从机名称', '变量名称', '触发条件', '触发设备', 1, 0, '2021-01-21 15:41:43', '2021-01-21 15:41:43');
INSERT INTO `sys_device_linkage` VALUES (1352873421360381953, '测试', '测试', '测试', '测试', '测试', '测试', '测试', 1, 0, '2021-01-23 14:58:53', '2021-01-23 14:58:53');

-- ----------------------------
-- Table structure for sys_device_online
-- ----------------------------
DROP TABLE IF EXISTS `sys_device_online`;
CREATE TABLE `sys_device_online`  (
  `online_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '记录id',
  `device_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '通知名称',
  `device_sn` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '设备SN',
  `student` int(10) NULL DEFAULT 0 COMMENT '设备状态',
  `version` int(10) NULL DEFAULT 1 COMMENT '乐观锁',
  `deleted` int(1) NULL DEFAULT 0 COMMENT '逻辑删除',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`online_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1352872879452110850 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '设备上下线记录' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_device_online
-- ----------------------------
INSERT INTO `sys_device_online` VALUES (1, '设备名称', 'sn', 0, 1, 0, NULL, NULL);
INSERT INTO `sys_device_online` VALUES (1352144731450155009, 'asda', 'asdasd', 1, 1, 0, '2021-01-21 14:43:20', '2021-01-21 14:43:20');
INSERT INTO `sys_device_online` VALUES (1352872879452110849, '测试', '测试', 1, 1, 0, '2021-01-23 14:56:44', '2021-01-23 14:56:44');

-- ----------------------------
-- Table structure for sys_dict_data
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict_data`;
CREATE TABLE `sys_dict_data`  (
  `dict_code` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '字典编码',
  `dict_sort` int(4) NULL DEFAULT NULL COMMENT '字典排序',
  `dict_label` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '字典标签',
  `dict_value` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '字典键值',
  `dict_type` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '字典类型',
  `dict_is_default` char(1) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '是否默认',
  `vsersion` int(10) NULL DEFAULT 1 COMMENT '乐观锁',
  `deleted` int(1) NULL DEFAULT 0 COMMENT '逻辑删除',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`dict_code`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '字典数据表' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for sys_dict_type
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict_type`;
CREATE TABLE `sys_dict_type`  (
  `dict_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '字典类型id',
  `dict_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '字典类型名称',
  `dict_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '字典类型',
  `version` int(10) NULL DEFAULT 1 COMMENT '乐观锁',
  `deleted` int(1) NULL DEFAULT 0 COMMENT '逻辑删除',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`dict_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '字典类型表' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for sys_flow_pool
-- ----------------------------
DROP TABLE IF EXISTS `sys_flow_pool`;
CREATE TABLE `sys_flow_pool`  (
  `pool_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `pool_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '流量池编码',
  `setmeal_info` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '套餐信息',
  `dest_operators` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '运营商',
  `dest_apn` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'APN 名称',
  `pool_tit_flow` double(10, 2) NULL DEFAULT NULL COMMENT '年流量',
  `pool_used_flow` double(10, 2) NULL DEFAULT NULL COMMENT '已使用',
  `pool_have_flow` double(10, 2) NULL DEFAULT NULL COMMENT '剩余流量',
  `pool_spread_flow` double(10, 2) NULL DEFAULT NULL COMMENT '扩容包已用流量',
  `pool_automatic` int(1) NULL DEFAULT NULL COMMENT '是否自动扩容 0否 1是',
  `member_amount` int(10) NULL DEFAULT NULL COMMENT '成员数量',
  `version` int(10) NULL DEFAULT 1 COMMENT '乐观锁',
  `deleted` int(1) NULL DEFAULT 0 COMMENT '逻辑删除',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`pool_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1352874369151451139 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '流量池表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_flow_pool
-- ----------------------------
INSERT INTO `sys_flow_pool` VALUES (1352504301506883585, '1312313123', '套餐信息', '运营商', 'APN', 100.00, 20.00, 80.00, 60.00, 0, 10, 1, 0, '2021-01-22 14:32:08', '2021-01-22 14:32:08');
INSERT INTO `sys_flow_pool` VALUES (1352504848322490370, '流量池', '套餐信息', '运营商', 'APN', 100.00, 20.00, 80.00, 20.00, 1, 100, 1, 0, '2021-01-22 14:34:19', '2021-01-22 14:34:19');
INSERT INTO `sys_flow_pool` VALUES (1352874369151451138, '测试', '测试', '测试', '测试', 1.00, 123.00, 1.00, 1.00, 0, 1, 1, 0, '2021-01-23 15:02:46', '2021-01-23 15:02:39');

-- ----------------------------
-- Table structure for sys_fuelbagannal
-- ----------------------------
DROP TABLE IF EXISTS `sys_fuelbagannal`;
CREATE TABLE `sys_fuelbagannal`  (
  `annal_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '记录id',
  `annal_cardnum` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '卡号',
  `annal_iccid` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'ICCID',
  `annal_state` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '卡状态',
  `dest_operators` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '运营商',
  `dext_recode_type` int(2) NULL DEFAULT NULL COMMENT '套餐类型',
  `refuel_news` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '加油信息',
  `unit_price` double(10, 2) NULL DEFAULT 0.00 COMMENT '单价',
  `version` int(10) NULL DEFAULT 1 COMMENT '乐观锁',
  `deleted` int(1) NULL DEFAULT 0 COMMENT '逻辑删除',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`annal_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1352875898998669315 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '加油包记录表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_fuelbagannal
-- ----------------------------
INSERT INTO `sys_fuelbagannal` VALUES (1352800342638653441, '卡号', 'ICCID', '1', '运营商', 1, '加油信息', 152.20, 1, 0, '2021-01-23 10:08:30', '2021-01-23 10:08:30');
INSERT INTO `sys_fuelbagannal` VALUES (1352875898998669314, 'annalState', 'annalState', '0', 'annalState', 1, 'annalState', 1.00, 1, 0, '2021-01-23 15:08:44', '2021-01-23 15:08:44');

-- ----------------------------
-- Table structure for sys_gas_bagapply
-- ----------------------------
DROP TABLE IF EXISTS `sys_gas_bagapply`;
CREATE TABLE `sys_gas_bagapply`  (
  `gas_bag_apply_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '表申请Id',
  `card_num` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '续期申请卡号',
  `card_iccid` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'ICCID',
  `card_operator` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '运营商',
  `renew_setmeal` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '当前套餐',
  `student` int(2) NULL DEFAULT NULL COMMENT '状态',
  `meal_type` int(1) NULL DEFAULT NULL COMMENT '续期申请套餐类别',
  `meal_lastflow` double(10, 2) NULL DEFAULT NULL COMMENT '剩余流量',
  `expire_date` date NULL DEFAULT NULL COMMENT '到期时间',
  `version` int(10) NULL DEFAULT 1 COMMENT '乐观锁',
  `deleted` int(1) NULL DEFAULT 0 COMMENT '逻辑删除',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`gas_bag_apply_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1352875637714501635 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '加油包申请表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_gas_bagapply
-- ----------------------------
INSERT INTO `sys_gas_bagapply` VALUES (1352548439124144130, '申请卡号', 'ICCID', '运营商', '当前套餐', 1, 1, 12.30, '2021-01-19', 1, 0, '2021-01-22 17:27:32', '2021-01-22 17:27:32');
INSERT INTO `sys_gas_bagapply` VALUES (1352875637714501634, 'mealType', 'mealType', 'mealType', 'mealType', 1, 0, 1.00, '2021-01-29', 1, 0, '2021-01-23 15:07:42', '2021-01-23 15:07:42');

-- ----------------------------
-- Table structure for sys_logininfor
-- ----------------------------
DROP TABLE IF EXISTS `sys_logininfor`;
CREATE TABLE `sys_logininfor`  (
  `info_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '访问ID',
  `user_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '用户账号',
  `ipaddr` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '登录IP地址',
  `login_location` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '登录地点',
  `browser` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '浏览器类型',
  `os` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '操作系统',
  `status` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '登录状态（0成功 1失败）',
  `msg` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '提示消息',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '访问时间',
  PRIMARY KEY (`info_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1352851933899046915 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '系统访问记录' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_logininfor
-- ----------------------------
INSERT INTO `sys_logininfor` VALUES (1344120393799069698, 'liao123', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '1', '账号密码错误', '2020-12-30 11:17:29');

-- ----------------------------
-- Table structure for sys_meal_changeapply
-- ----------------------------
DROP TABLE IF EXISTS `sys_meal_changeapply`;
CREATE TABLE `sys_meal_changeapply`  (
  `meal_change_apply_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '变更申请Id',
  `card_num` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '卡号',
  `card_iccid` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'ICCID',
  `card_state` int(2) NULL DEFAULT NULL COMMENT '状态',
  `card_opear` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '运营商',
  `card_type` int(2) NULL DEFAULT NULL COMMENT '类型',
  `card_cur_meal` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '当前套餐',
  `card_have_flow` double(10, 2) NULL DEFAULT NULL COMMENT '剩余流量',
  `card_timeout` date NULL DEFAULT NULL COMMENT '到期时间',
  `version` int(10) NULL DEFAULT 1 COMMENT '乐观锁',
  `deleted` int(1) NULL DEFAULT 0 COMMENT '逻辑删除',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`meal_change_apply_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1352874908975153155 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '套餐变更申请' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_meal_changeapply
-- ----------------------------
INSERT INTO `sys_meal_changeapply` VALUES (1352521150915178497, '123123', 'ICCID', 1, '运营商', 1, ' 当前套餐asd', 120.50, '2021-01-22', 1, 0, '2021-01-22 15:39:31', '2021-01-22 15:39:06');
INSERT INTO `sys_meal_changeapply` VALUES (1352874908975153154, 'billingType', 'billingType', 1, 'billingType', 0, 'billingType', 1.00, '2021-01-11', 1, 0, '2021-01-23 15:04:48', '2021-01-23 15:04:48');

-- ----------------------------
-- Table structure for sys_meal_recode
-- ----------------------------
DROP TABLE IF EXISTS `sys_meal_recode`;
CREATE TABLE `sys_meal_recode`  (
  `meal_change_recode_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '订单号',
  `card_num` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '卡号',
  `card_iccid` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'ICCID',
  `card_opear` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '运营商',
  `state` int(11) NULL DEFAULT NULL COMMENT '状态',
  `old_meal_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '老套餐名',
  `new_meal_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '新套餐名',
  `unit_price` double(10, 2) NULL DEFAULT NULL COMMENT '单价格',
  `version` int(10) NULL DEFAULT 1 COMMENT '乐观锁',
  `deleted` int(1) NULL DEFAULT 0 COMMENT '逻辑删除',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`meal_change_recode_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1352874962469306371 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '套餐变更记录' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_meal_recode
-- ----------------------------
INSERT INTO `sys_meal_recode` VALUES (1, '卡号', 'ICCID', '运营商', 1, '老套餐名', ' 新套餐名', 10.00, 1, 0, '2021-01-22 15:48:31', '2021-01-22 15:48:31');
INSERT INTO `sys_meal_recode` VALUES (1352524166498205697, '卡号新套餐名', '卡号', '卡号', 1, '老套餐名', '新套餐名', 1212.00, 1, 0, '2021-01-22 15:51:12', '2021-01-22 15:51:05');
INSERT INTO `sys_meal_recode` VALUES (1352874962469306370, 'billingType', 'billingType', 'billingType', 1, 'billingType', 'billingType', 1.00, 1, 0, '2021-01-23 15:05:01', '2021-01-23 15:05:01');

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu`  (
  `menu_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '菜单ID',
  `menu_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '菜单名称',
  `parent_id` bigint(20) NULL DEFAULT 0 COMMENT '父菜单ID',
  `order_num` int(4) NULL DEFAULT 0 COMMENT '显示顺序',
  `path` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '路由地址',
  `component` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '组件路径',
  `is_frame` int(1) NULL DEFAULT 1 COMMENT '是否为外链（0是 1否）',
  `is_cache` int(1) NULL DEFAULT 0 COMMENT '是否缓存（0缓存 1不缓存）',
  `menu_type` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '菜单类型（M目录 C菜单 F按钮）',
  `visible` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '菜单状态（0显示 1隐藏）',
  `status` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '菜单状态（0正常 1停用）',
  `perms` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限标识',
  `icon` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '#' COMMENT '菜单图标',
  `version` int(10) NULL DEFAULT 1 COMMENT '乐观锁',
  `deleted` int(1) NULL DEFAULT 0 COMMENT '逻辑删除',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`menu_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 68 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '菜单权限表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES (1, '系统管理', 0, 1, 'system', '', 1, 0, 'M', '0', '0', '', 'system', 1, 0, NULL, NULL);
INSERT INTO `sys_menu` VALUES (2, '系统监控', 0, 4, 'monitor', '', 1, 0, 'M', '0', '0', NULL, 'monitor', 1, 0, NULL, '2021-01-11 17:50:50');
INSERT INTO `sys_menu` VALUES (3, '系统工具', 0, 8, 'tool', NULL, 1, 0, 'M', '0', '0', NULL, 'table', 1, 0, NULL, '2021-01-11 17:50:54');
INSERT INTO `sys_menu` VALUES (4, '用户管理', 1, 1, 'admin', 'system/admin/index', 1, 0, 'C', '0', '0', 'system:user:list', 'user', 1, 0, NULL, '2020-12-30 16:13:55');
INSERT INTO `sys_menu` VALUES (5, '菜单管理', 1, 3, 'menu', 'system/menu/index', 1, 0, 'C', '0', '0', NULL, 'guide', 1, 0, NULL, '2020-12-29 14:18:56');
INSERT INTO `sys_menu` VALUES (6, '404', 3, 1, '404', NULL, 1, 0, 'M', '0', '0', NULL, '404', 1, 0, '2020-12-28 20:06:53', '2020-12-29 13:27:22');
INSERT INTO `sys_menu` VALUES (7, '测试', 2, 1, 'test', '', 1, 0, 'M', '0', '0', NULL, 'button', 1, 0, '2020-12-28 20:08:25', '2020-12-29 16:10:39');
INSERT INTO `sys_menu` VALUES (8, '测试', 3, 2, 'ceshio', NULL, 1, 0, 'M', '0', '0', NULL, 'clipboard', 1, 0, '2020-12-28 20:09:57', '2020-12-28 20:09:57');
INSERT INTO `sys_menu` VALUES (9, '角色管理', 1, 2, 'role', 'system/role/index', 1, 0, 'M', '0', '0', NULL, 'people', 1, 0, '2020-12-28 20:15:47', '2020-12-29 14:19:03');
INSERT INTO `sys_menu` VALUES (11, '日志管理', 1, 7, 'log', 'system/log/index', 1, 0, 'M', '0', '0', NULL, 'peoples', 1, 0, '2020-12-29 16:24:23', '2021-01-04 11:15:19');
INSERT INTO `sys_menu` VALUES (12, '操作日志', 11, 1, 'operlog', 'monitor/operlog/index', 1, 0, 'C', '0', '0', NULL, 'edit', 1, 0, '2020-12-29 16:33:34', '2020-12-29 16:37:10');
INSERT INTO `sys_menu` VALUES (13, '登录日志', 11, 2, 'logininfor', 'monitor/logininfor/index', 1, 0, 'M', '0', '0', NULL, 'validCode', 1, 0, '2020-12-30 10:53:12', '2020-12-30 10:53:21');
INSERT INTO `sys_menu` VALUES (14, 'UserTest', 1, 4, 'user', 'system/user/index', 1, 0, 'M', '0', '0', NULL, 'dashboard', 1, 1, '2020-12-30 16:12:24', '2020-12-30 16:12:24');
INSERT INTO `sys_menu` VALUES (15, '普通用户', 1, 4, 'User', 'system/user/index', 1, 0, 'M', '0', '0', NULL, 'clipboard', 1, 1, '2020-12-31 17:06:26', '2021-01-04 10:02:50');
INSERT INTO `sys_menu` VALUES (16, '实名认证', 1, 5, 'Realname', 'system/realname/index', 1, 0, 'C', '0', '0', NULL, 'example', 1, 0, '2021-01-04 11:14:57', '2021-01-04 11:15:12');
INSERT INTO `sys_menu` VALUES (37, '项目管理', 40, 4, 'Dept', 'system/dept/index', 1, 0, 'C', '0', '0', NULL, 'dict', 1, 0, '2021-01-20 17:51:33', '2021-01-22 09:38:06');
INSERT INTO `sys_menu` VALUES (38, '设备管理', 40, 8, 'Diver', 'system/device/index', 1, 0, 'M', '0', '0', NULL, 'druid', 1, 0, '2021-01-20 19:28:32', '2021-01-22 09:38:15');
INSERT INTO `sys_menu` VALUES (39, 'AI 云动态', 0, 3, 'ai cloud', NULL, 1, 0, 'M', '0', '0', NULL, 'example', 1, 1, '2021-01-21 10:19:26', '2021-01-21 10:19:26');
INSERT INTO `sys_menu` VALUES (40, 'Ai 云动态', 0, 2, 'ai', NULL, 1, 0, 'M', '0', '0', NULL, 'email', 1, 0, '2021-01-21 10:42:40', '2021-01-22 09:59:57');
INSERT INTO `sys_menu` VALUES (41, '报警联系人', 40, 1, 'Alarmcontact', 'system/alarmcontact/index', 1, 0, 'M', '0', '0', NULL, 'pdf', 1, 0, '2021-01-21 10:44:38', '2021-01-21 10:44:38');
INSERT INTO `sys_menu` VALUES (42, '报警管理', 40, 2, 'Notice', 'system/notice/index', 1, 0, 'C', '0', '0', NULL, 'tree-table', 1, 0, '2021-01-21 11:27:14', '2021-01-21 11:27:14');
INSERT INTO `sys_menu` VALUES (43, '设备上线记录', 40, 3, 'Online', 'system/online/index', 1, 0, 'C', '0', '0', NULL, 'tool', 1, 0, '2021-01-21 14:35:57', '2021-01-21 14:37:16');
INSERT INTO `sys_menu` VALUES (44, '报警记录', 40, 4, 'Record', 'system/record/index', 1, 0, 'M', '0', '0', NULL, 'tree', 1, 0, '2021-01-21 14:58:26', '2021-01-21 14:58:26');
INSERT INTO `sys_menu` VALUES (45, '设备联动', 40, 5, 'Linkage', 'system/linkage/index', 1, 0, 'C', '0', '0', NULL, 'education', 1, 0, '2021-01-21 15:32:04', '2021-01-21 15:32:04');
INSERT INTO `sys_menu` VALUES (46, '维保计划', 40, 6, 'Maintain', 'system/maintain/index', 1, 0, 'C', '0', '0', NULL, 'upload', 1, 0, '2021-01-21 17:20:08', '2021-01-21 17:20:08');
INSERT INTO `sys_menu` VALUES (47, '我的工单', 40, 7, 'Workorder', 'system/workorder/index', 1, 0, 'C', '0', '0', NULL, 'checkbox', 1, 0, '2021-01-21 19:13:07', '2021-01-21 19:13:07');
INSERT INTO `sys_menu` VALUES (48, '物联网卡', 0, 3, 'card', NULL, 1, 0, 'M', '0', '0', NULL, 'guide', 1, 0, '2021-01-22 11:12:51', '2021-01-22 11:12:51');
INSERT INTO `sys_menu` VALUES (49, '流量卡', 48, 1, 'Flow', 'system/flow/index', 1, 0, 'C', '0', '0', NULL, 'question', 1, 0, '2021-01-22 11:14:10', '2021-01-22 11:14:10');
INSERT INTO `sys_menu` VALUES (50, '电信NB卡', 48, 2, 'Dxnb', 'system/dxnb/index', 1, 0, 'M', '0', '0', NULL, 'validCode', 1, 0, '2021-01-22 13:27:24', '2021-01-22 13:27:24');
INSERT INTO `sys_menu` VALUES (51, '流量池卡', 48, 3, 'Flowpool', 'system/flowpool/index', 1, 0, 'C', '0', '0', NULL, 'checkbox', 1, 0, '2021-01-22 13:58:04', '2021-01-22 13:58:04');
INSERT INTO `sys_menu` VALUES (52, '流量池', 48, 4, 'Pool', 'system/pool/index', 1, 0, 'C', '0', '0', NULL, 'documentation', 1, 0, '2021-01-22 14:29:52', '2021-01-22 16:21:31');
INSERT INTO `sys_menu` VALUES (53, '卡标签管理', 48, 5, 'Cardlabel', 'system/cardlabel/index', 1, 0, 'C', '0', '0', NULL, 'table', 1, 0, '2021-01-22 14:44:03', '2021-01-22 14:44:03');
INSERT INTO `sys_menu` VALUES (54, '卡分配', 48, 6, 'Dealing', 'system/dealing/index', 1, 0, 'M', '0', '0', NULL, 'druid', 1, 0, '2021-01-22 15:16:03', '2021-01-22 15:16:03');
INSERT INTO `sys_menu` VALUES (55, '变更申请', 48, 7, 'Changeapply', 'system/changeapply/index', 1, 0, 'M', '0', '0', NULL, 'slider', 1, 0, '2021-01-22 15:38:09', '2021-01-22 15:38:19');
INSERT INTO `sys_menu` VALUES (56, '变更记录', 48, 8, 'Recode', 'system/recode/index', 1, 0, 'C', '0', '0', NULL, 'switch', 1, 0, '2021-01-22 15:47:43', '2021-01-22 15:47:43');
INSERT INTO `sys_menu` VALUES (57, '续期申请', 48, 9, 'Renewal', 'system/renewal/index', 1, 0, 'C', '0', '0', NULL, 'star', 1, 0, '2021-01-22 16:04:38', '2021-01-22 16:04:38');
INSERT INTO `sys_menu` VALUES (58, '销号申请', 48, 11, 'Destroyapply', 'system/destroyapply/index', 1, 0, 'C', '0', '0', NULL, 'tree-table', 1, 0, '2021-01-22 16:20:52', '2021-01-22 16:20:52');
INSERT INTO `sys_menu` VALUES (59, '销卡记录', 48, 12, 'Numberrecord', 'system/numberrecord/index', 1, 0, 'C', '0', '0', NULL, 'tool', 1, 0, '2021-01-22 16:34:52', '2021-01-22 16:34:52');
INSERT INTO `sys_menu` VALUES (60, '续期记录', 48, 10, 'Renewalrecord', 'system/renewalrecord/index', 1, 0, 'M', '0', '0', NULL, 'bug', 1, 0, '2021-01-22 17:06:24', '2021-01-22 17:06:24');
INSERT INTO `sys_menu` VALUES (61, '加油包申请', 48, 13, 'Bagapply', 'system/bagapply/index', 1, 0, 'C', '0', '0', NULL, 'slider', 1, 0, '2021-01-22 17:25:18', '2021-01-22 17:25:18');
INSERT INTO `sys_menu` VALUES (62, '加油包记录', 48, 14, 'Fuelbagannal', 'system/fuelbagannal/index', 1, 0, 'M', '0', '0', NULL, 'component', 1, 0, '2021-01-23 10:07:34', '2021-01-23 10:07:34');
INSERT INTO `sys_menu` VALUES (63, 'psm转换', 48, 15, 'Psmrecode', 'system/psmrecode/index', 1, 0, 'C', '0', '0', NULL, 'drag', 1, 0, '2021-01-23 10:30:37', '2021-01-23 10:30:37');
INSERT INTO `sys_menu` VALUES (64, '机卡解绑', 48, 16, 'Cardcancel', 'system/cardcancel/index', 1, 0, 'M', '0', '0', NULL, 'textarea', 1, 0, '2021-01-23 10:42:38', '2021-01-23 10:42:38');
INSERT INTO `sys_menu` VALUES (65, 'SIM实名认证', 48, 17, 'Simrealname', 'system/simrealname/index', 1, 0, 'C', '0', '0', NULL, 'job', 1, 0, '2021-01-23 11:16:58', '2021-01-23 11:16:58');
INSERT INTO `sys_menu` VALUES (66, '白名单', 48, 18, 'Cardwhitelist', 'system/cardwhitelist/index', 1, 0, 'M', '0', '0', NULL, 'dashboard', 1, 0, '2021-01-23 11:30:18', '2021-01-23 11:30:18');
INSERT INTO `sys_menu` VALUES (67, '告警日志', 48, 19, 'Alarmlog', 'system/alarmlog/index', 1, 0, 'C', '0', '0', NULL, 'number', 1, 0, '2021-01-23 13:33:08', '2021-01-23 13:33:08');

-- ----------------------------
-- Table structure for sys_my_workorder
-- ----------------------------
DROP TABLE IF EXISTS `sys_my_workorder`;
CREATE TABLE `sys_my_workorder`  (
  `workorder_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `repair_id` bigint(20) NOT NULL COMMENT '工单编号',
  `workorder_project` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所属项目',
  `workorder_device_sn` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '维保设备SN',
  `workorder_describe` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '故障描述',
  `workorder_email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '报修人邮箱',
  `workorder_student` int(2) NULL DEFAULT 0 COMMENT '工单状态 0进行中 1已结单',
  `workorder_type` int(2) NULL DEFAULT 0 COMMENT '工单类型0 常规维保 1 故障维保',
  `version` int(10) NULL DEFAULT 1 COMMENT '乐观锁',
  `deleted` int(1) NULL DEFAULT 0 COMMENT '逻辑删除',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`workorder_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1352873878384328707 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '我的工单' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_my_workorder
-- ----------------------------
INSERT INTO `sys_my_workorder` VALUES (1352214640364482561, 123, ' 所属项目', '设备SN', '故障描述', '报修邮箱', 0, 0, 1, 0, '2021-01-21 19:21:08', '2021-01-21 19:21:08');
INSERT INTO `sys_my_workorder` VALUES (1352214995265515522, 1231231, '所属项目', '设备SN', '设备SN', '报修邮箱', 1, 1, 1, 0, '2021-01-21 19:22:32', '2021-01-21 19:22:32');
INSERT INTO `sys_my_workorder` VALUES (1352873697320419330, 12456, '测试', '测试', '测试', '测试', 1, 0, 1, 0, '2021-01-23 14:59:59', '2021-01-23 14:59:59');
INSERT INTO `sys_my_workorder` VALUES (1352873878384328706, 1231, 'repairId', 'repairId', 'repairId', 'repairId', 1, 1, 1, 0, '2021-01-23 15:00:42', '2021-01-23 15:00:42');

-- ----------------------------
-- Table structure for sys_open_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_open_log`;
CREATE TABLE `sys_open_log`  (
  `oper_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '日志id',
  `oper_title` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '模块标题',
  `open_business_type` int(2) NULL DEFAULT NULL COMMENT '业务类型（0其它 1新增 2修改 3删除）',
  `open_method` varchar(250) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '方法名称',
  `open_request_method` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '请求方式',
  `oper_ip` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '主机地址IP',
  `open_url` varchar(500) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '请求url',
  `oper_location` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '地址',
  `oper_param` varchar(2000) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '请求参数',
  `open_result` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '返回参数',
  `open_status` int(1) NULL DEFAULT NULL COMMENT '状态',
  `open_error_msg` varchar(2000) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '错误消息',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`oper_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1352876411043495939 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '操作日志记录' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_open_log
-- ----------------------------
INSERT INTO `sys_open_log` VALUES (1343888126581448706, '清空日志', 9, 'com.liao.system.controller.SysOpenLogController.clean()', 'DELETE', '127.0.0.1', '/sys-open-log/clean', '内网IP', '{}', '{\"msg\":\"成功\",\"code\":200}', 0, NULL, '2020-12-29 19:54:32');

-- ----------------------------
-- Table structure for sys_pin_numberrecord
-- ----------------------------
DROP TABLE IF EXISTS `sys_pin_numberrecord`;
CREATE TABLE `sys_pin_numberrecord`  (
  `pin_number_recode_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '订单号',
  `dest_cardnum` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '卡号',
  `dest_iccid` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'ICCID',
  `dest_state` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '卡状态',
  `dest_operators` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '运营商',
  `dext_recode_type` int(2) NULL DEFAULT NULL COMMENT '销号类型',
  `dest_recode_commit_time` date NULL DEFAULT NULL COMMENT '提交时间',
  `dest_recode_ok_time` date NULL DEFAULT NULL COMMENT '完成时间',
  `version` int(10) NULL DEFAULT 1 COMMENT '乐观锁',
  `deleted` int(1) NULL DEFAULT 0 COMMENT '逻辑删除',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`pin_number_recode_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1352875373909557251 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '销卡记录表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_pin_numberrecord
-- ----------------------------
INSERT INTO `sys_pin_numberrecord` VALUES (1352535677232795649, '卡号', 'ICCID', '卡状态', '运营商', 1, '2021-01-22', '2021-01-22', 1, 0, '2021-01-22 16:36:49', '2021-01-22 16:36:49');
INSERT INTO `sys_pin_numberrecord` VALUES (1352875373909557250, '测试', '测试', '0', '测试', 0, '2021-01-18', '2021-01-30', 1, 0, '2021-01-23 15:06:39', '2021-01-23 15:06:39');

-- ----------------------------
-- Table structure for sys_plan_maintain
-- ----------------------------
DROP TABLE IF EXISTS `sys_plan_maintain`;
CREATE TABLE `sys_plan_maintain`  (
  `plan_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '维保计划id',
  `plan_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '维保计划名称',
  `plan_project` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所属项目',
  `plan_device_sn` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '维保设备SN',
  `plan_student` int(2) NULL DEFAULT 0 COMMENT '计划状态0 待处理 1 已派单 2 执行中',
  `plan_type` int(2) NULL DEFAULT 0 COMMENT '计划类型 0保内维保',
  `next_time` date NULL DEFAULT NULL COMMENT '下次维保时间',
  `version` int(10) NULL DEFAULT 1 COMMENT '乐观锁',
  `deleted` int(1) NULL DEFAULT 0 COMMENT '逻辑删除',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`plan_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1352873477161402371 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '维保计划表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_plan_maintain
-- ----------------------------
INSERT INTO `sys_plan_maintain` VALUES (1352191734066524161, '计划名称', '所属项目', '设备SN', 0, 0, '2021-01-21', 1, 0, '2021-01-21 17:50:07', '2021-01-21 17:50:07');
INSERT INTO `sys_plan_maintain` VALUES (1352191918888529922, '计划名称', '所属项目', '设备SN', 1, 1, '2021-01-21', 1, 0, '2021-01-21 17:50:51', '2021-01-21 17:50:51');
INSERT INTO `sys_plan_maintain` VALUES (1352192277522493442, '计划名称', '计划名称', '设备SN', 2, 1, '2021-01-21', 1, 0, '2021-01-21 17:52:16', '2021-01-21 17:52:16');
INSERT INTO `sys_plan_maintain` VALUES (1352206195942830082, '计划名称', ' 所属项目', '设备SN', 3, 0, '2021-01-21', 1, 0, '2021-01-21 18:47:35', '2021-01-21 18:47:35');
INSERT INTO `sys_plan_maintain` VALUES (1352873477161402370, '测试', '测试', '测试', 2, 1, '2021-01-24', 1, 0, '2021-01-23 14:59:07', '2021-01-23 14:59:07');

-- ----------------------------
-- Table structure for sys_psmrecode
-- ----------------------------
DROP TABLE IF EXISTS `sys_psmrecode`;
CREATE TABLE `sys_psmrecode`  (
  `psm_recode_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '记录主键',
  `annal_cardnum` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '卡号',
  `annal_iccid` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'ICCID',
  `change_type` int(2) NULL DEFAULT NULL COMMENT '转换类型 0：转非psm 1：转psm',
  `state` int(2) NULL DEFAULT NULL COMMENT '状态（0: 成功 1: 失败）',
  `version` int(10) NULL DEFAULT 1 COMMENT '乐观锁',
  `deleted` int(1) NULL DEFAULT 0 COMMENT '逻辑删除',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`psm_recode_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1352875953486872578 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = 'PSM 转换记录' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_psmrecode
-- ----------------------------
INSERT INTO `sys_psmrecode` VALUES (1352806440921792513, '卡号', 'ICCID', 0, 0, 1, 0, '2021-01-23 10:32:44', '2021-01-23 10:32:44');
INSERT INTO `sys_psmrecode` VALUES (1352806483896631297, '卡号', 'ICCID', 1, 1, 1, 0, '2021-01-23 10:32:54', '2021-01-23 10:32:54');
INSERT INTO `sys_psmrecode` VALUES (1352875953486872577, '测试', '测试', 0, 0, 1, 0, '2021-01-23 15:08:57', '2021-01-23 15:08:57');

-- ----------------------------
-- Table structure for sys_real_name
-- ----------------------------
DROP TABLE IF EXISTS `sys_real_name`;
CREATE TABLE `sys_real_name`  (
  `rn_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '实名认证id',
  `rn_u_id` bigint(20) NOT NULL COMMENT '用户id',
  `rn_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '姓名',
  `rn_sex` varchar(4) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '性别',
  `rm_born_date` date NULL DEFAULT NULL COMMENT '出生日期',
  `rm_id_card` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '身份证号码',
  `rm_positive` varchar(500) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '身份证正面',
  `rm_negative` varchar(500) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '身份证反面',
  `rm_mechanism` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '签发机构',
  `rm_Issue_date` date NULL DEFAULT NULL COMMENT '签发日期',
  `rm_maturity_date` date NULL DEFAULT NULL COMMENT '到期时间',
  `vsersion` int(10) NULL DEFAULT 1 COMMENT '乐观锁',
  `deleted` int(1) NULL DEFAULT 0 COMMENT '逻辑删除',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`rn_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '用户实名认证信息' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_real_name
-- ----------------------------
INSERT INTO `sys_real_name` VALUES (1, 1, '测试', '男', '2021-01-04', '123', '123', '123', '123', '2021-01-05', '2021-01-04', 1, 0, NULL, '2021-01-21 17:41:25');

-- ----------------------------
-- Table structure for sys_renewal
-- ----------------------------
DROP TABLE IF EXISTS `sys_renewal`;
CREATE TABLE `sys_renewal`  (
  `renewal_apply_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '续期申请Id',
  `renew_num` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '申请卡号',
  `renew_iccid` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'ICCID',
  `renew_statue` int(2) NULL DEFAULT NULL COMMENT '状态',
  `renew_operator` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '运营商',
  `renew_type` int(2) NULL DEFAULT NULL COMMENT '卡号类别（1--》 流量卡 、 2 ---电信NB卡）',
  `renew_setmeal` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '当前套餐',
  `meal_lastflow` double(10, 2) NULL DEFAULT NULL COMMENT '剩余流量',
  `version` int(10) NULL DEFAULT 1 COMMENT '乐观锁',
  `deleted` int(1) NULL DEFAULT 0 COMMENT '逻辑删除',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`renewal_apply_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1352875044451172355 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '续期申请表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_renewal
-- ----------------------------
INSERT INTO `sys_renewal` VALUES (1352527809226047490, '申请卡号', 'ICCID', 1, '运营商', 0, ' 当前套餐', 12.00, 1, 0, '2021-01-22 16:07:46', '2021-01-22 16:05:33');
INSERT INTO `sys_renewal` VALUES (1352875044451172354, '测试', '测试', 1, '测试', 1, '测试', 1.00, 1, 0, '2021-01-23 15:05:20', '2021-01-23 15:05:20');

-- ----------------------------
-- Table structure for sys_renewalrecord
-- ----------------------------
DROP TABLE IF EXISTS `sys_renewalrecord`;
CREATE TABLE `sys_renewalrecord`  (
  `renewalrecord_id` bigint(20) NOT NULL COMMENT '续期记录id',
  `card_num` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '续期申请卡号',
  `card_iccid` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'ICCID',
  `card_operator` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '运营商',
  `student` int(2) NULL DEFAULT NULL COMMENT '状态',
  `meal_type` int(2) NULL DEFAULT NULL COMMENT '续期申请套餐类别',
  `meal_unitprice` double(10, 2) NULL DEFAULT NULL COMMENT '套餐单价',
  `version` int(10) NULL DEFAULT 1 COMMENT '乐观锁',
  `deleted` int(1) NULL DEFAULT 0 COMMENT '逻辑删除',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`renewalrecord_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '续期记录表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_renewalrecord
-- ----------------------------
INSERT INTO `sys_renewalrecord` VALUES (1352544009742020610, '申请卡号', 'ICCID', '运营商', 1, 1, 1231.00, 1, 0, '2021-01-22 17:09:56', '2021-01-22 17:09:56');
INSERT INTO `sys_renewalrecord` VALUES (1352875238743916545, 'mealUnitprice', 'mealUnitprice', 'mealUnitprice', 1, 1, 1.00, 1, 0, '2021-01-23 15:06:07', '2021-01-23 15:06:07');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `role_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '角色id',
  `role_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '角色名称',
  `role_authority` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '权限字符',
  `role_sort` int(10) NULL DEFAULT NULL COMMENT '顺序',
  `role_status` int(1) NULL DEFAULT 0 COMMENT '角色状态',
  `version` int(10) NULL DEFAULT 1 COMMENT '乐观锁',
  `deleted` int(1) NULL DEFAULT 0 COMMENT '逻辑删除',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`role_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1343807643550027779 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '角色表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES (1, '超级管理员', 'admin', 1, 0, 1, 0, '2020-12-21 11:15:07', '2021-01-23 13:33:20');
INSERT INTO `sys_role` VALUES (1343796202273001474, '普通管理员', 'mange', 2, 0, 1, 0, '2020-12-29 13:49:16', '2020-12-29 20:01:56');
INSERT INTO `sys_role` VALUES (1343807643550027778, '删除测试', 'deleted', 3, 0, 1, 0, '2020-12-29 14:34:44', '2020-12-29 14:46:43');

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu`  (
  `role_id` bigint(20) NULL DEFAULT NULL COMMENT '角色id',
  `menu_id` bigint(20) NULL DEFAULT NULL COMMENT '菜单id'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '角色菜单关联表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO `sys_role_menu` VALUES (1343807643550027778, 1);
INSERT INTO `sys_role_menu` VALUES (1343807643550027778, 4);
INSERT INTO `sys_role_menu` VALUES (1343807643550027778, 5);
INSERT INTO `sys_role_menu` VALUES (1343807643550027778, 9);
INSERT INTO `sys_role_menu` VALUES (1343807643550027778, 2);
INSERT INTO `sys_role_menu` VALUES (1, 1);
INSERT INTO `sys_role_menu` VALUES (1, 4);
INSERT INTO `sys_role_menu` VALUES (1, 5);
INSERT INTO `sys_role_menu` VALUES (1, 9);
INSERT INTO `sys_role_menu` VALUES (1, 11);
INSERT INTO `sys_role_menu` VALUES (1, 12);
INSERT INTO `sys_role_menu` VALUES (1, 13);
INSERT INTO `sys_role_menu` VALUES (1, 16);
INSERT INTO `sys_role_menu` VALUES (1, 2);
INSERT INTO `sys_role_menu` VALUES (1, 7);
INSERT INTO `sys_role_menu` VALUES (1, 3);
INSERT INTO `sys_role_menu` VALUES (1, 6);
INSERT INTO `sys_role_menu` VALUES (1, 8);
INSERT INTO `sys_role_menu` VALUES (1, 40);
INSERT INTO `sys_role_menu` VALUES (1, 37);
INSERT INTO `sys_role_menu` VALUES (1, 38);
INSERT INTO `sys_role_menu` VALUES (1, 41);
INSERT INTO `sys_role_menu` VALUES (1, 42);
INSERT INTO `sys_role_menu` VALUES (1, 43);
INSERT INTO `sys_role_menu` VALUES (1, 44);
INSERT INTO `sys_role_menu` VALUES (1, 45);
INSERT INTO `sys_role_menu` VALUES (1, 46);
INSERT INTO `sys_role_menu` VALUES (1, 47);
INSERT INTO `sys_role_menu` VALUES (1, 48);
INSERT INTO `sys_role_menu` VALUES (1, 49);
INSERT INTO `sys_role_menu` VALUES (1, 50);
INSERT INTO `sys_role_menu` VALUES (1, 51);
INSERT INTO `sys_role_menu` VALUES (1, 52);
INSERT INTO `sys_role_menu` VALUES (1, 53);
INSERT INTO `sys_role_menu` VALUES (1, 54);
INSERT INTO `sys_role_menu` VALUES (1, 55);
INSERT INTO `sys_role_menu` VALUES (1, 56);
INSERT INTO `sys_role_menu` VALUES (1, 57);
INSERT INTO `sys_role_menu` VALUES (1, 58);
INSERT INTO `sys_role_menu` VALUES (1, 59);
INSERT INTO `sys_role_menu` VALUES (1, 60);
INSERT INTO `sys_role_menu` VALUES (1, 61);
INSERT INTO `sys_role_menu` VALUES (1, 62);
INSERT INTO `sys_role_menu` VALUES (1, 63);
INSERT INTO `sys_role_menu` VALUES (1, 64);
INSERT INTO `sys_role_menu` VALUES (1, 65);
INSERT INTO `sys_role_menu` VALUES (1, 66);
INSERT INTO `sys_role_menu` VALUES (1, 67);

-- ----------------------------
-- Table structure for sys_simrealname
-- ----------------------------
DROP TABLE IF EXISTS `sys_simrealname`;
CREATE TABLE `sys_simrealname`  (
  `simrealname_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '实名认证id',
  `annal_cardnum` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '卡号',
  `annal_iccid` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'ICCID',
  `dest_operators` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '运营商',
  `state` int(2) NULL DEFAULT NULL COMMENT '状态（0: 已实名 1: 未实名）',
  `version` int(10) NULL DEFAULT 1 COMMENT '乐观锁',
  `deleted` int(1) NULL DEFAULT 0 COMMENT '逻辑删除',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`simrealname_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1352876007043940355 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '解绑卡机表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_simrealname
-- ----------------------------
INSERT INTO `sys_simrealname` VALUES (1352817724383903745, '卡号', 'ICCID', '运营商', 0, 1, 0, '2021-01-23 11:17:34', '2021-01-23 11:17:34');
INSERT INTO `sys_simrealname` VALUES (1352817769640443906, '卡号', 'ICCID', '运营商', 1, 1, 0, '2021-01-23 11:17:45', '2021-01-23 11:17:45');
INSERT INTO `sys_simrealname` VALUES (1352876007043940354, '测试', '测试', '测试', 1, 1, 0, '2021-01-23 15:09:10', '2021-01-23 15:09:10');

SET FOREIGN_KEY_CHECKS = 1;
