package ApiChain;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;
public class UpdateUser {
	
	@Test
	public void updateUser(ITestContext context){
		
		int id =  (Integer) context.getSuite().getAttribute("User_id");
		Faker fake = new Faker();
		JSONObject object = new JSONObject();
		object.put("name", fake.name());
		object.put("job",fake.job());
		
		String bearerToken = "jbdsjhbsdjhgyudsgjdsbgdyug";
		
		
		given()
		.pathParams("UserNamePlace", "users", "id", id)
		.contentType("application/json")
		.body(fake.toString())
		.header("authorization","bearer " + bearerToken)
		
		.when()
			.put("https://reqres.in/api/{UserNamePlace}/{id}")
			
		.then()
			.statusCode(200);
	}

}
