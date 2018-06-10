# Editable Profile
This project provide some basic feature which allows you to edit your profile (both client and server).

# Description
In this project i'm using Spring boot on server side and Angular 4 on client side.

# Server
Spring boot REST API project using some useful features:

provides the following features:

* Spring Rest
* Spring Security
* Spring Session
* Hibernate

# How to start Server
Note that this seed project requires JDK 8.
I'm using mysql server for persisting data, so before running the server side please import editable-profile-script.sql file on your database and set below varaibles with your specific database configuration info in application.properties file.

spring.datasource.url=jdbc:mysql://database ip address/database name

spring.datasource.username=user name

spring.datasource.password=password

# Client
This project was generated with Angular CLI version 6.0.0.

provides the following features:

* Developed using boostrap-v4.0.0
* angular-v6.0.0
* angular/cli-v6.0.0
* ng-bootstrap-v2.0.0

# How to start Client
Note that this seed project requires node =v6.11.0.

In order to start the project use:
* git clone https://github.com/moayeri67/editable-profile.git
* cd editable-profile/Client/
* npm install
* npm start
* npm run build
