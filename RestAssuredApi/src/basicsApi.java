import io.restassured.RestAssured;
import resourceFile.payLoad;

//We have to import this package.
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*; /** this a specialized package that needs to be imported to get rid of error on equalTO. Since
this is a static package, selenium doesnot give auto suggestion**/

//log().all() logs all the request and the response.


public class basicsApi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
RestAssured.baseURI="https://rahulshettyacademy.com";

given().log().all().
queryParam("key", "qaclick123").queryParam("Content-Type", "application/json").
body(payLoad.bodyLoad()).
when().post("maps/api/place/add/json").

			then().log().all().assertThat().statusCode(200).body("scope", equalTo ("APP")).header("Server", "Apache/2.4.18 (Ubuntu)");
/**with this assertion, we are asserting the status code, body scope and header server*/



	}

}
