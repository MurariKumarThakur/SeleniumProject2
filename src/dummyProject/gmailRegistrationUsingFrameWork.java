package dummyProject;

import java.util.List;
import java.util.ListIterator;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.action.utility.action;
import com.file.utility.excelFileReusable;
import com.file.utility.propertyFileReusable;
import com.framework.reusable.driverEngine;
import com.object.utility.objectUtility;

public class gmailRegistrationUsingFrameWork extends action {

	propertyFileReusable config = objectUtility.getConfig(objectUtility.getConfigFilePath());
	propertyFileReusable gmailLocator = objectUtility.getGmailLocFile(objectUtility.getGmailLocPath());
	excelFileReusable excelReader = objectUtility.getExcelReusable(objectUtility.getExcelFilePath());

	@Test(priority = 1)
	public void loadUrlAndCheckCorrectPageIsOpenningOrNot() {

		loadUrl(config.getPropertyFileValue("gmailUrl"));
		String actualTitle = getTitle();
		String expectedTitle = "Gmail";

		Assert.assertEquals(actualTitle, expectedTitle, "TITLE NOT MATCHING");

	}

	@Test(priority = 2)
	public void openGmailRegistrationPage() {

		click(gmailLocator.getPropertyFileValue("moreOptionTextLoc"));
		waitForVisiablity(gmailLocator.getPropertyFileValue("CreateAccountTextLoc"));

		mousOver(gmailLocator.getPropertyFileValue("CreateAccountTextLoc"));
		clickEnterButton();

		waitForVisiablity(gmailLocator.getPropertyFileValue("CreateAccountHeading"));
		String ActualText = getText(gmailLocator.getPropertyFileValue("CreateAccountHeading"));
		String ExpectedText = "Create your Google Account";

		Assert.assertTrue(ActualText.contains(ExpectedText));
		
		

	}

	@Test(priority = 3)
	public void fillGmailRegistratationForm() {
		


          
		sendKeys(gmailLocator.getPropertyFileValue("fistNameField"),
				excelReader.getSingleExcelCellValue("Sheet1", 1, 0));
		
		
	
		
		sendKeys(gmailLocator.getPropertyFileValue("lastNameField"),
				excelReader.getSingleExcelCellValue("Sheet1", 1, 1));
		sendKeys(gmailLocator.getPropertyFileValue("chooseEmailId"),
				excelReader.getSingleExcelCellValue("Sheet1", 1, 2));
		sendKeys(gmailLocator.getPropertyFileValue("createPassword"),
				excelReader.getSingleExcelCellValue("Sheet1", 1, 3));
		sendKeys(gmailLocator.getPropertyFileValue("conformPassword"),
				excelReader.getSingleExcelCellValue("Sheet1", 1, 4));
		click(gmailLocator.getPropertyFileValue("month"));
		click(gmailLocator.getPropertyFileValue("marchMonth"));
		sendKeys(gmailLocator.getPropertyFileValue("day"), "16");
		sendKeys(gmailLocator.getPropertyFileValue("year"), "1992");
		click(gmailLocator.getPropertyFileValue("gendarField"));
		click(gmailLocator.getPropertyFileValue("MaleGender"));
		sendKeys(gmailLocator.getPropertyFileValue("mobileNumber"),
				excelReader.getSingleExcelCellValue("Sheet1", 1, 5));
		sendKeys(gmailLocator.getPropertyFileValue("emailId"),
				excelReader.getSingleExcelCellValue("Sheet1", 1, 6));   

	}
}
