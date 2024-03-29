package coverFox_Pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CoverFox_HealthPlanResults 
{
	//declare Variable
	@FindBy(xpath = "//div[contains(text(),'matching Health')]") private WebElement resultsInString;
	@FindBy(id = "plans-list") private List<WebElement> planList;
	
	//declare Constructor
	public CoverFox_HealthPlanResults(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//declare Methods
	public int availablePlanNumberFromText()
	{		
		String test = resultsInString.getText();
		
		//49 matching Health Insurance Plans
		String ar[]=test.split(" ");
		
		//ar[]={"49" "matching" "Health" "Insurance" "Plans"}
		String numberOfResultsInString = ar[0];//49-->String
		
		//convert String to integer
		int numberOfResultsInInt = Integer.parseInt(numberOfResultsInString);//49-->in number(int)
	
		return numberOfResultsInInt;
	}

	public int availablePlanNumberFromBanners()
	{
		int totalNumberOfPlans = planList.size();
		return totalNumberOfPlans;

	}
}
