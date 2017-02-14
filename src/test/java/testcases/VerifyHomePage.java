package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.microsoft.schemas.office.excel.CTClientData.Factory;

import dataProvider.ConfigDataProvider;
import factory.BrowserFactory;
import factory.DataProviderFactory;
import pages.HomePage;

public class VerifyHomePage {
	WebDriver driver;
	
	@BeforeMethod
	public void setup(){
		driver = BrowserFactory.getBrowser("chrome");
		
		//driver.get(DataProviderFactory.getConfig().getApplicationUrl());
		driver.get(new ConfigDataProvider().getApplicationUrl());
	}
	
	@Test
	public void testHomePage(){
		
		HomePage home = PageFactory.initElements(driver, HomePage.class);
		//HomePage home = new HomePage(driver);
		
		String title = home.getApplicationTitle();
		System.out.println(title);
		Assert.assertTrue(title.contains("My Store"));

	}
	
	@AfterMethod
	public void tearDown(){
		BrowserFactory.closeBrowser(driver);
	}
}
