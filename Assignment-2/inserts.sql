USE `cs5200_fall2019_rastogi`;
SET FOREIGN_KEY_CHECKS = 0; 
TRUNCATE TABLE `website_role`;
TRUNCATE TABLE `website_priviledge`;
TRUNCATE TABLE `page_role`;
TRUNCATE TABLE `page_priviledge`;
TRUNCATE TABLE `phone`;
TRUNCATE TABLE `address`;
TRUNCATE TABLE `widget`;
TRUNCATE TABLE `page`;
TRUNCATE TABLE `website`;
TRUNCATE TABLE `developer`;
TRUNCATE TABLE `user`;
TRUNCATE TABLE `person`;
SET FOREIGN_KEY_CHECKS = 1; 


START TRANSACTION;
INSERT INTO `person` (`id`,`username`,`password`,`first_name`,`last_name`,`email`) VALUES
(12,'alice','alice','Alice','Wonder','alice@wonder.com'),
(23,'bob','bob','Bob','Marley','bob@marley.com'),
(34,'charlie','charlie','Charles','Garcia','chuch@garcia.com'),
(45,'dan','dan','Dan','Martin','dan@martin.com'),
(56,'ed','ed','Ed','Karaz','ed@kar.com');

INSERT INTO `developer` (`id`,`developer_key`) VALUES
(12,'4321rewq'),
(23,'5432trew'),
(34,'6543ytre');

INSERT INTO `user` (`id`) VALUES
(45),
(56);
COMMIT;

START TRANSACTION;

INSERT INTO `website`
(`id`, `name`, `description`, `created`, `updated`, `visits`, `creator_id`)
VALUES
(123,'Facebook','an online social media and social networking service', NOW(), NOW(), 1234234, (SELECT `id` FROM `person` WHERE `username`='alice')),
(234,'Twitter','an online news and social networking service', NOW(), NOW(), 4321543, (SELECT `id` FROM `person` WHERE `username`='bob')),
(345,'Wikipedia','a free online encyclopedia', NOW(), NOW(), 3456654, (SELECT `id` FROM `person` WHERE `username`='charlie')),
(456,'CNN','an American basic cable and satellite television news channel', NOW(), NOW(), 6543345, (SELECT `id` FROM `person` WHERE `username`='alice')),
(567,'CNET','an American media website that publishes reviews, news, articles, blogs, podcasts and videos on technology and consumer electronics',NOW(), NOW(),5433455,(SELECT `id` FROM `person` WHERE `username`='bob')),
(678,'Gizmodo','a design, technology, science and science fiction website that also writes articles on politics',NOW(), NOW(), 4322345,(SELECT `id` FROM `person` WHERE `username`='charlie'));

INSERT INTO `website_role`(`role`,`did`,`wid`) VALUES ('owner', (SELECT `id` FROM `person` WHERE `username`='alice') ,(SELECT `id` FROM `website` WHERE `name`='Facebook')) ;
INSERT INTO `website_role`(`role`,`did`,`wid`) VALUES ('editor', (SELECT `id` FROM `person` WHERE `username`='bob') ,(SELECT `id` FROM `website` WHERE `name`='Facebook')) ;
INSERT INTO `website_role`(`role`,`did`,`wid`) VALUES ('admin', (SELECT `id` FROM `person` WHERE `username`='charlie') ,(SELECT `id` FROM `website` WHERE `name`='Facebook')) ;

INSERT INTO `website_role`(`role`,`did`,`wid`) VALUES ('owner', (SELECT `id` FROM `person` WHERE `username`='bob') ,(SELECT `id` FROM `website` WHERE `name`='Twitter')) ;
INSERT INTO `website_role`(`role`,`did`,`wid`) VALUES ('editor', (SELECT `id` FROM `person` WHERE `username`='charlie') ,(SELECT `id` FROM `website` WHERE `name`='Twitter')) ;
INSERT INTO `website_role`(`role`,`did`,`wid`) VALUES ('admin', (SELECT `id` FROM `person` WHERE `username`='alice') ,(SELECT `id` FROM `website` WHERE `name`='Twitter')) ;

INSERT INTO `website_role`(`role`,`did`,`wid`) VALUES ('owner', (SELECT `id` FROM `person` WHERE `username`='charlie') ,(SELECT `id` FROM `website` WHERE `name`='Wikipedia')) ;
INSERT INTO `website_role`(`role`,`did`,`wid`) VALUES ('editor', (SELECT `id` FROM `person` WHERE `username`='alice') ,(SELECT `id` FROM `website` WHERE `name`='Wikipedia')) ;
INSERT INTO `website_role`(`role`,`did`,`wid`) VALUES ('admin', (SELECT `id` FROM `person` WHERE `username`='bob') ,(SELECT `id` FROM `website` WHERE `name`='Wikipedia')) ;

INSERT INTO `website_role`(`role`,`did`,`wid`) VALUES ('owner', (SELECT `id` FROM `person` WHERE `username`='alice') ,(SELECT `id` FROM `website` WHERE `name`='CNN')) ;
INSERT INTO `website_role`(`role`,`did`,`wid`) VALUES ('editor', (SELECT `id` FROM `person` WHERE `username`='bob') ,(SELECT `id` FROM `website` WHERE `name`='CNN')) ;
INSERT INTO `website_role`(`role`,`did`,`wid`) VALUES ('admin', (SELECT `id` FROM `person` WHERE `username`='charlie') ,(SELECT `id` FROM `website` WHERE `name`='CNN')) ;

INSERT INTO `website_role`(`role`,`did`,`wid`) VALUES ('owner', (SELECT `id` FROM `person` WHERE `username`='bob') ,(SELECT `id` FROM `website` WHERE `name`='CNET')) ;
INSERT INTO `website_role`(`role`,`did`,`wid`) VALUES ('editor', (SELECT `id` FROM `person` WHERE `username`='charlie') ,(SELECT `id` FROM `website` WHERE `name`='CNET')) ;
INSERT INTO `website_role`(`role`,`did`,`wid`) VALUES ('admin', (SELECT `id` FROM `person` WHERE `username`='alice') ,(SELECT `id` FROM `website` WHERE `name`='CNET')) ;


INSERT INTO `website_role`(`role`,`did`,`wid`) VALUES ('owner', (SELECT `id` FROM `person` WHERE `username`='charlie') ,(SELECT `id` FROM `website` WHERE `name`='Gizmodo')) ;
INSERT INTO `website_role`(`role`,`did`,`wid`) VALUES ('editor', (SELECT `id` FROM `person` WHERE `username`='alice') ,(SELECT `id` FROM `website` WHERE `name`='Gizmodo')) ;
INSERT INTO `website_role`(`role`,`did`,`wid`) VALUES ('admin', (SELECT `id` FROM `person` WHERE `username`='bob') ,(SELECT `id` FROM `website` WHERE `name`='Gizmodo')) ;

COMMIT;

START TRANSACTION;
INSERT INTO `page` (`id`,`title`, `description`, `wid`, `created`, `updated`, `views` ) VALUES
(123, 'Home','Landing Page', (SELECT `id` FROM `website` WHERE `name`= 'CNET') , '2019-09-04', '2019-10-02', 123434),
(234, 'About','Website description', (SELECT `id` FROM `website` WHERE `name`='Gizmodo'), '2019-09-04', '2019-10-02', 234545),
(345, 'Contact','Addresses, phones, and contact info', (SELECT `id` FROM `website` WHERE `name`='Wikipedia'), '2019-09-04', '2019-10-02', 345656),
(456, 'Preferences','Where users can configure their preferences', (SELECT `id` FROM `website` WHERE `name`='CNN'), '2019-09-04', '2019-10-02', 456776),
(567, 'Profile','Users can configure their personal information', (SELECT `id` FROM `website` WHERE `name`='CNET'), '2019-09-04', '2019-10-02', 567878);

INSERT INTO `page_role`(`role`,`did`,`page_id`) VALUES ('editor', (SELECT `id` FROM `person` WHERE `username`='alice') ,(SELECT `id` FROM `page` WHERE `title`='Home' AND  `wid` = (SELECT `id` FROM `website` WHERE `name`='CNET'))) ;
INSERT INTO `page_role`(`role`,`did`,`page_id`) VALUES ('reviewer', (SELECT `id` FROM `person` WHERE `username`='bob') ,(SELECT `id` FROM `page` WHERE `title`='Home' AND  `wid` = (SELECT `id` FROM `website` WHERE `name`='CNET'))) ;
INSERT INTO `page_role`(`role`,`did`,`page_id`) VALUES ('writer', (SELECT `id` FROM `person` WHERE `username`='charlie') ,(SELECT `id` FROM `page` WHERE `title`='Home' AND  `wid` = (SELECT `id` FROM `website` WHERE `name`='CNET'))) ;

INSERT INTO `page_role`(`role`,`did`,`page_id`) VALUES ('editor', (SELECT `id` FROM `person` WHERE `username`='bob') ,(SELECT `id` FROM `page` WHERE `title`='About' AND  `wid` = (SELECT `id` FROM `website` WHERE `name`='Gizmodo'))) ;
INSERT INTO `page_role`(`role`,`did`,`page_id`) VALUES ('reviewer', (SELECT `id` FROM `person` WHERE `username`='charlie') ,(SELECT `id` FROM `page` WHERE `title`='About' AND  `wid` = (SELECT `id` FROM `website` WHERE `name`='Gizmodo'))) ;
INSERT INTO `page_role`(`role`,`did`,`page_id`) VALUES ('writer', (SELECT `id` FROM `person` WHERE `username`='alice') ,(SELECT `id` FROM `page` WHERE `title`='About' AND  `wid` = (SELECT `id` FROM `website` WHERE `name`='Gizmodo'))) ;

INSERT INTO `page_role`(`role`,`did`,`page_id`) VALUES ('editor', (SELECT `id` FROM `person` WHERE `username`='charlie') ,(SELECT `id` FROM `page` WHERE `title`='Contact' AND  `wid` = (SELECT `id` FROM `website` WHERE `name`='Wikipedia'))) ;
INSERT INTO `page_role`(`role`,`did`,`page_id`) VALUES ('reviewer', (SELECT `id` FROM `person` WHERE `username`='alice') ,(SELECT `id` FROM `page` WHERE `title`='Contact' AND  `wid` = (SELECT `id` FROM `website` WHERE `name`='Wikipedia'))) ;
INSERT INTO `page_role`(`role`,`did`,`page_id`) VALUES ('writer', (SELECT `id` FROM `person` WHERE `username`='bob') ,(SELECT `id` FROM `page` WHERE `title`='Contact' AND  `wid` = (SELECT `id` FROM `website` WHERE `name`='Wikipedia'))) ;

INSERT INTO `page_role`(`role`,`did`,`page_id`) VALUES ('editor', (SELECT `id` FROM `person` WHERE `username`='alice') ,(SELECT `id` FROM `page` WHERE `title`='Preferences' AND  `wid` = (SELECT `id` FROM `website` WHERE `name`='CNN'))) ;
INSERT INTO `page_role`(`role`,`did`,`page_id`) VALUES ('reviewer', (SELECT `id` FROM `person` WHERE `username`='bob') ,(SELECT `id` FROM `page` WHERE `title`='Preferences' AND  `wid` = (SELECT `id` FROM `website` WHERE `name`='CNN'))) ;
INSERT INTO `page_role`(`role`,`did`,`page_id`) VALUES ('writer', (SELECT `id` FROM `person` WHERE `username`='charlie') ,(SELECT `id` FROM `page` WHERE `title`='Preferences' AND  `wid` = (SELECT `id` FROM `website` WHERE `name`='CNN'))) ;

INSERT INTO `page_role`(`role`,`did`,`page_id`) VALUES ('editor', (SELECT `id` FROM `person` WHERE `username`='bob') ,(SELECT `id` FROM `page` WHERE `title`='Profile' AND  `wid` = (SELECT `id` FROM `website` WHERE `name`='CNET'))) ;
INSERT INTO `page_role`(`role`,`did`,`page_id`) VALUES ('reviewer', (SELECT `id` FROM `person` WHERE `username`='charlie') ,(SELECT `id` FROM `page` WHERE `title`='Profile' AND  `wid` = (SELECT `id` FROM `website` WHERE `name`='CNET'))) ;
INSERT INTO `page_role`(`role`,`did`,`page_id`) VALUES ('writer', (SELECT `id` FROM `person` WHERE `username`='alice') ,(SELECT `id` FROM `page` WHERE `title`='Profile' AND  `wid` = (SELECT `id` FROM `website` WHERE `name`='CNET'))) ;

COMMIT;

START TRANSACTION;
INSERT INTO `widget`(`id`,`name`,`dtype`,`text`,`order` ,`width`,`height`,`youtube_url`,`page_id`) VALUES
(123,'head123','heading','Welcome',0,null,null,null,(SELECT `id` FROM `page` WHERE `title`='Home')),
(234,'post234','html','<p>Lorem</p>',0,null,null,null,(SELECT `id` FROM `page` WHERE `title`='About')),
(345,'head345','heading','Hi',1	,null,null,null,(SELECT `id` FROM `page` WHERE `title`='Contact')),
(456,'intro456','html','<h1>Hi</h1>',2,null,null,null,(SELECT `id` FROM `page` WHERE `title`='Contact')),
(567,'image345','image',null,3,50,100,'/img/567.png',(SELECT `id` FROM `page` WHERE `title`='Contact')),
(678,'video456','youtube',null,0,400,300,'https://youtu.be/h67VX51QXiQ',(SELECT `id` FROM `page` WHERE `title`='Preferences'));
COMMIT;

START TRANSACTION;

INSERT INTO `phone`(`phone`, `primary`, `pid`) VALUES
('123-234-3456',true, (SELECT `id` FROM `person` WHERE `username`='alice')),
('234-345-4566',false,(SELECT `id` FROM `person` WHERE `username`='alice')),
('345-456-5677',true,(SELECT `id` FROM `person` WHERE `username`='bob')),
('321-432-5435',true,(SELECT `id` FROM `person` WHERE `username`='charlie')),
('432-432-5433',false,(SELECT `id` FROM `person` WHERE `username`='charlie')),
('543-543-6544',false,(SELECT `id` FROM `person` WHERE `username`='charlie'));

INSERT INTO `address`(`street1`,`city`,`zip`,`primary`,`pid`) VALUES
('123 Adam St.','Alton','01234',true,(SELECT `id` FROM `person` WHERE `username`='alice')),
('234 Birch St.','Boston','02345',false,(SELECT `id` FROM `person` WHERE `username`='alice')),
('345 Charles St.','Chelms','03455',true,(SELECT `id` FROM `person` WHERE `username`='bob')),
('456 Down St.','Dalton','04566',false,(SELECT `id` FROM `person` WHERE `username`='bob')),
('543 East St.','Everett','01112',false,(SELECT `id` FROM `person` WHERE `username`='bob')),
('654 Frank St.','Foulton','04322',true,(SELECT `id` FROM `person` WHERE `username`='charlie'));
COMMIT;

