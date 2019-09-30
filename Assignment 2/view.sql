USE heroku_79525cdf06e353b;
DROP VIEW  IF EXISTS `developer_roles_and_priviledges`;

CREATE VIEW `developer_roles_and_priviledges` AS
    (SELECT 
        `p`.`first_name`,
        `p`.`last_name`,
        `p`.`username`,
        `p`.`email`,
        `w`.`name`,
        `w`.`visits`,
        `w`.`updated`,
        `wr`.`role` AS `website_role`,
        `wp`.`priviledge` AS `website_priviledge`,
        `pa`.`title`,
        `pa`.`views`,
        `pr`.`role` AS `page_role`,
        `pp`.`priviledge` AS `page_priviledge`
    FROM
        `developer` `d`
            INNER JOIN
        `person` `p` ON `d`.`id` = `p`.`id`
            INNER JOIN
        `website_role` `wr` ON `wr`.`did` = `d`.`id`
            INNER JOIN
        `website_priviledge` `wp` ON `d`.`id` = `wp`.`did`
            INNER JOIN
        `website` `w` ON `w`.`id` = `wr`.`wid`
            AND `w`.`id` = `wp`.`wid`
            LEFT JOIN
        `page` `pa` ON `pa`.`wid` = `w`.`id`
            LEFT JOIN
        `page_role` `pr` ON `d`.`id` = `pr`.`did`
            AND `pa`.`id` = `pr`.`page_id`
            LEFT JOIN
        `page_priviledge` `pp` ON `d`.`id` = `pp`.`did`
            AND `pa`.`id` = `pp`.`page_id`); 
