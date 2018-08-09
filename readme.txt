## The program is basic demonstration of Spring security using springboot
## Twp perations are just exposed , which can be access after login is successfull
## For this it needs to use some tool which can execure REST API's like CURL or Postman
##I used postman for testing and found it good one
## 
1- Below is the login URL managed by spring security expose as POST method
http://localhost:90/auth/login
To execute it, add two parameters

 i-  username
 ii- password

 The credentials can be seen from configuration file.
 
 2- after successfull execution, program allow to execute other two URI's exposed
 
 i- http://localhost:90/secure/user
 ii- http://localhost:90/secure/admin
 
 3- If login is not successfull, spring secruity woudn't allow access to above URI
 