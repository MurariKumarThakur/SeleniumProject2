package dummyclassmethod;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.file.utility.excelFileReusable;
import com.file.utility.propertyFileReusable;
import com.object.utility.objectUtility;

public class class1 {

	public static void main(String[] args) throws IOException {
		
  excelFileReusable excel =    objectUtility.getExcelReusable(objectUtility.getExcelFilePath());
  
       System.out.println(   excel.getAllExcelCellValue("Sheet1"));
                 
	
	}

}
