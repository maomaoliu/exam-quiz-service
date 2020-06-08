DROP TABLE IF EXISTS `quiz`;
CREATE TABLE `quiz` (
   `id` varchar2(255) NOT NULL,
   `content` varchar2(255) NOT NULL,
   `referenceAnswer` varchar2(255) NOT NULL,
   `score` smallint NOT NULL,
   `teacherId` varchar2(255) NOT NULL,
   `createTime` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
   `updateTime` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
   PRIMARY KEY (`id`)
);