CREATE TABLE stocks(
	ticker varchar(5),
	"date" varchar(10),
	"close" numeric(5,2),
	volume int,
	"open" numeric(5,2),
	high numeric(5,2),
	low numeric(5,2)
);

INSERT INTO stocks VALUES 	('APPL', '06/17/2022', 131.56, 134520300, 130.07, 133.08, 129.81),
							('APPL', '06/16/2022', 130.06,	107961500,	132.08,	132.39,	129.04),
							('APPL', '06/15/2022', 135.43,	91532970,	134.29,	137.34,	132.16),
							('APPL', '06/14/2022', 132.76,	84784330,	133.13,	133.89,	131.48),
							('APPL', '06/13/2022', 131.88,	122207100,	132.87,	135.2,	131.44),
							('SBUX', '06/17/2022',	71.87, 	9824325,	71.08, 	72.44, 	70.77),
							('SBUX', '06/16/2022',	70.95, 	10147030,	72.43, 	72.61, 	70.35), 
							('SBUX', '06/15/2022',	74.19, 	7682259,	73.25, 	75.27, 	73.11),
							('SBUX', '06/14/2022',	72.31, 	7635554,	72.85, 	73.84, 	71.53),
							('SBUX', '06/13/2022',	72.36, 	9282753,	73.09, 	74.01, 	71.91),
							('MFST', '06/17/2022',	247.65,	43084780,	244.7,	250.5,	244.03),
							('MFST', '06/16/2022',	244.97,	33169160,	245.98,	247.42,	243.02),
							('MFST', '06/15/2022',	251.76,	33111730,	248.31,	255.3,	246.42),
							('MFST', '06/14/2022',	244.49,	28651490,	243.86,	245.74,	241.51),
							('MFST', '06/13/2022',	242.26,	46135790,	245.11,	249.02,	241.53),
							('AMZN', '06/17/2022',	106.22,	99772150,	102.8,	106.98,	102.51),
							('AMZN', '06/16/2022',	103.66,	82186300,	104.47,	104.58,	102.01),
							('AMZN', '06/15/2022',	107.67,	85011060,	103.86,	109.06,	103.53),
							('AMZN', '06/14/2022',	102.31,	69728760,	104.19,	104.88,	101.43),
							('AMZN', '06/13/2022',	103.67,	99277740,	104.19,	106.54,	101.86),
							('TSLA', '06/17/2022',	650.28,	30880590,	640.3,	662.91,	639.59),
							('TSLA', '06/16/2022',	639.3,	35796900,	668.21,	675.5,	626.08),
							('TSLA', '06/15/2022',	699,	39710650,	662.75,	706.99,	654.45),
							('TSLA', '06/14/2022',	662.67,	32662930,	654.86,	678.99,	635.21),
							('TSLA', '06/13/2022',	647.21,	34255750,	669.5,	679.9,	644.05);
							
-- Aggregate and Scalars
-- Aggregate functions can only be used in the select clause
SELECT max(high) FROM stocks;

SELECT min(low) FROM stocks;

SELECT avg("open") FROM stocks;

-- We can use basic math to created calculated columns
-- Let's find price change
SELECT ticker, date, "close" - "open" FROM stocks;
SELECT ticker, date, ("close" - "open") AS "Price Change" FROM stocks;

-- Let's try to use an aggregate function on this
SELECT ticker, AVG("close" - "open") AS "Price Change" FROM stocks GROUP BY ticker;

UPDATE stocks SET ticker = 'MSFT' WHERE ticker = 'MFST';

-- Scalar functions
-- Scalars can be used in either select or where clasues

SELECT ticker, date, floor(close) FROM stocks;

SELECT DISTINCT lower(ticker) FROM stocks;

SELECT DISTINCT ticker, length(ticker) FROM stocks;

-- We can use this in the where clause too

SELECT ticker, date FROM stocks WHERE abs("close" - "open") > .5;

SELECT ticker, date, ("close" - "open") AS "Price Change"
FROM stocks 
WHERE abs("close" - "open") > .5
ORDER BY "Price Change";