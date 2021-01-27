package jira_api;

import static io.restassured.RestAssured.given;

import java.io.File;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;
import io.restassured.path.json.JsonPath;

public class comment_To_Specific_Issue {
	@Test
	public void ValidatingIssue() {

		// AUTHENTICATING A SESSION

		SessionFilter session = new SessionFilter();

		RestAssured.baseURI = "http://localhost:8080/";

		String Resp = given().log().all().headers("Content-Type", "application/json")
				.body("{\"username\": \"hemmige.jayashree\", \"password\": \"Krom123$12\"}").filter(session).when()
				.post("rest/auth/1/session").then().assertThat().log().all().statusCode(200).extract().response()
				.asString();

		System.out.println(Resp);
		System.out.println(
				"*************************____________________________________***************************************");

		String msg = "Hi How are you?";
		// ADDING COMMENT TO 10021
		String CommentRes = given().log().all().pathParam("key", "10021").headers("Content-Type", "application/json")
				.body("{\n" + "  \"visibility\": {\n" + "    \"type\": \"role\",\n"
						+ "    \"value\": \"Administrators\"\n" + "  },\n" + "  \"body\": \" " + msg + "\"\n" + "}")
				.filter(session).when().post("rest/api/2/issue/{key}/comment").then().log().all().extract().response()
				.asString();

		JsonPath jsp1 = new JsonPath(CommentRes);
		String CommentID = jsp1.get("id").toString();
		System.out.println("********** " + CommentID);

//GETTING ISSUE 10021

//We are also asserting that the newly added comment equals msg above
		String getRes = given().log().all().pathParam("key", "10021").filter(session).when()
				.get("/rest/api/2/issue/{key}").then().log().all().extract().response().asString();
		System.out.println("This is get Res &&&&&&&" + getRes);

		JsonPath jps = new JsonPath(getRes);
		int commentSize = jps.get("fields.comment.comments.size()");

		System.out.println(commentSize);

		for (int i = 0; i < commentSize; i++) {

			String comID = jps.get("fields.comment.comments[" + i + "].id");
			System.out.println(comID);

			String NewComID = comID.toString();

			if (NewComID.equalsIgnoreCase(CommentID)) {

				System.out.println(CommentID);
				String issuebody = jps.get("fields.comment.comments[" + i + "].body").toString();
				String newIssuebody = issuebody.trim(); // If I didnot use this option, assertion was failing.

				System.out.println(issuebody);

				Assert.assertEquals(newIssuebody, msg);

			}

		}

	}

}
