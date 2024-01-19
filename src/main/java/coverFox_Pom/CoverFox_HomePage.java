package coverFox_Pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//create 4Package using testBaseUtilityPom==> coverFox_UsingPom, Test,Base,Utility
//POM Package→ Add all POM classes here

public class CoverFox_HomePage
{
	
	//Declare all classes(pages) where we perform action on webpage
	
	//declare variable
	@FindBy(xpath = "//div[text()='Female']") private WebElement femaleButton;
	
	//declare Constructor
	public CoverFox_HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Declare Methods
	public void ClickOnFemaleButton()
	{
		femaleButton.click();
	}

}
