package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import objectRepository.Locators;
import utils.Base;
import utils.Reporter;

public class LoginPage {
	
	WebDriver driver;
	WebDriverWait wait;
	ExtentTest extTest;
	
	public LoginPage(WebDriver driver, ExtentTest extTest) {
		this.driver= driver;
		wait= new WebDriverWait(driver, Duration.ofSeconds(10));
		this.extTest= extTest;
	}

	public boolean validateLogin(String userName, String pwd) {
		driver.findElement(Locators.userName).sendKeys(userName);
		Base.sleep();
		driver.findElement(Locators.password).sendKeys(pwd);
		Base.sleep();
		driver.findElement(Locators.loginButton).click();
		Base.sleep();
		try {
			//explicit wait for products element visibility.
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Products']")));
			// pass the test in extent report.
			Reporter.generateReport(driver,extTest,Status.PASS,"Login Successful");
			return true;
		}catch(TimeoutException te) {
			//fail the extent report.
			Reporter.generateReport(driver,extTest,Status.FAIL, "Login Failure");
			return false;
		}
	}
}
