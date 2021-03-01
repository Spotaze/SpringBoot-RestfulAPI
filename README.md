# SpringBoot-RESTful WEB services
This is a project about RESTful services and http basic spring security.

## How to use

Best way to use this project is with Postman makes it pretty simple to use.
Also there is two accounts with USER and ADMIN roles. USER can see all saved users, find them by id, but ADMIN can add and delete users.

Use Basic Auth to access accounts for: 
<strong>USER role (username: user, password: user)</strong>
<strong>ADMIN role (username: admin, password: admin)</strong>.

### Requests
Gives all users inside database:
```
GET @ localhost:8080/users
```
By user id:
```
GET @ localhost:8080/users/{userId}
```
To add user authenticate with ADMIN role:
```
POST @ localhost:8080/users/add

body structure:
{
    "firstName":"something",
    "lastName":"something",
    "emailAddress":"something@gmail.com",
    "birthDate":"year-month-day"
}
```
To delete user you need to be with ADMIN role:
```
DELETE @ localhost:8080/users/delete/{userId}
```
If something won't work there will be error message with HTTP error.
