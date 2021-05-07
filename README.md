# test-irm-2
Project requirements


With an influx of cases coming in — almost 500 daily — the partners are too overwhelmed to reprimand you. Instead, they ask you to figure out a way to help them manage all the cases. You’re now tasked with designing a system to manage the cases at the rm. 
Some things to know: 
Cases have different states: New, Under Review, Approved, Sent 
- Paralegals and Associates can review cases, but only partners can approve them. 

- Cases can have multiple files associated with them. 
1) What type of solution do you propose and what major components will you need to create? (Couple sentences) 
2) Design an data model for a case 
3) Design a simple API for your solution. 

==================================

1. In this case we can use Java SE/EE to create an application that exposes  RESTFUL/SOAP webservices to the user. The application can run in a Tomcat container hosted on a Linux VM, sitting on top of a MySQL relational database.
For redundancy, we can have two VM instances with the traffic being routed to them trough a load balancer that sits in front of the two VMs.


3. This application uses Java SE 8 in order to exemplify network communication between server and client through the use of SOAP web services, while using JPA (EclipseLink implementation) to store the information into a MySQL database. 

In order to run the application I have used the following tools:
Java IDE: NetBeans;
Web server package: XAMPP;
Database design tool: MySQL Workbench.
The architecture of the projects is designed following the MVC design pattern as follows:

The library project:
- dto:
the Data Transfer Object package contains a version of the object that allows the object to be transferred through a flux;
the classes placed in the ‘entities’ package of the server cannot reach the client because of the annotations that mark the classes in that package, which implement the JPA standard;
the client does not use JPA, as he only consumes the services offered by the server; as such, separate classes are needed that represent the object and describe precisely what it transfers;

The server project:
- dao:
the Data Access Object package holds the class that contains the direct operations with the database;
the class receives an EntityManager given as a dependency through the constructor;
-entities:
this package holds the class that describes the object that is to be mapped in the database;
-entities.enums:
this package server to describe static attributes;
-server:
contains a class that defines the server endpoint, built using as parameters the address and an instance of the class that defines the webservice;
- ws:
the package contains a class annotated as a @WebService and defines the services that the server exposes for the clients to consume, as methods that return dto objects or receive them as parameters;
service:
the service package contains a Singleton class that instantiates an EntityManagerFactory in the constructor and is responsible for implementing the use-cases using working instances of the dto and dao objects;

The client project:
- client:
contains a class that serves the main method;
- controller:
this package holds a Singleton class containing the methods that the clients can consume;
the class has an explicit constructor inside of which we declare the url of the contract and the service that is consumed;
- gui:
the package should contain a Graphic Interface for the users to consume the Create, Update or Delete services exposed by the server;
- ws:
a package that contains an interface that defines the consumed methods;
