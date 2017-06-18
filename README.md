# sortingapp
#Client side is based on AngularJS , & server side is based on Spring REST API.
#AngularJS encapsulated within plain JSP on front-end, communicating asynchronously with server using $http service.
Following technologies being used:

Spring 4.3.1.RELEASE
AngularJS 1.4.4
Maven 3
JDK 1.6+
Spring Source tool suite
Tomcat 7
Configure Java_HOME and path variable 
Configure M2e_HOME and path variable
Import the project as a Maven Faceted java project.
Add the dependency artificats in POM.XML and Enable Maven dependency management from your IDE.
This will load all dependencies required for the project.

Create a new war file via maven command line( mvn clean install).

 Here i am using Tomcat, i will simply put this war file into tomcat webapps folder and click on startup.bat inside tomcat/bin directory.
 
 App steps:
             Click the Generate button to generate a random set of numbers.
            Also, On click of the Generate button a rest service call will be made to fetch if any previous sort record exists if there it will return the records.
             Click the Sort button to sort the random numbers generated.
            Also, On click of the sort button a rest service call will be made to update the new sort records with the existing sort records.
             
