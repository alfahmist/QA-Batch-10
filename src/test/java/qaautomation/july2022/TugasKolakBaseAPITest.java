package qaautomation.july2022;

import static io.restassured.RestAssured.given;

import org.testng.annotations.BeforeMethod;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TugasKolakBaseAPITest {
	
	RequestSpecification commonJsonSpec = new RequestSpecBuilder()
			.setBaseUri("https://kolakproject.herokuapp.com")
			.setContentType(ContentType.JSON)
			.build().log().all();
	RequestSpecification loginJsonSpec;
	RequestSpecification wrongLoginJsonSpec;
	
	String token;
	
	@BeforeMethod
	public void login() {
		
		String payload = "{\r\n"
				+ "    \"username\":\"jajanbareng\",\r\n"
				+ "    \"password\":\"passwordsangatkuat\"\r\n"
				+ "}";
		
		Response responseLogin = given().spec(commonJsonSpec)
				.body(payload)
				.when().post("/login");
		token = responseLogin.jsonPath().get("Authorization");
		
		loginJsonSpec = new RequestSpecBuilder()
				.setBaseUri("https://kolakproject.herokuapp.com")
				.setContentType(ContentType.JSON).addHeader("Authorization", "bearer " +  token)
				.build().log().all();
		
	}
}
 