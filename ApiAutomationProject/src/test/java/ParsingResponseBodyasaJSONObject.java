import static org.testng.Assert.ARRAY_MISMATCH_TEMPLATE;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


public class ParsingResponseBodyasaJSONObject {
	
	
	@Test()
  public void validation() {
		
						// Approch-1 Validating by using only Rest assure method
		
		/*given()
		.pathParam("Vesion", "v1")
		.pathParam("Workers", "employees")
		
		.when()
			.get("https://dummy.restapiexample.com/api/{Vesion}/{Workers}")
		
		.then()
		.statusCode(200)
		.body("data[12].employee_name", equalTo("Charde Marshall"));
		*/
		
		
						// Aproch-2 Validating by using Test Ng assertions
	
		/*
		Response response= given()
		.pathParam("Vesion", "v1")
		.pathParam("Workers", "employees")
		
		.when()
			.get("https://dummy.restapiexample.com/api/{Vesion}/{Workers}");
		
		
		Assert.assertEquals(response.getStatusCode(),200);
		Assert.assertEquals(response.getHeader("Content-Type"),"application/json");
		Assert.assertEquals(response.body().jsonPath().get("data[12].employee_name").toString(), "Charde Marshall");
		*/
		
		
					// Approch-3 Validating by reading Json object
		
		Response response= given()
				.pathParam("Vesion", "v1")
				.pathParam("Workers", "employees")
				
				.when()
					.get("https://dummy.restapiexample.com/api/{Vesion}/{Workers}");
		
		     JSONObject json = new JSONObject(response.toString());
		
		
		    boolean found = false;
			for(int i=0;i<json.getJSONArray("data").length();i++) {
				
			String empname =json.getJSONArray("data").getJSONObject(i).get("employee_name").toString();
			
			if(empname.equals("Charde Marshall")){
				found = true;
			}
			
		
		}
			
			Assert.assertEquals(found, true);
	}
	
	
	
	
	
	
	
}
