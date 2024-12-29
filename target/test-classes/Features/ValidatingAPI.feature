 #Feature: Validating Place API's
#Scenario: Verify if Place is being successfully added using AddPlaceAPI
#	Given Add Place Payload
#	When User call "AddPlaceAPI" with Post http request
#	Then the api call got success with status code 200
#	And "status" in response body is "OK"
#	And "scope" in response body is "APP"

#Feature: Validating Place API's
#@AddPlace
#Scenario Outline: Verify if Place is being successfully added using AddPlaceAPI
#	Given Add Place Payload "<Name>" "<Language>" "<Address>"
#	When User call "AddPlaceAPI" with "Post" http request
#	Then the api call got success with status code 200
#	And "status" in response body is "OK"
#	And "scope" in response body is "APP"
#	And  Verify place_Id create to maps to "<Name>" using "getPlaceAPI" 
#
#																												
#Examples:
#| Name | Language | Address  |
#| AAAA | English   | Banglore |
#| BBBB | Hindi		 | New Delhi |
#
#	