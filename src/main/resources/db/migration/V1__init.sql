-- Exchange companies which provides currency exchange services --
CREATE TABLE companies (
	id SERIAL PRIMARY KEY,
	name VARCHAR(100) NOT NULL
);

-- Operators which works on companies --
CREATE TABLE operators (
	id SERIAL PRIMARY KEY,
	displayname VARCHAR(100) NOT NULL,
	companyid INT NOT NULL,
	FOREIGN KEY (companyid) REFERENCES companies(id)
);

-- Company cash boxes --
CREATE TABLE cashboxes (
	id SERIAL PRIMARY KEY,
	name VARCHAR(50) NOT NULL,
	companyid INT NOT NULL,
	FOREIGN KEY (companyid) REFERENCES companies(id)
);

-- Charges records, which means operators on which cash box is in charge today --
CREATE TABLE charges (
    id SERIAL PRIMARY KEY,
	chargedate DATE NOT NULL,
    operatorid INT NOT NULL,
    cashboxid INT NOT NULL,
	FOREIGN KEY (operatorid) REFERENCES operators(id),
	FOREIGN KEY (cashboxid) REFERENCES cashboxes(id)
);

-- Exchange rates --
CREATE TABLE rates (
	id SERIAL PRIMARY KEY,
	codvaluta VARCHAR(5) NOT NULL,
	curs REAL NOT NULL,
	ratedate DATE NOT NULL,
	companyid INT NOT NULL,
	FOREIGN KEY (companyid) REFERENCES companies(id)
);

-- Exchange operations --
CREATE TABLE exchangeoperations (
    id SERIAL PRIMARY KEY,
	amount REAL NOT NULL,
	summ REAL NOT NULL,
    operationdate DATE NOT NULL,
    operatorid INT NOT NULL,
    rateid INT NOT NULL,
	FOREIGN KEY (operatorid) REFERENCES operators(id),
	FOREIGN KEY (rateid) REFERENCES rates(id)
);

