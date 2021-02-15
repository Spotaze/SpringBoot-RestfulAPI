# SpringBoot-RESTful WEB services
This is a project about RESTful services and http basic spring security.<p>
How to use it:<br>
Best way to use this project is with <i>Postman</i> makes it pretty simple to use.<br>
Also there is two accounts with USER and ADMIN roles. USER can see all saved users, find them by id, but ADMIN also can add and delete users.<br>
Use Basic Auth to access accounts: <strong>for USER role (username: user, password: user)</strong><br>
    <strong>ADMIN role (username: admin, password: admin)</strong>.<p>
Gives all users inside database:
```
localhost:8080/users
```
By id:
```
localhost:8080/users/{userId}
```
To add user authenticate with ADMIN role:
```
localhost:8080/users/add

body structure:
{
    "firstName":"something",
    "lastName":"something",
    "emailAddress":"something@gmail.com",
    "birthDate":"years-month-day"
}
```

To delete user you need to be with ADMIN role:
```
localhost:8080/users/delete/{userId}
```
If something won't work there will be error message body also with HTTP error.
