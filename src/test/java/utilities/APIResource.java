package utilities;

//enum is class in java which has collection of constants and methods
public enum APIResource {

	AddPlaceAPI("/maps/api/place/add/json"),
	getPlaceAPI("/maps/api/place/get/json"),
	deletePlaceAPI("/maps/api/place/delete/json"),
	addNewPetAPI("/v2/pet"),
	getPetAPI("/v2/pet/"),
	deletePetAPI("/v2/pet/"),
	findPetByStatusAPI("/v2/pet/findByStatus"),
	createUserListAPI("/v2/user/createWithList");
	
	
	 private final String resource;
	
	APIResource(String resource)
	{
		this.resource=resource;
	}
	
	public String getResource()
	{
		return resource;
	}
}
