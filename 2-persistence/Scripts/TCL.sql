-- TCL (Transaction Control Language)

CREATE TABLE myTable(
	id int,
	field_1 varchar(10),
	field_2 int,
	PRIMARY KEY (id)
);

-- To begin a transaction block we use the BEGIN keyword;
BEGIN;
-- Let's start some transactions
INSERT INTO myTable values (1, 'HELLO', 2);
INSERT INTO myTable VALUES (2, 'WORLD', 54);
INSERT INTO mytable VALUES (3, 'MY', 109);
SAVEPOINT a;
INSERT INTO myTable VALUES(4,'NAME', 4);
INSERT INTO myTable VALUES(5,'IS', 2);
INSERT INTO myTable VALUES(6,'BOB', 13);

-- All of these are still part of one singular transaction and a transaction will last until either a roll back 
-- or a commit is reached

SELECT * FROM myTable;
-- So these results have not been committed yet but they been cached/saved
-- That's why we still receive results from our select statements

SAVEPOINT b;

UPDATE mytable SET field_1 = 'Jane' WHERE field_1 = 'BOB';

-- Verify the update went through
SELECT * FROM myTable;

-- Now we can use rollback to roll back to the save point
-- ROLLBACK TO a;
ROLLBACK TO b;
ROLLBACK TO a;


SELECT * FROM myTable;

COMMIT;

-- Since we committed all our changes are posted to the database and we can no longer roll back 
--ROLLBACK TO a;
SELECT * FROM myTable;

-- Let's truncate the table to retest our TCL
TRUNCATE mytable;