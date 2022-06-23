-- Let's take a look at creating a function

CREATE OR REPLACE FUNCTION multiply(x NUMERIC, y NUMERIC)
RETURNs NUMERIC 
AS $$

	BEGIN 
			RETURN x * y;
		
	END
$$
LANGUAGE plpgsql;


SELECT multiply(5, 2);

-- plpgsql also has some type coercion

SELECT multiply(6, '3');

CREATE TABLE colors(
	id serial PRIMARY KEY,
	color varchar(15)
);

INSERT INTO colors (color) VALUES ('red'), ('orange'), ('magenta');

SELECT * FROM colors;

-- I'm going to create a function that occurs when we try to INSERT 
-- this function will prevent blue from being inserted into the color table

CREATE OR REPLACE FUNCTION no_more_blues()
RETURNS TRIGGER 
AS $$
	BEGIN 
		IF (NEW.color = 'blue') THEN 
		
		RETURN NULL;
	
		-- End if functions like a }
		END IF; -- IF the above clause IS TRUE THEN we RETURN NULL
		
		RETURN NEW; -- IF the color IS NOT blue, THEN we just RETURN it
		
	END
$$
LANGUAGE plpgsql;

-- Let's define the trigger that would invoke this function

CREATE TRIGGER no_blue
	BEFORE INSERT OR UPDATE ON colors
	FOR EACH ROW 
	EXECUTE FUNCTION no_more_blues();
	
SELECT * FROM colors;

INSERT INTO colors (color) VALUES ('yellow');
INSERT INTO colors (color) VALUES ('green');
-- Let's try adding blue
INSERT INTO colors(color) VALUES ('blue');

-- Let's try updating a color

UPDATE colors SET color = 'blue' WHERE color = 'magenta';

UPDATE colors SET color = 'purple' WHERE color = 'magenta';