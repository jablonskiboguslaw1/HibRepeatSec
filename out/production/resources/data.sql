SET FOREIGN_KEY_CHECKS=0;
Truncate table `product`;
SET FOREIGN_KEY_CHECKS=1;

INSERT INTO `product`
(`id`,`name`,`description`,`created`,`updated`,`price`,`type`)
VALUES
('1', 'Bike 01', 'This is description of the product', '2020-07-22 13:29:39', '2020-07-22 13:29:39', '19.99', 'REAL'),
('2', 'Bike 02', 'This is description of the product', '2020-07-22 13:29:39', '2020-07-22 13:29:39', '19.99', 'REAL'),
('3', 'Bike 03', 'This is description of the product', '2020-07-22 13:30:06', '2020-07-22 13:30:06', '19.99', 'REAL'),
('4', 'Bike 04', 'This is description of the product', '2020-07-22 13:31:45', '2020-07-22 13:31:45', '19.99', 'REAL'),
('5', 'Bike 05', 'This is description of the product', '2020-07-22 13:31:54', '2020-07-22 13:31:54', '19.99', 'REAL');

INSERT INTO `review`(`id`,`product_id`,`content`,`rating`)VALUES(1,1,'The Content of the opinion 1',5);
INSERT INTO `review`(`id`,`product_id`,`content`,`rating`)VALUES(2,1,'The Content of the opinion 2',5);
INSERT INTO `review`(`id`,`product_id`,`content`,`rating`)VALUES(3,1,'The Content of the opinion 3',5);
INSERT INTO `review`(`id`,`product_id`,`content`,`rating`)VALUES(4,1,'The Content of the opinion 4',5);
INSERT INTO `review`(`id`,`product_id`,`content`,`rating`)VALUES(5,1,'The Content of the opinion 5',5);
INSERT INTO `review`(`id`,`product_id`,`content`,`rating`)VALUES(6,2,'The Content of the opinion 1',5);
INSERT INTO `review`(`id`,`product_id`,`content`,`rating`)VALUES(7,2,'The Content of the opinion 2',5);
INSERT INTO `review`(`id`,`product_id`,`content`,`rating`)VALUES(8,2,'The Content of the opinion 3',5);
INSERT INTO `review`(`id`,`product_id`,`content`,`rating`)VALUES(9,2,'The Content of the opinion 4',5);
INSERT INTO `review`(`id`,`product_id`,`content`,`rating`)VALUES(10,2,'The content of the opinion 5',5);
INSERT INTO `review`(`id`,`product_id`,`content`,`rating`)VALUES(11,3,'The content of the opinion 1',5);
INSERT INTO `review`(`id`,`product_id`,`content`,`rating`)VALUES(12,3,'The content of the opinion 2',5);
INSERT INTO `review`(`id`,`product_id`,`content`,`rating`)VALUES(13,3,'The content of the opinion 3',5);
INSERT INTO `review`(`id`,`product_id`,`content`,`rating`)VALUES(14,3,'The content of the opinion 4',5);
INSERT INTO `review`(`id`,`product_id`,`content`,`rating`)VALUES(15,3,'The content of the opinion 5',5);
INSERT INTO `review`(`id`,`product_id`,`content`,`rating`)VALUES(16,4,'The content of the opinion 1',5);
INSERT INTO `review`(`id`,`product_id`,`content`,`rating`)VALUES(17,4,'The content of the opinion 2',5);
INSERT INTO `review`(`id`,`product_id`,`content`,`rating`)VALUES(18,4,'The content of the opinion 3',5);
INSERT INTO `review`(`id`,`product_id`,`content`,`rating`)VALUES(19,4,'The content of the opinion 4',5);
INSERT INTO `review`(`id`,`product_id`,`content`,`rating`)VALUES(20,4,'The content of the opinion 5',5);
INSERT INTO `review`(`id`,`product_id`,`content`,`rating`)VALUES(21,5,'The content of the opinion 1',5);
INSERT INTO `review`(`id`,`product_id`,`content`,`rating`)VALUES(22,5,'The content of the opinion 2',5);
INSERT INTO `review`(`id`,`product_id`,`content`,`rating`)VALUES(23,5,'The content of the opinion 3',5);
INSERT INTO `review`(`id`,`product_id`,`content`,`rating`)VALUES(24,5,'The content of the opinion 4',5);
INSERT INTO `review`(`id`,`product_id`,`content`,`rating`)VALUES(25,5,'The content of the opinion
INSERT INTO `category`
(`id`,`name`,`description`)
VALUES
(1,'Category 1','Description 1'),
(2,'Category 2','Description 2'),
(3,'Category 3','Description 3');


Update product set category_id=1 where id=3;
Update product set category_id=2 where id=4;
Update product set category_id=3 where id=5;

INSERT INTO `attribute`
(`id`,`name`,`value`)
VALUES
(1,'COLOR','RED'),
(2,'COLOR','GREEN'),
(3,'COLOR','BLUE');
INSERT INTO `product_attribute`
(`product_id`, `attribute_id`)
VALUES
(3,1),
(3,2),
(3,3),
(4,1),
(4,2),
(5,3);
