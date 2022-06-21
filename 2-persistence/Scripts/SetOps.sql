CREATE TABLE one(
	col_one int PRIMARY KEY,
	col_two int
);

CREATE TABLE two(
	col_one int PRIMARY KEY,
	col_two int
);

INSERT INTO one VALUES (1,1),(2,2),(3,3),(4,4),(5,5);
INSERT INTO two VALUES (1,100),(2,200),(3,300), (4,400), (5,5);

-- Joins add horizontally (columns)
SELECT * FROM one o 
FULL JOIN two t 
ON o.col_one = t.col_one;

-- Set operations act veritcally (combining rows)
-- Set operations only operate on results that have the same number and type of columns

-- Union stacks the two sets together and does not include duplicates
SELECT * FROM one UNION SELECT * FROM two ORDER BY col_one;

-- Union all is the same as union but include duplicates
SELECT * FROM one UNION ALL SELECT * FROM two ORDER BY col_one;

-- Intersect basically only returns duplicates
SELECT * FROM one INTERSECT SELECT * FROM two;

-- Except will return the first set without records that are duplicated in the second set
SELECT * FROM two EXCEPT SELECT * FROM one;