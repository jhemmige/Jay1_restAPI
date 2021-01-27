package oAuth2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class newoAuthPractise {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","/Users/jayashreehemmige/Downloads/chromedriver");
		WebDriver driver =new ChromeDriver();
		
		driver.get("https://finance.yahoo.com/");

	}

}
