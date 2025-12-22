package com.trywill.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.trywill.testUtility.DriverUtility;
import com.trywill.testbase.BaseClass;

public class CreateAccountPage extends BaseClass {
	
	public CreateAccountPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[contains(text(),'Create')]")
	private WebElement createNewAccountButton;

	@FindBy(xpath = "//input[@name='firstname']")
	private WebElement firstnameField;

	@FindBy(xpath = "//input[@name='lastname']")
	private WebElement lastnameField;

	@FindBy(xpath = "//select[@id='day']")
	private WebElement daydropdown;

	@FindBy(xpath = "//select[@id='month']")
	private WebElement monthdropdown;

	@FindBy(xpath = "//select[@id='yea']")
	private WebElement yeardropdown;

	public void verifyNewAccountCreation(String firstname, String lastname, String day, String month, String year) {
		clickCreateNewAccountButton();
		enterFirstnameField(firstname);
		enterlastnameField(lastname);
		chooseDaydropdown(day);
		chooseMonthdropdown(month);
		chooseYeardropdown(year);
	}

	public void clickCreateNewAccountButton() {
		DriverUtility.getInstance().click(createNewAccountButton);
	}

	public void enterFirstnameField(String firstname) {
		DriverUtility.getInstance().fillText(firstnameField, firstname);
	}

	public void enterlastnameField(String lastname) {
		DriverUtility.getInstance().fillText(lastnameField, lastname);
	}

	public void chooseDaydropdown(String day) {
		DriverUtility.getInstance().selectByText(daydropdown, day);
	}

	public void chooseMonthdropdown(String month) {
		DriverUtility.getInstance().selectByText(monthdropdown, month);
	}

	public void chooseYeardropdown(String year) {
		DriverUtility.getInstance().selectByText(yeardropdown, year);
	}

}
