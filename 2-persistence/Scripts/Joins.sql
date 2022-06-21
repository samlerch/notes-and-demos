CREATE TABLE authors(
	id int,
	first_name varchar(10),
	last_name varchar(15)
);

CREATE TABLE editors(
	id int,
	first_name varchar(10),
	last_name varchar(15)
);

CREATE TABLE translators(
	id int,
	first_name varchar(10),
	last_name varchar(15)
);

CREATE TABLE books(
	id int,
	title varchar(50),
	"type" varchar(50),
	author_id int,
	editor_id int,
	translator_id int
);


INSERT INTO authors VALUES (11, 'Ellen', 'Writer'),
							(12, 'Olga', 'Savelia'),
							(13, 'Jack', 'Smart'),
							(14, 'Donald', 'Brain'),
							(15, 'Yao', 'Dao')
							
INSERT INTO editors VALUES (21, 'Daniel', 'Brown'),
							(22, 'Mark', 'Johnson'),
							(23, 'Maria', 'Evans'),
							(24, 'Cathrine', 'Roberts'),
							(25, 'Sebestian', 'Wright'),
							(26, 'Barbara', 'Jones'),
							(27, 'Matthew', 'Smith')
							
INSERT INTO translators VALUES (31, 'Ira', 'Davies'),
								(32, 'Ling', 'Weng'),
								(33, 'Kristian', 'Green'),
								(34, 'Roman', 'Edwards')
								
INSERT INTO books VALUES (1, 'Time to Grow Up!', 'original', 11, 21, null),
						 (2, 'Your Trip', 'translated', 15, 22, 32),
						 (3, 'Lovely Love', 'original', 14, 24, null),
						 (4, 'Dream Your Life', 'original', 11, 24, null),
						 (5, 'Oranges', 'translated', 12, 25, 31),
						 (6, 'Your Happy Life', 'translated', 15, 22, 33),
						 (7, 'Applied AI', 'translated', 13, 23, 34),
						 (8, 'My Last Book', 'original', 11, 28, null);
						 
-- Let's do some joins
-- Inner Joins
SELECT b.id, b.title, a.first_name, a.last_name  
FROM books b 
INNER JOIN authors a 
ON b.author_id = a.id
ORDER BY b.id;

SELECT b.id, b.title, t.last_name AS translator
FROM books b
JOIN translators t 
ON b.translator_id = t.id
ORDER BY b.id;


-- Left Joins

SELECT b.id, b.title, t.last_name AS translator
FROM books b
LEFT JOIN translators t 
ON b.translator_id = t.id
ORDER BY b.id;

-- Use multiple joins

SELECT b.id, b.title, a.last_name AS author, t.last_name AS translator
FROM books b
LEFT JOIN authors a 
ON b.author_id = a.id
LEFT JOIN translators t 
ON b.translator_id = t.id 
ORDER BY b.id;

-- Let's look a right join
SELECT b.id AS BookID, b.title, e.last_name AS editor
FROM books b
RIGHT JOIN editors e 
ON b.editor_id = e.id
ORDER BY b.id;

-- Let's look at full join
SELECT b.id, b.title, e.last_name AS editor
FROM books b
FULL JOIN editors e 
ON b.editor_id = e.id
ORDER BY b.id;

-- Let's rename a column and try a natural JOIN 
ALTER TABLE editors RENAME COLUMN id TO editor_id;

SELECT b.id, b.title, e.last_name AS editor
FROM books b
NATURAL FULL JOIN editors e 
ORDER BY b.id;