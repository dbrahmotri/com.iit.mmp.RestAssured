package org.iitwforce.restassured.restassured;

import org.testng.AssertJUnit;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.response.ResponseBody;




public class GetNewlyAddedPetTest extends RestLibrary{
	AddNewPetTest pet=new AddNewPetTest();
	@Parameters({"petavailablestatus"})
		@Test(description="Finds Pets By Available Status",priority=1)
		
		public void validatefindByAvailableStatus(String petavailablestatus) throws Exception
		{//GET
		    
		    
			String requestURL = pro.getProperty("findnewpetstatus");
			requestURL= requestURL+petavailablestatus;
			pet.response = getServiceResponse(requestURL);
			SoftAssert sa = new SoftAssert();
			int expected = 200;
			int actual = pet.response.getStatusCode();
			//String responseBody = pet.response.asPrettyString();
			ResponseBody respBody = pet.response.getBody();
			System.out.println(pet.response.asString());
			String actualStatus = com.jayway.jsonpath.JsonPath.read(pet.response.asString(), "$.[0].status");
			System.out.println(actualStatus);
			String expectedStatus=petavailablestatus;
			AssertJUnit.assertEquals(actualStatus,expectedStatus);
			AssertJUnit.assertEquals(actual,expected);
			sa.assertAll();

		}
	
	@Parameters({"petpendingstatus"})
	@Test(description="Finds Pets By Pending Status",priority=2)

	public void validatefindByPendingStatus(String petpendingstatus) throws Exception
	{
		String requestURL = pro.getProperty("findnewpetstatus");
		requestURL= requestURL+petpendingstatus;
		pet.response = getServiceResponse(requestURL);
		SoftAssert sa = new SoftAssert();
		int expected = 200;
		int actual = pet.response.getStatusCode();
		//String responseBody = pet.response.asPrettyString();
		ResponseBody respBody = pet.response.getBody();
		System.out.println(pet.response.asString());
		String actualStatus = com.jayway.jsonpath.JsonPath.read(pet.response.asString(), "$.[0].status");
		System.out.println(actualStatus);
		String expectedStatus=petpendingstatus;
		sa.assertEquals(actualStatus,expectedStatus);
		sa.assertEquals(actual,expected);
		sa.assertAll();

	}
	@Parameters({"petsoldstatus"})
	@Test(description="Finds Pets By Sold Status",priority=3)

	public void validatefindBySoldStatus(String petsoldstatus) throws Exception
	{
		String requestURL = pro.getProperty("findnewpetstatus");
		requestURL= requestURL+petsoldstatus;
		pet.response = getServiceResponse(requestURL);
		SoftAssert sa = new SoftAssert();
		int expected = 200;
		int actual = pet.response.getStatusCode();
	    //String responseBody = pet.response.asPrettyString();
		ResponseBody respBody = pet.response.getBody();
		System.out.println(pet.response.asString());
		String actualStatus = com.jayway.jsonpath.JsonPath.read(pet.response.asString(), "$.[0].status");
		System.out.println(actualStatus);
		String expectedStatus=petsoldstatus;
		sa.assertEquals(actualStatus,expectedStatus);
		sa.assertEquals(actual,expected);
		sa.assertAll();

	}
}
