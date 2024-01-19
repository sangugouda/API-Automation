
import io.restassured.matcher.RestAssuredMatchers;
import io.restassured.module.jsv.JsonSchemaValidator;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class XMLSchemaValidator {

	@Test
	public void xmlSchemaValidator() {
		given()

		.when()
			.get("http://restapi.adequateshop.com/api/Traveler")
		
		.then()
			.assertThat().body(RestAssuredMatchers.matchesXsdInClasspath("XmlSchemaFile.xsd"));
		
		// Serilization >> Java Object to Json object 
		
		//De-Serilization >>  Json object to  Java Object 
		 
	}
}
