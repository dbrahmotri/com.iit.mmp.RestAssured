package org.iitwforce.restassured.restassured;

import org.testng.annotations.Test;


public class UpdateNewlyAddedPetTest extends RestLibrary {
	AddNewPetTest petp=new AddNewPetTest();
	
	@Test(description="Updatinging existing Pet")
	public void validateUpdateExistingPet() throws Exception
	{

		String requestURL = pro.getProperty("updateexistpet");
		
		String payloadString=	readPayload("UpdateExisting_Payload.txt");
		petp.response = updateServiceResponse(requestURL,payloadString);
		
		System.out.println(petp.response.getStatusCode());//printing status code=200
		System.out.println(petp.response.prettyPrint());
		//ResponseBody respBody = petp.response.getBody();
		//String actual = respBody.asString();
		//System.out.println("Response Body" + actual);//printing the Response body
		
		//String dogName = com.jayway.jsonpath.JsonPath.read(petp.response.asString(), "$.name");
		//System.out.println(dogName);//printing dogname
		
	}
	
}
