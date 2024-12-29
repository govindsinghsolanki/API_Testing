package stepDefinations;
import java.util.ArrayList;
import java.util.List;
import io.restassured.RestAssured;
import pojo.AddPetDetails;
import pojo.Category;
import pojo.Tags;

public class Test {
	
	public static void main(String[] args) {
		AddPetDetails ap=new AddPetDetails();
		ap.setId(100);
		
		Category category=new Category();
		category.setId(1);
		category.setName("string1");
		ap.setCategory(category);
		ap.setName("Doggie1");	

		List<String> photoUrl=new ArrayList<String>();
		photoUrl.add("test@abc");
		ap.setPhotoUrls(photoUrl);
		
		
		Tags tag=new Tags();
		tag.setId(1);
		tag.setName("string1");
		
		List<Tags> tagList=new ArrayList<Tags>();
		tagList.add(tag);
		ap.setTags(tagList);
		
		ap.setStatus("available");
		
		RestAssured.baseURI="https://petstore.swagger.io";
		AddPetDetails addPetDetails=RestAssured.given().log().all().header("Content-Type","application/json").body(ap)
		.when().post("/v2/pet").then().log().all().extract().response().as(AddPetDetails.class);
		
		System.out.println("Id is: "+ap.getId());
		System.out.println("Category id is: "+ap.getCategory().getId());
		System.out.println("Category name is: "+ap.getCategory().getName());
		System.out.println("Name is :"+ap.getName());
		System.out.println("Photo url is:");
		for(int i=0;i<ap.getPhotoUrls().size();i++) {
			System.out.println("Photo url is:"+ap.getPhotoUrls().get(i));
		}
		
		List<Tags>getTagList=ap.getTags();
		for(int i=0;i<getTagList.size();i++) {
			System.out.println(getTagList.get(i).getId());
			System.out.println(getTagList.get(i).getName());
		}
		System.out.println(ap.getStatus());
		
		RestAssured.given().log().all().pathParam("id",155).
		when().get("/v2/pet/{id}").then().log().all().extract().response();
		
	}
	
	

	
}
