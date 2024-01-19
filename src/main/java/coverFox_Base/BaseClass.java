package coverFox_Base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;

//create 4Package using testBaseUtilityPom==> coverFox_UsingPom, Test,Base,Utility

public class BaseClass 
{
	static protected WebDriver driver;
	
	//launchBrowser
	public void launchCoverFoxBrowser() throws InterruptedException
	{
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Reporter.log("Launch Browser", true);
		driver.get("https://www.coverfox.com/");
		Thread.sleep(1000);
	}
	
	//close Browser
	public void closeCoverFoxBrowser() throws InterruptedException
	{
		Thread.sleep(5000);
		Reporter.log("Close CoverFox Browser", true);
		driver.close();
	}
	

}
