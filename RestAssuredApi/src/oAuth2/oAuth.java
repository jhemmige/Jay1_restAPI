package oAuth2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class oAuth {
	
	
	public  static void  main(String[] args)throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver","/Users/jayashreehemmige/Downloads/chromedriver");
		WebDriver driver =new ChromeDriver();
		
		driver.get("https://finance.yahoo.com/");
//		driver.get("https://accounts.google.com/o/oauth2/v2/auth?auth_url=https://accounts.google.com/o/oauth2/v2/auth&client_id=692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com&response_type=code&redirect_uri=https://rahulshettyacademy.com/getCourse.php&state=verifyfjdss&scope=https://www.googleapis.com/auth/userinfo.email");
//		driver.findElement(By.xpath(" //input[@id='identifierId']")).sendKeys("testclient2121@gmail.com");
//		driver.findElement(By.xpath("//*[@class='VfPpkd-vQzf8d']")).click();	
//		driver.findElement(By.xpath("//*[@type='password']")).sendKeys("jhemmige123");
//		driver.findElement(By.xpath("//*[@class='VfPpkd-RLmnJb']")).click();
//		Thread.sleep(3000);
//		String CurrentURL=driver.getCurrentUrl();
//		System.out.println(CurrentURL);
		
//String xchangeCodeAccesstoken=		given().log().all().queryParam("code", "")
//		.queryParam("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
//		.queryParam("client_secret", "erZOWM9g3UtwNRj340YYaK_W")
//		.queryParam("redirect_uri", "https://rahulshettyacademy.com/getCourse.php")
//		.queryParam("grant_type", "authorization_code").when().post("https://www.googleapis.com/oauth2/v4/token").then().log().all()
//		.extract().response().asString();
//		
//String actualResponse=		given().log().all().queryParam("access_token", xchangeCodeAccesstoken).when().get("https://rahulshettyacademy.com/getCourse.php")
//		.then().log().all().extract().response().asString();
		
		System.out.println("THis is yahoo");
		System.out.println("This is the value5-jayashree5");
		
		
	}
	
	
	

	

}
