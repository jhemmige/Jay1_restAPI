
//this class was created so instead of body having the lenghty code . It is being fetched from this class into basicsApi class.
package resourceFile;

public class payLoad {
	
	
	public  static String bodyLoad() {
		
		return "{\n"
				+ "    \"location\": {\n"
				+ "        \"lat\": -38.383494,\n"
				+ "        \"lng\": 33.427362\n"
				+ "    },\n"
				+ "    \"accuracy\": 50,\n"
				+ "    \"name\": \"Frontline house\",\n"
				+ "    \"phone_number\": \"(+91) 983 893 3937\",\n"
				+ "    \"address\": \"29, side layout, cohen 09\",\n"
				+ "    \"types\": [\n"
				+ "        \"shoe park\",\n"
				+ "        \"shop\"\n"
				+ "    ],\n"
				+ "    \"website\": \"http://google.com\",\n"
				+ "    \"language\": \"French-IN\"\n"
				+ "}";
		
	}
	
	//Test cases to be used for Nested APi
	/**1. Print No of courses returned by API

2.Print Purchase Amount

3. Print Title of the first course

4. Print All course titles and their respective Prices

5. Print no of copies sold by RPA Course

6. Verify if Sum of all Course prices matches with Purchase Amount
	 * @return */
	
	public static String titlePrices() {
		
		return "{\n"
				+ "\n"
				+ "\"dashboard\": {\n"
				+ "\n"
				+ "\"purchaseAmount\": 910,\n"
				+ "\n"
				+ "\"website\": \"rahulshettyacademy.com\"\n"
				+ "\n"
				+ "},\n"
				+ "\n"
				+ "\"courses\": [\n"
				+ "\n"
				+ "{\n"
				+ "\n"
				+ "\"title\": \"Selenium Python\",\n"
				+ "\n"
				+ "\"price\": 50,\n"
				+ "\n"
				+ "\"copies\": 6\n"
				+ "\n"
				+ "},\n"
				+ "\n"
				+ "{\n"
				+ "\n"
				+ "\"title\": \"Cypress\",\n"
				+ "\n"
				+ "\"price\": 40,\n"
				+ "\n"
				+ "\"copies\": 4\n"
				+ "\n"
				+ "},\n"
				+ "\n"
				+ "{\n"
				+ "\n"
				+ "\"title\": \"RPA\",\n"
				+ "\n"
				+ "\"price\": 45,\n"
				+ "\n"
				+ "\"copies\": 10\n"
				+ "\n"
				+ "}\n"
				+ "\n"
				+ "]\n"
				+ "\n"
				+ "}";


	}
	
	public static String addAbook() { /** this method  and the one below addAbook1 are same method basically used in different classes
	
	 *This method is used in addingBook.Java class
	 */
		
return "{   \n"
+ "\"name\":\"Learn Appium Automation with Java\",\n"
+ "\"isbn\":\"bttzszzc0d\",\n"
+ "\"aisle\":\"2287\",\n"
+ "\"author\":\"John foe\"\n"
+ "}";
		
		
		
	}
/** This method is used in addingBook1.Java class. In this method, we are passing isbn and aisle numbers are arguments and the class adding new
 * newbook has the data directly.*/
	public static String addAbook1(String isbnnew, String aislenew) {
		
		return "{   \n"
		+ "\"name\":\"Learn Appium Automation with Java\",\n"
		+ "\"isbn\":\""+isbnnew+"\",\n"
		+ "\"aisle\":\""+aislenew+"\",\n"
		+ "\"author\":\"John foe\"\n"
		+ "}";
	}

	
}
