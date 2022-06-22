CREATE TABLE accounts(
	id serial PRIMARY KEY,
	balance NUMERIC(50,2) DEFAULT 0, -- 50 total digits WITH up TO 2 being decimal 12345.67
	acc_owner integer NOT NULL,
	active bool DEFAULT FALSE -- mark whether the account IS OPEN OR not
);


CREATE TYPE user_role AS ENUM ('Admin', 'Customer', 'Employee');


CREATE TABLE users(
	id serial PRIMARY KEY,
	username varchar(50) NOT NULL UNIQUE,
	pwd varchar(50) NOT NULL,
	user_role user_role NOT null
);

ALTER TABLE accounts ADD CONSTRAINT users_fkey FOREIGN KEY (acc_owner) REFERENCES users(id);

CREATE TABLE user_accounts_jt(
	acc_owner integer NOT NULL REFERENCES users(id),
	account int NOT NULL REFERENCES accounts(id)
);

INSERT INTO users (username, pwd, user_role) 
	VALUES ('Larry', 'pass', 'Employee'),
			('Marry', '1234', 'Customer'),
			('Barry', 'pass', 'Customer');
			
SELECT * FROM users;

INSERT INTO accounts (balance, acc_owner)
	VALUES (100, 1),
		    (200, 2),
		    (2000, 2),
		    (300, 3);
		    
SELECT * FROM accounts;

INSERT INTO user_accounts_jt (acc_owner, account) 
	VALUES (1, 1),
	 	   (2, 2), -- Marry's account (her id is 2)
	 	   (2, 3), -- Marry's account (her id is 2)
	 	   (3, 4);

SELECT * FROM user_accounts_jt;

INSERT INTO users (username, pwd, user_role) values ('Test', 'Password' , 'Admin' ) RETURNING users.id;