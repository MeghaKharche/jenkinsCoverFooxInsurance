package coverFox_Test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import coverFox_Utility.UtilityUseAllMethods;
import coverFox_Base.BaseClass;
import coverFox_Pom.CoverFox_AddressDetails;
import coverFox_Pom.CoverFox_HealthPlanPage;
import coverFox_Pom.CoverFox_HealthPlanResults;
import coverFox_Pom.CoverFox_HomePage;
import coverFox_Pom.CoverFox_MemberDetails;

import java.io.IOException;
import java.time.Duration;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.EncryptedDocumentException;

import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.Assert;

//@Listeners(testNg_listeners.Listener_CoverFox.class)
//@Listeners(testNg_listeners.ExtentReporterNG.class)

public class CF_TC555_Validate_search_results_for_healthcare_policies extends BaseClass
{
  
	 // WebDriver driver;
	
	  public static Logger logger;
	
	  CoverFox_HomePage home;
	  CoverFox_HealthPlanPage healthPlan;
	  CoverFox_MemberDetails memberDetails;
	  CoverFox_AddressDetails addressDetails;
	  CoverFox_HealthPlanResults healthPlanResult;
	  
	  @BeforeClass  //Launch browser
	  
	  public void launchBrowser() throws InterruptedException
	  {
		  logger = Logger.getLogger("CoverFoxInsurance");
		  PropertyConfigurator.configure("log4j.properties");
		  
		  //whenever we show error using log4j then we use error() OR fatal() 
		  
		//  logger.fatal("hi using log4j fatal");
		//  driver= new ChromeDriver();
		  
		  launchCoverFoxBrowser();   ////BaseClass Method name
		  
		  logger.info("launching coverfox browser"); //same use as a Reporter.log() show msg in output window
		  
		  home=new CoverFox_HomePage(driver);
		  healthPlan= new CoverFox_HealthPlanPage(driver);
		  memberDetails = new CoverFox_MemberDetails(driver);
		  addressDetails = new CoverFox_AddressDetails(driver);
		  healthPlanResult= new CoverFox_HealthPlanResults(driver);
	  
//		  Reporter.log("Opening browser ", true);
//		  driver.get("https://www.coverfox.com/");
//		  driver.manage().window().maximize();
//		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); 
	  }
	  
	  @BeforeMethod  //Declare all Page Method Name
	  
	  public void enterMemeberDeatils() throws InterruptedException,
	  EncryptedDocumentException, IOException
	 {
		  //logger.info AND Reporter.log it is a same for showing message whenever we execute program
		  
		  logger.info("clicking on gender button");
		  //Reporter.log("clicking on gender button ", true); //methodName HomePage ==>CoverFoxHomePage_1stPage
		  home.ClickOnFemaleButton();
		  Thread.sleep(1000);
		  
		  logger.info("clicking on next button");
		  //Reporter.log("clicking on next button ", true); //methodName HelathPlanPage ==>CoverFoxHealthPlan_2ndPage
		  healthPlan.ClickOnNextButton();
		  Thread.sleep(1000);
		  
		  logger.info("Handeling age drop down");
		  //Reporter.log("Handeling age drop down ", true);  //methodName MemberDetailsPage ==>CoverFoxMemberDetails_3rdPage
		  // memberDetails.selectAgeDropDownList("28");
		  memberDetails.selectAgeDropDownList(UtilityUseAllMethods.readDataFromExcelSheet(0,0));
		
		  logger.info("clicking on next button");
		//Reporter.log("Clicking on next button ", true);
		  memberDetails.ClickOnNextButton();
		  Thread.sleep(1000);
		  
		  logger.info("Entering pin code");
		  //Reporter.log("Entering pin code ",true);	//MethodName AddressDetailsPage
		 //addressDetails.enterPinCode("412105");  //write manually
		  addressDetails.enterPinCode(UtilityUseAllMethods.readDataFromExcelSheet(0,1));
		  
		  logger.info("Entering mobile num");
		 //Reporter.log("Entering mobile num ",true);
		  addressDetails.enterMobNumber(UtilityUseAllMethods.readDataFromExcelSheet(0,2));
		  
		  
		  //property file data
		  
//		  Reporter.log("Handeling age drop down", true);
//			memberDetails.selectAgeDropDownList(UtilityUseAllMethods.readDataFromExcelSheet("age"));
//			memberDetails.ClickOnNextButton();
//			Thread.sleep(1000);
//			
//			Reporter.log("Entering Pincode", true);
//			//addressDetails.enterPinCode("pincode");
//			addressDetails.enterPinCode(UtilityUseAllMethods.readDataFromExcelSheet("pincode"));
//		
//			Reporter.log("Entering mobile number", true);
//			//addressDetails.enterMobileNumber("mobileNumber");
//			addressDetails.enterMobNumber(UtilityUseAllMethods.readDataFromExcelSheet("mobileNumber"));
//			
		  
		  logger.info("Clicking on continue button");
		 //Reporter.log("Clicking on continue button ", true);
		  addressDetails.clickOnContinueButton();
		  Thread.sleep(2000);
	  }
	  
	  @Test
	  public void validateTestPlansFromTextAndBanners() throws InterruptedException
	  {
		  Thread.sleep(5000);
		  
		  logger.info("Fetching number of results from text");
		 // Reporter.log("Fetching number of results from text ", true);
		  int textResult = healthPlanResult.availablePlanNumberFromText();
		  Thread.sleep(7000);
		  
		  logger.info("Fetching number of results from Banners");
		  //Reporter.log("Fetching number of results from Banners ", true);
		  int bannerResult = healthPlanResult.availablePlanNumberFromBanners();
		  Thread.sleep(5000);
		  
		  //code for passed test cases
		  
		  Assert.assertEquals(textResult, bannerResult,"Text results are not matching with Banner results, TC is failed");
		  logger.info("TC is passed");
		//  Reporter.log("TC is passed ", true);
	      Thread.sleep(7000);
		
	      //code for failed test cases screenshot using listeners
	
//	      Assert.assertNotEquals(textResult, bannerResult,"Text results are matching with Banner results, TC is failed");
//		  Reporter.log("TakeScreenshot failed TC is passed ", true);
//		  Thread.sleep(7000);
	  }
	  
	  @AfterMethod     //Close Browser
	 
	  public void closeBrowser() throws InterruptedException
	  {
		  logger.info("closing coverfox browser");
		//  Reporter.log("Closing browser ", true);
		  Thread.sleep(5000);
		  //driver.close();
		  closeCoverFoxBrowser(); //BaseClass Method name
	  }

	
  
}
