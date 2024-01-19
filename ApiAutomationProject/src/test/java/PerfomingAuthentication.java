import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
public class PerfomingAuthentication {

	
	// @Test
	public void BasicAuth() {
		given()
			.auth().basic("Developer5@gmail.com", "123456")
		
		.when()
		.get("http://restapi.adequateshop.com/api/authaccount/login")
		
		.then()
			.statusCode(200)
			.body("message" ,equalTo("invalid username or password"));
		
	}
	
	// @Test
	public void digestAuth() {
		given()
			.auth().digest("Developer5@gmail.com", "123456")
		
		.when()
		.get("http://restapi.adequateshop.com/api/authaccount/login")
		
		.then()
			.statusCode(200)
			.body("message" ,equalTo("invalid username or password"));
		
	}
	
	
	// @Test
	public void bearerToken() {
		String bearerToken ="eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICI3VzJKaWpiREpXTlJHcXdsaUVMa2I3N3NpN0VPdEhBYnYtMTJUT3BSbEFBIn0.eyJleHAiOjE2OTg0OTM5NTIsImlhdCI6MTY5ODMyMTE1MiwianRpIjoiNmY1NzJhNjktMGRiZC00MDE2LWE5OGItODhlNGI3NWMyZDIzIiwiaXNzIjoiaHR0cHM6Ly9hcHAuZmlyZWZsaW5rLmNvbTo4NDQzL3JlYWxtcy9GaXJlRmxpbmsiLCJzdWIiOiJmOmFmOGZmZTJhLWMxMjItNDdmMC05MjFhLTU4ODI4NzAyNWNmYzptYW5vaGFyYS5rc0BmaXJlZmxpbmsuY29tIiwidHlwIjoiQmVhcmVyIiwiYXpwIjoiZmxpbmstc2VydmljZSIsInNlc3Npb25fc3RhdGUiOiIzNzJiY2E1Yi0zNzRkLTRhYjQtOWMyZi1lZmExZmZmYTAxMTgiLCJhY3IiOiIxIiwiYWxsb3dlZC1vcmlnaW5zIjpbIioiXSwicmVhbG1fYWNjZXNzIjp7InJvbGVzIjpbIm9mZmxpbmVfYWNjZXNzIiwidW1hX2F1dGhvcml6YXRpb24iXX0sInNjb3BlIjoiZW1haWwgcHJvZmlsZSIsInNpZCI6IjM3MmJjYTViLTM3NGQtNGFiNC05YzJmLWVmYTFmZmZhMDExOCIsImN1cnJlbnRMaWNlbnNlSWQiOiJMSUM2NzkzIiwiZW1haWxfdmVyaWZpZWQiOmZhbHNlLCJjdXJyZW50UHJpdmlsZWdlIjoiU3VwZXIgQWRtaW4iLCJmdWxsTmFtZSI6Ik1hbm9oYXJhIEtTIiwiYWN0aXZhdGlvblN0YXR1cyI6IkFDVElWRSIsInByaXZpbGVnZSI6IlN1cGVyIEFkbWluIiwibGljZW5zZU5hbWUiOiJmaXJlLWZsaW5rLUxJQzY3OTMiLCJwcmVmZXJyZWRfdXNlcm5hbWUiOiJNYW5vaGFyYSBLUyIsInVzZXJOYW1lIjoibWFub2hhcmEua3NAZmlyZWZsaW5rLmNvbSIsImJpbGxpbmdDeWNsZSI6IlllYXJseSIsImlkIjoiVVNSMjE2NTkiLCJsaWNlbnNlSWQiOiJMSUM2NzkzIiwiZW1haWwiOiJtYW5vaGFyYS5rc0BmaXJlZmxpbmsuY29tIn0.A58-yFIz7FlbT1LnQJcoQiYEBZA1SEInBJWU_KhlKYM2L0BXWLt_gGjqJmUSVlOIHY48dMXpAXoZTDozrqiFgM2Hn1w45_x_kYyifbbwdOw2erugsBrQ9mhiKr9ICK9LNASuiXK6uoi7PyWb2bQ4OSs4saQAPOegIFH65zL3Jd2AH3W4QozZgOeWn0JE262BW1J7LMkfZ75-6N_LnKTn9e8I3nptKSpP0uEOGM2_9xjeB1mTB7P0PDyuYqSXn1MKmUoXwhp3rYrPoAP3QrP-I3n-aKfz-Atom4llAodtVDavK9lR8BIeEgcnOB24YxcJt9q9gr1rk8nheXgWdMXBCA";
		
			given()  
			.header("Authorization", "Bearer " + bearerToken) // why we are passing here means API has been developed accordingly
		
			.when()
			
			.get("") // need to give an Get request
		
			.then();
	}
	
	
	// @Test
	public void Oauth2() {
		String OauthToken = ""; // need to get generate or dev will give
		
		given()
		 .auth().oauth2(OauthToken)		
		 
		.when()
			.get("") //  need to give an Get request
			
		.then()
			.statusCode(200)
			
			.log().all();
	}
	
	@Test
	public void apiKeyAuth() {
	
		
		given()
		 .queryParam(" ", " ")	 // Api key & value has passed on query params beacuse it's been developed on the same
		 
		.when()
			.get("") //  need to give an Get request
			
			.then()
			.statusCode(200)
			
			.log().all();
	}
	
	
}

