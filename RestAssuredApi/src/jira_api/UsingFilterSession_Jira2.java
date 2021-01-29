//This script is same as Jira1. 
/** we have  used somethign called Session filter method which filters the session ID which helps in authenticating and fiters the session iD
 * . Its as if you are logged into Jira and add comment to the issue. THis has to be before When() */

package jira_api;

import static io.restassured.RestAssured.given;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;
import io.restassured.path.json.JsonPath;

public class UsingFilterSession_Jira2 {
	
public void newmethod() {
		
		System.out.println("this is a new test method created for github testing");
	}

	
	@Test
	
public void createNewIssueWithSessionFilter() {
		
		// AUTHENTICATING A SESSION
		
		SessionFilter session = new SessionFilter();

		RestAssured.baseURI = "http://localhost:8080/";

		String Resp = given().log().all().headers("Content-Type", "application/json")
				.body("{\"username\": \"hemmige.jayashree\", \"password\": \"Krom123$12\"}").filter(session).when()
				.post("rest/auth/1/session").then().assertThat().log().all().statusCode(200).extract().response()
				.asString();

	System.out.println(Resp);
	System.out.println("This is the value-jayashree1");
	System.out.println("*************************____________________________________***************************************");
	
		//CREATING A NEW ISSUE
	String response=	given().log().all().headers("Content-Type", "application/json").body("{\n"
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
				+ "}").filter(session).when().post("rest/api/2/issue/").then().assertThat().statusCode(201).log().all().extract().response().asString();
	
	System.out.println(response);
	
	JsonPath jp = new JsonPath(response);
String id= 	jp.get("id");
System.out.println(id);
	
System.out.println("*************************____________________________________***************************************");	
	//POSTING A COMMENT TO AN ISSUE
	
String CommentRes=	given().log().all().pathParam("key", id).headers("Content-Type", "application/json").
	body("{\n"
			+ "  \"visibility\": {\n"
			+ "    \"type\": \"role\",\n"
			+ "    \"value\": \"Administrators\"\n"
			+ "  },\n"
			+ "  \"body\": \"This is the comment for  lkjklsdjagkljsdl g lsdkfjkjajds glsjdlkgjklsejgklsdjkljglk.\"\n"
			+ "}").filter (session).when().post("rest/api/2/issue/{key}/comment").then().log().all().extract().response().toString();
	System.out.println("*************************____________________________________***************************************");
	
//	JsonPath jsp1= new JsonPath(CommentRes);
//String CommentID=	jsp1.get("id");
//System.out.println(CommentID);
	
	//ADDING AN ATTACHMENT TO THE ISSUE
	
	/**We use a method call multipart that takes a file argument and we provide the path of the file that needs to be attached. 
	 * Inorder to differentiate between string and a file, we actually provide "new File cast so it knows we are passing a file actually"*/
	
	given().log().all().pathParam("key", id).headers("X-Atlassian-Token",  "no-check").headers("Content-Type", "multipart/form-data").filter(session).
	multiPart("file", new File("/Users/jayashreehemmige/Downloads/Info.txt")).when().post("rest/api/2/issue/{key}/attachments").then().log().all();
	System.out.println("*************************____________________________________***************************************");
	//GETTING A RESPONSE FOR ISSUE ADDED
String getRes=	given().log().all().pathParam("key", id).filter(session).when().get("/rest/api/2/issue/{key}").then().log().all().extract().response().asString();
	System.out.println("This is get Res &&&&&&&"+ getRes);
	
JsonPath jps= new JsonPath(getRes);
int commentSize=	jps.get("fields.comment.size()");

System.out.println(commentSize);
System.out.println("This is the value3-jayashree3");
	}


}
