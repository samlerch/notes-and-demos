-- This is a comment

-- Use DDL (Data Definition Language) to define a product table
-- Create Table, Alter, Drop, Truncate

CREATE TABLE product(
	id int PRIMARY KEY,
	name varchar(50) NOT NULL,
	price NUMERIC(5,2) CHECK (price > 0)
);

-- Let's use DML (Data Manipulation Language) to insert data into the product table
-- Create Data With Insert
INSERT INTO product VALUES (21, 'Toaster', 25.00);
INSERT INTO product VALUES (22, 'Toaster Oven', 48);
INSERT INTO product VALUES (32, 'Bike', 128.99);

INSERT INTO product VALUES (44, 'Nintendo Switch', 299.99);
INSERT INTO product VALUES (47, 'Nerf Gun', 24.99);

-- Let's Truncate the table to test some things we can get when entering data
TRUNCATE product;

-- Let's use DQL (Data Query Language)/DML to select entries from the table
SELECT name 
FROM product;

SELECT "id" 
FROM product;

SELECT * 
FROM product;

-- We can use the where clause to filter this data 

SELECT *
FROM product 
WHERE price > 100;

SELECT *
FROM product
WHERE name = 'Toaster Oven';

-- We can use like to check for strings with patterns we want
SELECT *
FROM product
WHERE name LIKE '%oven%';

-- We can use more DML to update or delete records
UPDATE product 
SET name = 'Microwave'
WHERE name = 'Toaster Oven';

DELETE FROM product 
WHERE id = 22;

-- Let's use DDL to define another table
CREATE TABLE department(
	id serial PRIMARY KEY,
	name varchar(50) NOT null
);

INSERT INTO department (name) VALUES ('Kitchen Appliances');
INSERT INTO department (name) VALUES ('Sporting Goods');
INSERT INTO department (name) VALUES ('Toys');

DELETE FROM department WHERE id = 3;

INSERT INTO department (name) VALUES ('Toys');

-- Let's use DDL to alter the first table and add a foreign key
ALTER TABLE product ADD COLUMN department int references department(id);

UPDATE product 
SET department = 2
WHERE id = 32;

UPDATE product 
SET department = 4
WHERE id = 44 OR id = 47;

UPDATE product 
SET department = 1
WHERE id = 21 AND price = 25.00;

-- Use DDL to attempt to delete a table
DROP TABLE department CASCADE;











