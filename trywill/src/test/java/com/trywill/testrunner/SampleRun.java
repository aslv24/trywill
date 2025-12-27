package com.trywill.testrunner;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.trywill.pageobjects.CreateAccountPage;
import com.trywill.testUtility.DriverUtility;
import com.trywill.testUtility.ListenersUtility;
import com.trywill.testbase.BaseClass;

@Listeners(ListenersUtility.class)
public class SampleRun extends BaseClass{

	CreateAccountPage accountPage;
	
	@BeforeClass
	public void setup()
	{
		createDriver("chrome");
		
		accountPage=new CreateAccountPage();
		
	}
	
	@Test(priority = 1)
	public void verifyPageTitle()
	{
		String expectedWebpageTitle="Facebook - India";
		
		String webpageTitle = DriverUtility.getInstance().getWebpageTitle();
		
		SoftAssert softAssert=new SoftAssert();
		
		softAssert.assertEquals(webpageTitle,expectedWebpageTitle);
		
		System.out.println("Page Title :: "+webpageTitle);
		
		softAssert.assertAll();
		
	}
	
	@Test(priority = 2)
	public void verifyPageUrl()
	{
		
		String expectedWebpageUrl="https://www.facebook.co.in";
		
		String webpageUrl = DriverUtility.getInstance().getWebpageUrl();
		
		SoftAssert softAssert=new SoftAssert();
		
		softAssert.assertEquals(webpageUrl,expectedWebpageUrl);
		
		System.out.println("Page Url :: "+webpageUrl);
		
		softAssert.assertAll();
		
	}
	
	@Test(priority = 3)
	public void verifyAccount()
	{
		accountPage.verifyNewAccountCreation("Logeshwaran", "Sivasamy", "30", "May", "1992");
	}

}
