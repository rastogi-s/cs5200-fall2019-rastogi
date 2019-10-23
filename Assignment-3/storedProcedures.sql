USE `cs5200_fall2019_rastogi-assign3`;
drop PROCEDURE if exists `getUnansweredQuestions`;
drop PROCEDURE if exists `endorsedUsersForWeek`;

DELIMITER //  
CREATE PROCEDURE `getUnansweredQuestions`()
BEGIN
	SELECT 
    `question_text`, MAX(answer_count)
	FROM
		(SELECT 
			`q`.`text` AS 'question_text',
				COUNT(`a`.`id`) AS 'answer_count',
				`q`.`module_id` AS 'module'
		FROM
			`question` `q`
		JOIN `answer` `a` ON `q`.`id` = `a`.`question_id`
			AND `q`.`id` NOT IN (SELECT DISTINCT
				`question_id`
			FROM
				`answer`
			WHERE
				`correct_answer` = TRUE)
		GROUP BY `q`.`id`
		ORDER BY COUNT(`a`.`id`) DESC) AS `T`
	GROUP BY `module`;
END//

call `getUnansweredQuestions`;

DELIMITER // 
CREATE PROCEDURE `endorsedUsersForWeek`(IN `start` Date,IN `end` Date)
BEGIN
	SELECT 
		`id` AS 'user_id',
		CONCAT(`first_name`, ' ', `last_name`) AS 'full name'
	FROM
		`person`
	WHERE
		`id` IN (SELECT 
				*
				FROM
				(SELECT 
					`posted_by`
				FROM
					`question` `q`
				JOIN `answer` `a` ON `q`.`id` = `a`.`question_id`
				WHERE
					`a`.`correct_answer` = TRUE
						AND `q`.`posted_on` BETWEEN START AND END
				GROUP BY `posted_by`
				ORDER BY COUNT(`posted_by`) DESC
				LIMIT 5) AS R)
	ORDER BY `first_name`;
END//

call `endorsedUsersForWeek`('2019-08-11', '2019-08-17');