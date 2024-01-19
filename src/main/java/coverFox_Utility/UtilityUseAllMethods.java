package coverFox_Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;

//create 4Package using testBaseUtilityPom==> coverFox_UsingPom, Test,Base,Utility

public class UtilityUseAllMethods 
{
	//ReadExcelSheetData
	
	public static String readDataFromExcelSheet(int row, int cell) throws EncryptedDocumentException, IOException
	{
		Reporter.log("Read data from excel sheet method", true);
		//FileInputStream myFile = new FileInputStream("F:\\ExcelSheetEclilpse\\UsingTestBaseUtility.xlsx");
		FileInputStream myFile = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\UsingTestBaseUtility.xlsx");
		String excelSheeteData = WorkbookFactory.create(myFile).getSheet("sheet1").getRow(row).getCell(cell).getStringCellValue();
		return excelSheeteData;
	}
	
	//property file Data

//	public static String readDataFromExcelSheet(String age) throws EncryptedDocumentException, IOException
//	{
//		Properties prop = new Properties();
//		
//		//create object of FileInputStream
//		
//		//FileInputStream myFile = new FileInputStream(("user.dir")+"\\CoverFoxReadDataUsingPropertyFiles.properties");
//		FileInputStream myFile = new FileInputStream("C:\\Users\\USER\\eclipse-workspace\\first_page\\seleniumMegha\\CoverFoxReadDataUsingPropertyFiles.properties");
//		
//		//using properties object name load this
//		prop.load(myFile);
//		
//		// using getProperty() that we write property file key 
//		Reporter.log("Select Age From Properties Files", true);
//		String age1 = prop.getProperty(age);
//		return age1;
//
//	
//	}
	
	//TakeScreenShot
	
	//1.way ==> takeScreenshot pass test cases 
	//2.way ==> again take fail test cases screenshot using Listeners  //use 2 way this code
	
	public static void takeScreenShot(WebDriver driver,String TCID) throws IOException
	{
		Reporter.log("Taking screenshot", true);
		String timeStamp= new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());

		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest=new File("F:\\Screenshot\\coverFox"+TCID+"_"+timeStamp+".png");
		
		Reporter.log("Saved screenshot at "+dest, true);
		FileHandler.copy(src, dest);
	}
	
	

}
