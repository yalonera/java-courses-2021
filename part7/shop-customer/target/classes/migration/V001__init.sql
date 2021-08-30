DROP TABLE IF EXISTS address_info;

CREATE TABLE address_info (
  id            INT AUTO_INCREMENT  PRIMARY KEY,
  country       VARCHAR(250) NOT NULL,
  city          VARCHAR(250) NOT NULL,
  street        VARCHAR(250) NOT NULL,
  house_number  INT
);

DROP TABLE IF EXISTS customer;

CREATE TABLE customer (
  id              INT AUTO_INCREMENT  PRIMARY KEY,
  name            VARCHAR(250) NOT NULL,
  email           VARCHAR(250) NOT NULL,
  address_info_id INT,
  foreign key (address_info_id) references address_info(id)
);

INSERT INTO address_info (country, city, street, house_number) VALUES
  ('Russian Federation', 'Moscow', 'Test st.', 39),
  ('USA','New York','Marble st.',143),
  ('Great Britain','London','Marble st.',63),
  ('Great Britain','London','Basic st.',102),
  ('USA','New York','Lomonosova st.',62);


INSERT INTO customer (name, email, address_info_id) VALUES
  ('John Smith', 'john.smith@rambler.uk', 1),
  ('Rose Tyler', 'r0se-tyler@gmail.com', 2),
  ('Donna Noble', 'DonnaDonna@gmail.com', 3),
  ('Martha Jones', 'martha@mail.ru', 4),
  ('Rory Williams', 'super-rory@tut.by', 5);
