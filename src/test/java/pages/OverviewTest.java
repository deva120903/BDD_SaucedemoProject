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

public class OverviewTest {
	WebDriver driver;
	WebDriverWait wait;
	ExtentTest extTest;
	
	public OverviewTest(WebDriver driver, ExtentTest extTest) {
		this.driver= driver;
		wait= new WebDriverWait(driver, Duration.ofSeconds(10));
		this.extTest= extTest;
	}
	
	public boolean validateOverview() {
		driver.findElement(Locators.finish).click();
		Base.sleep();
		
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("back-to-products")));
			Reporter.generateReport(driver,extTest,Status.PASS,"Overview verified Successful");
			return true;
		}catch(TimeoutException te) {
			Reporter.generateReport(driver,extTest,Status.FAIL,"Overview verification Failure");
			return false;
		}
	}
}
