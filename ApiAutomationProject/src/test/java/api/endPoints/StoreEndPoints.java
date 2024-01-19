package api.endPoints;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import api.Payload.StorePojo;
import io.restassured.response.Response;

public class StoreEndPoints {

	
	public static Response createStore(StorePojo payLoad){
		Response response = given()
			.contentType("application/json")
			.body(payLoad)
		
			.when()
				.post(Routes.storePost_Url);
		
		return response;
			
	}
	
	
	public static Response getSingleStoreDetails(String orderedStoreId) {
		Response response = given()
				.pathParam("orderId", orderedStoreId)
				
		.when()
			.get(Routes.sinleStoreGet_Url);
		return response;
	}
	
	
	public static Response deleteSigleStoreDetails(String storeIdToBeDeleted) {
		Response respone	= given()
			.pathParam("orderId", storeIdToBeDeleted)
			
		.when()
			.delete(Routes.storeDelete_Url);
		
		return respone;
		
	}
	
public static Response getStoresDetails() {
		
		Response respone	= given()
				
		.when()
			.delete(Routes.getStoreDetails);
		
		return respone;
		
	}
	
	
	
	
}
