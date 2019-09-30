USE heroku_79525cdf06e353b;
DROP TRIGGER IF EXISTS `after_website_role_insert`;
DROP TRIGGER IF EXISTS `after_website_role_update`;
DROP TRIGGER IF EXISTS `after_website_role_delete`;
DROP TRIGGER IF EXISTS `after_page_role_insert`;
DROP TRIGGER IF EXISTS `after_page_role_update`;
DROP TRIGGER IF EXISTS `after_page_role_delete`;

DELIMITER //
CREATE TRIGGER `after_website_role_insert` AFTER INSERT ON `website_role` FOR EACH ROW
BEGIN
CASE
	WHEN NEW.`role` = 'owner' THEN
    INSERT INTO `website_priviledge` (`priviledge`,`did`,`wid`) SELECT `name`,NEW.`did`,NEW.`wid` FROM `priviledge` ;
    WHEN NEW.`role` = 'admin' THEN
    INSERT INTO `website_priviledge` (`priviledge`,`did`,`wid`) SELECT `name`,NEW.`did`,NEW.`wid` FROM `priviledge`;
    WHEN NEW.`role` = 'writer' THEN
    INSERT INTO `website_priviledge` (`priviledge`,`did`,`wid`) SELECT `name`,NEW.`did`,NEW.`wid` FROM `priviledge` WHERE `name` NOT IN ('delete');
    WHEN NEW.`role` = 'editor' THEN
    INSERT INTO `website_priviledge` (`priviledge`,`did`,`wid`) SELECT `name`,NEW.`did`,NEW.`wid` FROM `priviledge` WHERE `name` NOT IN ('create','delete');
    WHEN NEW.`role` = 'reviewer' THEN
    INSERT INTO `website_priviledge` (`priviledge`,`did`,`wid`) SELECT `name`,NEW.`did`,NEW.`wid` FROM `priviledge` WHERE `name` NOT IN ('create','delete','update');
    END CASE;
END//

DELIMITER //
CREATE TRIGGER `after_website_role_update` AFTER UPDATE ON `website_role` FOR EACH ROW
BEGIN
DELETE FROM  `website_priviledge` WHERE `did` = OLD.`did` AND `wid`= OLD.`wid`;
CASE
	WHEN NEW.`role` = 'owner' THEN
    INSERT INTO `website_priviledge` (`priviledge`,`did`,`wid`) SELECT `name`,OLD.`did`,OLD.`wid` FROM `priviledge`;
    WHEN NEW.`role` = 'admin' THEN
    INSERT INTO `website_priviledge` (`priviledge`,`did`,`wid`) SELECT `name`,OLD.`did`,OLD.`wid` FROM `priviledge`;
    WHEN NEW.`role` = 'writer' THEN
    INSERT INTO `website_priviledge` (`priviledge`,`did`,`wid`) SELECT `name`,OLD.`did`,OLD.`wid` FROM `priviledge` WHERE `name` NOT IN ('delete');
    WHEN NEW.`role` = 'editor' THEN
    INSERT INTO `website_priviledge` (`priviledge`,`did`,`wid`) SELECT `name`,OLD.`did`,OLD.`wid` FROM `priviledge` WHERE `name` NOT IN ('create','delete');
    WHEN NEW.`role` = 'reviewer' THEN
    INSERT INTO `website_priviledge` (`priviledge`,`did`,`wid`) SELECT `name`,OLD.`did`,OLD.`wid` FROM `priviledge` WHERE `name` NOT IN ('create','delete','update');
    END CASE;
END//

  
DELIMITER //
CREATE TRIGGER `after_website_role_delete` AFTER DELETE ON `website_role` FOR EACH ROW
BEGIN
DELETE FROM  `website_priviledge` WHERE `did` = OLD.`did` AND `wid`= OLD.`wid`;
END//
  
  
 DELIMITER //
CREATE TRIGGER `after_page_role_insert` AFTER INSERT ON `page_role` FOR EACH ROW
BEGIN
CASE
	WHEN NEW.`role` = 'owner' THEN
    INSERT INTO `page_priviledge` (`priviledge`,`did`,`page_id`) SELECT `name`,NEW.`did`,NEW.`page_id` FROM `priviledge`;
    WHEN NEW.`role` = 'admin' THEN
    INSERT INTO `page_priviledge` (`priviledge`,`did`,`page_id`) SELECT `name`,NEW.`did`,NEW.`page_id` FROM `priviledge`;
    WHEN NEW.`role` = 'writer' THEN
    INSERT INTO `page_priviledge` (`priviledge`,`did`,`page_id`) SELECT `name`,NEW.`did`,NEW.`page_id` FROM `priviledge` WHERE `name` NOT IN ('delete');
    WHEN NEW.`role` = 'editor' THEN
    INSERT INTO `page_priviledge` (`priviledge`,`did`,`page_id`) SELECT `name`,NEW.`did`,NEW.`page_id` FROM `priviledge` WHERE `name` NOT IN ('create','delete');
    WHEN NEW.`role` = 'reviewer' THEN
    INSERT INTO `page_priviledge` (`priviledge`,`did`,`page_id`) SELECT `name`,NEW.`did`,NEW.`page_id` FROM `priviledge` WHERE `name` NOT IN ('create','delete','update');
    END CASE;
END//

DELIMITER //
CREATE TRIGGER `after_page_role_update` AFTER UPDATE ON `page_role` FOR EACH ROW
BEGIN

DELETE FROM  `page_priviledge` WHERE `did` = OLD.`did` AND `page_id`= OLD.`page_id`;
CASE
	WHEN NEW.`role` = 'owner' THEN
    INSERT INTO `page_priviledge` (`priviledge`,`did`,`page_id`) SELECT `name`,OLD.`did`,OLD.`page_id` FROM `priviledge`;
    WHEN NEW.`role` = 'admin' THEN
    INSERT INTO `page_priviledge` (`priviledge`,`did`,`page_id`) SELECT `name`,OLD.`did`,OLD.`page_id` FROM `priviledge`;
    WHEN NEW.`role` = 'writer' THEN
    INSERT INTO `page_priviledge` (`priviledge`,`did`,`page_id`) SELECT `name`,OLD.`did`,OLD.`page_id` FROM `priviledge` WHERE `name` NOT IN ('delete');
    WHEN NEW.`role` = 'editor' THEN
    INSERT INTO `page_priviledge` (`priviledge`,`did`,`page_id`) SELECT `name`,OLD.`did`,OLD.`page_id` FROM `priviledge` WHERE `name` NOT IN ('create','delete');
    WHEN NEW.`role` = 'reviewer' THEN
    INSERT INTO `page_priviledge` (`priviledge`,`did`,`page_id`) SELECT `name`,OLD.`did`,OLD.`page_id` FROM `priviledge` WHERE `name` NOT IN ('create','delete','update');
    END CASE;
END//

  
DELIMITER //
CREATE TRIGGER `after_page_role_delete` AFTER DELETE ON `page_role` FOR EACH ROW
BEGIN
DELETE FROM  `page_priviledge` WHERE `did` = OLD.`did` AND `page_id`= OLD.`page_id`;
END//
  