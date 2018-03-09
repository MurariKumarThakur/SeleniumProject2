package dummyclassmethod;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.framework.reusable.driverEngine;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentReport  {

	WebDriver driver;
	ExtentReports er;
	ExtentTest et ;
	@Test
	public void gmail_Text() {

		 er = new ExtentReports("./extendsReport/report.html");
		 et = er.startTest("verify Title ");
		

		System.setProperty("webdriver.chrome.driver", "./browserDrivercontainer/chromedriver.exe");

		driver = new ChromeDriver();
		et.log(LogStatus.INFO, "Browser launch");
		driver.get("http://www.gamil.com");
		et.log(LogStatus.INFO, "Url load");
		String text = driver.getTitle();
		Assert.assertTrue(text.contains("facebook"));
		
		et.log(LogStatus.PASS, "gmail_Text pass");
	}
	
@AfterMethod

	public void status(ITestResult result) {

		if (result.getStatus() == ITestResult.FAILURE) {
			driverEngine obj = new driverEngine();
			 obj.takeScreenShot("gamil_login");
			
			/* String imageFilepath="./failureTest_CaseScreenShot/"+result.getName() +".jpeg";
			
		String image =	et.addScreenCapture(imageFilepath);
			et.log(LogStatus.FAIL, "Title verification", image);*/
			

		}
		er.endTest(et);
		er.flush();

		//driver.get("./extendsReport/report.html");
	}

}
