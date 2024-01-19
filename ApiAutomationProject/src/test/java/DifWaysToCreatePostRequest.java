import org.hamcrest.Matcher;
import org.json.JSONObject;
import org.testng.annotations.Test;

import libraries.POJOLibrary;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

public class DifWaysToCreatePostRequest {
	
	int id;
	// passing request body by using Map
	// @Test
	public void creatingUserByMapWay() {
		
		/*
		 	"name":"test",
       "salary":"123",
       "age":"23"
		 */
		HashMap map = new HashMap();
		
		map.put("name", "tests");
		map.put("salary", "123");
		map.put("age", "23");
		
	  id	= given()
			.contentType("application/json")
			.body(map)
			
		
		.when()
			.post("https://dummy.restapiexample.com/api/v1/create")
			.jsonPath().getInt("id");	
	}
	
	
	
	
	
	// passing request body by using Json 
	// @Test
	public void creatingUserByJson() {
		
		JSONObject data = new JSONObject();
		data.put("name", "Anu");
		data.put("salary", "123");
		data.put("age", "23");
		
		id = given()
				.contentType("application/json")
				.body(data.toString())
		
		
		.when()
			.post("https://dummy.restapiexample.com/api/v1/create")
			.jsonPath().getInt("data.id");
		
		
	}
	
	
	
	// passing data from POJO class
	
	@Test
	public void creatingUserByPOJO() {
		
		POJOLibrary data = new POJOLibrary();
		data.setName("Goudass");
		data.setSalary("345");
		data.setAge("27");
		
		
		id = given()
				.contentType("application/json")
				.body(data)
				
		
		.when()
			.post("https://dummy.restapiexample.com/api/v1/create")
			.jsonPath().getInt("data.id");
		
		System.out.println(id);
		
		
		
	}
	
	
	
	
	
	

	// @Test
	public void deleteAUser() {
		when()
			.delete("https://dummy.restapiexample.com/api/v1/delete/"+id);
		
	}
	
	


}
