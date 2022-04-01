-- games.platform definition
CREATE DATABASE `games` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

CREATE TABLE `platform` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `appkey` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `master_secret` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `name` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `department` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1001 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;


-- games.`user` definition

CREATE TABLE `user` (
  `id` binary(16) NOT NULL,
  `create_time` datetime(6) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `platform_id` bigint(20) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO platform (id,appkey,create_time,master_secret,name,department,status) VALUES
	 (1000,'369646520318908809687797',NULL,'812102524289316172204346','光谷1号','武昌区',NULL);