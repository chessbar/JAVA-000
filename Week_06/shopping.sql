CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;

-- -----------------------------------------------------
-- Table `user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `user` (
  `id` BIGINT NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `username` VARCHAR(100) NOT NULL COMMENT '用户名',
  `nickname` VARCHAR(100) NOT NULL COMMENT '昵称',
  `password` VARCHAR(100) NOT NULL COMMENT '密码',
  `created` DATETIME NOT NULL COMMENT '创建时间',
  `modified` DATETIME NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`),
  UNIQUE INDEX `idx_usernamne` (`username` ASC))
ENGINE = InnoDB
COMMENT = '用户';


-- -----------------------------------------------------
-- Table `user_address`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `user_address` (
  `id` BIGINT NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `username` VARCHAR(100) NOT NULL COMMENT '用户名 user表关联字段',
  `contact_name` VARCHAR(100) NOT NULL COMMENT '联系人',
  `contact_phone` VARCHAR(45) NOT NULL COMMENT '联系人手机号',
  `address` VARCHAR(255) NOT NULL COMMENT '收货地址',
  `post` VARCHAR(45) NOT NULL COMMENT '邮编',
  `created` DATETIME NOT NULL COMMENT '创建时间',
  `modified` DATETIME NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`))
ENGINE = InnoDB
COMMENT = '收货地址';


-- -----------------------------------------------------
-- Table `goods`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `goods` (
  `id` BIGINT NOT NULL AUTO_INCREMENT COMMENT '商品',
  `category_id` BIGINT NOT NULL COMMENT '分类id',
  `goods_title` VARCHAR(100) NOT NULL COMMENT '商品名称',
  `goods_content` MEDIUMTEXT NOT NULL COMMENT '商品描述',
  `price` BIGINT NOT NULL COMMENT '商品金额',
  `status` VARCHAR(45) NOT NULL COMMENT '状态',
  `created` DATETIME NOT NULL COMMENT '创建时间',
  `modified` DATETIME NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`))
ENGINE = InnoDB
COMMENT = '商品表';


-- -----------------------------------------------------
-- Table `order`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `order` (
  `id` BIGINT NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `order_number` VARCHAR(100) NOT NULL COMMENT '订单编号',
  `user_id` BIGINT NOT NULL COMMENT '下单人',
  `goods_id` BIGINT NOT NULL COMMENT '商品id',
  `user_address_id` BIGINT NOT NULL COMMENT '收货地址',
  `price` BIGINT NOT NULL COMMENT '创建时间',
  `created` DATETIME NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`))
ENGINE = InnoDB
COMMENT = '订单';


-- -----------------------------------------------------
-- Table `category`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `category` (
  `id` BIGINT NOT NULL AUTO_INCREMENT COMMENT '商品id',
  `category_title` VARCHAR(45) NOT NULL COMMENT '分类名称',
  `pid` BIGINT NOT NULL COMMENT '上级分类id',
  `created` DATETIME NOT NULL COMMENT '创建时间',
  `modified` DATETIME NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`))
ENGINE = InnoDB
COMMENT = '商品分类';
