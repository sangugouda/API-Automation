import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

public class BasicHttsRequests {
	
	int id;
	 @Test(priority=1)
	public void getUserFromPage() {
		given()
		
		.when()
			.get("https://reqres.in/api/users?page=2")
		
		.then()
			.statusCode(200)
			.body("page", equalTo(2));
			
		
	}

	
	 @Test(priority=2)
	public void createAUser() {
		
		
		HashMap map = new HashMap();
		map.put("name", "Gouda");
		map.put("job", "Engg");
		
		id = given()
			.contentType("application/json")
			.body(map)
			
		
		.when()
			.post("https://reqres.in/api/users")
			.jsonPath().getInt("id");
		
//		.then()	
//			.statusCode(201)
//			.log().all();
	}
	
	 @Test(priority=3,dependsOnMethods={"createAUser"}) 
	 public void updateUser() {
		 
		 HashMap map = new HashMap();
			map.put("name", "Goudas");
			map.put("job", "Engge");
		 
		 given()
		 	.body(map)
		 
		 .when()
		 	.put("https://reqres.in/api/users/"+ id)
		 
		 .then()
		 	.statusCode(200);
		 
		 	
		 
		 
	 }
	
	 @Test(priority=4)
	 public void deleteUser() {
		 
		 given()
		 
		 .when()
		 	.delete("https://reqres.in/api/users/" + id)
		 	
		 .then()
		 	.statusCode(204);
		 	
	 }
	
}
