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

public class CustomerInformation {
	WebDriver driver;
	WebDriverWait wait;
	ExtentTest extTest;
	
	public CustomerInformation(WebDriver driver, ExtentTest extTest) {
		this.driver= driver;
		wait= new WebDriverWait(driver, Duration.ofSeconds(10));
		this.extTest= extTest;
	}
	
	public boolean addCustomerDetails(String firstname, String lastname, String postalcode) {
		driver.findElement(Locators.firstName).sendKeys(firstname);
		Base.sleep();
		driver.findElement(Locators.lastName).sendKeys(lastname);
		Base.sleep();
		driver.findElement(Locators.postalCode).sendKeys(postalcode);
		Base.sleep();
		driver.findElement(Locators.Continue).click();

		try {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@name='cancel']")));
		Reporter.generateReport(driver,extTest,Status.PASS,"The Customer Information collected successfully");
		return true;
	}catch(TimeoutException te) {
		Reporter.generateReport(driver,extTest,Status.FAIL,"The Customer Information collected Failed");
		return false;
	}
	}
	}

