

package jira_api;

import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class Jira1 {

	@Test
	public void createNewIssue() {
		
		// AUTHENTICATING A SESSION
		
		SessionFilter session = new SessionFilter();

		RestAssured.baseURI = "http://localhost:8080/";

		String Resp = given().log().all().headers("Content-Type", "application/json")
				.body("{\"username\": \"hemmige.jayashree\", \"password\": \"Krom123$12\"}").when()
				.post("rest/auth/1/session").then().assertThat().log().all().statusCode(200).extract().response()
				.asString();

		System.out.println(Resp);

		JsonPath jp = new JsonPath(Resp);
		String val = jp.get("session.value");

		System.out.println("This is the  " + val);
		
		//CREATING A NEW ISSUE
	String response=	given().log().all().headers("Cookie", "JSESSIONID=" +val).headers("Content-Type", "application/json").body("{\n"
				+ "    \"fields\": {\n"
				+ "       \"project\":\n"
				+ "       {\n"
				+ "          \"key\": \"RES\"\n"
				+ "       },\n"
				+ "       \"summary\": \"new Bug Via api\",\n"
				+ "       \"description\": \"Bug Created via Selenium using the REST API\",\n"
				+ "       \"issuetype\": {\n"
				+ "          \"name\": \"Bug\"\n"
				+ "       }\n"
				+ "   }\n"
				+ "}").when().post("rest/api/2/issue/").then().assertThat().statusCode(201).log().all().extract().response().asString();
	
	System.out.println(response);
	
	
	//POSTING A COMMENT TO AN ISSUE
	
	given().log().all().headers("Cookie", "JSESSIONID=" +val).headers("Content-Type", "application/json").
	body("{\n"
			+ "  \"visibility\": {\n"
			+ "    \"type\": \"role\",\n"
			+ "    \"value\": \"Administrators\"\n"
			+ "  },\n"
			+ "  \"body\": \"updating info for 1008 lkjklsdjagkljsdl g lsdkfjkjajds glsjdlkgjklsejgklsdjkljglk.\"\n"
			+ "}").when().post("rest/api/2/issue/10008/comment").then().log().all();

	}

}
