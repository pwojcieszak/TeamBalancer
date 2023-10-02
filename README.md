# TeamBalancer
The Team Balancer project is a Java application that divides a group of individuals into teams of equal size while attempting to balance the teams based on their "rate" attributes. It's a interview task from Software Mind. 
There are plenty of ways of executing test classes, I will describe just two of them. 

# Running test suite using Maven in Command Line
1. Open a command prompt or terminal window
2. Navigate to the root directory of project which is named "TeamBalancer" using the cd command. For example:
   
   `cd C:\Users\username\Desktop\TeamBalancer\`

   You can right-click on 'TeamBalancer' folder and choose 'Open file location'. File path is found under 'Location'. Paste it after 'cd' and add backslash '\'.
4. Once you are in the project directory, you can simply run the following command to execute all the tests in your Maven project:
    `mvn test`
5. Maven will start the testing process, and it will run all the tests in your project. You will see the test results in the command prompt or terminal window.


If you want to run a specific test class or a single test method, you can use the -Dtest option followed by the test class or method name. For example, to run test class named TeamTest, you can use the following command:
`mvn test -Dtest=TeamTest`

To run a specific test method within a test class, you can provide the full method name like this:
`mvn test -DTeamTest#ShouldAddMember`

# Running test suite using IntelliJ IDEA
1. Open the Project: Launch IntelliJ IDEA and open your Maven project which is in 'TeamBalancer' folder.
2. Navigate to Test Class: In the project explorer, navigate to the test class or test package you want to run. To find test classes go through these folders: src -> test -> java -> org -> example -> here are test classes.
3. Right-Click on Test Class: Right-click on the test class or package, and you will see a context menu. 
4. Select "Run" or "Debug": Choose "Run" or "Debug" from the context menu, depending on whether you want to run the tests with or without debugging.
5. View Test Results: IntelliJ IDEA will execute the tests, and you can see the results in the "Run" or "Debug" tool window at the bottom of the IDE. Successful tests will be marked with a green checkmark, and any failures or errors will be displayed with details.
