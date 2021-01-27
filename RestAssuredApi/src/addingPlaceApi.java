import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import resourceFile.newResource;
import resourceFile.payLoad;


public class addingPlaceApi {

	public static void main(String[] args) {

		// POST

		RestAssured.baseURI = "https://rahulshettyacademy.com";

		String response = given().log().all().queryParam("key", "qaclick123")
				.headers("Content-Type", "application/json").body(payLoad.bodyLoad()).when()
				.post("maps/api/place/add/json").

				then().assertThat().statusCode(200).body("scope", equalTo("APP"))
				.header("Server", "Apache/2.4.18 (Ubuntu)").extract().response().asString();
		/**
		 * Here we have removed log.all so, response can be printed. Reponse has been
		 * captured in a string response
		 */

		System.out.println("The response is : " + response);
		/**
		 * Next, we will be creating an method called JsonPath that'll help parse the
		 * response so we get just the placeID and an object for it
		 */

		JsonPath jp = new JsonPath(response); // we pass the response into this so, it can be parsed.
		String placeID = jp.get("place_id");

		/**
		 * jp.get(this uses the path of string that needs to be retrieved). In this
		 * case, placeID. If the string has a parent for eg:Body: { "location": { "lat":
		 * -38.383494, "lng": 33.427362 }, "accuracy": 50, "name": "Frontline house",
		 * "phone_number": "(+91) 983 893 3937", "address": "29, side layout, cohen 09",
		 * "types": [ "shoe park", "shop" ],
		 * 
		 * location has 2 children - lat and lng. In such case, we will pass the path as
		 * location.lat or location.lng
		 * 
		 **/

		System.out.println("this is the placeID: " + placeID);

//PUT

		String newAddress = "70 Summer walk, portlan, Oregon, 94208, USA"; // we will be using this address in the body
		given().log().all().queryParam("place_id", placeID).queryParam("key", "qaclick123")
				.headers("Content-Type", "application/json")
				.body("{\n" + "\"place_id\":\"" + placeID + "\",\n" + "\"address\":\"" + newAddress + "\",\n"
						+ "\"key\":\"qaclick123\"\n" + "}")
				.when().put("maps/api/place/update/json").then().assertThat().log().all()
				.body("msg", equalTo("Address successfully updated"));

//GET
		String rep = given().log().all().queryParam("place_id", placeID).queryParam("key", "qaclick123")
				.headers("Content-Type", "application/json").when().get("maps/api/place/get/json").then().assertThat()
				.log().all().body("address", equalTo(newAddress)).extract().response().asString();
		
		//JsonPath jp1 = new JsonPath(rep); - This is one way of creating a method.

		JsonPath jp1= newResource.rawToJson(rep); // this is another way where the object is created in a new class
		
		String actualAddress = jp1.get("address");

		System.out.println(actualAddress);

		Assert.assertEquals(actualAddress, newAddress); // Testng jar address to use assert

		// this is not on the course, I tried to use the loop to ensure validation.

		if (rep.contains(newAddress)) {

			System.out.println("Yes, the address is updated!");
		}

		else
			System.out.println("Yes, the address not  updated!");

	}

}
