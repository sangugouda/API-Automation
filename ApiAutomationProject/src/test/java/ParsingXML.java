import static org.testng.Assert.ARRAY_MISMATCH_TEMPLATE;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


public class ParsingXML {
	
	@Test 
	public void parsingXMLData() {
				// Approch -1
		
	/*	given()
			.queryParam("page", 1)
		.when()
			.get("http://restapi.adequateshop.com/api/Traveler")
		
		.then()
			.statusCode(200)
			.body("TravelerinformationResponse.travelers.Travelerinformation[3].email", equalTo("Developer523@gmail.com"));
			
			*/
		
		
		
				// Approch - 2
		
				/*Response response	= given()
					.queryParam("page", 1)
				.when()
					.get("http://restapi.adequateshop.com/api/Traveler");
				
				Assert.assertEquals(response.getStatusCode(),200);
				String travellerEmailId = response.getBody().xmlPath().get("TravelerinformationResponse.travelers.Travelerinformation[3].email");
				Assert.assertEquals(travellerEmailId,"Developer523@gmail.com");
				System.out.println(response.getBody().xmlPath().get("TravelerinformationResponse.travelers.Travelerinformation[3].email"));
				*/
		
				
				
					// Approch - 3
				
				
				Response response	= given()
						.queryParam("page", 1)
					.when()
						.get("http://restapi.adequateshop.com/api/Traveler");
				
				 
				XmlPath path = new XmlPath(response.asString());
				
				List<String> travellersInfo = path.getList("TravelerinformationResponse.travelers.Travelerinformation.name");
				
				boolean present = false;
				
				for(String travelerInfo : travellersInfo) {
					
					if(travelerInfo.equalsIgnoreCase("da")) {
						present =true;
						break;
					}
				}
				
				if(present==true) {
					System.out.println("traveller is present in XML data");
					
				}else {
					System.out.println("traveller is not present in XML data");
				}
				
				
	}

}
