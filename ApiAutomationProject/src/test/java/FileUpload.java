import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;	
public class FileUpload {
	
	@Test
	public void sigleFileUpload() {
		
	File uploadingFile = new File("C:\\Users\\User\\Downloads\\New issues Julyv2.xlsx");
		
	Response response = given() 
	.multiPart("File", uploadingFile) // Key value pair how we are maintaining in postman
	.contentType("multipart/form-data") // this how we will provide form-data in postman

	
	.when()
	.post("https://v2.convertapi.com/upload");
	
	Assert.assertEquals(response.getStatusCode(), 200);
	Assert.assertEquals(response.getBody().jsonPath().getString("FileName"),"New issues Julyv2.xlsx");
	
	

	}

	//@Test
	public void multipleFileUpload() {
		
		File uploadingFile = new File("C:\\Users\\User\\Downloads\\New issues Julyv2.xlsx");
		File uploadingFile2 = new File("C:\\Users\\User\\Downloads\\Reopen issues julyv2.xlsx");
			
		given() 
		.multiPart("Files", uploadingFile)
		.multiPart("Files", uploadingFile2)
		.contentType("multipart/form-data")
		
		
		.when()
		.post("https://v2.convertapi.com/upload");
		

		}
	
}
