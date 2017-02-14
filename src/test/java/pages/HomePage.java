package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver;
	public HomePage(WebDriver driver){
		this.driver = driver;
		//PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//a[@class='login']")
	WebElement lnkSignIn;
	
	@FindBy(xpath=".//*[@id='contact-link']/a")
	WebElement lnkContactUs;
	
	@FindBy(xpath="//b[text()='Cart']")
	WebElement lnkCart;
	
	public void clickOnSignIn(){
		lnkSignIn.click();
	}
	
	public void clickOnContactUs(){
		lnkContactUs.click();
	}
	
	public void clickOnCart(){
		lnkCart.click();
	}
	
	public String getApplicationTitle(){
		return driver.getTitle();
	}

}
