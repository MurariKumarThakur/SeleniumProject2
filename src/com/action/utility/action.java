package com.action.utility;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.file.utility.propertyFileReusable;
import com.framework.reusable.driverEngine;
import com.object.utility.objectUtility;

public class action extends driverEngine {
	WebDriverWait wait;
	WebElement web;
	Robot r;
	static propertyFileReusable gmailLoc = objectUtility.getGmailLocFile(objectUtility.getGmailLocPath());

	public WebElement getLocator(String fullLocator) {

		String[] str = fullLocator.split(":");
		String locatorType = str[0];
		String locatorValue = str[1];

		if (locatorType.equalsIgnoreCase("xpath")) {

			return getDriver().findElement(By.xpath(locatorValue));
		} else if (locatorType.equalsIgnoreCase("css")) {

			return getDriver().findElement(By.cssSelector(locatorValue));
		} else if (locatorType.equalsIgnoreCase("id")) {

			return getDriver().findElement(By.id(locatorValue));
		} else if (locatorType.equalsIgnoreCase("name")) {

			return getDriver().findElement(By.name(locatorValue));

		} else if (locatorType.equalsIgnoreCase("class")) {

			return getDriver().findElement(By.className(locatorValue));
		} else if (locatorType.equalsIgnoreCase("linkText")) {

			return getDriver().findElement(By.linkText(locatorValue));

		} else if (locatorType.equalsIgnoreCase("class")) {

			return getDriver().findElement(By.partialLinkText(locatorValue));
		} else {

			try {
				throw new Exception("UNKNOWN LOCATOR TYPE " + locatorType);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
		}
		return null;
	}

	public List<WebElement> getLocators(String fullLocator) {
		String[] str = fullLocator.split(":");
		String locatorType = str[0];
		String locatorValue = str[1];

		if (locatorType.equalsIgnoreCase("xpath")) {

			return getDriver().findElements(By.xpath(locatorValue));
		} else if (locatorType.equalsIgnoreCase("css")) {

			return getDriver().findElements(By.cssSelector(locatorValue));
		} else if (locatorType.equalsIgnoreCase("id")) {

			return getDriver().findElements(By.id(locatorValue));
		} else if (locatorType.equalsIgnoreCase("name")) {

			return getDriver().findElements(By.name(locatorValue));

		} else if (locatorType.equalsIgnoreCase("class")) {

			return getDriver().findElements(By.className(locatorValue));
		} else if (locatorType.equalsIgnoreCase("linkText")) {

			return getDriver().findElements(By.linkText(locatorValue));

		} else if (locatorType.equalsIgnoreCase("class")) {

			return getDriver().findElements(By.partialLinkText(locatorValue));
		} else {

			try {
				throw new Exception("UNKNOWN LOCATOR TYPE " + locatorType);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
		}
		return null;

	}

	public void loadUrl(String url) {

		getDriver().get(url);
	}

	public void sendKeys(String fullLocator, String textData) {
		getLocator(fullLocator).clear();
		getLocator(fullLocator).sendKeys(textData);

	}

	public void click(String fullLocator) {

		getLocator(fullLocator).click();
	}

	public void clear(String fullLocator) {

		getLocator(fullLocator).clear();

	}

	public String getTitle() {

		String actualTitle = getDriver().getTitle();

		return actualTitle;

	}

	public void waitForVisiablity(String FullLocator) {

		wait = new WebDriverWait(getDriver(), 30);
		wait.until(ExpectedConditions.visibilityOf(getLocator(FullLocator)));
	}

	public void waitForClickable(String FullLocator) {

		wait = new WebDriverWait(getDriver(), 30);
		wait.until(ExpectedConditions.elementToBeClickable(getLocator(FullLocator)));
	}

	public String getText(String fullLocator) {

		String actualText = getLocator(fullLocator).getText();

		return actualText;

	}

	public void mousOver(String fullLocator) {

		Actions act = new Actions(getDriver());

		act.moveToElement(getLocator(fullLocator)).perform();

	}

	public void clickOnEnterButton() {

		try {
			r = new Robot();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		r.keyPress(KeyEvent.VK_ENTER);
	}
}
