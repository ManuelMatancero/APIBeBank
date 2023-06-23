# How to use and deploy

This is the link to download the backup of the database: https://drive.google.com/drive/folders/1C4bSwEe7K1HMh9LessnmjUmoLLvXV_MS?usp=sharing

# Jar of the API
In this link you will find the JAR of the API: https://drive.google.com/drive/folders/1c-mVOTDEyDvwkZMZNaLhMTSBfAphhWoH?usp=sharing

To deploy the API, first you have to install the Java JDK 17 and MySql, and then import the database using your prefered unified visual tool for MySql databases, open the API code in your preferred IDE, clean and build the project and change the connection parameters in the application.properties file with yours, finally run it from the class ApiBeBankApplication.

# Example of the application.properties file
``` 
#Mysql conexion
spring.datasource.url=jdbc:mysql://localhost/<database name>?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrival=true&sslMode=REQUIRED
spring.datasource.username=<Your User>
spring.datasource.password=<Your Password>
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.database-platform=org.hibernate.dialect.MySQLDialect
```
# Recommendations
In order to use the data already inserted in the database the password for the first two users is 123456 and for the third is 654321, also you can insert users and its related information, insert data in the following order the user->bankingAccount.

# Updates
The API now is protected with Json Web Token, you can't use the endpoints without authenticate first, once you authenticate with a POST petition with http://localhost:80/jwt, in the body you have to put a user and a password from a user that is registered in the database, the response of that operation will be a 200 OK, and in its header will be the JsonWebToken which you are going to use to send it in the header of all your request in order to have successful responses. The JsonWebToken will have an expiration date that we can change whenever we want.

This is what you have to send in the body of the request:
```
{
 "user": "john.doe",
 "password": "password123"
}

```
# Remember this
All the petitions you are going to do from now must have the valid JWT in its header in order to not get a 401.

# How to use UserController

The UserController API provides various methods for performing CRUD operations on User objects. Below is a guide on how to use the API.

# Save a User object

To save a User object, you need to send a POST request to the /user/save endpoint with the User object as the request body. The API will then save the User object to the database.

Example:

``` 
POST /user/save

{
  "id": null,
  "name": "John",
  "email": "john@mail.com",
  "user": "john.doe",
  "password": "password123",
  "role": 1,
  "status": 2,
  "pin": "1234"
} 
```

# Login a user

To login a user, you need to send a POST request to the /user/login endpoint with the user's login credentials in the request body. The API will then check the user's credentials and return the user object if the credentials are correct.

Example:

```
 POST /user/login

{
  "user": "john.doe",
  "password": "password123"
} 
```

# Login a user with PIN

To login a user with a PIN, you need to send a POST request to the /user/pinlogin endpoint with the user's login credentials and PIN in the request body. The API will then check the user's credentials and PIN and return the user object if they are correct.

Example:

```
POST /user/pinlogin

{
  "user": "john.doe",
  "password": "password123",
  "pin": "1234"
}
```


# List all User objects

To list all User objects, you need to send a GET request to the /user/list endpoint. The API will then return a list of all User objects in the database.

Example:

```
GET /user/list
```

# Get a specific User object

To get a specific User object, you need to send a GET request to the /user/{id} endpoint with the user ID as a path parameter. The API will then return the User object with the specified ID.

Example:

```
GET /user/1
```

# Delete a User object

To delete a User object, you need to send a DELETE request to the /user/delete/{id} endpoint with the user ID as a path parameter. The API will then delete the User object with the specified ID from the database.

Example:

```
DELETE /user/delete/1
```


# How to use BankingAccountController 
This a Java class that provides REST API endpoints for managing banking accounts. Here's how to use it with examples:

# Saving a Banking Account
To save a banking account, send a POST request to the URL http://localhost:8080/account/save/{id_of_the_user} with a JSON body containing the banking account mount. This request will create the account with the initial mount and its related card. Here's an example JSON body:
```
{
"mount": 3000,
}
```
This will save the banking account in the database and return a 200 OK response with the saved banking account details and the card related wit the user passed in the URL.

# Listing All Banking Accounts
To get a list of all banking accounts, send a GET request to the URL http://localhost:8080/account/list. This will return a 200 OK response with a JSON array of all banking account details.

# Getting a Banking Account by ID
To get a specific banking account by ID, send a GET request to the URL http://localhost:8080/account/{id}, where {id} is the ID of the banking account you want to retrieve. For example, to get the banking account with ID 1, send a GET request to the URL http://localhost:8080/account/1. If the banking account exists, this will return a 200 OK response with the banking account details. If the banking account does not exist, this will return a 404 Not Found response.

# Deleting a Banking Account by ID
To delete a banking account by ID, send a DELETE request to the URL http://localhost:8080/account/delete/{id}, where {id} is the ID of the banking account you want to delete. For example, to delete the banking account with ID 1, send a DELETE request to the URL http://localhost:8080/account/delete/1. If the banking account exists, this will delete the banking account from the database and return a 200 OK response with the message "BankingAccount Eliminado". If the banking account does not exist, this will return a 404 Not Found response.

# How to use CardController 
CardsController is a Java class that provides REST API endpoints for managing cards. Here's how to use it with examples:

# Listing All Cards
To get a list of all cards, send a GET request to the URL http://localhost:8080/cards/list. This will return a 200 OK response with a JSON array of all card details.

# Getting a Card by ID
To get a specific card by ID, send a GET request to the URL http://localhost:8080/cards/{id}, where {id} is the ID of the card you want to retrieve. For example, to get the card with ID 1, send a GET request to the URL http://localhost:8080/cards/1. If the card exists, this will return a 200 OK response with the card details. If the card does not exist, this will return a 404 Not Found response.

# Deleting a Card by ID
To delete a card by ID, send a DELETE request to the URL http://localhost:8080/cards/delete/{id}, where {id} is the ID of the card you want to delete. For example, to delete the card with ID 1, send a DELETE request to the URL http://localhost:8080/cards/delete/1. If the card exists, this will delete the card from the database and return a 200 OK response with the message "Cards Eliminado". If the card does not exist, this will return a 404 Not Found response.

Note: In order to use the API, you need to have the necessary permissions and access to the API's endpoints. Additionally, you may need to provide authentication and authorization credentials depending on the API's configuration.
