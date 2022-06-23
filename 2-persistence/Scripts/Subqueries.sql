-- Let's use DDL to create some tables

CREATE TABLE stores(
	store_id int PRIMARY KEY,
	store_city varchar(20),
	store_state varchar(20)
);

CREATE TABLE suppliers(
	supplier_id int PRIMARY KEY,
	supplier_city varchar(20),
	supplier_state varchar(20),
	product_type varchar(20),
	store_id int REFERENCES stores
);


-- Lets add in some mocked data

insert into stores (store_id, store_city, store_state) values (1, 'Dallas', 'Texas');
insert into stores (store_id, store_city, store_state) values (2, 'Anaheim', 'California');
insert into stores (store_id, store_city, store_state) values (3, 'Fort Lauderdale', 'Florida');
insert into stores (store_id, store_city, store_state) values (4, 'Boca Raton', 'Florida');
insert into stores (store_id, store_city, store_state) values (5, 'Salinas', 'California');
insert into stores (store_id, store_city, store_state) values (6, 'Laredo', 'Texas');
insert into stores (store_id, store_city, store_state) values (7, 'Houston', 'Texas');
insert into stores (store_id, store_city, store_state) values (8, 'Brooklyn', 'New York');
insert into stores (store_id, store_city, store_state) values (9, 'Albany', 'New York');
insert into stores (store_id, store_city, store_state) values (10, 'Denton', 'Texas');
insert into stores (store_id, store_city, store_state) values (11, 'Vero Beach', 'Florida');
insert into stores (store_id, store_city, store_state) values (12, 'San Antonio', 'Texas');
insert into stores (store_id, store_city, store_state) values (13, 'Lubbock', 'Texas');
insert into stores (store_id, store_city, store_state) values (14, 'Jacksonville', 'Florida');
insert into stores (store_id, store_city, store_state) values (15, 'Garland', 'Texas');
insert into stores (store_id, store_city, store_state) values (16, 'Fort Pierce', 'Florida');
insert into stores (store_id, store_city, store_state) values (17, 'South Lake Tahoe', 'California');
insert into stores (store_id, store_city, store_state) values (18, 'San Diego', 'California');
insert into stores (store_id, store_city, store_state) values (19, 'Los Angeles', 'California');
insert into stores (store_id, store_city, store_state) values (20, 'Clearwater', 'Florida');
insert into stores (store_id, store_city, store_state) values (21, 'New York City', 'New York');
insert into stores (store_id, store_city, store_state) values (22, 'Miami', 'Florida');
insert into stores (store_id, store_city, store_state) values (23, 'Bradenton', 'Florida');
insert into stores (store_id, store_city, store_state) values (24, 'Miami', 'Florida');
insert into stores (store_id, store_city, store_state) values (25, 'White Plains', 'New York');
insert into stores (store_id, store_city, store_state) values (26, 'Carlsbad', 'California');
insert into stores (store_id, store_city, store_state) values (27, 'New York City', 'New York');
insert into stores (store_id, store_city, store_state) values (28, 'Albany', 'New York');
insert into stores (store_id, store_city, store_state) values (29, 'El Paso', 'Texas');
insert into stores (store_id, store_city, store_state) values (30, 'Dallas', 'Texas');
insert into stores (store_id, store_city, store_state) values (31, 'Brooklyn', 'New York');
insert into stores (store_id, store_city, store_state) values (32, 'Fort Lauderdale', 'Florida');
insert into stores (store_id, store_city, store_state) values (33, 'San Diego', 'California');
insert into stores (store_id, store_city, store_state) values (34, 'Austin', 'Texas');
insert into stores (store_id, store_city, store_state) values (35, 'Glendale', 'California');
insert into stores (store_id, store_city, store_state) values (36, 'Austin', 'Texas');
insert into stores (store_id, store_city, store_state) values (37, 'Orlando', 'Florida');
insert into stores (store_id, store_city, store_state) values (38, 'Miami', 'Florida');
insert into stores (store_id, store_city, store_state) values (39, 'Los Angeles', 'California');
insert into stores (store_id, store_city, store_state) values (40, 'San Antonio', 'Texas');
insert into stores (store_id, store_city, store_state) values (41, 'El Paso', 'Texas');
insert into stores (store_id, store_city, store_state) values (42, 'Humble', 'Texas');
insert into stores (store_id, store_city, store_state) values (43, 'Clearwater', 'Florida');
insert into stores (store_id, store_city, store_state) values (44, 'Lancaster', 'California');
insert into stores (store_id, store_city, store_state) values (45, 'Arlington', 'Texas');
insert into stores (store_id, store_city, store_state) values (46, 'Escondido', 'California');
insert into stores (store_id, store_city, store_state) values (47, 'Fort Worth', 'Texas');
insert into stores (store_id, store_city, store_state) values (48, 'Riverside', 'California');
insert into stores (store_id, store_city, store_state) values (49, 'Syracuse', 'New York');
insert into stores (store_id, store_city, store_state) values (50, 'Fort Myers', 'Florida');


insert into suppliers (supplier_id, supplier_city, supplier_state, product_type, store_id) values (1, 'Fort Myers', 'Florida', 'Cookware', 44);
insert into suppliers (supplier_id, supplier_city, supplier_state, product_type, store_id) values (2, 'Albany', 'New York', 'Deli Products', 12);
insert into suppliers (supplier_id, supplier_city, supplier_state, product_type, store_id) values (3, 'Albany', 'New York', 'Dairy Products', 5);
insert into suppliers (supplier_id, supplier_city, supplier_state, product_type, store_id) values (4, 'Fort Worth', 'Texas', 'Deli Products', 23);
insert into suppliers (supplier_id, supplier_city, supplier_state, product_type, store_id) values (5, 'Corpus Christi', 'Texas', 'Bakery', 40);
insert into suppliers (supplier_id, supplier_city, supplier_state, product_type, store_id) values (6, 'Miami', 'Florida', 'Cookware', 33);
insert into suppliers (supplier_id, supplier_city, supplier_state, product_type, store_id) values (7, 'Orlando', 'Florida', 'Bakery', 24);
insert into suppliers (supplier_id, supplier_city, supplier_state, product_type, store_id) values (8, 'Dallas', 'Texas', 'Dairy Products', 21);
insert into suppliers (supplier_id, supplier_city, supplier_state, product_type, store_id) values (9, 'Oceanside', 'California', 'Bakery', 16);
insert into suppliers (supplier_id, supplier_city, supplier_state, product_type, store_id) values (10, 'Burbank', 'California', 'Deli Products', 41);
insert into suppliers (supplier_id, supplier_city, supplier_state, product_type, store_id) values (11, 'Los Angeles', 'California', 'Cookware', 12);
insert into suppliers (supplier_id, supplier_city, supplier_state, product_type, store_id) values (12, 'Berkeley', 'California', 'Cookware', 39);
insert into suppliers (supplier_id, supplier_city, supplier_state, product_type, store_id) values (13, 'Utica', 'New York', 'Deli Products', 4);
insert into suppliers (supplier_id, supplier_city, supplier_state, product_type, store_id) values (14, 'Rochester', 'New York', 'Bakery', 42);
insert into suppliers (supplier_id, supplier_city, supplier_state, product_type, store_id) values (15, 'Atlanta', 'Georgia', 'Dairy Products', 28);
insert into suppliers (supplier_id, supplier_city, supplier_state, product_type, store_id) values (16, 'Clearwater', 'Florida', 'Dairy Products', 26);
insert into suppliers (supplier_id, supplier_city, supplier_state, product_type, store_id) values (17, 'Miami', 'Florida', 'Deli Products', 35);
insert into suppliers (supplier_id, supplier_city, supplier_state, product_type, store_id) values (18, 'Albany', 'New York', 'Deli Products', 44);
insert into suppliers (supplier_id, supplier_city, supplier_state, product_type, store_id) values (19, 'Corpus Christi', 'Texas', 'Dairy Products', 2);
insert into suppliers (supplier_id, supplier_city, supplier_state, product_type, store_id) values (20, 'Austin', 'Texas', 'Bakery', 26);
insert into suppliers (supplier_id, supplier_city, supplier_state, product_type, store_id) values (21, 'Fresno', 'California', 'Cookware', 20);
insert into suppliers (supplier_id, supplier_city, supplier_state, product_type, store_id) values (22, 'Pasadena', 'Texas', 'Bakery', 26);
insert into suppliers (supplier_id, supplier_city, supplier_state, product_type, store_id) values (23, 'Saint Petersburg', 'Florida', 'Deli Products', 24);
insert into suppliers (supplier_id, supplier_city, supplier_state, product_type, store_id) values (24, 'San Diego', 'California', 'Dairy Products', 39);
insert into suppliers (supplier_id, supplier_city, supplier_state, product_type, store_id) values (25, 'El Paso', 'Texas', 'Bakery', 49);
insert into suppliers (supplier_id, supplier_city, supplier_state, product_type, store_id) values (26, 'Santa Clara', 'California', 'Bakery', 27);
insert into suppliers (supplier_id, supplier_city, supplier_state, product_type, store_id) values (27, 'Jamaica', 'New York', 'Bakery', 29);
insert into suppliers (supplier_id, supplier_city, supplier_state, product_type, store_id) values (28, 'El Paso', 'Texas', 'Deli Products', 21);
insert into suppliers (supplier_id, supplier_city, supplier_state, product_type, store_id) values (29, 'Fresno', 'California', 'Dairy Products', 9);
insert into suppliers (supplier_id, supplier_city, supplier_state, product_type, store_id) values (30, 'Lehigh Acres', 'Florida', 'Deli Products', 36);
insert into suppliers (supplier_id, supplier_city, supplier_state, product_type, store_id) values (31, 'Tampa', 'Florida', 'Deli Products', null);
-- Let's look at some subqueries

-- Let's say I wanted to find the percentage of suppliers without a store
-- First thing would be to find the total number of suppliers
SELECT count(*) FROM suppliers;

-- Divide the number of suppliers with a blank store id by the total number
SELECT (count(*)*100.0/30) AS "Percent Missing" FROM suppliers WHERE store_id is NULL;

-- Let's use a subquery to condense this down to one query
SELECT (count(*)*100.0/(SELECT count(*) FROM suppliers)) AS "Percent Missing" FROM suppliers WHERE store_id is NULL;

-- Let's look at using it in a where clause
-- Select all suppliers that supply to stores in the state of new york;
SELECT store_id FROM stores WHERE store_state = 'New York';

-- We can find all the supplier info for these stores in 2 ways (joins or subqueries)
SELECT * FROM suppliers s 
NATURAL LEFT JOIN stores s2 
WHERE s2.store_state = 'New York';

-- Let's look at how to do this with a subquery
SELECT * FROM suppliers WHERE store_id IN (SELECT store_id FROM stores WHERE store_state = 'New York');

-- Subquery where it's in the from clause

-- Let's look at all of the cities we work in and see how many network pieces(stores or suppliers) we have in EACH 

-- Let's start by listing the cities we work IN 
-- Stores
SELECT store_city AS city FROM stores;

-- Suppliers
SELECT supplier_city AS city FROM suppliers;

-- Let's use a set operation to stack these together
SELECT store_city AS city FROM stores s 
UNION 
SELECT supplier_city FROM suppliers;

-- Let's use this to count each piece in each city

SELECT city_all.city, count(city_all.city)
FROM (SELECT store_city AS city FROM stores s 
	  UNION ALL
	  SELECT supplier_city FROM suppliers
	  ) AS city_all GROUP BY city_all.city
ORDER BY city_all.city;

SELECT store_city, count(store_city) FROM stores GROUP BY store_city;



