# restapitest

This project is test task for DINS.  

It's contains test suite for check the work of resource at https://platform.devtest.ringcentral.com/restapi.  
Positive test contains the test-methods for checking the serverVersion, serverRevision and releaseDate fields when the data is correctly entered.  
Negative test contains the test-methods for check that the system correctly work with incorrect action, like load unavailable page.  

To run test via Maven, issue this command : mvn test  
To run single PositiveTest, issue this command : mvn -Dtest=PositiveTest test  
To run single NegativeTest, issue this command : mvn -Dtest=NegativeTest test  
