/*
 Navicat Premium Data Transfer

 Source Server         : MySQL_Local
 Source Server Type    : MySQL
 Source Server Version : 80016
 Source Host           : 127.0.0.1:3306
 Source Schema         : incubator_oauth2

 Target Server Type    : MySQL
 Target Server Version : 80016
 File Encoding         : 65001

 Date: 20/08/2019 12:40:56
*/
-- ----------------------------
-- New database
-- ----------------------------
CREATE DATABASE IF NOT EXISTS incubator_oauth2 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE incubator_oauth2;

-- ----------------------------
SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for oauth_access_token
-- ----------------------------
DROP TABLE IF EXISTS `oauth_access_token`;
CREATE TABLE `oauth_access_token`  (
  `token_id` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '将access_token的值通过MD5加密后存储的',
  `token` blob NULL COMMENT '将OAuth2AccessToken.java对象序列化后的二进制数据, 是真实的AccessToken的数据值',
  `authentication_id` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '根据当前的username(如果有),client_id与scope通过MD5加密生成',
  `user_name` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '登录时的用户名, 若客户端没有用户名(如grant_type=\"client_credentials\"),则该值等于client_id',
  `client_id` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `authentication` blob NULL COMMENT '将OAuth2Authentication.java对象序列化后的二进制数据.',
  `refresh_token` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '将refresh_token的值通过MD5加密后存储的.',
  PRIMARY KEY (`authentication_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;


-- ----------------------------
-- Table structure for oauth_approvals
-- ----------------------------
DROP TABLE IF EXISTS `oauth_approvals`;
CREATE TABLE `oauth_approvals`  (
  `userId` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `clientId` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `scope` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `status` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `expiresAt` timestamp(0) NULL DEFAULT NULL,
  `lastModifiedAt` timestamp(0) NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for oauth_client_details
-- ----------------------------
DROP TABLE IF EXISTS `oauth_client_details`;
CREATE TABLE `oauth_client_details`  (
  `client_id` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用于唯一标识每一个客户端',
  `resource_ids` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '客户端所能访问的资源id集合，多个资源时用逗号(,)分隔',
  `client_secret` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '客户端(client)的访问密匙',
  `scope` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '客户端申请的权限范围,可选值包括read,write,trust',
  `authorized_grant_types` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '指定客户端支持的grant_type,可选值包括authorization_code,password,refresh_token,implicit,client_credentials, 若支持多个grant_type用逗号(,)分隔,如: \"authorization_code,password\".',
  `web_server_redirect_uri` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '客户端的重定向URI,可为空, 当grant_type为authorization_code或implicit时, 在Oauth的流程中会使用并检查与注册时填写的redirect_uri是否一致. 下面分别说明:\r\n当grant_type=authorization_code时, 第一步 从 spring-oauth-server获取 \'code\'时客户端发起请求时必须有redirect_uri参数, 该参数的值必须与 web_server_redirect_uri的值一致. 第二步 用 \'code\' 换取 \'access_token\' 时客户也必须传递相同的redirect_uri. \r\n在实际应用中, web_server_redirect_uri在注册时是必须填写的, 一般用来处理服务器返回的code, 验证state是否合法与通过code去换取access_token值. \r\n在spring-oauth-client项目中, 可具体参考AuthorizationCodeController.java中的authorizationCodeCallback方法.\r\n当grant_type=implicit时通过redirect_uri的hash值来传递access_token值.如:',
  `authorities` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '客户端所拥有的Spring Security的权限值,可选, 若有多个权限值,用逗号(,)分隔',
  `access_token_validity` int(11) NULL DEFAULT NULL COMMENT '客户端的access_token的有效时间值(单位:秒)',
  `refresh_token_validity` int(11) NULL DEFAULT NULL COMMENT '客户端的refresh_token的有效时间值(单位:秒)',
  `additional_information` varchar(4096) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '预留的字段，必须是JSON格式',
  `autoapprove` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '设置用户是否自动Approval操作, 默认值为 \'false\', 可选值包括 \'true\',\'false\', \'read\',\'write\'. \r\n该字段只适用于grant_type=\"authorization_code\"的情况,当用户登录成功后,若该值为\'true\'或支持的scope值,则会跳过用户Approve的页面, 直接授权. \r\n该字段与 trusted 有类似的功能, 是 spring-security-oauth2 的 2.0 版本后添加的新属性',
  PRIMARY KEY (`client_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of oauth_client_details
-- ----------------------------
INSERT INTO `oauth_client_details` VALUES ('client', NULL, '$2a$10$Gel0zdveyr8nfE6cWnsV3OuaxxA3RZdBpCcJObzpJHO6Bwwim/S9e', 'app', 'password,authorization_code,client_credentials,implicit,refresh_token', NULL, 'read,write,trust', 7200, 72000, '{\"project\": \"incubator-projects-oauth2\"}', 'false');
INSERT INTO `oauth_client_details` VALUES ('system', NULL, '$2a$10$0VZq9w6xFjXRdeQtMXuEnO92DutOBBRAAH1Co1Lyu0gN7zfvYkyIK', 'all', 'password,authorization_code,client_credentials,implicit,refresh_token', NULL, 'read', 7200, 72000, '{\"project\": \"incubator-projects-oauth2\"}', 'false');

-- ----------------------------
-- Table structure for oauth_client_token
-- ----------------------------
DROP TABLE IF EXISTS `oauth_client_token`;
CREATE TABLE `oauth_client_token`  (
  `token_id` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `token` blob NULL,
  `authentication_id` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `user_name` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `client_id` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`authentication_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for oauth_code
-- ----------------------------
DROP TABLE IF EXISTS `oauth_code`;
CREATE TABLE `oauth_code`  (
  `code` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '存储服务端系统生成的code的值(未加密).',
  `authentication` blob NULL COMMENT '存储将AuthorizationRequestHolder.java对象序列化后的二进制数据.'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for oauth_refresh_token
-- ----------------------------
DROP TABLE IF EXISTS `oauth_refresh_token`;
CREATE TABLE `oauth_refresh_token`  (
  `token_id` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '通过MD5加密后的refresh_token',
  `token` blob NULL COMMENT '存储将OAuth2RefreshToken.java对象序列化后的二进制数据.',
  `authentication` blob NULL COMMENT '存储将OAuth2Authentication.java对象序列化后的二进制数据.'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `parent_id` bigint(20) NULL DEFAULT NULL COMMENT '父权限',
  `name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '权限名称',
  `type` tinyint(1) NOT NULL COMMENT '权限类型：0-MENU 1-OPERATION 2-FILE 3-ELEMENT',
  `permission` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '权限代码',
  `uri` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '授权访问地址',
  `method` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '请求方式：POST | GET | PUT | DELETE | ',
  `description` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  `create_time` datetime(0) NOT NULL,
  `update_time` datetime(0) NOT NULL,
  `has_deleted` tinyint(1) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '权限表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_permission
-- ----------------------------
INSERT INTO `sys_permission` VALUES (613335937463746563, NULL, '新增用户', 1, 'user:insert', '/api/v1/user', 'POST', '新增用户', '2019-08-20 11:56:51', '2019-08-20 11:56:53', 0);
INSERT INTO `sys_permission` VALUES (613335937463746564, NULL, '修改用户', 1, 'user:update', '/api/v1/user', 'PUT', '修改用户', '2019-08-20 11:57:41', '2019-08-20 11:57:44', 0);
INSERT INTO `sys_permission` VALUES (613335937463746565, NULL, '删除用户', 1, 'user:delete', '/api/v1/user', 'DELETE', '删除用户', '2019-08-20 11:58:26', '2019-08-20 11:58:28', 0);
INSERT INTO `sys_permission` VALUES (613335937463746566, NULL, '查询用户', 1, 'user:select', '/api/v1/user', 'GET', '查询用户', '2019-08-20 11:59:12', '2019-08-20 11:59:13', 0);

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `parent_id` bigint(20) NULL DEFAULT NULL COMMENT '父角色',
  `name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '角色名称',
  `code` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '角色唯一标识',
  `enable` tinyint(1) NULL DEFAULT NULL COMMENT '是否启用：1-启用 0-禁用',
  `description` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  `create_time` datetime(0) NOT NULL,
  `update_time` datetime(0) NOT NULL,
  `has_deleted` tinyint(1) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '角色表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES (613335937459552256, NULL, '超级管理员', 'ROLE_ROOT', 1, '最高权限', '2019-08-20 11:39:03', '2019-08-20 11:39:05', 0);
INSERT INTO `sys_role` VALUES (613335937459552257, NULL, '系统管理员', 'ROLE_ADMIN', 1, '普通管理员', '2019-08-20 11:39:49', '2019-08-20 11:39:52', 0);
INSERT INTO `sys_role` VALUES (613335937459552258, NULL, '测试人员', 'ROLE_TEST', 1, '测试人员', '2019-08-20 11:40:33', '2019-08-20 11:40:36', 0);
INSERT INTO `sys_role` VALUES (613335937459552259, NULL, '普通用户', 'ROLE_USER', 1, '普通用户，已登录', '2019-08-20 11:41:33', '2019-08-20 11:41:35', 0);
INSERT INTO `sys_role` VALUES (613335937459552260, NULL, '游客', 'ROLE_GUEST', 1, '游客，未登录', '2019-08-20 11:42:13', '2019-08-20 11:42:15', 0);

-- ----------------------------
-- Table structure for sys_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_permission`;
CREATE TABLE `sys_role_permission`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) NOT NULL COMMENT '角色 ID',
  `permission_id` bigint(20) NOT NULL COMMENT '权限 ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '角色权限表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role_permission
-- ----------------------------
INSERT INTO `sys_role_permission` VALUES (613335937463746582, 613335937459552256, 613335937463746563);
INSERT INTO `sys_role_permission` VALUES (613335937463746583, 613335937459552256, 613335937463746564);
INSERT INTO `sys_role_permission` VALUES (613335937463746584, 613335937459552256, 613335937463746565);
INSERT INTO `sys_role_permission` VALUES (613335937463746585, 613335937459552256, 613335937463746566);
INSERT INTO `sys_role_permission` VALUES (613335937463746586, 613335937459552257, 613335937463746564);
INSERT INTO `sys_role_permission` VALUES (613335937463746587, 613335937459552257, 613335937463746566);
INSERT INTO `sys_role_permission` VALUES (613335937463746588, 613335937459552257, 613335937463746565);
INSERT INTO `sys_role_permission` VALUES (613335937463746589, 613335937459552258, 613335937463746564);
INSERT INTO `sys_role_permission` VALUES (613335937463746590, 613335937459552258, 613335937463746566);
INSERT INTO `sys_role_permission` VALUES (613335937463746591, 613335937459552259, 613335937463746566);

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `id` bigint(20) NOT NULL,
  `username` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '管理员账号',
  `password` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '管理员密码MD5',
  `real_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '管理员真实姓名',
  `email` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'email',
  `telephone` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '联系方式',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '账号创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '账号修改时间',
  `status` tinyint(1) NULL DEFAULT NULL COMMENT '账号状态  0-禁用  1-可用 2-锁定',
  `has_deleted` tinyint(1) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `username_index`(`username`) USING BTREE COMMENT '用户名唯一'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (613335937459552263, 'root', '$2a$10$Ydu.y2CE4svsbbD0I5xwyelGKOTiwxGV96WzrCX.9eQTwqVtr3iFK', 'Root', 'root@gmail.com', '18569843328', '2019-08-20 11:46:31', '2019-08-20 11:46:34', 0, 0);
INSERT INTO `sys_user` VALUES (613335937459552264, 'admin', '$2a$10$Ydu.y2CE4svsbbD0I5xwyelGKOTiwxGV96WzrCX.9eQTwqVtr3iFK', 'Administrator', 'admin@sina.com', '17605888676', '2019-08-06 20:53:01', '2019-08-06 20:53:01', 0, 0);
INSERT INTO `sys_user` VALUES (613335937459552265, 'user', '$2a$10$Ydu.y2CE4svsbbD0I5xwyelGKOTiwxGV96WzrCX.9eQTwqVtr3iFK', 'User', 'user@foxmail.com', '13687019878', '2019-08-06 21:02:37', '2019-08-06 21:02:37', 0, 0);
INSERT INTO `sys_user` VALUES (613335937459552266, 'test', '$2a$10$Ydu.y2CE4svsbbD0I5xwyelGKOTiwxGV96WzrCX.9eQTwqVtr3iFK', 'Test', 'test@qq.com', '18569874599', '2019-08-20 11:44:53', '2019-08-20 11:44:55', 0, 0);

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL COMMENT '用户 ID',
  `role_id` bigint(20) NOT NULL COMMENT '角色 ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户角色表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES (613335937459552274, 613335937459552263, 613335937459552256);
INSERT INTO `sys_user_role` VALUES (613335937459552275, 613335937459552264, 613335937459552257);
INSERT INTO `sys_user_role` VALUES (613335937459552276, 613335937459552265, 613335937459552259);
INSERT INTO `sys_user_role` VALUES (613335937459552277, 613335937459552266, 613335937459552258);

SET FOREIGN_KEY_CHECKS = 1;
