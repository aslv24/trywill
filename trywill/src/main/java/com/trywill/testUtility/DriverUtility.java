package com.trywill.testUtility;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

import com.trywill.testbase.BaseClass;
import com.trywill.testbase.Constants;

public class DriverUtility extends BaseClass {

	private static DriverUtility driverUtility = new DriverUtility();

	private DriverUtility() {

	}

	public static DriverUtility getInstance() {
		return driverUtility;
	}

	public void createChromeDriver() {
		System.setProperty(Constants.CHROME_DRIVER_KEY, Constants.CHROME_DRIVER_PATH);
		driver = new ChromeDriver();
	}

	public void createEdgeDriver() {
		System.setProperty(Constants.EDGE_DRIVER_KEY, Constants.EDGE_DRIVER_PATH);
		driver = new EdgeDriver();
	}

	public void createFirefoxDriver() {
		System.setProperty(Constants.FIREFOX_DRIVER_KEY, Constants.FIREFOX_DRIVER_PATH);
		driver = new FirefoxDriver();
	}

	public void maximizeWindow() {
		driver.manage().window().maximize();
	}

	public void setImplicitWait()// 30
	{
		driver.manage().timeouts().implicitlyWait(Constants.TIMEOUT_LONG, TimeUnit.SECONDS);
	}

	public void setImplicitWait(long wait)// user defined
	{
		driver.manage().timeouts().implicitlyWait(wait, TimeUnit.SECONDS);
	}

	public void openUrl(String pageUrl) {
		driver.get(pageUrl);
	}

	public String getWebpageTitle() {
		return driver.getTitle();
	}

	public String getWebpageUrl() {
		return driver.getCurrentUrl();
	}

	public void click(WebElement element) {
		element.click();
	}

	public void fillText(WebElement element, String value) {
		element.click();
		element.clear();
		element.sendKeys(value);
	}

	public void clear(WebElement element) {
		element.clear();
	}

	public void selectByIndex(WebElement element, int index) {
		new Select(element).selectByIndex(index);
	}

	public void selectByValue(WebElement element, String value) {
		new Select(element).selectByValue(value);
	}

	public void selectByText(WebElement element, String visibleText) {
		new Select(element).selectByVisibleText(visibleText);
	}
	
	public void switchToFrame(int frameIndex)
	{
		driver.switchTo().frame(frameIndex);
	}
	
	public void switchToFrame(String frameNameOrId)
	{
		driver.switchTo().frame(frameNameOrId);
	}
	
	public void switchToFrame(WebElement element)
	{
		driver.switchTo().frame(element);
	}
	
	public void captureScreenshot(String fileName)
	{
		
		String screenshotFolder=Constants.SCREENSHOT_DIR;
		
		String screenshotType=Constants.IMAGE_FORMAT_PNG;
		
		File screenshotAs = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		File screenshotTo=new File(screenshotFolder+fileName+screenshotType);
		try {
		FileHandler.copy(screenshotAs, screenshotTo);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	

}
