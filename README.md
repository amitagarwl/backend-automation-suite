# backend-automation-suite
An automation framework for backend API's

Libraries being used:
1. TestNG  
2. Lombok 
3. JDBI
4. REST-assured

Package Structure:
> concurrency
  - ConcurrencyTest.java uses the thread pool executor ( ExecutorService ) along with the @DataProvider feature of testng to execute           concurrency test cases, the model being used by this class is defined in the model package.
    
    http://tutorials.jenkov.com/java-util-concurrent/threadpoolexecutor.html
    
    http://testng.org/doc/
    
> config
  - Endpoints and Db credentails from the automation.yml file are mapped to Config.java and DbConfig.java class using the Lombok library,
    this avaoids any boilerplate code.
    
    https://projectlombok.org/
> dao
  - MyDao.java interface has collection of abstract methods being used to Query database.
    
    http://jdbi.org/
> model
  - DummyModel.java is the model defined for one of the API's being used in ConcurrencyTest.java class. This should hold all the POJO's.
> restclient
  - RestClient.java defines all the static methods which supports GET and POST requests.
    
    https://github.com/rest-assured/rest-assured/wiki/Usage
> test
  - This package should have all your test classes, can be grouped based on feature or API. Several features of TestNG can be used to 
    make a very powerful and easier to use automation suite,
    
    http://testng.org/doc/documentation-main.html
> utils
  - This package can have various utility classes, example: Constants.java

BaseTest.java
  -- This is where you read the configs from automation.yml, make a db connection before running your main test classes 
     ( using @BeforeSuite ) and finally close your connection once all your test cases has been executed ( using @AfterSuite )
     
All the test class that needs to executed should be added to testng.xml

resources directory has codeCoverage directory which has the required steps to generate code coverage report for your Offline instrumented Jar.



    

