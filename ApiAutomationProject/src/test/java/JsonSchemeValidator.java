import org.testng.annotations.Test;

import io.restassured.module.jsv.JsonSchemaValidator;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
public class JsonSchemeValidator {
	
	
	@Test
	public void jsonSchemaValidator() {
		
		given()
		
		.when()
		.get("https://dummy.restapiexample.com/api/v1/employees")
		
		.then()
			.assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("JsonSchemaFile.json"));
		
		//JsonSchemaValidator >> Class & 
		//matchesJsonSchemaInClasspath >> Static method of JsonSchemaValidator
		
	}

}
