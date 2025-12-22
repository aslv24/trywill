package com.trywill.testrunner;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.trywill.testUtility.DriverUtility;
import com.trywill.testbase.BaseClass;

public class OrangeHRM extends BaseClass{
	
	@BeforeClass
	public void setup()
	{
		createDriver("chrome");
	}

@Test
public void runTheCode()
{
	WebElement usernameField = driver.findElement(By.name("username"));
	
	WebElement passwordField = driver.findElement(By.name("password"));
	
	WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
	
	DriverUtility.getInstance().fillText(usernameField, "Admin");
	
	DriverUtility.getInstance().fillText(passwordField, "admin123");
	
	DriverUtility.getInstance().click(loginButton);
	
	try {
	WebElement dashboardPageIcon = driver.findElement(By.xpath("//h6[text()='Dashboard']"));
	
	boolean displayed = dashboardPageIcon.isDisplayed();
	
	Assert.assertTrue(displayed,"Login Failed...");
	}
	catch(NoSuchElementException e)
	{
		Assert.fail("Invalid Credentials");
	}
	
}
}
