# Build the project docker
docker build -t greeting-app .

# To Run the project after build
docker run -it -d -p 5000:8080 greeting-app:latest

# To Demonstrate the API check
http://localhost:5000/swagger-ui.html

# Welcome to Telenor's take-home assignment
**Congratulations on making it this far! Great job!**
The purpose of this assignment is to give you an opportunity to demonstrate some code.
All the necessary information is contained in this file. 
There are no logical puzzles. The requirement is simple, but it is important to demonstrate clean code and good test coverage.
Do the absolute bare minimum work required for the application. Out of the box, configurations will do just fine.
There is no time limit, but it shouldn’t take more than 60-90min. 

In a basic Dockerized Springboot Maven application, develop a single REST endpoint GET /greeting which behaves in a manner that fulfills the following criteria:

1. Given the following input values account=personal and id=123 
and the allowable values for an account are personal and business
and the allowable values for id are all positive integers
then return "Hi, userId 123".

2. Given the following input values account=business and type=small and 
and the allowable values for an account are personal and business
and the allowable values for type are small and big
then return an error that the path is not yet implemented.

3. Given the following input values account=business and type=big and 
and the allowable values for an account are personal and business
and the allowable values for type are small and big
then return "Welcome, business user!".

We should be able to:
- build the application with Maven
- build the Docker image and run it
- make a request to localhost:5000/greeting and verify the behavior
Please provide an archive with the source code and a list of the terminal commands to build and run the application.