package stepDefinations;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.AddPetDetails;
import pojo.Category;
import pojo.Tags;
import utilities.APIResource;
import utilities.TestDataBuild;
import utilities.Utility;

public class AddPetStepDef extends Utility{
	RequestSpecification reqSpec;
	ResponseSpecification resSpec;
	Response response;
	static String petId;
	TestDataBuild data=new TestDataBuild();

	
	@Given("As user add new pet with {string} {string} {string} and {string}")
	public void as_user_add_new_pet_with_and(String id, String name, String photoUrls, String status) throws NumberFormatException, IOException {
		 reqSpec=RestAssured.given().spec(requestSpecification())
				 .body(data.addPetDetailsPayLoad(Integer.parseInt(id),name,photoUrls,status));
	}

	
	@When("As user call {string} with {string} http request")
	public void as_user_call_with_http_request(String resource, String httpMethod){
		String resourceAPI = APIResource.valueOf(resource).getResource();
		if(httpMethod.equalsIgnoreCase("POST"))	{
		response= reqSpec.when().post(resourceAPI);
		}
		else if(httpMethod.equalsIgnoreCase("GET")) {
		response= reqSpec.when().get(resourceAPI+"{petId}"); 	
		}
		else if(httpMethod.equalsIgnoreCase("DELETE")) {
		response= reqSpec.when().delete(resourceAPI+"{petId}");
		}

//		resSpec= new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();

	}
	
	@Then("the api call got success with status code {int}")
	public void the_api_call_got_success_with_status_code(Integer statusCode) {
		System.out.println("Respone code is: "+response.getStatusCode());	
	    Assert.assertEquals(200,response.getStatusCode());
	    
//		response.then().spec(resSpec).extract().response(); 
	}
	
	@Then("{string} in response body is {string}")
	public void in_response_body_is(String key, String expectedValue) {
		 if(expectedValue.equals("id")) {
			
			 expectedValue=petId;
		 }
	     Assert.assertEquals(getJsonPath(response,key), expectedValue);
	}

	
	@Then("gets the pet {string}")
	public void gets_the_pet(String string) {
		System.out.println("Getting id based on POST respone");		
		petId=getJsonPath(response,"id");
		System.out.println("Pet Id is :"+petId);
//		as_user_call_with_http_request(resource,"GET");
//	    String actualName=getJsonPath(response,"name");
//	    Assert.assertEquals(actualName,expectedName);
	}

	
	@Given("As user find a pet based on {string} of Added Pet")
	public void as_user_find_a_pet_based_on_of_added_pet(String string) throws IOException {
		System.out.println("Now getting id from post response and adding here as pathParam in GET API");
		reqSpec=RestAssured.given().spec(requestSpecification()).pathParam("petId",petId);
	}

	@Given("As user delete a pet based on {string}")
	public void as_user_delete_a_pet_based_on(String string) throws IOException {
		System.out.println("Now getting id from post response and adding here as pathParam in DELETE API");
	    reqSpec=RestAssured.given().spec(requestSpecification()).pathParam("petId", petId);
	}
	
	@Given("As user finds a pet based on {string}")
	public void as_user_finds_a_pet_based_on(String statusValue) throws IOException {
		System.out.println("############################## Find pet based on status ################################");
	    reqSpec=  RestAssured.given().spec(requestSpecification()).queryParam("status", statusValue);
	} 
	@When("As user finds pets by {string}")
	public void as_user_finds_pets_by(String resource) {
	  String apiResource= APIResource.valueOf(resource).getResource();
	  response=reqSpec.when().get(apiResource);
	}
	
	@Given("Create user with {string} {string} {string} {string} {string}")
	public void create_user_with(String id, String username, String firstName, String lastName, String email) throws NumberFormatException, IOException {
//		reqSpec=RestAssured.given().spec(requestSpecification()).body(data.createUserPayload(Integer.parseInt(id), username, firstName, lastName, email));
	}
	


}