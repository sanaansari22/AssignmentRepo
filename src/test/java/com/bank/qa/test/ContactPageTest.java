package com.bank.qa.test;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.bank.qa.base.TestBase;
import com.bank.qa.pages.ContactPage;
import com.bank.qa.testdata.ExcelDataSupplier;
import com.bank.qa.util.TestUtil;

public class ContactPageTest extends TestBase {

	ContactPage contactPage;
	public ContactPageTest() {
		super();

	}

	@BeforeMethod
	public void setupTest() throws Exception {
		initialization();
		Thread.sleep(3000);
		TestUtil.handleBankUrlCookies();
		TestUtil.switchToFormFrame();
		Thread.sleep(3000);



		contactPage= new ContactPage();
	}


	@Test(dataProvider = "getData", dataProviderClass = ExcelDataSupplier.class)
	public void fillInContactForm(String company,String firstName,String lastName,String email,String phone, String country,String enquiryDetails,String howDidYouHere) throws Exception {


		contactPage.fillInCompanyName(company);
		contactPage.fillInFirstName(firstName);
		contactPage.fillInLastName(lastName);
		contactPage.fillInWorkEmail(email);
		contactPage.fillInPhone(phone);
		contactPage.selectCountry(country);
		contactPage.fillInEnquiryDetails(enquiryDetails);
		contactPage.selectHearAboutDropDown(howDidYouHere);
		contactPage.setAgreeCheckBox();

		Assert.assertEquals(contactPage.getCompany(), company);
		Assert.assertEquals(contactPage.getFirstname(), firstName);
		Assert.assertEquals(contactPage.getLastname(), lastName);
		Assert.assertEquals(contactPage.getWorkEmail(), email);
		Assert.assertEquals(contactPage.getPhone(),phone);
		Assert.assertEquals(contactPage.getSelectedCountry(), country);
		Assert.assertEquals(contactPage.getEnquiryDetails(), enquiryDetails);
		Assert.assertEquals(contactPage.getSelectedHearAbout(), howDidYouHere);
		Assert.assertTrue(true);

		// Take a screenshot of the filled-in contact form
		TestUtil.takeScreenshotAtEndOfTest();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
