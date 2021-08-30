DROP TABLE IF EXISTS payment_info;

CREATE TABLE payment_info (
                              id            INT AUTO_INCREMENT  PRIMARY KEY,
                              card_type     VARCHAR(250) NOT NULL,
                              card_number   VARCHAR(250) NOT NULL,
                              security_code VARCHAR(250) NOT NULL
);

INSERT INTO payment_info (card_number, card_type, security_code) VALUES
('4111 3456 5454 9900', 'VISA', '456'),
('9785 5409 1111 5555', 'MASTERCARD', '409'),
('6677 5432 9587 1670', 'VISA', '432');
