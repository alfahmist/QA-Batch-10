	package qaautomation.july2022;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class APITest {
	String token;
	String contentType = "application/json";
	
	@Test
	public void loginAPI() {
		RestAssured.baseURI = "https://api-staging-builder.engineer.ai";
		
		String payload = "{\r\n"
				+ "    \"email\":\"testlabs@gmail.com\",\r\n"
				+ "    \"password\":\"builder123\"\r\n"
				+ "}";
		
		Response responseLogin = RestAssured.given().contentType("application/json")
				.body(payload).when().post("/users/sign_in");
		token = responseLogin.jsonPath().get("user.authtoken");
		System.out.println(token);
	}
	
	
	@Test
	public void userAPI() {
		RestAssured.baseURI = "https://api-staging-builder.engineer.ai";
		Response responseUser = RestAssured.given().contentType("application/json")
				.header("authtoken",token).when().get("/user");
		
		assertEquals(responseUser.statusCode(), 200);
	}
	
	@Test
	public void configAPI() {
		RestAssured.baseURI = "https://api-staging-builder.engineer.ai";
		Response responseUser = RestAssured.given().contentType("application/json")
				.when().get("/configurations");
		
		assertEquals(responseUser.statusCode(), 200);
	}
}
