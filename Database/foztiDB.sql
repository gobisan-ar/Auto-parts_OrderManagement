CREATE DATABASE FoztiAP;

CREATE TABLE shipping_zone(
	zoneid int NOT NULL IDENTITY(2750,1),
	name varchar(50) NOT NULL,
	area real,
	budget real,

	CONSTRAINT PK_shipping_zone PRIMARY KEY(zoneid)
);

INSERT INTO shipping_zone(name, area, budget)
VALUES
('Battaramulla', 1.7, 255000),
('Rajagiriya', 1.5, 375000),
('Colombo Fort', 1.9, 280000),
('Slave Island', 1.8, 275000),
('Moratuwa', 1.3, 265000),
('Bambalapitiya', 1.1, 225000);

/***************************************************************/

CREATE TABLE delivery_staff(
	staffid int NOT NULL IDENTITY(2500,1),
	firstname VARCHAR(30),
	lastname VARCHAR(30),
	nic VARCHAR(30),
	email VARCHAR(30),
	mobile VARCHAR(30),
	status VARCHAR(30) DEFAULT 'Available',

	CONSTRAINT delivery_staff_pk PRIMARY KEY(staffid)
);

INSERT INTO delivery_staff(firstname, lastname, nic, email, mobile)
VALUES
('Richard', 'Linklater', '901111111V', 'richard@fozti.lk', '0771010101'),
('Denis', 'Villeneuve', '902222222V', 'denis@fozti.lk', '0772222222'),
('Peter', 'Berg', '9033333333V', 'peter@fozti.lk', '07733333333'),
('Sam', 'Mendes', '904444444V', 'sam@fozti.lk', '0774444444'),
('Anthony', 'Russo', '905555555V', 'anthony@fozti.lk', '0775555555'),
('Zack', 'Snyder', '906666666V', 'snyder@fozti.lk', '0776666666');


/***************************************************************/


CREATE TABLE customer_order(
	orderid int NOT NULL IDENTITY(2000,1),
	customerid int NOT NULL,
	deliveryAddress VARCHAR(30) NOT NULL, 
	payment REAL DEFAULT 0,
	payStatus int DEFAULT 0,
	stockStatus int DEFAULT 0,
	orderStatus VARCHAR(30) DEFAULT 'new', 
	pendingReason VARCHAR(30) DEFAULT 'NA',
	shipperid VARCHAR(10) DEFAULT 'NA',
	shippedDate DATE DEFAULT GETDATE(),

	CONSTRAINT PK_customer_order PRIMARY KEY(orderid)
);

/* Shipped orders */
INSERT INTO customer_order(customerid, deliveryAddress, payment, payStatus, orderStatus, shipperid)
VALUES
(3750,  'Battaramulla', 95000, 1, 'shipped', 2501),
(3751,  'Battaramulla', 14300, 1, 'shipped', 2501),
(3752,  'Rajagiriya', 87500, 1, 'shipped', 2501),
(3753,  'Battaramulla', 34000, 1, 'shipped', 2501),
(3754,  'Battaramulla', 52000, 1, 'shipped', 2501),
(3755,  'Bambalapitiya', 45000, 1, 'shipped', 2501);

/* Pending Orders */
INSERT INTO customer_order(customerid, deliveryAddress, payment, payStatus, stockStatus, orderStatus, pendingReason)
VALUES
(3750,  'Battaramulla', 95000, 1, 0, 'pending', 'Out of Stock'),
(3751,  'Battaramulla', 14300, 1, 0, 'pending', 'Out of Stock'),
(3752,  'Rajagiriya', 87500, 1, 0, 'pending', 'Out of Stock'),
(3753,  'Battaramulla', 34000, 1, 0, 'pending', 'Out of Stock'),
(3754,  'Battaramulla', 52000, 1, 0, 'pending', 'Out of Stock'),
(3750,  'Battaramulla', 95000, 0, 1, 'pending', 'Payment Incomplete'),
(3751,  'Battaramulla', 14300, 0, 1, 'pending', 'Payment Incomplete'),
(3752,  'Rajagiriya', 87500, 0, 1, 'pending', 'Payment Incomplete'),
(3753,  'Battaramulla', 34000, 0, 1, 'pending', 'Payment Incomplete'),
(3754,  'Battaramulla', 52000, 0, 1, 'pending', 'Payment Incomplete');


/* New Orders*/
INSERT INTO customer_order(customerid, deliveryAddress)
VALUES
(3501, 'Battaramulla'),
(3502, 'Rajagiriya'),
(3503, 'Colombo Fort'),
(3504, 'Slave Island'),
(3505, 'Battaramulla'),
(3506, 'Bambalapitiya');

/*****************************************************/

CREATE FUNCTION shippingPercentage()
RETURNS real
AS
BEGIN
	declare @totShip int, @totOrder int, @pc real

	SELECT @totShip = COUNT(orderid)
	FROM customer_order
	WHERE orderStatus = 'shipped'

	SELECT @totOrder = COUNT(orderid)
	FROM customer_order

	SELECT @pc = @totShip * 100 / @totOrder

	RETURN @pc
END

/****************************************************/	

CREATE TABLE users(
  userid int NOT NULL Identity(5000,1),
  email varchar(45) NOT NULL,
  password varchar(45) NOT NULL,
  fullname varchar(45) NOT NULL,
  designation varchar(30) NOT NULL,

  CONSTRAINT PK_users PRIMARY KEY (userid)
);

INSERT INTO users 
VALUES
('gobisan@fozti.lk', 'gobi123', 'Gobisan', 'Sales Manager'),
('kenneth@fozti.lk', 'kenneth123', 'Kenneth', 'Warehouse Manager'),
('andrew@fozti.lk', 'andrew 123', 'Andrew', 'Product Manager'),
('hilary@fozti.lk', 'hilary123', 'Hilary ', 'Customer Manager'),
('kira@fozti.lk', 'kira123', 'Kira', 'IT Manager');