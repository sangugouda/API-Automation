package ApiChain;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class CreateUser {
	@Test
	public void creatingUser(ITestContext context) {
		
		
		Faker fake = new Faker();
		JSONObject object = new JSONObject();
		object.put("name", fake.name());
		object.put("job",fake.job());
		
		String bearerToken = "jbdsjhbsdjhgyudsgjdsbgdyug";
		
		
	int id = given()
		.pathParam("UserNamePlace", "users")
		.contentType("application/json")
		.body(object.toString())
		.header("authorization","bearer " + bearerToken)
		
		.when()
			.post("https://reqres.in/api/{UserNamePlace}")
			.jsonPath().getInt("id");
	
		//context.setAttribute("User_id",id );   //This will work only when we will trigger in once same Test of XML
	
		context.getSuite().setAttribute("User_id",id );     //This will make us to use in different  Test set also  of XML
	
	
	
		
	
	}

}
