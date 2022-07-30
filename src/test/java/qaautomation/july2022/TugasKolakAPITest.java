package qaautomation.july2022;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class TugasKolakAPITest extends TugasKolakBaseAPITest{
	
	@Test
	public void userAPI() {
		Response responseUser = given().spec(loginJsonSpec).when().get("/me/status");
		
		assertEquals(responseUser.statusCode(), 200);
	}
	
	@Test
	public void userNegativeAPI() {
		Response responseUser = given().spec(commonJsonSpec).when().get("/me/status");
		
		assertEquals(responseUser.statusCode(), 401);
	}
	
	
	@Test
	public void helpAPI() {
		Response responseUser = given().spec(commonJsonSpec).when().get("/help");
		
		assertEquals(responseUser.statusCode(), 200);
	}
	
	
	
	

}
