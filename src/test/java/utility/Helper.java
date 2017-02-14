package utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Helper {
	
	public static String captureScreenshot(WebDriver driver, String screenshotName){
		TakesScreenshot ts = (TakesScreenshot)driver; 
		File sourceFile = ts.getScreenshotAs(OutputType.FILE);
		String targetPath = System.getProperty("user.dir")+"\\Screenshots\\"+screenshotName+System.currentTimeMillis()+".png";
		File targetFile = new File(targetPath);
		try {
			FileUtils.copyFile(sourceFile, targetFile);
		} catch (IOException e) {
			System.out.println("Failed to capture screenshot: "+e.getMessage());
		}
		return targetPath;
	}

}
