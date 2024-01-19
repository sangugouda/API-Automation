package api.endPoints;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import api.Payload.UserPojo;
import io.restassured.response.Response;

public class UserEndPoints {

	
	public static Response createUser(UserPojo payload){
	Response response = given()
			.contentType("application/json")
			.accept("application/json")
			.body(payload)
		
		.when()
			.post(Routes.post_Url);
	
		return response;
	}
	
	
public static Response getUserDetails(String createdUserName){
	
		Response response = given()
				.pathParam("userName", createdUserName)
		.when()
			.get(Routes.get_Url);
		
		return response;
		
		
	}
	


public static Response UpdatingUser(UserPojo payload, String updatingUserName) {
	
		Response response = given()
			.contentType("application/json")
			.accept("application/json")
			.pathParam("userName", updatingUserName)
			.body(payload)
			
		.when()
			.put(Routes.put_Url);
			return response;
}


public static Response deleteUser(String deletingUserName){
	
	Response response = given()
			.pathParam("userName", deletingUserName)
			
			.when()
			.delete(Routes.delete_Url);
			return response;
	
}


}
