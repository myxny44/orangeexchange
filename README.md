# Exchange server application
This exchange service application based on **Spring Boot Framework**

For launch server need to be installed **Docker** and **Java 8**

### In commandline run following commands:
```agsl
./gradlew build
docker-compose up
```

### Files Reference

* ```Exchange.postman_collection.json - JSON collection for postman with all requests and examples```
* ```init.sql - create database in PostgreSQL container```
* ```/src/main/resources/db/migration/V1__init.sql - migration file with all schemas using in project```
* ```testdata/* - test data files for import```

### Import test data
For importing test data in **PostgreSQL** run following commands from project root folder on running **Docker** containers:

```agsl
docker cp testdata/ exchange-postgres:/tmp/
docker exec -it exchange-postgres bash
psql -U postgres -d orangeexchange -a -f /tmp/testdata/import.sql
```