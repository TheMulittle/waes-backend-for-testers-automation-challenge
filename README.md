# backend-for-testers-automation

## Used technologies

* `Gradle:` build management tool that uses a Groovy DSL for managing dependencies and build lifecycle
* `Cucumber:` BDD framework for writing stories and automated tests runner
* `Serenity:` framework for using RestAssured with BDD, responsible for generating the reports

Why to use a different stack than the front end test? Since the specifications used BDD, I assumed that BDD was a requirement,
thus Cucumber was applied for writing BDD and it nicely integrates with Serenity which gives a good report for RestAssured tests.
For example, when a step fails it is possible to check the HTTP content sent. 

## What do I need to install?

You need to have JDK 8 installed and properly set in your `JAVA_HOME` environment variable.

No other tool is required

## How to run it?

Within the root folder of the project, run following code in order to execute tests and generates a report in 
target/serenity/index.html

```
gradlew clean test aggregate
```

* `gradlew` invokes the gradle wrapper, it will download Gradle if needed (that's why the first execution may take a while)
, and then execute the tasks
* `clean` is a built-in task that erases build folder and `test` task executes the tests
* `aggregate` is a Serenity task responsible for creating the report 

## Assumptions and choices

* I assumed that all the fields were mandatory based in the UI behavior

## Defects found and possible defects

Defects can be found under [docs/Back End Report.pdf](docs/Back End Report.pdf)

## Possible improvements

* Some parameter validations should performed. Whenever we send an invalid field the status code is 400 but the error
message is "Data format is not correct: Error deserializing object from entity stream.". This doesn't tell the API user
what field was wrong when what is wrong with the field. Is it the length? Is a parameter missing? Is it too short? 
Which parameter failed?

* Define field maximum and minimum 


## Unit tests analysis

They can be found [here](docs/UT_Analysis/Analysis.md)


