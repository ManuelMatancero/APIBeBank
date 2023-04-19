# How to use UserController API

The UserController API provides various methods for performing CRUD operations on User objects. Below is a guide on how to use the API.

# Save a User object

To save a User object, you need to send a POST request to the /user/save endpoint with the User object as the request body. The API will then save the User object to the database.

Example:

``` POST /user/save

{
  "id": null,
  "name": "John",
  "email": "john@mail.com"
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

``` POST /user/login

{
  "user": "john.doe",
  "password": "password123"
} 
```

# Login a user with PIN

To login a user with a PIN, you need to send a POST request to the /user/pinlogin endpoint with the user's login credentials and PIN in the request body. The API will then check the user's credentials and PIN and return the user object if they are correct.

Example:

```POST /user/pinlogin

{
  "user": "john.doe",
  "password": "password123",
  "pin": "1234"
}
```


# List all User objects

To list all User objects, you need to send a GET request to the /user/list endpoint. The API will then return a list of all User objects in the database.

Example:

```GET /user/list
```

# Get a specific User object

To get a specific User object, you need to send a GET request to the /user/{id} endpoint with the user ID as a path parameter. The API will then return the User object with the specified ID.

Example:

```GET /user/1
```

# Delete a User object

To delete a User object, you need to send a DELETE request to the /user/delete/{id} endpoint with the user ID as a path parameter. The API will then delete the User object with the specified ID from the database.

Example:

```DELETE /user/delete/1
```

Note: In order to use the API, you need to have the necessary permissions and access to the API's endpoints. Additionally, you may need to provide authentication and authorization credentials depending on the API's configuration.