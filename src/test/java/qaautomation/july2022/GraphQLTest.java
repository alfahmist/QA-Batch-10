package qaautomation.july2022;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static org.testng.Assert.assertEquals;

import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import qaautomation.july2022.utils.DataUtility;
import qaautomation.july2022.utils.GraphQLRequestBuilder;

public class GraphQLTest {
	
	@Test
	public void checkCEO() {
		GraphQLRequestBuilder gql = new GraphQLRequestBuilder();
		String query = "{company {ceo cto  }}";
		
		gql.setQuery(query);
		String jsonStringQuery = gql.getJSONString();
		
		Response responseCEO = given().contentType(ContentType.JSON)
				.body(jsonStringQuery)
				.when()
				.post("https://api.spacex.land/graphql");
		String expectedCEO = "Elon Musk";
		String ceoName = responseCEO.jsonPath().get("data.company.ceo");
		
		System.out.println(ceoName);
		
		assertEquals(expectedCEO, ceoName);
		
		responseCEO.then().assertThat().body(matchesJsonSchema(DataUtility.getDataFromExcel("Schemas", "gqlceo")));
		
	}
	
	@Test
	public void getLaunches() {
		GraphQLRequestBuilder gql = new GraphQLRequestBuilder();
		JSONObject variables = new JSONObject();
		variables.put("limit", 6);

		String query = "query getLaunches($limit: Int!) {\r\n" + "  launches(limit: $limit) {\r\n"
				+ "    mission_id\r\n" + "    mission_name\r\n" + "  }\r\n" + "}\r\n" + "";

		gql.setQuery(query);
		gql.setVariable(variables.toString());
		String jsonStringQuery = gql.getJSONString();
		Response responseLaunches = given().contentType(ContentType.JSON).body(jsonStringQuery).when()
				.post("https://api.spacex.land/graphql/");
		String missionName = responseLaunches.jsonPath().get("data.launches[1].mission_name");
		assertEquals("AsiaSat 6", missionName);
		
	}
	

}
