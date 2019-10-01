USE `cs5200_fall2019_rastogi`;
-- Update developer - Update Charlie's primary phone number to 333-444-5555

UPDATE `phone` 
SET 
    `phone` = '333-444-5555'
WHERE
    `primary` = TRUE
        AND `pid` = (SELECT 
            `id`
        FROM
            `person`
        WHERE
            `username` = 'charlie');

-- Update widget - Update the relative order of widget head345 on the page so that it's new order is 3. Note that the other widget's order needs to update as well

SELECT 
    `order`, `page_id`
FROM
    `widget`
WHERE
    `name` = 'head345' INTO @old , @page;

UPDATE `widget` 
SET 
    `order` = CASE
        WHEN
            NOT `name` = 'head345' AND @old < 3
                AND `order` > @old
                AND `order` <= 3
        THEN
            `order` - 1
        WHEN `name` = 'head345' THEN 3
        WHEN
            NOT `name` = 'head345' AND @old > 3
                AND `order` <= @old
        THEN
            `order` + 1
        ELSE `order`
    END
WHERE
    `page_id` = @page;
    
--  Update page - Append 'CNET - ' to the beginning of all CNET's page titles

SELECT 
    `id`
FROM
    `website`
WHERE
    `name` = 'CNET' INTO @id;
UPDATE `page` 
SET 
    `title` = CONCAT('CNET', `title`)
WHERE
    `wid` = @id;
    

-- Update roles - Swap Charlie's and Bob's role in CNET's Home page
SELECT 
    `id`
FROM
    `page`
WHERE
    `wid` = (SELECT 
            `id`
        FROM
            `website`
        WHERE
            `name` = 'CNET')
        AND `title` LIKE '%Home' INTO @cnet_home_page_id;
    
SELECT 
    `id`
FROM
    `person`
WHERE
    `username` = 'charlie' INTO @charlie_id;
SELECT 
    `id`
FROM
    `person`
WHERE
    `username` = 'bob' INTO @bob_id;
    
SELECT 
    `role`
FROM
    `page_role`
WHERE
    `page_id` = @cnet_home_page_id
        AND `did` = @charlie_id INTO @charlie_role;

SELECT 
    `role`
FROM
    `page_role`
WHERE
    `page_id` = @cnet_home_page_id
        AND `did` = @bob_id INTO @bob_role;
UPDATE `page_role` 
SET 
    `role` = CASE
        WHEN `did` = @charlie_id THEN @bob_role
        WHEN `did` = @bob_id THEN @charlie_role
        ELSE `role`
    END
WHERE
    `page_id` = @cnet_home_page_id;