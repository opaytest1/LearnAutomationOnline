package dataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ConfigDataProvider {
	Properties prop;
	public ConfigDataProvider(){
		
		File src = new File("./Configuration/config.properties");
		
		try {
			FileInputStream fis = new FileInputStream(src);
			prop = new Properties();
			prop.load(fis);
		} catch (Exception e) {
			System.out.println("Exception is :"+e.getMessage());
		}
	}
	
	
	public String getApplicationUrl(){
		String url = prop.getProperty("url");
		return url;
	}
	
	public String getChromePath(){
		String chromePath = prop.getProperty("chromePath");
		return chromePath;
	}
	
	public String getFirefoxPath(){
		String firefoxPath = prop.getProperty("firefoxPath");
		return firefoxPath;
	}
	
	public String getIEPath(){
		String iePath = prop.getProperty("IEPath");
		return iePath;
	}

}
