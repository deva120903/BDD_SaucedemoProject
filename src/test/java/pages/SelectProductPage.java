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

public class SelectProductPage {
	
	WebDriver driver;
	WebDriverWait wait;
	ExtentTest extTest;
	
	public SelectProductPage(WebDriver driver, ExtentTest extTest) {
		this.driver= driver;
		wait= new WebDriverWait(driver, Duration.ofSeconds(10));
		this.extTest= extTest;
	}
	public boolean validateSelectProduct() {
		driver.findElement(Locators.product).click();
		Base.sleep();
		try {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@name='back-to-products']")));
		Reporter.generateReport(driver,extTest,Status.PASS,"Product Select Successful");
		return true;
	}catch(TimeoutException te) {
		Reporter.generateReport(driver,extTest,Status.FAIL,"Product Select Failure");
		return false;
	}
	}
}

