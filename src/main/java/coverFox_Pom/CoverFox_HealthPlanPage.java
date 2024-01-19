package coverFox_Pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CoverFox_HealthPlanPage 
{
	//declare variable
	@FindBy(className = "next-btn") private WebElement nextButton;
	
	//declare contructor
	public CoverFox_HealthPlanPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//declare methods
	public void ClickOnNextButton()
	{
		nextButton.click();
	}

}
