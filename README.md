# Credit Card Management Application

## Overview
This application exposes the REST apis to add and retrieve credit card details. API definitions are generated using
OpenAPI v3 specification by running a gradle build task openApiGenerate. Specification is version controlled and defined
under specs folder.

Minimum requirement to build and run the application is > java 1.8 and gradle 6

Start the spring boot application by running the main java class CreditCardMgmtApplication from the IDE or first build the
project and run the jar file generated under build/lib folder from terminal java -jar <jar_name>

You can view the api documentation in swagger-ui by pointing to base URL
http://localhost:8080/

Change default port value in application.yml
