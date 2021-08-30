DROP TABLE IF EXISTS product;

CREATE TABLE product (
  id            INT AUTO_INCREMENT  PRIMARY KEY,
  name          VARCHAR(250)  NOT NULL,
  color         VARCHAR(250)  NOT NULL,
  price         DECIMAL(15,2) NOT NULL
);

INSERT INTO product (name, color, price) VALUES
('Apple iPhone 8', 'WHITE', 15.10),
('Motorola RAZR V3', 'BLACK', 17.11),
('Nokia 1600', 'RED', 18.12),
('Nokia 3310', 'WHITE', 19.20),
('Nokia 1208', 'BLACK', 21.01),
('Samsung Galaxy S4', 'RED', 22.02),
('Nokia 6010', 'WHITE', 23.03),
('Apple iPhone 5', 'BLACK', 24.05),
('Nokia 5130', 'RED', 15.10),
('Apple iPhone 4S', 'WHITE', 15.09),
('Motorola StarTAC996', 'BLACK', 15.08),
('Motorola C200', 'RED', 15.07),
('Samsung Galaxy S III', 'WHITE', 15.06),
('Apple iPhone 5S', 'BLACK', 15.05),
('Nokia 3100', 'RED', 15.04),
('Nokia 6230', 'WHITE', 15.03),
('Apple iPhone 4', 'BLACK', 15.02),
('amsung Galaxy S II', 'RED', 15.01),
('Samsung Galaxy Note II', 'WHITE', 15.00),
('Apple iPhone 3GS 5', 'BLACK', 14.10),
('Nokia 6270 Slider', 'RED', 13.10),
('Nokia 5200 Slider', 'WHITE', 12.11),
('amsung E250', 'BLACK', 10.10),
('Samsung Star', 'RED', 14.11),
('Apple iPhone 5C', 'WHITE', 15.19),
('HTC Thunderbolt', 'BLACK', 13.10),
('Nokia 6120', 'RED', 12.11),
('Siemens M30', 'RED', 10.15);