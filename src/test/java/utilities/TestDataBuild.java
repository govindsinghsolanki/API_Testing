package utilities;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import pojo.AddPetDetails;
import pojo.AddPlace;
import pojo.Category;
import pojo.CreateUser;
import pojo.Location;
import pojo.Tags;
import pojo.UserData;

public class TestDataBuild {

	public AddPlace addPlacePayLoad(String name,String lanaguage,String address)
	{
		AddPlace p=new AddPlace();
		
		p.setAccuracy(50);
		p.setAddress(address);
		p.setLanguage(lanaguage);
		p.setName(name);
		p.setPhone_number("\"(+91) 983 893 3937");
		p.setWebsite("http://google.com");
		
		List<String> list=new ArrayList<String>();
		list.add("shoe park");
		list.add("shop");
		p.setTypes(list);
		Location l=new Location();
		l.setLat(-38.383494);
		l.setLng(33.427362);
		p.setLocation(l);
		return p;	
	}
	
	public AddPetDetails addPetDetailsPayLoad(int id,String name,String photoUrls,String status) {
		AddPetDetails addPetDeatils=new AddPetDetails();
		addPetDeatils.setId(id);
		Category category=new Category();
		category.setId(1);
		category.setName("string1");
		addPetDeatils.setCategory(category);
		addPetDeatils.setName(name);	
		List<String> photoUrl=new ArrayList<String>();
		photoUrl.add(photoUrls);
		addPetDeatils.setPhotoUrls(photoUrl);
		
		Tags tag=new Tags();
		tag.setId(1);
		tag.setName("string1");	
		List<Tags> tagList=new ArrayList<Tags>();
		tagList.add(tag);
		addPetDeatils.setTags(tagList);
		
		addPetDeatils.setStatus(status);
		return addPetDeatils;
	}
	
	public void createUserPayload(int id, String username, String firstName, String lastName, String email) {
		UserData userData=new UserData();
		
		CreateUser createUser=new CreateUser();
		createUser.setId(id);
		createUser.setUsername(username);
		createUser.setFirstName(firstName);
		createUser.setLastName(lastName);
		createUser.setEmail(email);
		createUser.setPassword("string");
		createUser.setPhone("string");
		createUser.setUserStatus("string");
		
		List<CreateUser> createUserList=new ArrayList<>();
		createUserList.add(createUser);
		userData.setCreateUser(createUserList);
//		
//		ObjectMapper objectMapper = new ObjectMapper();
//		objectMapper.readValue(createUser, new TypeReference<List<CreateUser>>(){});
//		objectMapper.readValue(createUser,UserDatas[].class);
		
//		return createUserList;
	}
}


