package utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {
	static final int Time=2000;
	public static WebDriver driver;
	public void launchBrowser() {
		
		Properties prop= PropertyReader.readProperties();
		if(prop.getProperty("Browser").equalsIgnoreCase("Chrome")){
		
			ChromeOptions chromeOptions = new ChromeOptions();
			Map<String, Object> chromePrefs = new HashMap<>();
			chromePrefs.put("credentials_enable_service", false);
			chromePrefs.put("profile.password_manager_leak_detection", false);
			chromeOptions.setExperimentalOption("prefs", chromePrefs);
			driver = new ChromeDriver(chromeOptions);
			driver.manage().window().maximize();
	}else if(prop.getProperty("Browser").equalsIgnoreCase("Firefox")){
			driver= new FirefoxDriver();
			driver.manage().window().maximize();
	}
		driver.get(prop.getProperty("URL"));
  }
	public static void sleep() {
	try {
		Thread.sleep(Time);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	}
}
