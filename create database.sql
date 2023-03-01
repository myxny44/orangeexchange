CREATE DATABASE orangeexchange;
USE orangeexchange;

CREATE TABLE companies (
	id INT AUTO_INCREMENT PRIMARY KEY, 
	name VARCHAR(100) NOT NULL
);

CREATE TABLE operators (
	id INT AUTO_INCREMENT PRIMARY KEY,
	username VARCHAR(100) NOT NULL,
	password VARCHAR(100) NOT NULL,
	displayname VARCHAR(100) NOT NULL,
	FOREIGN KEY (companyid) REFERENCES companies(id)
);

CREATE TABLE cashboxes (
	id INT AUTO_INCREMENT PRIMARY KEY,
	name VARCHAR(50) NOT NULL,
	FOREIGN KEY (companyid) REFERENCES companies(id)
);

CREATE TABLE charges (
	FOREIGN KEY (operatorid) REFERENCES operators(id),
	FOREIGN KEY (cashboxid) REFERENCES cashboxes(id),
	chargedate DATE NOT NULL
);

CREATE TABLE rates (
	id INT AUTO_INCREMENT PRIMARY KEY,
	codvaluta VARCHAR(5) NOT NULL,
	curs DOUBLE NOT NULL,
	ratedate DATE NOT NULL
);

CREATE TABLE exchangeoperations (
	FOREIGN KEY (operatorid) REFERENCES operators(id),
	FOREIGN KEY (rateid) REFERENCES rates(id),
	amount DOUBLE NOT NULL
);

