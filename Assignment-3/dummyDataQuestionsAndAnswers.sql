USE `cs5200_fall2019_rastogi-assign3`;
SET FOREIGN_KEY_CHECKS = 0; 
TRUNCATE TABLE `answer`;
TRUNCATE TABLE `question`;
SET FOREIGN_KEY_CHECKS = 1;

DELETE FROM `user` 
WHERE
    `id` IN (112 , 145, 134, 123, 156);
DELETE FROM `person` 
WHERE
    `id` IN (112 , 145, 134, 123, 156);

START TRANSACTION;
INSERT INTO `person` (`id`,`username`,`password`,`first_name`,`last_name`,`email`) VALUES
(112,'222alice','alice','Alice','Wonder','alice@wonder.com'),
(123,'222bob','bob','Bob','Marley','bob@marley.com'),
(134,'222charlie','charlie','Charles','Garcia','chuch@garcia.com'),
(145,'111dan','dan','Dan','Martin','dan@martin.com'),
(156,'2222ed','ed','Ed','Karaz','ed@kar.com');


INSERT INTO `user` (`id`) VALUES (112), (145), (134),(123),(156);

INSERT INTO `question` (`id`,`text`,`asked_by`,`posted_on`,`length`,`endorsed_by_instructor`, `module_id`) 
			VALUES (13,'question13',45,'2019-09-12',3,TRUE,2) ,
             (14,'question14',45,'2019-10-12',3,FALSE,1) ,
             (15,'question15',56,'2019-08-12',2,TRUE,4),
             (16,'question16',45,'2018-11-12',5,FALSE,2),
			(17,'question17',45,'2019-08-15',5,FALSE,6),
            (18,'question18',56,'2019-08-13',5,TRUE,6),
            (19,'question19',56,'2019-08-13',5,TRUE,2),
            (20,'question20',123,'2019-08-13',5,TRUE,3);

INSERT INTO `answer` (`text`,`posted_by`,`posted_on`,`correct_answer`, `up_votes`,`down_votes`,`question_id`) 
			VALUES ('answer1',45,'2019-09-12',FALSE,2,4,13) ,
            ('answer2',56,'2019-10-12',FALSE,1,4,13) ,
            ('answer3',45,'2019-08-23',FALSE,6,2,13) ,
            ('answer4',56,'2019-09-26',FALSE,5,3,13) ,
            
            ('answer1',45,'2019-09-21',TRUE,2,4,14) ,
            ('answer2',56,'2019-10-11',FALSE,1,4,14) ,
            ('answer3',56,'2019-08-23',TRUE,6,2,14) ,
            
           ('answer1',45,'2019-09-03',TRUE,2,4,15) ,
            ('answer2',56,'2019-10-01',FALSE,1,4,15) ,
            ('answer3',45,'2019-08-04',FALSE,6,2,15) ,
            ('answer4',56,'2019-09-06',FALSE,5,3,15),
             ('answer1',145,'2019-09-03',TRUE,2,4,15) ,
              ('answer1',123,'2019-09-03',TRUE,2,4,15) ,
            
              ('answer1',45,'2019-09-03',TRUE,2,4,16) ,
            ('answer2',56,'2019-10-01',TRUE,1,4,16) ,
            ('answer3',45,'2019-08-04',TRUE,6,2,16) ,
            ('answer4',56,'2019-09-06',TRUE,5,3,16),
            
              ('answer1',45,'2019-09-03',TRUE,2,4,17) ,
            ('answer2',112,'2019-10-01',TRUE,1,4,17) ,
            ('answer3',123,'2019-08-04',TRUE,6,2,17) ,
            ('answer4',56,'2019-09-06',TRUE,5,3,17),
              ('answer4',145,'2019-09-06',TRUE,5,3,17),
               ('answer4',156,'2019-09-06',TRUE,5,3,17),
              
              
               ('answer1',112,'2019-09-03',TRUE,2,4,18) ,
            ('answer2',112,'2019-10-01',TRUE,1,4,18) ,
            ('answer3',45,'2019-08-04',TRUE,6,2,18) ,
            ('answer4',134,'2019-09-06',TRUE,5,3,18),
            ('answer4',156,'2019-09-06',TRUE,5,3,18),
            
            ('answer19-1',156,'2019-09-06',FALSE,5,3,19),
            ('answer19-2',45,'2019-09-06',FALSE,5,3,19),
            ('answer19-3',56,'2019-09-06',FALSE,5,3,19),
            ('answer19-4',134,'2019-09-06',FALSE,5,3,19),
            ('answer19-5',123,'2019-09-06',FALSE,5,3,19),
            ('answer19-6',156,'2019-09-06',FALSE,5,3,19),
            
            ('answer20-1',123,'2019-09-06',FALSE,5,3,20);