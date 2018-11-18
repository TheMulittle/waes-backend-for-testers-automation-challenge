**Coverage**

The project has a good code coverage (65% of line coverage). One point that I'd like to highlight is that, in my opinion, POJO's shouldn't be targeted by Unit Tests. They have only setters and getters and almost all IDE's can generate them. Also, there are other tools such as Lombok that can be used. We should focus on business logic instead. 

**Mutation Coverage**

I've added Pitest (http://pitest.org/) in the project to check the mutation coverage. Mutation tests let us know how good our tests are by running our unit tests against modified versions of our code. If nothing fails, the mutation is tagged as "SURVIVED" and this means that we do not have good coverage for that specific line. Pitest was run, considering only business logic classes, and the mutation coverage stayed at 63% which is reasonable, but can be improved. The report in this folder (report.html) contains the result.

**Test strategy/efficiency**

The unit tests names are using a pattern of expectation_condition() which is solid. UserService is being instantiated in every test, perhaps it could be moved to a @BeforeEach section, just to make the other tests shorten.

The Resouces classes are not being tested, indicating that integration tests should be created to validate system behavior to invalid user inputs (such as blank emails, emails without @, etc.). Even though those validations are made in the frontend, it is still necessary to validate them in the backend. One can check the calls performed by the frontend and replicate such calls with invalid data. Also, it is possible that third-party software will leverage the API and there is no guarantee that their frontend/services will send sanitized data.
