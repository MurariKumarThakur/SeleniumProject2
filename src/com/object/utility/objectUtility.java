package com.object.utility;

import java.io.IOException;

import com.file.utility.excelFileReusable;
import com.file.utility.propertyFileReusable;
import com.file.utility.textFileReusable;

public class objectUtility {
	
	private String  filePath ;
	
	private static  excelFileReusable excelReusable ;
	private static  propertyFileReusable configFile ;
	private static  textFileReusable textFile ;
	private static  propertyFileReusable gmailLocFile ;
	
	private static String  excelFilePath = "./src/com/testData/TestData.xlsx" ;
	private static String  configFilePath ="./config.property" ;
	private static String textFilePath ="./src/TextFileFolder/textFile.txt" ;
	private static String gmailLocPath = "./src/com/app/objectRepository/OR.gmail.locator";
	public static excelFileReusable getExcelReusable(String filePath) {
		
		excelFileReusable excelReusable = new excelFileReusable(filePath);
	     	return excelReusable;
	}
	public static propertyFileReusable getConfig(String filePath) {
		propertyFileReusable configFile = new propertyFileReusable(filePath);
		return configFile;
	}
	public static textFileReusable getTextfile(String filePath) {
		try {
			textFileReusable textFile = new textFileReusable(filePath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return textFile;
	}
	public static propertyFileReusable getGmailLocFile(String filePath) {
		
		propertyFileReusable gmailLocFile = new propertyFileReusable(filePath);
		return gmailLocFile;
	}
	public static String getExcelFilePath() {
		return excelFilePath;
	}
	public static String getConfigFilePath() {
		return configFilePath;
	}
	public static String getTextFilePath() {
		return textFilePath;
	}
	public static String getGmailLocPath() {
		return gmailLocPath;
	}
	
}
