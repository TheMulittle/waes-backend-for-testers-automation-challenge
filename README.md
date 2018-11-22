<h1>backend-for-testers-automation</h1>

<h2>Used technologies</h2>

* **Gradle:** build management tool that uses a Groovy DSL for managing dependencies and build lifecycle
* **Cucumber:** BDD framework for writing stories and automated tests runner
* **Serenity:** framework for using RestAssured with BDD, responsible for generating the reports

Why to use a different stack than the front end test? Since the specifications used BDD, I assumed that BDD was a requirement,
thus Cucumber was applied for witting BDD and it nicely integrates with Serenity which gives a good report for RestAssured tests.
For example, when a step fails it is possible to check the HTTP content sent. 

<h2>What do I need to download?</h2>

You need to have JDK 8 installed and properly set in your `JAVA_HOME` environment variable.

No other tool is required

<h2>How to run it?</h2>

Within the root folder of the project, run following code in order to execute tests and generates a report in 
target/serenity/index.html

```
gradlew clean test aggregate
```

* `gradlew` invokes the gradle wrapper, it will download Gradle if needed, and then execute the tasks
* `clean` is a built-in task that erases build folder and `test` task executes the tests
* `aggregate` is a Serenity task responsible for creating the report 

<h2>Assumptions and choices</h2>

<h2>Defects found and possible defects</h2>

<h2> Unit tests analysis</h2>

They can be found [here](UT_Analysis/Analysis.md)


