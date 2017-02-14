package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import factory.BrowserFactory;
import factory.DataProviderFactory;
import pages.HomePage;
import pages.LoginPage;
import utility.Helper;

public class VerifyLoginPageWithReportsAndScreenshots {
	WebDriver driver;
	ExtentReports report;
	ExtentTest logger;
	
	@BeforeMethod
	public void setup(){
		driver = BrowserFactory.getBrowser("chrome");
		driver.get(DataProviderFactory.getConfig().getApplicationUrl());
		
		report = new ExtentReports("./Reports/LoginPageReport.html", true);
		
		logger = report.startTest("VerifyLoginPage", "This test verifies if login happens successfully or not");
		
		logger.log(LogStatus.INFO, "Application is up and running");
		
	}
	
	@Test
	public void loginTest(){
		HomePage home = PageFactory.initElements(driver, HomePage.class);
		//HomePage home = new HomePage(driver);
		
		String title = home.getApplicationTitle();
		Assert.assertTrue(title.contains("My Store"));
		logger.log(LogStatus.PASS, "Home page loaded and verified");
		
		home.clickOnSignIn();
		logger.log(LogStatus.INFO, "Clicked on Sign In link");
		
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		//LoginPage loginPage = new LoginPage(driver);
		
		//loginPage.loginToApplication("ballu@gmail.com", "ballu");
		loginPage.loginToApplication(DataProviderFactory.getExcel().getData(0, 0, 0), DataProviderFactory.getExcel().getData(0, 0, 1));
		logger.log(LogStatus.INFO, "Logged into application");
		
		//Assert.assertTrue(driver.findElement(By.xpath("//a[@class='logout' and @title='Log me out']")).isDisplayed());
		loginPage.verifySignOutLink();
		logger.log(LogStatus.PASS, "Sign Out link is present hence Login is verified");
		
		logger.log(LogStatus.INFO, logger.addScreenCapture(Helper.captureScreenshot(driver, "screenshot"+System.currentTimeMillis())));
	}
	
	@AfterMethod
	public void tearDown(ITestResult result){
		if(result.getStatus()==ITestResult.FAILURE){
			String path = Helper.captureScreenshot(driver, result.getName());
			logger.log(LogStatus.FAIL, logger.addScreenCapture(path));
			
		}
		BrowserFactory.closeBrowser(driver);
		report.endTest(logger);
		report.flush();
		//logger.log(LogStatus.INFO, "Browser closed");
	}
	

}
