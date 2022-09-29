## **Trivia Game**

A basic REST API that serves up a random unique trivia question to users. Users will always see unique questions that they have not answered yet unless they have attempted each question. Their answers are stored in a log. The program deliverables, technical requirements, and building processes and notes are included below.

## Deliverables:

- The unique identifier has been pre-assigned based on the assumption, in this example, it has been preset to id: 1.

- Each request refresh will generate a random question from the list which excludes answered questions.

- A set of database values have been stored and defined in the database. These can also be within each module's Config file. e.g. TriviaConfig file showcases 4 different questions that have been created.

- Basic tests are included to showcase some CRUD functionality. Due to time constraints, not all relevant tests were conducted however the general process is showcased.

## Technical Requirements:

- Java Spring Boot was selected as the runtime and framework of choice.

- A build file (.jar) within the target can be found to run the backend.

- PostgreSQL was the database of choice.

- A fundamental UI was created to interact with the REST requests and in order to trigger POST responses in order to log the questions that are attempted.

## **Getting Started**

- It is assumed you have Postgres and all relevant Java development software installed. e.g using IntelliJ

Create a Postgres database named 'triviadb' with username: postgres and password: password. In order to run the program to see the REST API in action, run the .jar executable found in the target file in the backend. This build will automatically create all relevant tables needed within the database. 

- A database dump is included within the database folder. This is not necessary if the above step is completed successfully. However, a database dump is provided to allow you to restore the database to its initial condition stored here. The following link will explain how to restore the database from the dump: https://www.educba.com/postgres-dump-database/

## **Note**

Direct your terminal into the frontend folder, backend > src > main > frontend to start the development React server using 'npm start'. In the instance that the localhost:3000 server does not present information. Possibly shut down the build executable of the backend and restart it from within an IDE to have an active instance that communicates with the UI. As the UI is an added option, the build creation was not developed to a high standard for the React app and is solely to showcase random questions and submit POST responses, solely to showcase development.

## **Next Steps**

- The next step would be finalising the frontend to have more functionality.

- Creating a REST interface to manage the different aspects of the API's.

- Hosting the application. Possible methods could be using AWS API Gateway to host the API's along with Lambda functions that trigger requests to interact with the hosted frontend, possibly using S3 buckets.

## **Security consideration**

- As the production is still in development, security has not been prioritised for now. For example, the CORS policy allows access from all endpoints instead of adding a proxy to them to manage and control the access points.

- Spring boot security dependency should be used to manage access and viewpoints.

- Within start-up, if the user has not logged in, any URL requests will be interrupted.

- All users and their account creations, will have their passwords encrypted (using BCrypt for example) before being stored on the database. 

- The database username, password, and API endpoints should all be stored in environment variables to ensure they are not visible to the public.

## **Future scaling**

- Once the application is live and hosted on the cloud, being safely accessible by anyone. The trivia game will need to be further developed. Creating a multiplayer mode where friends can play against each other by answering random questions within a certain category is functionality that could help drive interest and engagement.

- From the development side, hosting the application on a cloud provider such as AWS, Google or Azure for example will enable rapid scalability. Using AWS for example, a serverless pay-as-you-use architecture can be developed that allows the application to rapidly adjust according to its user base with extremely low downtime. 
