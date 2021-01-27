
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import resourceFile.payLoad;

public class SumValidation {

	/**
	 * while running this program, I had TestNG Jar and that was throwing this error
	 * - "A JNI error has occurred, please check your installation and try again "
	 * All I did was remove the testNG jar and instead used " Add testng library" up
	 * on hover over the test.
	 */

	@Test

	public void numofCourses() {

		JsonPath jp = new JsonPath(payLoad.titlePrices());

		int c = jp.getInt("courses.size()");

		int purchaseAmt = jp.get("dashboard.purchaseAmount");

		int sum = 0;

		for (int i = 0; i < c; i++) {

			int price = jp.get("courses[" + i + "].price");
			int numofCopies = jp.get("courses[" + i + "].copies");

			int Amount = (price * numofCopies);

			System.out.println(Amount);

			sum = sum + Amount;

		}

		System.out.println(sum);

		Assert.assertEquals(sum, purchaseAmt);
	

	}

}
