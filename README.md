# J2EE
Coding samples for J2EE concepts

All are dynamic web projects, just import into eclipse

# Server
Tomcat 9 is used for all dynamic web projects.
Set the server in eclipse by following these steps

1) From the Eclipse main menu choose File > New > Other...
2) Search for server and then select Server > Server.
3) Search for tomcat 9, select it and click next
4) Browse to the folder of your tomcat installation (J2EE_PROJECTS/apache-tomcat-9.0.14)
5) Finish

# Spring
Spring Core Projects are Java projects. each has a lib folder consisting of spring jars.
After importing the spring java project, select all jars in lib folder and add them to build path by 
right clicking selected files -> build path -> add to build path


# MySql
Execute following mysql commands if running for first time

1) CREATE DATABASE student;
2) CREATE TABLE student_details(id int, name varchar(30));
3) INSERT INTO student_details VALUES(1, "Abhishek");
4) INSERT INTO student_details VALUES(2, "Raina");




