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

public class CheckOut {
	WebDriver driver;
	WebDriverWait wait;
	ExtentTest extTest;
	
	public CheckOut(WebDriver driver, ExtentTest extTest) {
		this.driver= driver;
		wait= new WebDriverWait(driver, Duration.ofSeconds(10));
		this.extTest= extTest;
	}
	
	public  boolean validateCheckOut() {
		driver.findElement(Locators.CheckOut).click();
		Base.sleep();
		
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@name='cancel']")));
			Reporter.generateReport(driver,extTest,Status.PASS,"Check Out Successful");
			return true;
		}catch(TimeoutException te) {
			Reporter.generateReport(driver,extTest,Status.FAIL,"Check Out Failure");
			return false;
		}
	}
}
