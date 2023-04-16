package com.bank.qa.pages;

import java.time.Duration;
import java.util.List;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.bank.qa.base.TestBase;
import com.bank.qa.util.TestUtil;

public class ContactPage extends TestBase{
	
	JavascriptExecutor jse = (JavascriptExecutor) driver;
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	

	//Page Factory - OR
	@FindBy(xpath = "//input[@id='Companypi_Company']")
	private WebElement companyName;
	
	@FindBy(xpath = "//input[@id='First_Namepi_First_Name']")
	private WebElement firstName;

	@FindBy(xpath = "//input[@id='Last_Namepi_Last_Name']")
	private WebElement lastName;

	@FindBy(xpath = "//input[@id='Emailpi_Email']")
	private WebElement workEmail;

	@FindBy(xpath = "//label[text()='Phone']/following-sibling::input[@type='text']")
	private WebElement phoneField;

	@FindBy(xpath = "//label[text()='Country*']/following-sibling::select[@class='select']")
	private WebElement countryDropdown;

	@FindBy(xpath = "//label[text()='How did you hear about us?']/following-sibling::select[@class='select']")
	private WebElement howDidYouHearDropdown;

	@FindBy(xpath = "//form[@class='form']//div[7][@class=\"form-field form-col-full comments pd-textarea     \"]//label[text()='Enquiry Details']/following-sibling::textarea[@class='standard']")
	private WebElement enquiryDetail;

	@FindBy(xpath = "//label[@class='inline' and contains(text(),'* Terms')]/preceding-sibling::input[@type='checkbox']")
	private WebElement agreeCheckBox;

	public ContactPage() {
		PageFactory.initElements(driver, this);
	}

	public void fillInCompanyName(String company) {
		
		 wait.until(ExpectedConditions.visibilityOf(companyName));
		companyName.sendKeys(company);
		
	}

	public void fillInFirstName(String firstname) {
		 wait.until(ExpectedConditions.visibilityOf(firstName));
		firstName.sendKeys(firstname);
	}

	public void fillInLastName(String lastname) {
		 wait.until(ExpectedConditions.visibilityOf(lastName));
		lastName.sendKeys(lastname);
	}

	public void fillInWorkEmail(String email) {
		 wait.until(ExpectedConditions.visibilityOf(workEmail));
		workEmail.sendKeys(email);
	}

	public void fillInPhone(String phone){
		 wait.until(ExpectedConditions.visibilityOf(phoneField));
		phoneField.sendKeys(phone);
	}

	public void selectCountry(String country) {
		 wait.until(ExpectedConditions.visibilityOf(countryDropdown));
		Select select = new Select(countryDropdown);
		select.selectByVisibleText(country); }

	public void fillInEnquiryDetails(String enquiryDetails) {
		 wait.until(ExpectedConditions.visibilityOf(enquiryDetail));
		enquiryDetail.sendKeys(enquiryDetails);
	}

	public void selectHearAboutDropDown(String howDidYouHere) {
		 wait.until(ExpectedConditions.visibilityOf(howDidYouHearDropdown));
		Select select = new Select(howDidYouHearDropdown);
		select.selectByVisibleText(howDidYouHere);
	}


	public boolean setAgreeCheckBox() throws InterruptedException {
		Thread.sleep(2000);
		jse.executeScript("document.getElementById('941293_139028pi_941293_139028_631736').click()");
		Thread.sleep(4000);
       return true;
	}

	public String getCompany() {
		return companyName.getAttribute("value");
	}

	public String getFirstname() {
		return firstName.getAttribute("value");
	}

	public String getLastname() {
		return lastName.getAttribute("value");
	}

	public String getWorkEmail() {
		return workEmail.getAttribute("value");
	}

	public String getPhone() {
		return phoneField.getAttribute("value");
	}

	public String getSelectedCountry() {
		Select select = new Select(countryDropdown);
		return select.getFirstSelectedOption().getText();
	}

	public String getEnquiryDetails() {
		return enquiryDetail.getAttribute("value");
	}

	public String getSelectedHearAbout() {
		Select select = new Select(howDidYouHearDropdown);
		return select.getFirstSelectedOption().getText();
	}

	public boolean isTermsAgreeCheckBoxSelected() {
		return agreeCheckBox.isSelected();
	}

}
