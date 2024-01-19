import org.testng.annotations.Test;

import io.restassured.response.Response;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;
public class PathParameterAndQueryParameters {
	
	
	// @Test
	public void passPathParameter() {
		
		given()
			.pathParam("Version", "v3")
			.pathParam("lanchStations", "landpads")
		
		
		.when()
			.get("https://api.spacexdata.com/{Version}/{lanchStations}")
		
		
		.then()
		
			.statusCode(200)
			.log().all();
	}
	
	
	
	//@Test
	public void passPathParameters() {
		
		Map<String, String> data = new HashMap();
		data.put("Version", "v3");
		data.put("lanchStations", "landpads");
		
	given()
		  	.pathParams(data)
		
		.when()
			.get("https://api.spacexdata.com/{Version}/{lanchStations}")
			
	
		.then()
		.log().all();
		
	}
	
	
	@Test
	public void queryParameter() {
		
		given()
		.pathParam("Resource","users")  
		.queryParam("page", 2)  // can't pass multiple query parameter in single queryparam
		.queryParam("id", "5")
		
		
		.when()
			.get("https://reqres.in/api/{Resource}")
			
			
		.then()
			.statusCode(200)
			.log().all();
		
	}

}
