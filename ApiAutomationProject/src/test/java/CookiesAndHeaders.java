import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

	import org.testng.annotations.Test;
	import static io.restassured.RestAssured.*;
	import static io.restassured.matcher.RestAssuredMatchers.*;
	import static org.hamcrest.Matchers.*;

	import java.util.HashMap;
	import java.util.Map;
import java.util.Set;

public class CookiesAndHeaders {
	
	   				//Single cookie value
	
	// @Test
	public void getCookieValue() {
		
		Response responce = given()
				
			.when()
				.get("https://www.google.com");
		
		// get single cookie info    
	 String cookieValue = responce.getCookie("ACE");
	 System.out.println(cookieValue);
		
			// validated the Cookie in after request
			
//			.then()
//				.cookie("ACE", "Ackid1S9Q3ZfJuD-OTn4jcxl18R-mC2F2EQ3dUeAIXFzvzu2u2zyqyoBqDw");
		
	}
	
	
	// Multiple cookies validation 
	// @Test
	public void getCookiesValue() {
	
		
		Response responce = given()
				
			.when()
				.get("https://www.google.com");
		
		
		
		// get multiple cookie info
		Map<String, String> cookieValues = responce.getCookies();  
		  
         Set<String> keys = cookieValues.keySet();
         
         
         // Form Api perspective
         for(String key : keys ) {
        	System.out.println (key + "   " + responce.getCookie(key));
       	 
        }
         
         // Java Map perspective 
			
//         for(String key:keys) {
//        	 System.out.println(cookieValues.get(key));
//         }
		
	}
	
	// @Test
	public void getHeaderValue() {
		
		Response response = given()
		
		
		.when()
			.get("http://google.com/");
			
			// Validated the header
			
		/*.then()
			.header("Content-Type", "text/html; charset=ISO-8859-1")
			.header("Content-Encoding", "gzip")
			.header("Server", "gws");
			*/

			  String headerValue  = response.getHeader("Content-Type");
			  String headerValue2  = response.getHeader("Server");
				
			   System.out.println(headerValue);
			   System.out.println(headerValue2);
		
		
		
	}
	
	
	
	@Test
	public void getHeaderValues() {
		
		Response response = given()
		
		
		.when()
			.get("http://google.com/");
			
			// Validated the header
			
		/*.then()
			.header("Content-Type", "text/html; charset=ISO-8859-1")
			.header("Content-Encoding", "gzip")
			.header("Server", "gws");
			*/

		
		// getting multiple cookie info
		
		
	Headers	myHeadsInfo = response.getHeaders();
	
	for(Header head: myHeadsInfo) {
		
		System.out.println(head.getName() + "    " + head.getValue()  );
		
	}
		
		
	}
	
	
	
	
	
	
}
