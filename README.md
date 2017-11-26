A sample project to play around with Spring MVC, Thymeleaf and Spring Security.

#### Notes

* run ```docker-compose up``` from the projects directory (it will create a MySQL and an Adminer container)  
* run the application with ```./gradlew bootrun``` (FlyWay will install the DB tables if it is running for the first time)  
* open Adminer on [http://localhost:9000/](http://localhost:9000/) and log in with this data:  

 &nbsp; | &nbsp;  
 ---|---  
 **System** | MySQL   
 **Server** | db   
 **Username** | admin   
 **Password** | pass   
 **Databse** | securedmvc   
 
* insert some data to the tables, i.e.:  
```
INSERT INTO `user` (`email`, `enabled`, `password`, `role`) VALUES  
('employee@email.com',	CONV('1', 2, 10) + 0,	'employee',	0),  
('manager@email.com',	CONV('1', 2, 10) + 0,	'manager',	1);  
  
INSERT INTO `authority` (`id`, `authority`, `role`) VALUES  
(1,	'employee',	0),  
(2,	'manager',	1);  
```

* login to the page on [http://localhost:8080/](http://localhost:8080/) and see the text parts allowed to the given role 