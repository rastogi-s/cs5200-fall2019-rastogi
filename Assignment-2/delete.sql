USE `cs5200_fall2019_rastogi`;
SET SQL_SAFE_UPDATES = 0;
-- Delete Alice's primary address
DELETE FROM `address` 
WHERE
    `primary` = TRUE
    AND `pid` = (SELECT 
        `id`
    FROM
        `person`
    
    WHERE
        `first_name` = 'Alice');

-- Remove the last widget in the Contact page. The last widget is the one with the highest value in the order field
SELECT 
    MAX(`order`), `id`
FROM
    `widget`
WHERE
    `page_id` = (SELECT 
            `id`
        FROM
            `page`
        WHERE
            `title` LIKE '%Contact') INTO @max_order , @max_order_widget_id;
DELETE FROM `widget` 
WHERE
    `id` = @max_order_widget_id;

-- Delete page - Remove the last updated page in Wikipedia

SELECT 
    `id`, MAX(`updated`)
FROM
    `page`
WHERE
    `wid` = (SELECT 
            `id`
        FROM
            `website`
        WHERE
            `name` = 'Wikipedia') INTO @delete_last_updated_wiki_page_id , @last_updated_date;
            
DELETE FROM `widget` 
WHERE
    `page_id` = @delete_last_updated_wiki_page_id;
DELETE FROM `page_priviledge` 
WHERE
    `page_id` = @delete_last_updated_wiki_page_id;
DELETE FROM `page_role` 
WHERE
    `page_id` = @delete_last_updated_wiki_page_id;
DELETE FROM `page` 
WHERE
    `id` = @delete_last_updated_wiki_page_id;



-- Delete website - Remove the CNET web site, as well as all related roles and privileges relating 
-- developers to the Website and Pages
SELECT 
    `id`
FROM
    `website`
WHERE
    `name` = 'CNET' INTO @cnet_website_id;
DELETE FROM `widget` 
WHERE
    `page_id` IN (SELECT 
        `id`
    FROM
        `page`
    
    WHERE
        `wid` = @cnet_website_id);
DELETE FROM `page_priviledge` 
WHERE
    `page_id` IN (SELECT 
        `id`
    FROM
        `page`
    
    WHERE
        `wid` = @cnet_website_id);
DELETE FROM `page_role` 
WHERE
    `page_id` IN (SELECT 
        `id`
    FROM
        `page`
    
    WHERE
        `wid` = @cnet_website_id);
DELETE FROM `page` 
WHERE
    `wid` = @cnet_website_id;

DELETE FROM `website_priviledge` 
WHERE
    `wid` = @cnet_website_id;
DELETE FROM `website_role` 
WHERE
    `wid` = @cnet_website_id;
DELETE FROM `website` 
WHERE
    `id` = @cnet_website_id;

