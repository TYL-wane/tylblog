/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.7.25-log : Database - blog
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`blog` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `blog`;

/*Table structure for table `article` */

DROP TABLE IF EXISTS `article`;

CREATE TABLE `article` (
  `art_id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `art_insert_time` date NOT NULL COMMENT '博文创建时间',
  `art_content` longtext CHARACTER SET utf8 NOT NULL COMMENT '博文内容',
  `art_describe` text CHARACTER SET utf8 NOT NULL COMMENT '描述',
  `art_title` varchar(255) CHARACTER SET utf8 NOT NULL COMMENT '标题',
  `art_image` varchar(255) CHARACTER SET utf8 NOT NULL COMMENT '图片',
  `art_update_time` date NOT NULL COMMENT '更改时间',
  `art_thumbs_size` int(11) DEFAULT '0' COMMENT '点赞数',
  `art_browse_size` int(11) DEFAULT '0' COMMENT '浏览数',
  `isdelete` int(11) DEFAULT '0',
  `art_keyword` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '关键字',
  `art_comments_size` int(255) DEFAULT '0' COMMENT '评论数量',
  PRIMARY KEY (`art_id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4;

/*Data for the table `article` */

insert  into `article`(`art_id`,`art_insert_time`,`art_content`,`art_describe`,`art_title`,`art_image`,`art_update_time`,`art_thumbs_size`,`art_browse_size`,`isdelete`,`art_keyword`,`art_comments_size`) values (16,'2021-10-15','法塔赫风格化风格化规范化风格和风格和','规划风格化风格化风格化','规范化风格化风格化','imgge','2021-10-15',0,0,0,'打发士大夫',0),(17,'2021-10-15','空间规划覅计算机上的不易腐蚀的','h规划规划规范化风格化规范化','干活干活干活','img','2021-10-15',0,0,0,'共和国和',0);

/*Table structure for table `article_sort` */

DROP TABLE IF EXISTS `article_sort`;

CREATE TABLE `article_sort` (
  `art_sort_id` int(11) NOT NULL AUTO_INCREMENT,
  `art_id` bigint(20) NOT NULL,
  `doc_id` int(11) NOT NULL,
  PRIMARY KEY (`art_sort_id`),
  KEY `art_id` (`art_id`),
  KEY `doc_id` (`doc_id`),
  CONSTRAINT `article_sort_ibfk_1` FOREIGN KEY (`art_id`) REFERENCES `article` (`art_id`),
  CONSTRAINT `article_sort_ibfk_2` FOREIGN KEY (`doc_id`) REFERENCES `documenttype` (`doc_id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

/*Data for the table `article_sort` */

insert  into `article_sort`(`art_sort_id`,`art_id`,`doc_id`) values (20,14,8),(21,15,1),(24,19,8);

/*Table structure for table `classification` */

DROP TABLE IF EXISTS `classification`;

CREATE TABLE `classification` (
  `classi_id` int(11) NOT NULL AUTO_INCREMENT,
  `classi_name` varchar(50) NOT NULL,
  PRIMARY KEY (`classi_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `classification` */

insert  into `classification`(`classi_id`,`classi_name`) values (1,'面试题'),(2,'心情随笔'),(3,'错误笔记');

/*Table structure for table `classification_article` */

DROP TABLE IF EXISTS `classification_article`;

CREATE TABLE `classification_article` (
  `cart_id` int(11) NOT NULL AUTO_INCREMENT,
  `classi_id` int(11) NOT NULL,
  `art_id` bigint(20) NOT NULL,
  PRIMARY KEY (`cart_id`),
  KEY `classi_id` (`classi_id`),
  KEY `art_id` (`art_id`),
  CONSTRAINT `classification_article_ibfk_1` FOREIGN KEY (`classi_id`) REFERENCES `classification` (`classi_id`),
  CONSTRAINT `classification_article_ibfk_2` FOREIGN KEY (`art_id`) REFERENCES `article` (`art_id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

/*Data for the table `classification_article` */

insert  into `classification_article`(`cart_id`,`classi_id`,`art_id`) values (17,2,14),(18,1,15),(21,2,19);

/*Table structure for table `comments` */

DROP TABLE IF EXISTS `comments`;

CREATE TABLE `comments` (
  `comm_id` bigint(18) NOT NULL AUTO_INCREMENT COMMENT '评论id',
  `u_id` bigint(18) NOT NULL COMMENT '用户id',
  `art_id` bigint(18) NOT NULL COMMENT '博文id',
  `comm_content` longtext COMMENT '评论内容',
  `comm_time` date DEFAULT NULL COMMENT '评论时间',
  `comm_like_num` int(18) DEFAULT '0' COMMENT '点赞数',
  `comm_nolike_num` int(18) DEFAULT '0' COMMENT '不喜欢',
  `comm_parentid` bigint(18) DEFAULT '0' COMMENT '父评论id',
  `isdelete` bigint(2) DEFAULT '0',
  `parent_user_id` bigint(18) DEFAULT '0' COMMENT '回复人的id',
  PRIMARY KEY (`comm_id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4;

/*Data for the table `comments` */

insert  into `comments`(`comm_id`,`u_id`,`art_id`,`comm_content`,`comm_time`,`comm_like_num`,`comm_nolike_num`,`comm_parentid`,`isdelete`,`parent_user_id`) values (1,6,16,'第一层','2021-10-13',0,0,0,0,0),(10,7,16,'第二层','2021-10-15',0,0,1,0,6),(11,8,16,'回复评论','2021-10-15',0,0,1,0,7),(12,9,16,'第一层 1','2021-10-15',0,0,0,0,0),(13,6,16,'第二层  1','2021-10-15',0,0,12,0,9),(14,7,16,'回复  1','2021-10-15',0,0,12,0,6),(18,10,16,'<p>张三<img class=\"eleImg\" data-emoji=\"[坏笑]\" src=\"http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/7a/shenshou_thumb.gif\" alt=\"[[坏笑]]\"/></p>','2021-10-15',0,0,1,0,7),(19,10,16,'<p>王五<img class=\"eleImg\" data-emoji=\"[舔屏]\" src=\"http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/60/horse2_thumb.gif\" alt=\"[[舔屏]]\"/></p>','2021-10-15',0,0,1,0,8),(20,10,16,'<p>李四<img class=\"eleImg\" data-emoji=\"[浮云]\" src=\"http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/bc/fuyun_thumb.gif\" alt=\"[[浮云]]\"/></p>','2021-10-15',0,0,1,0,6),(21,10,16,'<p>赵六<img class=\"eleImg\" data-emoji=\"[给力]\" src=\"http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/c9/geili_thumb.gif\" alt=\"[[给力]]\"/></p>','2021-10-15',0,0,12,0,9),(22,10,16,'<p>李四<img class=\"eleImg\" data-emoji=\"[围观]\" src=\"http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/f2/wg_thumb.gif\" alt=\"[[围观]]\"/></p>','2021-10-15',0,0,12,0,6),(23,10,16,'<p>张三<img class=\"eleImg\" data-emoji=\"[威武]\" src=\"http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/70/vw_thumb.gif\" alt=\"[[威武]]\"/></p>','2021-10-15',0,0,12,0,7),(24,10,16,'<p>欢迎来到评论<img class=\"eleImg\" data-emoji=\"[挖鼻屎]\" src=\"http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/a0/kbsa_thumb.gif\" alt=\"[[挖鼻屎]]\"/><img class=\"eleImg\" data-emoji=\"[吐]\" src=\"http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/9e/t_thumb.gif\" alt=\"[[吐]]\"/><img class=\"eleImg\" data-emoji=\"[抱抱]\" src=\"http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/27/bba_thumb.gif\" alt=\"[[抱抱]]\"/><img class=\"eleImg\" data-emoji=\"[怒]\" src=\"http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/7c/angrya_thumb.gif\" alt=\"[[怒]]\"/></p>','2021-10-15',0,0,0,0,0),(25,10,16,'<p><img class=\"eleImg\" data-emoji=\"[互粉]\" src=\"http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/89/hufen_thumb.gif\" alt=\"[[互粉]]\"/><br/></p>','2021-10-15',0,0,24,0,10);

/*Table structure for table `documenttype` */

DROP TABLE IF EXISTS `documenttype`;

CREATE TABLE `documenttype` (
  `doc_id` int(11) NOT NULL AUTO_INCREMENT,
  `doc_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`doc_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

/*Data for the table `documenttype` */

insert  into `documenttype`(`doc_id`,`doc_name`) values (1,'Java基础'),(2,'spring'),(3,'springMvc'),(4,'Mybatis'),(5,'javaEE'),(6,'javaEE'),(7,'springBoot'),(8,'javaScript');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `user_id` int(20) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `user_name` varchar(20) NOT NULL COMMENT '用户名',
  `user_password` varchar(255) NOT NULL COMMENT '用户密码',
  `user_email` varchar(30) NOT NULL COMMENT '用户邮箱',
  `user_profile_photo` varchar(255) DEFAULT 'image/headImg.png' COMMENT '用户头像',
  `user_registration_time` datetime NOT NULL COMMENT '注册时间',
  `user_birthday` date DEFAULT NULL COMMENT '用户生日',
  `user_age` tinyint(4) DEFAULT NULL COMMENT '用户年龄',
  `user_telephone_number` varchar(11) DEFAULT NULL COMMENT '用户手机号',
  `user_nickname` varchar(20) NOT NULL COMMENT '用户昵称',
  `user_signature` varchar(255) DEFAULT NULL COMMENT '个性签名',
  `isdelete` bigint(2) NOT NULL DEFAULT '0',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`user_id`,`user_name`,`user_password`,`user_email`,`user_profile_photo`,`user_registration_time`,`user_birthday`,`user_age`,`user_telephone_number`,`user_nickname`,`user_signature`,`isdelete`) values (6,'lisi','反对法','反对d','image/headImg.png','2021-10-23 14:44:18','2021-10-15',18,'1424242424','lisi','是的是的',0),(7,'zhangsan','sdsdsdsd','sdsd','image/headImg.png','2021-10-15 14:51:13','2021-10-15',20,'5246541212','zhangsan','sdasd',0),(8,'wangwu','fdfdfdf','dfdfdfdfd','image/headImg.png','2021-10-15 14:51:59','2021-10-15',23,'1251245132','wangwu','dfdf',0),(9,'zhaoliu','fdfd','ddfdf','image/headImg.png','2021-10-15 14:52:19','2021-10-15',12,'4424242422','zhaoliu','fdfd',0),(10,'17628647224','a69eead8138f909fe5b79e9f95971a82','2119196781@qq.com','image/headImg.png','2021-10-15 18:13:53',NULL,NULL,NULL,'tangtang1',NULL,0);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
