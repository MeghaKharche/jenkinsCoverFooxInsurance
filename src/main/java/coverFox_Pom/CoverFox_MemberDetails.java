package coverFox_Pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CoverFox_MemberDetails
{
	//declare Variable
	@FindBy(id="Age-You") private WebElement ageDropdownList;
	@FindBy(xpath = "//div[@class='next-btn']") private WebElement nextButton;
	
	//declare Constructor
	public CoverFox_MemberDetails(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//declare Method
	public void selectAgeDropDownList(String age)
	{
		Select s = new Select(ageDropdownList);
		s.selectByValue(age+"y"); //excel sheet data
		//s.selectByValue(age);		//properties file data
	}
	
	public void ClickOnNextButton()
	{
		nextButton.click();
	}
	
}
