import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import resourceFile.payLoad;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;


public class addingBook {
	

	@Test
	public static void addingABookonISBN() {
		
		RestAssured.baseURI="http://216.10.245.166";
	
		
String resp=		given().log().all().queryParam("Content-Type", "application/json")
		.body(payLoad.addAbook()).when().post("Library/Addbook.php").then().assertThat()
		.statusCode(200).extract().response().asString();

JsonPath jp = new JsonPath(resp);
String resID= jp.get("ID");
String resmsg= jp.get("Msg");
System.out.println("This is the bookID: "+ resID);
System.out.println(resmsg);


	
	given().log().all().queryParam("Content-Type", "application/json").body("{\n"
			+ " \n"
			+ "\"ID\" : \""+resID+"\"\n"
			+ " \n"
			+ "}").when().post("/Library/DeleteBook.php").
	then().assertThat().log().all().statusCode(200).body("msg", equalTo("book is successfully deleted"));
}
		
	}


