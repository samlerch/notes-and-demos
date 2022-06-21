
-- Let's create a food table
CREATE TABLE food(
	food_id int unique,
	food_name varchar(20) NOT null,
	calories int
);

-- Let's create a snack time table
CREATE TABLE snack_time(
	snack_id int,
	snack_time timestamp,
	food_id int,
	FOREIGN KEY (food_id) REFERENCES food(food_id)
);

INSERT INTO food VALUES (1, 'pizza', 250);
INSERT INTO food VALUES(2,'pasta',650);
INSERT INTO food VALUES(3,'ice cream',300);
INSERT INTO food VALUES(4,'salad',100);

SELECT * FROM Food;

INSERT INTO snack_time VALUES (1, localtimestamp, 1);
INSERT INTO snack_time VALUES(2,localtimestamp, 4);
INSERT INTO snack_time VALUES(3,localtimestamp, 2);
INSERT INTO snack_time VALUES(4,localtimestamp, 4);

SELECT * FROM snack_time;

-- This represents a 1:M relationship because one food can be consumed at multiple snacktimes but each 
-- snacktime only has one snack

-- Let's look at a one to one relationship

CREATE TABLE Student(
	student_id int PRIMARY key,
	first_name varchar(15),
	last_name varchar(15)
);

-- create a table that references the first in a one to one relationship

CREATE TABLE contact_info(
	student_id int,
	phone varchar(15),
	address varchar(20),
	FOREIGN KEY (student_id) REFERENCES student(student_id)
);

-- To make this a one to one relationship we have to add on an additional CONSTRAINT 
ALTER TABLE contact_info ADD CONSTRAINT one2one UNIQUE (student_id);

INSERT INTO student VALUES (123456, 'Bob', 'Smith');
INSERT INTO student VALUES (234567, 'Billy', 'Bob');
INSERT INTO student VALUES (1, 'Jane', 'Doe');

SELECT * FROM student;

INSERT INTO contact_info VALUES (123456, '(123)-456-7890', ' 123 Main St.');
INSERT INTO contact_info VALUES(234567,'(122)-444-5555','1908 Main St.');

SELECT * FROM contact_info;

-- Let's try to add another contact info for 1233456
-- INSERT INTO contact_info VALUES(123456,'(111)-867-5309','123 Main St.');

-- Let's look at a many to many relationship
-- Many to many relationships require the use of a junction object with foreign key that point
-- to the relating table. These foreign keys will not have a unique constraint on them

-- Many to many examples could be snacks to students

-- Let's make snack id UNIQUE 
ALTER TABLE snack_time ADD CONSTRAINT makingUnique unique(snack_id);

CREATE TABLE student_snack_junction(
	student_id int,
	snack_id int,
	FOREIGN KEY (student_id) REFERENCES student(student_id),
	FOREIGN KEY (snack_id) REFERENCES snack_time(snack_id)
);

INSERT INTO student_snack_junction VALUES (123456, 1), (1, 1), (234567, 2), (123456, 3);

SELECT * FROM student_snack_junction;