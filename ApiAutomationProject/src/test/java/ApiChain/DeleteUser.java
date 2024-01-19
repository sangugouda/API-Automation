package ApiChain;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.ITestContext;

public class DeleteUser {
	
	
	public void deleteUser(ITestContext context){
		
	int id = (Integer) context.getSuite().getAttribute("User_id");
	String bearerToken = "jbdsjhbsdjhgyudsgjdsbgdyug";
		
	given()
	
	.pathParams("UserNamePlace", "users", "id",id)
	.contentType("application/json")
	.header("authorization","bearer " + bearerToken)
	
	.when()
	.delete("https://reqres.in/api/{UserNamePlace}/{id}")
	
	.then()
	.statusCode(204);
	
	}

}
