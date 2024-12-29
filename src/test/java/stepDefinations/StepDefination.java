/*
 * package stepDefinations;
 * 
 * import java.io.FileNotFoundException; import java.io.IOException;
 * 
 * import io.cucumber.java.en.Given; import io.cucumber.java.en.Then; import
 * io.cucumber.java.en.When; import io.restassured.RestAssured; import
 * io.restassured.builder.ResponseSpecBuilder; import
 * io.restassured.http.ContentType; import io.restassured.path.json.JsonPath;
 * import io.restassured.response.Response; import
 * io.restassured.specification.RequestSpecification; import
 * io.restassured.specification.ResponseSpecification; import
 * junit.framework.Assert; import resource.APIResource; import
 * resource.TestDataBuild; import resource.Utility;
 * 
 * public class StepDefination extends Utility{
 * 
 * RequestSpecification reqspec; ResponseSpecification resspec; Response
 * response; TestDataBuild data=new TestDataBuild(); //Utility u=new Utility();
 * 
 * @Given("Add Place Payload {string} {string} {string}") public void
 * add_Place_Payload(String name, String language, String address) throws
 * IOException { System.out.println(language); // Write code here that turns the
 * phrase above into concrete actions
 * reqspec=RestAssured.given().spec(requestSpecification()).body(data.
 * addPlacePayLoad(name,language,address)); }
 * 
 * //@Given("Add Place Payload") //public void add_Place_Payload() throws
 * IOException { // // Write code here that turns the phrase above into concrete
 * actions // RestAssured.baseURI="https://rahulshettyacademy.com"; //
 * reqspec=RestAssured.given().spec(requestSpecification()).body(data.
 * addPlacePayLoad()); //}
 * 
 * 
 * @When("User call {string} with {string} http request") public void
 * user_call_with_http_request(String resource, String method) { // Write code
 * here that turns the phrase above into concrete actions resspec=new
 * ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.
 * JSON).build();
 * 
 * //Constructor will be invoked with value of resource which we pass ex.
 * resource="AddPlaceAPI" APIResource resourceAPI=APIResource.valueOf(resource);
 * System.out.println(resourceAPI.getResource());
 * 
 * if(method.equalsIgnoreCase("POST"))
 * response=reqspec.when().post(resourceAPI.getResource()); else
 * if(method.equalsIgnoreCase("GET"))
 * response=reqspec.when().get(resourceAPI.getResource())
 * .then().spec(resspec).extract().response(); //Remove hard code //
 * response=reqspec.when().post("/maps/api/place/add/json") //
 * .then().spec(resspec).extract().response(); }
 * 
 * @Then("the api call got success with status code {int}") public void
 * the_api_call_got_success_with_status_code(Integer int1) { // Write code here
 * that turns the phrase above into concrete actions
 * Assert.assertEquals(response.getStatusCode(),200); }
 * 
 * @Then("{string} in response body is {string}") public void
 * in_response_body_is(String keyValue, String expectedValue) {
 * Assert.assertEquals(getJsonPath(response,keyValue), expectedValue); }
 * 
 * @Then("Verify place_Id create to maps to {string} using {string}") public
 * void verify_place_Id_create_to_maps_to_using(String expectedName, String
 * resource) throws IOException { //RequestSpec String
 * place_id=getJsonPath(response,"place_id");
 * reqspec=RestAssured.given().spec(requestSpecification()).queryParam(
 * "place_id",place_id); user_call_with_http_request(resource,"GET"); String
 * actualName=getJsonPath(response,"name");
 * Assert.assertEquals(actualName,expectedName); } }
 */