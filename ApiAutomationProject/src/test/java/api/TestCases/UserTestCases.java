package api.TestCases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.Payload.UserPojo;
import api.endPoints.UserEndPoints;
import api.endPoints.UserEndPointsByUsingPropertyFile;
import io.restassured.response.Response;

public class UserTestCases {
	
	UserPojo payLoad;
	Faker faker;
	/*
	 * "id": 0,
	  "username": "string",
	  "firstName": "string",
	  "lastName": "string",
	  "email": "string",
	  "password": "string",
	  "phone": "string",
	  "userStatus": 0
	  */
	@BeforeClass
	public void setUp() {
		payLoad = new UserPojo();
		faker = new Faker();
		payLoad.setId(faker.idNumber().hashCode());
		payLoad.setUsername(faker.name().username());
		payLoad.setFirstname(faker.name().lastName());
		payLoad.setEmail(faker.internet().emailAddress());
		payLoad.setPassword(faker.internet().password());
		payLoad.setPhone(faker.number().toString());
		payLoad.setUserStatus(0);
		
	}
	

	@Test(priority=1)
	public void postUser(){
		Response response = UserEndPointsByUsingPropertyFile.createUser(payLoad);
		Assert.assertEquals(response.statusCode(), 200);
		
		
	}
	
	
	// @Test(priority=2)
	public void getUser(){
		Response response = UserEndPoints.getUserDetails(payLoad.getUsername());
		Assert.assertEquals(response.getStatusCode(), 200);
		Assert.assertEquals(response.getBody().jsonPath().get("username"), payLoad.getUsername());
		
	}
	
	// @Test(priority=3)
	public void updateUser(){
		payLoad.setId(faker.idNumber().hashCode());
		payLoad.setFirstname(faker.name().lastName());
		payLoad.setEmail("Email.com");
		payLoad.setPassword("Gouda@123");

		Response response = UserEndPoints.UpdatingUser(payLoad, payLoad.getUsername());
		Assert.assertEquals(response.getStatusCode(),200);
		
		Response responseAfterUpdate = UserEndPoints.getUserDetails(payLoad.getUsername());
		Assert.assertEquals(responseAfterUpdate.getStatusCode(), 200);
		Assert.assertEquals(responseAfterUpdate.getBody().jsonPath().get("username"), payLoad.getUsername());
		
	}
	
	
	// @Test(priority=4)
	public void deleteUser(){
	Response response	= UserEndPoints.deleteUser(payLoad.getUsername());
	Assert.assertEquals(response.getStatusCode(), 200);
	response.then().log().all();
		
	}
}
