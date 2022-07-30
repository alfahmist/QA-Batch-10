package qaautomation.july2022;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import qaautomation.july2022.utils.DataUtility;

public class APITestAfterRefactor extends BaseAPITest{
	
	@Test
	public void userAPI() {
		Response responseUser = given().spec(loginJsonSpec).when().get("/user");
		responseUser.then().assertThat().body(matchesJsonSchema(DataUtility.getDataFromExcel("Schemas", "userAPI")));
		
		assertEquals(responseUser.statusCode(), 200);
	}
	
	@Test
	public void userNegativeAPI() {
		Response responseUser = given().spec(commonJsonSpec).when().get("/user");
		//check negative case
		assertEquals(responseUser.statusCode(), 401);
	}
	
	@Test
	public void configAPI() {
		Response responseUser = given().spec(commonJsonSpec).when().get("/configurations");
		
		assertEquals(responseUser.statusCode(), 200);
	}
	
}
