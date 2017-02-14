package testcases;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import factory.BrowserFactory;
import factory.DataProviderFactory;
import pages.HomePage;
import pages.LoginPage;

public class VerifyLoginPage {
	WebDriver driver;
	
	@BeforeMethod
	public void setup(){
		driver = BrowserFactory.getBrowser("chrome");
		driver.get(DataProviderFactory.getConfig().getApplicationUrl());
		
	}
	
	@Test
	public void loginTest(){
		HomePage home = PageFactory.initElements(driver, HomePage.class);
		//HomePage home = new HomePage(driver);
		home.clickOnSignIn();
		
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		//LoginPage loginPage = new LoginPage(driver);
		
		//loginPage.loginToApplication("ballu@gmail.com", "ballu");
		loginPage.loginToApplication(DataProviderFactory.getExcel().getData(0, 0, 0), DataProviderFactory.getExcel().getData(0, 0, 1));
		
		//Assert.assertTrue(driver.findElement(By.xpath("//a[@class='logout' and @title='Log me out']")).isDisplayed());
		loginPage.verifySignOutLink();
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	

}
