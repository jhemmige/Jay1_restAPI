import org.testng.Assert;

import io.restassured.path.json.JsonPath;
import resourceFile.payLoad;

public class complexJsonParse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		JsonPath jp= new JsonPath(payLoad.titlePrices());

	// Test Case 1 : Print No of courses returned by API
	
	int c= 	jp.getInt("courses.size()"); // getting the size or # of courses 
	System.out.println(c);

	
	String e=jp.get("dashboard.website");//gets the website name
	
	// Test Case 2 :	Print Purchase Amount
	
	int d=	jp.get("dashboard.purchaseAmount"); // get the purchase amt for the course
		
		System.out.println(d);
		
		// Test Case 3 :	Print Title of the first course
		
		String s=	jp.get("courses[2].title");
		System.out.println(s);
		
		// Test Case 4 :	 Print All course titles and their respective Prices
		
		int cp = 0;
	for( int i=0; i<c; i++) {
		
String courseTitle=		jp.get("courses["+i+"].title");
int coursePrice= jp.get("courses["+i+"].price");//  .toString can be added here if we dont know what kind of return type.

cp = coursePrice;

System.out.println(courseTitle);
	
System.out.println("this the courseprice" +coursePrice);
	}
	
	//System.out.println(cp);
	
	
	// Test Case 5 :	Print no of copies sold by RPA Course
	
		int copiesSold= jp.get("courses[2].copies");
		System.out.println("Number of RPA Copies sold: "+copiesSold);
		
		//this method is when when we just have the title and don't know which index the RPA title is in.
		
		for( int i=0; i<c; i++) {
			
			String courseTitle=		jp.get("courses["+i+"].title");
			int copiesSold1= 		jp.get("courses["+i+"].copies");
			
			if (courseTitle.equalsIgnoreCase("Cypress")) {
				
				System.out.println("Number of Cypress Copies sold: "+ copiesSold1);
				
			break; // this will break the loop. Even if there are more apis present 
				
			}
		}
		
		
		// Test Case 6 :	 Verify if Sum of all Course prices matches with Purchase Amount
		
		//Straightforward method 
		int cp1= jp.get("courses[0].price");
		int cp2= jp.get("courses[1].price");
		int cp3= jp.get("courses[2].price");
		
		int cs1= jp.get("courses[0].copies");
		int cs2= jp.get("courses[1].copies");
		int cs3= jp.get("courses[2].copies");
		
		
		int ActualTotal= ((cp1*cs1) +(cp2*cs2)+(cp3*cs3));
		System.out.println(ActualTotal);
		
		
	Assert.assertEquals(ActualTotal, d, "hoorah! They match.");
	
	System.out.println("hoorah! They match.");
		
		

	}
	
	
}
