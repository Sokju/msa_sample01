--drop sequence if exists hibernate_sequence;
--DROP TABLE IF EXISTS oauth_client_details;
--DROP TABLE IF EXISTS members;

create sequence IF NOT EXISTS hibernate_sequence start with 1 increment by 1;

CREATE TABLE IF NOT EXISTS `oauth_client_details` (
  `client_id` varchar(256) COLLATE utf8_unicode_ci NOT NULL,
  `resource_ids` varchar(256) COLLATE utf8_unicode_ci DEFAULT NULL,
  `client_secret` varchar(256) COLLATE utf8_unicode_ci DEFAULT NULL,
  `scope` varchar(256) COLLATE utf8_unicode_ci DEFAULT NULL,
  `authorized_grant_types` varchar(256) COLLATE utf8_unicode_ci DEFAULT NULL,
  `web_server_redirect_uri` varchar(256) COLLATE utf8_unicode_ci DEFAULT NULL,
  `authorities` varchar(256) COLLATE utf8_unicode_ci DEFAULT NULL,
  `access_token_validity` int(11) DEFAULT NULL,
  `refresh_token_validity` int(11) DEFAULT NULL,
  `additional_information` varchar(4096) COLLATE utf8_unicode_ci DEFAULT NULL,
  `autoapprove` varchar(256) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`client_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;


CREATE TABLE IF NOT EXISTS `members` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `name` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `comment` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `user_type` varchar(1) COLLATE utf8_unicode_ci NOT NULL,
  `reg_date` datetime,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;