## Spring Multitenancy Experiment

### Technology Stack :
* Java SDK 1.7
* Servlet 3.1
* Spring MVC 4.2
* Maven 3
* Log4j 1.2
* SLF4J 1.7
* PostgreSQL 9.4
* MyBatis 4

### Prerequisite :
* Installed JDK 1.7
* Installed Maven
* Installed PostgreSQL database server
* Create database with name `default_tenant`
* Create the following table :

```
CREATE TABLE users
(
  id integer NOT NULL,
  name character varying(50) NOT NULL,
  address character varying(100),
  CONSTRAINT users_pk PRIMARY KEY (id)
)
```

### Run and Build :
* Run application :

    	mvn clean tomcat7:run

* Call URL :

		http://localhost:8080