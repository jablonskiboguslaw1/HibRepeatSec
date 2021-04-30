SET FOREIGN_KEY_CHECKS=0;
Truncate table `product_attribute`;
Truncate table `attribute`;
Truncate table `review`;
Truncate table `product`;
Truncate table `category`;
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
INSERT INTO `review`(`id`,`product_id`,`content`,`rating`)VALUES(6,2,'The Content of the opinion 6',5);
INSERT INTO `review`(`id`,`product_id`,`content`,`rating`)VALUES(7,2,'The Content of the opinion 7',5);
INSERT INTO `review`(`id`,`product_id`,`content`,`rating`)VALUES(8,2,'The Content of the opinion 8',5);
INSERT INTO `review`(`id`,`product_id`,`content`,`rating`)VALUES(9,2,'The Content of the opinion 9',5);
INSERT INTO `review`(`id`,`product_id`,`content`,`rating`)VALUES(10,2,'The content of the opinion 10',5);
INSERT INTO `review`(`id`,`product_id`,`content`,`rating`)VALUES(11,3,'The content of the opinion 11',5);
INSERT INTO `review`(`id`,`product_id`,`content`,`rating`)VALUES(12,3,'The content of the opinion 12',5);
INSERT INTO `review`(`id`,`product_id`,`content`,`rating`)VALUES(13,3,'The content of the opinion 13',5);
INSERT INTO `review`(`id`,`product_id`,`content`,`rating`)VALUES(14,3,'The content of the opinion 14',5);
INSERT INTO `review`(`id`,`product_id`,`content`,`rating`)VALUES(15,3,'The content of the opinion 15',5);
INSERT INTO `review`(`id`,`product_id`,`content`,`rating`)VALUES(16,4,'The content of the opinion 16',5);
INSERT INTO `review`(`id`,`product_id`,`content`,`rating`)VALUES(17,4,'The content of the opinion 17',5);
INSERT INTO `review`(`id`,`product_id`,`content`,`rating`)VALUES(18,4,'The content of the opinion 18',5);
INSERT INTO `review`(`id`,`product_id`,`content`,`rating`)VALUES(19,4,'The content of the opinion 19',5);
INSERT INTO `review`(`id`,`product_id`,`content`,`rating`)VALUES(20,4,'The content of the opinion 20',5);
INSERT INTO `review`(`id`,`product_id`,`content`,`rating`)VALUES(21,5,'The content of the opinion 21',5);
INSERT INTO `review`(`id`,`product_id`,`content`,`rating`)VALUES(22,5,'The content of the opinion 22',5);
INSERT INTO `review`(`id`,`product_id`,`content`,`rating`)VALUES(23,5,'The content of the opinion 23',5);
INSERT INTO `review`(`id`,`product_id`,`content`,`rating`)VALUES(24,5,'The content of the opinion 24',5);
INSERT INTO `review`(`id`,`product_id`,`content`,`rating`)VALUES(25,5,'The content of the opinion 25',5);

INSERT INTO `category`
(`id`,`name`,`description`)
VALUES
(1,'Category 1','Description 1'),
(2,'Category 2','Description 2'),
(3,'Category 3','Description 3');

UPDATE `product` SET `category_id` = '2' WHERE (`id` = '2');
UPDATE `product` SET `category_id` = '3' WHERE (`id` = '3');
UPDATE `product` SET `category_id` = '2' WHERE (`id` = '5');

INSERT INTO `customer`(`id`,`firstname`,`lastname`,`created`,`updated`)
VALUES
(1, 'Jan', 'Kowalski', '2020-09-01T12:00:00', '2020-10-10T12:00:00'),
(2, 'Jan', 'Nowak', '2020-09-01T12:00:00', '2020-10-10T12:00:00'),
(3, 'Jan', 'Szewczyk', '2020-09-01T12:00:00', '2020-10-10T12:00:00'),
(4, 'Jan', 'Wójcik ', '2020-09-01T12:00:00', '2020-10-10T12:00:00'),
(5, 'Jan', 'Kowalczyk', '2020-09-01T12:00:00', '2020-10-10T12:00:00');

INSERT INTO `order`(`id`,`customer_id`,`created`,`total`)
VALUES
(1, 1, '2020-10-10T12:00:00', 59.97), -- 3
(2, 1, '2020-10-10T12:00:00', 39.98), -- 2
(3, 1, '2020-10-10T12:00:00', 19.99), -- 1
(4, 1, '2020-10-10T12:00:00', 19.99), -- 1
(5, 1, '2020-10-10T12:00:00', 79.96), -- 4
(6, 1, '2020-10-10T12:00:00', 19.99), -- 1
(7, 2, '2020-10-10T12:00:00', 39.98), -- 2
(8, 2, '2020-10-10T12:00:00', 19.99), -- 1
(9, 2, '2020-10-10T12:00:00', 19.99), -- 1
(10, 2, '2020-10-10T12:00:00', 39.98), -- 2
(11, 3, '2020-10-10T12:00:00', 19.99), -- 1
(12, 3, '2020-10-10T12:00:00', 19.99), -- 1
(13, 3, '2020-10-10T12:00:00', 39.98), -- 2
(14, 4, '2020-10-10T12:00:00', 39.98); -- 2


INSERT INTO `order_row`(`id`,`order_id`,`product_id`,`price`)
VALUES
(1, 1, 1, 19.99),
(2, 1, 2, 19.99),
(3, 1, 3, 19.99),
(4, 2, 1, 19.99),
(5, 2, 2, 19.99),
(6, 3, 1, 19.99),
(7, 4, 1, 19.99),
(8, 5, 2, 19.99),
(9, 5, 3, 19.99),
(10, 5, 4, 19.99),
(11, 5, 5, 19.99),
(12, 6, 4, 19.99),
(13, 7, 5, 19.99),
(14, 7, 1, 19.99),
(15, 8, 1, 19.99),
(16, 9, 2, 19.99),
(17, 10, 3, 19.99),
(18, 10, 4, 19.99),
(19, 11, 5, 19.99),
(20, 12, 3, 19.99),
(21, 13, 3, 19.99),
(22, 13, 3, 19.99),
(23, 14, 3, 19.99),
(24, 14, 3, 19.99);


INSERT INTO `attribute`
(`id`,`name`,`value`)
VALUES
(1,'COLOR','RED'),
(2,'COLOR','GREEN'),
(3,'COLOR','BLUE'),
(4,'COLOR','YELLOW'),
(5,'COLOR','ORANGE');

INSERT INTO `product_attribute`
(`product_id`, `attribute_id`)
VALUES
(1,1),
(2,1),
(3,1),
(4,1),
(5,1),
(1,2),
(2,2),
(3,2),
(4,2),
(5,2),
(1,3),
(2,3),
(3,3),
(4,3),
(5,3),
(1,4),
(2,4),
(3,4),
(4,4),
(5,4),
(1,5),
(2,5),
(3,5),
(4,5),
(5,5);