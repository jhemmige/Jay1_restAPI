// in this script, we are passing the path of the Json file into body using Files.readAllBytes method.
// This code is the same as addingnewbook except for the body change. 
//new string command basically reads all the bytes into a string.
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class addingNewerBook {
	

	
	@Test 
	
	public void addANewBook() throws IOException {

		RestAssured.baseURI = "http://216.10.245.166";

		String resp = given().log().all().queryParam("Content-Type", "application/json").body(new String(Files.readAllBytes(Paths.get("/Users/jayashreehemmige/Documents/rest_api/Addnewbook1.json")))).when()
				.post("Library/Addbook.php").then().assertThat().statusCode(200).extract().response().asString();

		JsonPath jp = new JsonPath(resp);
		String resID = jp.get("ID");
		String resmsg = jp.get("Msg");
		System.out.println("This is the bookID: " + resID);
		System.out.println(resmsg);
	

		//@AfterTest
		//public void deleteNewBook() {
		
		given().log().all().queryParam("Content-Type", "application/json").body("{\n"
				+ " \n"
				+ "\"ID\" : \""+resID+"\"\n"
				+ " \n"
				+ "}").when().post("/Library/DeleteBook.php").
		then().assertThat().log().all().statusCode(200).body("msg", equalTo("book is successfully deleted"));
			
			
		}
	
	
		
	}


