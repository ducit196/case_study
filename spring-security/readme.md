# Spring boot security with JWT
Very simple project for spring security with JWT, JPA, Mysql

## Table of Contents

* [Requirements](#Requirement)
* [Sequence diagram](#sequence-diagram)
* [Project Structer](#project-structer)
* [Running Instructions](#running-instructions)
  
## Requirement
Create simple project for spring security with JWT, JPA, Mysql.

System have 2 roles of user: admin, user.

Access to /rest/admin need role admin

Access to /rest/user need role admin or user

User needs store at mysql database

Authentication using JWT

## Sequence diagram

![](src/main/resources/image/Diagram.png)

Step1: Call api login to get JWT

Call post: localhost:8080/rest/login

Body:
{
"userName": "nbduc",
"passWord": "1"
}
![](src/main/resources/image/login_api.png)
To get token from response body.

Step 2: Call api for admin role.

Call get: localhost:8080/rest/admin

Header: 

Authorization: eyJhbGciOiJIUzI1NiJ9.eyJleHAiOjE2MzQwMzI4MDIsInVzZXJuYW1lIjoibWFpIGFuaCJ9.FdVRFpjyRU4mVy-ZDBVtzozjI3cNesJ6Ude44AEkx5k

In this case: user nbduc have 2 role admin and user so can access to admin page.
![](src/main/resources/image/admin_page.png)
Try to use another user have only user role will be get access deny
![](src/main/resources/image/deny.png)

## Project Structer
**Controller**

Provide controller class for restful API.

**Filter**

Filter class to authentication request before call to controller class.

**Model**

User entity mapping JPA with user table.

**Repository**

Provide function manipulate data with database.

**Security**

JwtService class: provide service generate JWT token after login success, validate token,...

SecurityConfiguration class: config security.

CustomAccessDeniedHandler, RestAuthenticationEntryPoint class: customer response in exception case.

**Service**

Provide user function.

## Running instructions
Run database script: resources/sql/datatase_script.sql

Run maven: mvn spring-boot:run


