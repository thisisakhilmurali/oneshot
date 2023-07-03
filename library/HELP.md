---
Project description:

The government is building a centralized library management system which involves a micro-service, allowing people to issue books and return them at the right time.

Library management requires creating users and renewing user subscriptions via authenticated processes. Secure create-user and renew-user-subscription APIs with Spring Security. The API issue-book should be permitted for everyone. This micro-service should be built using the Spring Boot REST API framework and it should connect to the database using the JPA API and secure methods using Spring Security.



In this task, implement 3 APIs for which the details are given below:

1. /api/v1/create-user [POST]: Simple user save method in an authenticated manner
2. /api/v1/issue-book [POST]: Send issue, check if users subscribed(see subscribed field in User entity), otherwise throw SubscriptionExpiredException- permitAll
3. /api/v1/renew-user-subscription/{id} [GET]: Send userId, set user subscription to true in an authenticated manner.


Your task is to complete the files given below:
1. src/main/java/com/wecp/library/controller/LibraryController.java
2. src/main/java/com/wecp/library/security/WebSecurityConfigurer.java
3. src/main/java/com/wecp/library/repository/UserRepository.java
4. src/main/java/com/wecp/library/repository/IssueRepository.java


You can find blank jpa repositories here:

1. src/main/java/com/wecp/library/repository/UserRepository.java
2. src/main/java/com/wecp/library/repository/IssueRepository.java


Notes:

1. Implementation related specifics are added directly as javadocs in the workspace.
2. Ensure that the structure and datatypes of the APIs are followed as specified in the comments to ensure that the code is evaluated correctly.

Testing & Submitting your code:

Step 1: Click on the WeCP Projects Button. 
Step 2: Write your code to complete the tasks and click on the Test and Submit App to execute your code and confirm if the application is working as expected. 
Step 3: Click on the Test and Submit App button to execute your code. You will be given a congratulations message if your code is working perfectly.
Step 4: You will be given a string url on clicking on Show testing url button. Append your api endpoints to the end of this string url to test your API endpoints on thunderclient. 
Step 5: Use the Run App button to start the application before performing api testing.