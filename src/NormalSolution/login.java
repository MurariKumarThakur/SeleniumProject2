package NormalSolution;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class login {

	public static void main(String[] args) throws Exception {

		System.setProperty("webdriver.chrome.driver", "./browserDrivercontainer/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://aiint.appinteract.com/account/login?returnUrl=signUp");
Thread.sleep(3000);
		 driver.findElement(By.id("firstName")).sendKeys("kiya haal hai"); 
		
		
		/*// Home page assertion
		String expected = "THE ART OF PATTERN";
		WebDriverWait wait = new WebDriverWait(driver, 25);

		WebElement web = driver.findElement(By.xpath("//center[text()='THE ART OF PATTERN']"));
		wait.until(ExpectedConditions.visibilityOf(web));

		String actual = driver.findElement(By.xpath("//center[text()='THE ART OF PATTERN']")).getText();
		System.out.println(actual);
		Assert.assertEquals(expected, actual);
		// Logging into user account
		driver.findElement(By.xpath("//span[text()='Account']")).click();
	

		// Valid login details
		WebDriverWait wait2 = new WebDriverWait(driver, 25);

		WebElement web2 = driver.findElement(By.xpath("//input[contains(@id,'username')]"));
		wait2.until(ExpectedConditions.visibilityOf(web2));

		driver.findElement(By.xpath("//input[contains(@id,'username')]")).sendKeys("pkotamsetti@gmail.com");
		driver.findElement(By.xpath("//input[@type ='password']")).sendKeys("Testing123");
		driver.findElement(By.xpath("//button[@value='Login']")).click();
   
		driver.close();
*/
	}

}
