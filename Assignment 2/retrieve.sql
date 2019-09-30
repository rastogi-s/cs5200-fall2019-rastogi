USE heroku_79525cdf06e353b;

-- retrieve all developers
SELECT 
    *
FROM
    `developer` `d`
        JOIN
    `person` `p` ON `p`.`id` = `d`.`id`;

-- Retrieve a developer with id equal to 34 (charlie)
SELECT 
    *
FROM
    `developer` `d`
        JOIN
    `person` `p` ON `p`.`id` = `d`.`id`
WHERE
    `d`.`id` = 34;

-- Retrieve all developers who have a role in Twitter other than owner (charlie, alice)
SELECT 
    *
FROM
    `developer` `d`
        JOIN
    `person` `p` ON `p`.`id` = `d`.`id`
WHERE
    `d`.`id` IN (SELECT 
            `did`
        FROM
            `website_role` `wr`
        WHERE
            `wr`.`role` != 'owner'
                AND `wr`.`wid` = (SELECT 
                    `id`
                FROM
                    `website`
                WHERE
                    `name` = 'Twitter'));


-- Retrieve all developers who are page reviewers of pages with less than 300000 visits (charlie, bob)
SELECT 
    *
FROM
    `developer` `d`
        JOIN
    `person` `p` ON `p`.`id` = `d`.`id`
WHERE
    `d`.`id` IN (SELECT 
            `did`
        FROM
            `page_role`
        WHERE
            `role` = 'reviewer'
                AND `page_id` IN (SELECT 
                    `id`
                FROM
                    `page`
                WHERE
                    `views` < 300000));


-- Retrieve the writer developer who added a heading widget to CNET's home page (charlie)
SELECT 
    *
FROM
    `developer` `d`
        JOIN
    `person` `p` ON `p`.`id` = `d`.`id`
WHERE
    `d`.`id` IN (SELECT 
            `did`
        FROM
            `page_role`
        WHERE
            `role` IN ('owner' , 'admin', 'writer')
                AND `page_id` IN (SELECT 
                    `id`
                FROM
                    `page`
                WHERE
                    `title` = 'Home'
                        AND `wid` = (SELECT 
                            `id`
                        FROM
                            `website`
                        WHERE
                            `name` = 'CNET')));
                            
                            
                            
-- Retrieve websites

SELECT 
    *
FROM
    `website`
WHERE
    `visits` = (SELECT 
            MIN(`visits`)
        FROM
            `website`);

-- Retrieve the name of a website whose id is 678 (Gizmodo)

SELECT 
    `name`
FROM
    `website`
WHERE
    `id` = 678;

-- Retrieve all websites with videos reviewed by bob (CNN)
SELECT 
    *
FROM
    `website`
WHERE
    `id` IN (SELECT 
            `wid`
        FROM
            `page`
        WHERE
            `id` IN (SELECT 
                    `page_id`
                FROM
                    `page_role`
                WHERE
                    `role` = 'reviewer'
                        AND `did` = (SELECT 
                            `id`
                        FROM
                            `person`
                        WHERE
                            `username` = 'bob'))
                AND `id` IN (SELECT 
                    `page_id`
                FROM
                    `widget`
                WHERE
                    `dtype` = 'youtube'));

-- Retrieve all websites where alice is an owner (Facebook,CNN )
SELECT 
    *
FROM
    `website`
WHERE
    `id` IN (SELECT 
            `wid`
        FROM
            `website_role`
        WHERE
            `role` = 'owner'
                AND `did` = (SELECT 
                    `id`
                FROM
                    `person`
                WHERE
                    `username` = 'alice'));

-- Retrieve all websites where charlie is an admin and get more than 6000000 visits
SELECT 
    *
FROM
    `website`
WHERE
    `id` IN (SELECT 
            `wid`
        FROM
            `website_role`
        WHERE
            `role` = 'admin'
                AND `did` = (SELECT 
                    `id`
                FROM
                    `person`
                WHERE
                    `username` = 'charlie')
                AND `visits` > 6000000);
                
 -- Retrieve pages
-- Retrieve the page with the most number of views
SELECT 
    *
FROM
    `page`
WHERE
    `views` = (SELECT 
            MAX(`views`)
        FROM
            `page`);

-- Retrieve the title of a page whose id is 234
SELECT 
    `title`
FROM
    `page`
WHERE
    `id` = 234;

-- Retrieve all pages where alice is an editor (About)
SELECT 
    *
FROM
    `page`
WHERE
    `id` IN (SELECT 
            `page_id`
        FROM
            `page_role`
        WHERE
            `role` = 'editor'
                AND `did` = (SELECT 
                    `id`
                FROM
                    `person`
                WHERE
                    `username` = 'alice'));

-- Retrieve the total number of pageviews in CNET
SELECT 
    SUM(`views`) AS `total_page_views`
FROM
    `page`
WHERE
    `wid` = (SELECT 
            `id`
        FROM
            `website`
        WHERE
            `name` = 'CNET');
     
-- Retrieve the average number of page views in the Web site Wikipedia
SELECT 
    AVG(`views`) AS `average_page_views`
FROM
    `page`
WHERE
    `wid` = (SELECT 
            `id`
        FROM
            `website`
        WHERE
            `name` = 'Wikipedia');
            
-- Retrieve widgets
-- Retrieve all widgets in CNET's Home page

SELECT 
    *
FROM
    `widget`
WHERE
    `page_id` IN (SELECT 
            `id`
        FROM
            `page`
        WHERE
            `title` = 'Home'
                AND `wid` = (SELECT 
                    `id`
                FROM
                    `website`
                WHERE
                    `name` = 'CNET'));
                    
-- Retrieve all youtube widgets in CNN
SELECT 
    *
FROM
    `widget`
WHERE
    `dtype` = 'youtube'
        AND `page_id` IN (SELECT 
            `id`
        FROM
            `page`
        WHERE
            `wid` = (SELECT 
                    `id`
                FROM
                    `website`
                WHERE
                    `name` = 'CNN'));


-- Retrieve all image widgets on pages reviewed by Alice
SELECT 
    *
FROM
    `widget`
WHERE
    `dtype` = 'image'
        AND `page_id` IN (SELECT 
            `page_id`
        FROM
            `page_role`
        WHERE
            `role` = 'reviewer'
                AND `did` = (SELECT 
                    `id`
                FROM
                    `person`
                WHERE
                    `username` = 'alice'));

-- Retrieve how many widgets are in Wikipedia
SELECT 
    COUNT(*) AS `num_of_widgets_of_wikipedia`
FROM
    `widget`
WHERE
    `page_id` IN (SELECT 
            `id`
        FROM
            `page`
        WHERE
            `wid` IN (SELECT 
                    `id`
                FROM
                    `website`
                WHERE
                    `name` = 'Wikipedia'));

-- To verify the page and website triggers written earlier function properly:
-- Retrieve the names of all the websites where Bob has DELETE privileges. 
SELECT 
    `name`
FROM
    `website`
WHERE
    `id` IN (SELECT 
            `wid`
        FROM
            `website_priviledge`
        WHERE
            `priviledge` = 'delete'
                AND `did` = (SELECT 
                    `id`
                FROM
                    `person`
                WHERE
                    `username` = 'bob'));

-- Retrieve the names of all the pages where Charlie has CREATE privileges. 
SELECT 
    `title`
FROM
    `page`
WHERE
    `id` IN (SELECT 
            `page_id`
        FROM
            `page_priviledge`
        WHERE
            `priviledge` = 'create'
                AND `did` = (SELECT 
                    `id`
                FROM
                    `person`
                WHERE
                    `username` = 'charlie'));  