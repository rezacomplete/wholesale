# ANZ wholesale code test
Test application for ANZ <br/>
Please run by building the application using Maven first (mvn clean package). <br/>
Then run using (java -jar target/wholesale-1.jar) <br/>
You can retrieve book information by calling the Rest API like below:<br>
<b>http://localhost:8080/api/v1/customers/123/accounts</b> <br>
You can access the swagger from the postman using:<br>
<b>http://localhost:8080/v2/api-docs </b> <br>
You can access the swagger UI from the browser using:<br>
<b>http://localhost:8080/swagger-ui.html </b> <br>
<br>
<b>Assumptions:</b> <br>
It does not use any database and all the accounts and transactions are hard coded in the repository. <br>
Security user is also hardcoded in the SecurityConfig <br>
It uses basic http security model which requires the username and password to be in the request header for each API call <br>
The username is <b>customer</b> and the password is <b>password</b>