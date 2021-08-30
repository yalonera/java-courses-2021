DROP TABLE IF EXISTS payment_info;

CREATE TABLE payment_info (
  id            INT AUTO_INCREMENT  PRIMARY KEY,
  card_type     VARCHAR(250) NOT NULL,
  card_number   VARCHAR(250) NOT NULL,
  security_code VARCHAR(250) NOT NULL
);

DROP TABLE IF EXISTS payment_order;

CREATE TABLE payment_order (
  id              INT AUTO_INCREMENT  PRIMARY KEY,
  customer_id     INT NOT NULL,
  payment_info_id INT NOT NULL,
  foreign key (payment_info_id) references payment_info(id)
);

DROP TABLE IF EXISTS payment_order_item;

CREATE TABLE payment_order_item (
  id            INT AUTO_INCREMENT  PRIMARY KEY,
  product_id    INT NOT NULL,
  quantity      INT NOT NULL,
  order_id      INT NOT NULL,
  foreign key (order_id) references payment_order(id)
);

INSERT INTO payment_info (card_number, card_type, security_code) VALUES
  ('4111 3456 5454 9900', 'VISA', '456'),
  ('9785 5409 1111 5555', 'MASTERCARD', '409'),
  ('6677 5432 9587 1670', 'VISA', '432');


INSERT INTO payment_order (customer_id, payment_info_id) VALUES
  (1, 1),
  (2, 2),
  (3, 3),
  (4, 1),
  (5, 2),
  (1, 3),
  (2, 1),
  (3, 3),
  (4, 1),
  (5, 3),
  (1, 1),
  (2, 2),
  (3, 3),
  (4, 2),
  (5, 3);

INSERT INTO payment_order_item (product_id, quantity, order_id) VALUES
  (1, 1, 1),
  (1, 2, 2),
  (1, 3, 3),
  (2, 3, 1),
  (2, 2, 2),
  (2, 1, 3),
  (3, 1, 1),
  (3, 2, 2),
  (3, 3, 3),
  (3, 3, 4),
  (3, 2, 5),
  (3, 1, 6),
  (4, 1, 7),
  (5, 2, 8),
  (6, 3, 9),
  (7, 3, 10),
  (8, 2, 11),
  (9, 1, 12),
  (10, 1, 13),
  (10, 2, 14),
  (9, 3, 15),
  (7, 3, 15),
  (6, 2, 14),
  (5, 1, 13);
