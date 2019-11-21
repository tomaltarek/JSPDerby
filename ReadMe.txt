Goal:
----- 
We will create a password management system back ended by derby db network server. The application 
will run on tomcat webserver running on my Gateway laptop. All computers/device at home 
network will be able to use this application i.e perfrom CRUD. 

Learning: 
*********
jstl-1.2:
 This is a tag library that I have downloaded from web. This was used in the jsp pages. 

MVC Model: 
The idea is not to have a messy code. Things should be organized in three main components.
These are: 
Model (in our package tomal.dao): Deal with data
Controller: Do all communications with front end users and Model and Views. This is a servlet. 
Views: jsp pages, Under web content a folder named views should be created. 

Not only web project, MVC should be used in all forms of CRUD application regardless of java or 
.net , web or desktop. 

BootStrap Library: 
To have nice css features, we have added 
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
to our jsp page. After that we were able to use various classes on the tags. 



We will Follow MVC model (Model, View, Controller). 
Usually controller is as servlet, model is for example DAO (database access object), views
are jsp files. 

Terminology: MVC
Entity class: 
POJO (plain old java class), it has fields setters/getters and toString() method. 
Users class is an entity class.

DAO: 
DAO needs a database connection. 
DAO communicates with the database
We need a helper class. Helper class contains connections specific things. 

 
What we have done: 
------------------
-Download a jstl jar file and add that to our project. This will allow us to use jstl tag library on 
the jsp page . Note: you must have jstl-1.2. 
-Bootstrap library has many css file in it. Test

Test: 
First I run the server from C:\Users\Tomal\DerbyNetworkDB, it worked ok. 
Then I stopped the server and run the server from 
C:\Users\Tomal\Documents\Tomal Tarek\Personal Development\Project Arcola\Derby DB\DerbyClientServer
and it worked too,but make sure you retart the tomcat server to reflect this, 
this folder has a database that has the same name but the contents are 
completely different. It is amazing, a perfect production and dev environment. 


Resource: 
https://www.youtube.com/watch?v=H-XMn8t3a3Y&list=PLA7e3zmT6XQVMzpfv1ygJdpD-gWauFIZD&index=36 
https://www.youtube.com/watch?v=NwhB2tYrABA&list=PLSM8fkP9ppPoDjapu4muwRjPmUfArMezP&index=7
https://github.com/scbushan05/jsp-servlet-database-crud-application


Issues: 
*******
DB Connections: 
----------------
I was not able to do the database connections. Adding derbynet.jar in the WEB-INF/lib does not work. 
I had even no idea what the issue was about. On the http://localhost:8080/PassMgmt/ConnectionServlet 
nothing shown as "successful". Then I ran the application as debug as and found on the console that the 
problem was in the driver, could not load driver. Then I added derbyclient.jar , and then it started 
working, I mean the connection was successful. 

jstl: 
----
First I have copied jstl from tomcat directory, did not work. jstl-1.2 worked ok which I downloaded 
later from web. 