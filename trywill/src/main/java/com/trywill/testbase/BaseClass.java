package com.trywill.testbase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;

import com.trywill.testUtility.DriverUtility;

public class BaseClass {

	public static WebDriver driver;
	
	
	public void createDriver(String browserName)
	{
		if(browserName.equalsIgnoreCase(BrowserType.CHROME))
		{
			DriverUtility.getInstance().createChromeDriver();
		}
		//edge
		//MicrosoftEdge
		else if(browserName.toLowerCase().contains(BrowserType.EDGE))
		{
			DriverUtility.getInstance().createEdgeDriver();
		}
		
		else if(browserName.equalsIgnoreCase(BrowserType.FIREFOX))
		{
			DriverUtility.getInstance().createFirefoxDriver();
		}
		
		else
		{
			//throw new RuntimeException("Unable to Create the Driver for given browser name - "+browserName);
		}
		
		DriverUtility.getInstance().maximizeWindow();
		DriverUtility.getInstance().setImplicitWait(2);
		DriverUtility.getInstance().openUrl(Constants.NEW_URL);
	}
}
