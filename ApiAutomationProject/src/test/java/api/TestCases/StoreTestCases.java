package api.TestCases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.Payload.StorePojo;
import api.endPoints.StoreEndPoints;
import io.restassured.response.Response;

public class StoreTestCases {
	
	Faker faker;
	StorePojo payLoad;
	
	@BeforeClass
	public void setUp() {
		/* {
			  "id": 0,
			  "petId": 0,
			  "quantity": 0,
			  "shipDate": "2024-01-08T15:22:22.576Z",
			  "status": "placed",
			  "complete": true
			}*/
		
		faker = new Faker();
		payLoad = new StorePojo();
		
		payLoad.setId(faker.idNumber().hashCode());
		payLoad.setPetId(faker.idNumber().hashCode());
		payLoad.setQuantity(faker.idNumber().hashCode());
		payLoad.setShipDate(faker.date());
		payLoad.setStatus("placed");
		payLoad.setComplete(true);
		
	}
	
	
	@Test
	public void createStore() {
		Response response = StoreEndPoints.createStore(payLoad);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(),200);
		
		
		
	}

}
