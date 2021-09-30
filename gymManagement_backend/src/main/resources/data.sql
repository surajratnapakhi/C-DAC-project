DROP TABLE IF EXISTS client;
DROP TABLE IF EXISTS admin;

CREATE TABLE client (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  first_name VARCHAR(250) NOT NULL,
  last_name VARCHAR(250) NOT NULL,
  password VARCHAR(25) NOT NULL,
  age NUMBER DEFAULT NULL
);

INSERT INTO client (first_name, last_name, password, age) VALUES
('client', 'client','Pass@aj10101', 28),
  ('Akshay', 'Jadhav','Pass@aj10101', 26),
  ('Sachin', 'Khandre','Pass@aj10101', 27),
  ('Suraj', 'Ratnaparkhi','Pass@aj10101', 28),
  ('Akash', 'Patil','Pass@aj10101', 28),
   ('Aashish', 'Gangurde','Pass@aj10101', 28),
  ('Pravin', 'Patil', 'Pass@aj10101',29);
  
 
CREATE TABLE admin (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  first_name VARCHAR(250) NOT NULL,
  last_name VARCHAR(250) NOT NULL,
  password VARCHAR(25) NOT NULL,
  age NUMBER DEFAULT NULL
);

  INSERT INTO admin (first_name, last_name, password, age) VALUES
  ('admin', 'admin','Pass@aj10101', 29),
  ('Akshay', 'Jadhav','Pass@aj10101', 26),
  ('Sachin', 'Khandre', 'Pass@aj10101', 27),
  ('Suraj', 'Ratnaparkhi','Pass@aj10101', 28);