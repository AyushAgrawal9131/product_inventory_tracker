# Product-Inventory Tracker
Product Inventory Tracker :
- Create a simple product inventory tracker for managing stock levels and product details.
- Implemented CRUD operations to add, view, update, and delete product information.
-MySQL is used as a database.

How To use :

There are two roles user role and admin role , user role can only get all the product details and get specific information about the 
product via product id . Admin has all the privilages to perform CRUD operations on the Product .

Predefined data in the database
In the database, there are two types of users: ROLE_ADMIN and ROLE_USER.
Also, there are 2 predefined users as you can see in import.sql file.

Regular user is john.doe.
Admin is jane.doe.
All passwords are 123.


API documentation
Login
POST http://localhost:8080/auth/login
Request:

{
	"username":"john.doe",
	"password":"123"
}
Response:

{
    "id": 1,
    "username": "john.doe",
    "firstName": "John",
    "lastName": "Doe",
    "email": "john@doe.com",
    "enabled": true,
    "authorities": [
        "ROLE_USER"
    ],
    "token": {
        "accessToken": "JWT_TOKEN_VALUE",
        "expiresIn": 3600000
    }
}

After login with Admin : you can add the products 
POST http://localhost:8080/api/products
Request: 
{
    "id":1,
    "name":"Apple Charger",
    "description": "22 W apple charger",
    "price":4400,
    "quantity":2
}

Response : 
{
    "id":1,
    "name":"Apple Charger",
    "description": "22 W apple charger",
    "price":4400,
    "quantity":2
}

Update the product : 
PUT http://localhost:8080/api/products/{productid}
Request: 
{
    "id":1,
    "name":"Apple charger plus watch",
    "description": "22 W apple charger and apple watch",
    "price":4400,
    "quantity":3
}

Response:
{
    "id":1,
    "name":"Apple charger plus watch",
    "description": "22 W apple charger and apple watch",
    "price":4400,
    "quantity":3
}

get all the products listed :
GET http://localhost:8080/api/products

Response :
{
  {
    "id":1,
    "name":"Apple charger plus watch",
    "description": "22 W apple charger and apple watch",
    "price":4400,
    "quantity":3
  }
}

Get the product by id :
GET http://localhost:8080/api/products/1

Response :

{
    "id":1,
    "name":"Apple charger plus watch",
    "description": "22 W apple charger and apple watch",
    "price":4400,
    "quantity":3
}

Delete the product if you have login through admin credentials:

DELETE http://localhost:8080/api/products/{product_id}

Response :
product deleted successfully 


If you have user role then you are only get the product details :
GET http://localhost:8080/api/products
GET http://localhost:8080/api/products/{product_id}




Refresh token
POST http://localhost:8080/auth/refresh
Authentication: you must send JWT with request
All users are authorized to use this endpoint
Response:

{
    "accessToken": "JWT_TOKEN_VALUE",
    "expiresIn": 3600000
}
Change password
POST http://localhost:8080/auth/change-password
Authentication: you must send JWT with request
All users are authorized to use this endpoint
Request:

{
    "oldPassword": "12345",
    "newPassword": "asdfg"
}
Response: 200 OK or exception

Public Hello World
GET http://localhost:8080/api/public/hello-world
Everyone is authorized to use this endpoint
Response: Hello World from PUBLIC controller!

Private Hello World for registered users
GET http://localhost:8080/api/hello-world/registered-user
Only registered users can use this endpoint
Response: Hello ANY REGISTERED USER from PRIVATE controller!

Private Hello World for regular users
GET http://localhost:8080/api/hello-world/user
Only users with role ROLE_USER can use this endpoint
Response: Hello USER from PRIVATE controller!

Private Hello World for admins
GET http://localhost:8080/api/hello-world/admin
Only users with role ROLE_ADMIN can use this endpoint
Response: Hello ADMIN from PRIVATE controller!
