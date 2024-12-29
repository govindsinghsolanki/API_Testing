Feature: Adding a new pet to the store

@AddPet	 @Regression
Scenario Outline: Add a new pet
  Given As user add new pet with "<id>" "<name>" "<photoUrls>" and "<status>"
  When  As user call "addNewPetAPI" with "POST" http request
  Then  the api call got success with status code 200
  And   "status" in response body is "<status>"
  And   gets the pet "id"
Examples:
  |id  |name    |photoUrls |status    |
  |1000|doggie1 |test@abc  |available |
  
  
@GetPet	 @Regression
Scenario: Get a pet by Add Pet ID
	Given As user find a pet based on "id" of Added Pet
	When  As user call "getPetAPI" with "GET" http request
	Then  the api call got success with status code 200
		

@DeletePet  @Regression
Scenario: Delete a pet by Pet Id
	Given As user delete a pet based on "id"
	When  As user call "deletePetAPI" with "DELETE" http request
	Then 	the api call got success with status code 200
	And   "message" in response body is "id"
	And   "type" in response body is "unknown"
  
@FindByStatus @Regression
Scenario Outline: Finds Pets by status
  Given  As user finds a pet based on "<status>"
  When   As user finds pets by "findPetByStatusAPI"
  Then   the api call got success with status code 200
Examples:
   |status     |
   |available  |
   
   
#@CreateUser
#Scenario Outline: Create list of users
#	Given Create user with "<id>" "<username>" "<firstname>" "<lastname>" "<email>"
#	When  As user call "createUserListAPI" with "POST" http request
#	Then  the api call got success with status code 200
#Examples:
#	 |id |username|firstname|lastname|email	 |
#	 |11 |test1	 |test2		 |test3		|test@abc|
  
 