package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LoginPage {
	
	WebDriver driver;
	public LoginPage(WebDriver driver){
		this.driver = driver;
		//PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath=".//*[@id='email']")
	WebElement txtEmail;
	
	@FindBy(xpath=".//*[@id='passwd']")
	WebElement txtPasswd;
	
	@FindBy(xpath=".//*[@id='SubmitLogin']")
	WebElement btnSignIn;
	
	@FindBy(xpath="//a[@class='logout' and @title='Log me out']")
	WebElement lnkSignOut;
	
	By signOutText = By.xpath("//a[@class='logout' and @title='Log me out']");
	
	public void loginToApplication(String username, String password){
		txtEmail.sendKeys(username);
		txtPasswd.sendKeys(password);
		btnSignIn.click();
	}
	
	public void verifySignOutLink(){
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement ele = wait.until(ExpectedConditions.presenceOfElementLocated(signOutText));
		String text = ele.getText();
		Assert.assertEquals(text, "Sign out", "Sign out button is not present");
	}

}
