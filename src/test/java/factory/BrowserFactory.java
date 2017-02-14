package factory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import dataProvider.ConfigDataProvider;

public class BrowserFactory {
	
	static WebDriver driver;
	
	public static WebDriver getBrowser(String browserName){
		if(browserName.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.gecko.driver", DataProviderFactory.getConfig().getFirefoxPath());
			driver = new FirefoxDriver();
		}else if(browserName.equalsIgnoreCase("chrome")){
			//System.setProperty("webdriver.chrome.driver", new ConfigDataProvider().getChromePath());
			System.setProperty("webdriver.chrome.driver", DataProviderFactory.getConfig().getChromePath());
			driver = new ChromeDriver();
		}else if(browserName.equalsIgnoreCase("ie")){
			//System.setProperty("webdriver.ie.driver", new ConfigDataProvider().getIEPath());
			System.setProperty("webdriver.ie.driver", DataProviderFactory.getConfig().getIEPath());
			driver = new InternetExplorerDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	
	
	public static void closeBrowser(WebDriver ldriver){
		ldriver.quit();
	}

}
