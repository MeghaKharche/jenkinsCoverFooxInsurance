package testNg_listeners;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

import coverFox_Utility.UtilityUseAllMethods;
import coverFox_Base.BaseClass;

public class Listener_CoverFox extends BaseClass implements ITestListener
{
	//use driver-->but this driver inside the takeScreenshot so we extends BaseClass
	
	@Override
	public void onTestFailure(ITestResult result) 
	{
		try {
			UtilityUseAllMethods.takeScreenShot(driver, result.getName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
//	@Override
//	public void onTestSuccess(ITestResult result) 
//	{
//		
//	}
//	
//	
//	@Override
//	public void onTestSkipped(ITestResult result)
//	{
//		
//	}
}
