package com.bank.qa.util;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import com.bank.qa.base.TestBase;
import com.bank.qa.pages.ContactPage;


public class TestUtil extends TestBase {

	
	public static long PAGE_LOAD_TIMEOUT = 15;
	public static long IMPLICITLY_WAIT = 15;

	
	public static void switchToFormFrame() {
		WebElement frameElement = driver.findElement(By.xpath("(//iframe[@type='text/html'])[3]"));
		driver.switchTo().frame(frameElement);
	}
	
	public static void handleBankUrlCookies() throws Exception{
		WebElement cookieButn  =  driver.findElement(By.xpath("//a[@id='cookie_action_close_header']"));
	    cookieButn.click();
          Thread.sleep(2000);

	}
	
public static void takeScreenshotAtEndOfTest() throws IOException {

	File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	String currentDir = System.getProperty("user.dir");
	FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
}
	
	
}
