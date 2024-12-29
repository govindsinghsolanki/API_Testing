package stepDefinations;

import java.io.IOException;

import io.cucumber.java.Before;

public class Hooks {

	AddPetStepDef addPetStepDef=new AddPetStepDef();
	
	@Before("@GetPet")
	public void beforeGetPetScenario() throws NumberFormatException, IOException {
		
		if(AddPetStepDef.petId==null) {
			addPetStepDef.as_user_add_new_pet_with_and("2000", "doggie2", "test@xyz", "pending");
			addPetStepDef.as_user_call_with_http_request("addNewPetAPI", "POST");
			addPetStepDef.gets_the_pet("");
		}
	}
	
	@Before("@DeletePet")
	public void beforeDeletePetScenario() throws NumberFormatException, IOException {
		
		if(AddPetStepDef.petId==null) {
			addPetStepDef.as_user_add_new_pet_with_and("2000", "doggie2", "test@xyz", "pending");
			addPetStepDef.as_user_call_with_http_request("addNewPetAPI", "POST");
			addPetStepDef.gets_the_pet("");
		}
	}
}
