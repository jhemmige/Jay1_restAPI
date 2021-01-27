package resourceFile;

import io.restassured.path.json.JsonPath;

public class newResource {
	
	public static JsonPath rawToJson(String rep)/** by making this method static, we can call this method directly to a new class .This method 
	has been used in addingPlaceApi*/
	{
		
		JsonPath jp1 = new JsonPath(rep);
		
		return jp1;
		
	}

}
