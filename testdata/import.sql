COPY companies(id,name) FROM '/tmp/testdata/company.csv' DELIMITER ',' CSV HEADER;
COPY operators(id,displayname,companyid) FROM '/tmp/testdata/operator.csv' DELIMITER ',' CSV HEADER;
COPY cashboxes(id,name,companyid) FROM '/tmp/testdata/cashbox.csv' DELIMITER ',' CSV HEADER;
COPY charges(id,chargedate,operatorid,cashboxid) FROM '/tmp/testdata/charge.csv' DELIMITER ',' CSV HEADER;
COPY rates(id,codvaluta,curs,ratedate,companyid) FROM '/tmp/testdata/rate.csv' DELIMITER ',' CSV HEADER;
COPY exchangeoperations(id,amount,summ,operationdate,operatorid,rateid) FROM '/tmp/testdata/exchangeoperations.csv' DELIMITER ',' CSV HEADER;
