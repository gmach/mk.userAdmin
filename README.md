mk.userAdmin
============
This is built using Java Spring Boot, REST, Hibernate against MySQL for implementing a backend for user registrations.
To build first setup DB tables using SQL script in src\main\resources\Customer.sql and customise your DB connections in the hibernate.cfg.xml file
use Maven with "mvn clean package" to build JAR
then "java -jar target\userAdmin-0.1.0.jar"
Test client in restclient.html
