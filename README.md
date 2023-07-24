# SpringMVC_microservices_Accelerator-

Its a accelerator of micro service which have two jar file :
1 : Connection Provider : its provide database connection , Generic Dao classes and POJO files.
2 : Registration : Its RegistrationServer which register client server.
3 : Signup : Its Provides SignupServer client and restful webservices.
4 : Signin : Its Provides SigninServer client and restful webservices.
5 : Web    : Its consumes restful webservice and UI.


## Using an IDE

You can run the system in your IDE by running the four servers in order: _RegistrationService_, _SignupService_,_SigninService_ and _WebService_.

Open the Eureka dashboard [http://localhost:1111](http://localhost:1111) in your browser to see that the `SIGNIN-SERVICE` `SIGNUP-SERVICE` , and `WEB-SERVICE` applications have registered.  Next open the Home Page [http://localhost:4444](http://localhost:4444)links.

The `localhost:4444` web-site is being handled by a Spring MVC Controller in the _WebService_ application.

## Database changes
do the needful changes in application.properties and create DB accourdingly. 

## Command Line

You may find it easier to view the different applications by running them from a command line since you can place the four windows side-by-side and watch their log output

To do this, open three CMD windows (Windows) or four Terminal windows (MacOS, Linux) and arrange so you can view them conveniently.

 1. In each window, change to the directory where you cloned the demo.
 2. In the first window, build the application using "mvn clean package" in root folder "SpringMVC_Microservice_Accelerator".
 3. In the first window
		 go inside folder  "SpringMVC_Microservice_Accelerator-registrationServer and then 
		 run: "java -jar target/registration.jar registration"
 4. Switch to the second window 
		 go inside folder  "SpringMVC_Microservice_Accelerator-signup" and then
		 run: "java -jar target/signup.jar signup"
		 
 5. Switch to the third window and 
		 go inside folder  "SpringMVC_Microservice_Accelerator-signin" and then
		 run: "java -jar target/signin.jar signin"
		 
 6. In the fourth window
		 go in folder  "SpringMVC_Microservice_Accelerator-web" and then
		 run: "java -jar target/web.jar web"
		 
 1. In your favorite browser open the same two links: [http://localhost:1111](http://localhost:1111) and [http://localhost:4444](http://localhost:4444)


You should see servers being registered in the log output of the first (registration) window.
As you interact you should logging in the second, third and fourth windows.

 1. In a new window, run up a second account-server using HTTP port 2223:
     * "java -jar target/singin.jar accounts 2223"
 1. Allow it to register itself
 1. Kill the first singin-server and see the web-server switch to using the new signin-server - no loss of service.