package org.iitwforce.restassured.restassured;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class AddNewPetTest extends RestLibrary {//POST
	protected Response response;
	
	@Test(description="Adding a new Pet")
	public void validateAddNewPet() throws Exception
	{

		String requestURL = pro.getProperty("addnewpet");
		
		String payloadString=	readPayload("AddNewPet_Payload.txt");
		response = postServiceResponse(requestURL,payloadString);
		
		System.out.println(response.getStatusCode());//printing status code=200
		//System.out.println(response.prettyPrint());
		ResponseBody respBody = response.getBody();
		String actual = respBody.asString();
		System.out.println("Response Body" + actual);//printing the Response body
		
		String dogName = com.jayway.jsonpath.JsonPath.read(response.asString(), "$.name");
		System.out.println(dogName);//printing dogname
		
	}
	
	
}
