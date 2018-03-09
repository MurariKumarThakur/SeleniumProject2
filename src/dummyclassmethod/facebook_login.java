package dummyclassmethod;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.net.SyslogAppender;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;

import com.file.utility.excelFileReusable;

public class facebook_login {

	WebDriver driver;
	File file;
	FileInputStream fis;
	String cellValue;
	String filePath = "./src/com/testData/facebookLogin.xls";

	@BeforeClass
	public void launchBrowser() {

		System.setProperty("webdriver.chrome.driver", "./browserDrivercontainer/chromedriver.exe");
		driver = new ChromeDriver();

	}

	public void loginFacebook(String username, String password) {
		
		System.setProperty("webdriver.chrome.driver", "./browserDrivercontainer/chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.get("https://www.facebook.com"
				+ "");

		driver.findElement(By.id("email")).sendKeys(username);

		driver.findElement(By.id("pass")).sendKeys(password);

	//	driver.findElement(By.name("login")).click();

	}

	public String getColumeWiseValue(String sheetName, String columnName) {

		Row row;
		File file = new File(filePath);
		FileInputStream fis;
		Workbook workbook;
		try {
			fis = new FileInputStream(file);
			workbook = WorkbookFactory.create(fis);
			Sheet sheet = workbook.getSheet("Sheet1");

			row = sheet.getRow(0);

			int col_Num = 0;

			//System.out.println(row.getLastCellNum());

			for (int i = 0; i < row.getLastCellNum(); i++) {

				if (row.getCell(i).getStringCellValue().equals(columnName)) {

					for (int k = 1; k <= sheet.getLastRowNum(); k++) {

						Row total = sheet.getRow(k);
						Cell cell = total.getCell(i);
						if (cell != null) {

							if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
								
								//System.out.println(cell.getStringCellValue());

								//return cell.getStringCellValue();
								
								
								
							} else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
								return  String.valueOf(cell.getNumericCellValue());
							} else if (cell.getCellType() == Cell.CELL_TYPE_BOOLEAN) {
								return  String.valueOf(cell.getBooleanCellValue());
							} else if (cell.getCellType() == Cell.CELL_TYPE_BLANK) {
								return "";
							}

						}
					}
				}
			}

		} catch (Exception e) {

			e.printStackTrace();
		}
		return null;

	}

	public static void main(String[] args) throws EncryptedDocumentException, InvalidFormatException, IOException {

		facebook_login obj = new facebook_login();

		//obj.getColumeWiseValue("Sheet1", "address");
		
		obj.loginFacebook(obj.getColumeWiseValue("Sheet1", "firstName"),obj.getColumeWiseValue("Sheet1", "lastName") );

	}

}
