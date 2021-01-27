import static io.restassured.RestAssured.given;

import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import resourceFile.payLoad;
import static org.hamcrest.Matchers.*;

public class addingnewBook {
	String resID ;
	@Test (dataProvider="getData")
	
	public void addANewBook(String isbn, String aisle) {

		RestAssured.baseURI = "http://216.10.245.166";
		
		

		String resp = given().log().all().queryParam("Content-Type", "application/json").body(payLoad.addAbook1(isbn,aisle)).when()
				.post("Library/Addbook.php").then().assertThat().statusCode(200).extract().response().asString();

		JsonPath jp = new JsonPath(resp);
		resID = jp.get("ID");
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
	
	@DataProvider
	public Object[][] getData() {
		/** this is oneway of declaring an object*/ 
//Object obj[][] = new Object[3][2];
//	
//		obj[0][0]= "bcz1zzd";
//		
//		obj[0][1]="12345";
//	
//		obj[1][0]="bcz1zezd";
//		obj[1][1]="1226345";
//		
//		obj[2][0]="bcwz1zezd";
//		obj[2][1]="122634545";
//		
//		return obj;
		/** this is another way of declaring an object*/ 
	return new Object[][] {{"bcz1zzd", "12345"},{"bcz1zezd", "1226345"}, {"bcwz1zezd", "122634545"}};
		
		
	}

}
