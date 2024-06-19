# project 
- [Ejada - BDD + RestAssured]
## Prerequisites
- Java 22
- Maven
- TestNG
- cucumber
- restAssured

## project structure
- feature files : src/test/java/resources/features
- website pages : src/test/java/org/ejadaTest/Pages
- cucumber runner : src/test/java/org/ejadaTest/runners
- Step definitions : src/test/java/org/ejadaTest/stepDefinitions
- RestAssure Tests : src/test/java/org/ejadaTest/RestAssuredTest

## Project coverage 
- Feature : Login
  * login using 4 different incorrect data across chrome and firefox browsers
- Feature : Order Cycle
  * login with valid creds
  * add items to cart
  * validate cart
  * validate checkout
  * validate checkout over view
  * validate finish
 
- RestAssured : cover all available API in the Demo project
  1. `testGetStatus`
  2. `testGetBooks`
  3. `testAutherization`
  4. `singleBook`
  5. `orderBook`
  6. `getOrdersList`
  7. `getSingleOrder`
  8. `patchOrder`
  9. `deleteOrder`
##
## for Appium project, I have No experience in build automation for Mobile app and I didn't have enough time to learn in the available time 
