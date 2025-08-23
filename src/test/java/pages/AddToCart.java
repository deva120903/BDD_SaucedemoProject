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

public class AddToCart {
	WebDriver driver;
	WebDriverWait wait;
	ExtentTest extTest;
	
	public AddToCart(WebDriver driver, ExtentTest extTest) {
		this.driver= driver;
		wait= new WebDriverWait(driver, Duration.ofSeconds(10));
		this.extTest= extTest;
}
	public boolean validateAddToCart() {
		driver.findElement(Locators.AddToCart).click();
		Base.sleep();
		
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@name='remove']")));
			Reporter.generateReport(driver,extTest,Status.PASS,"AddToCart Successful");
			return true;
		}catch(TimeoutException te) {
			Reporter.generateReport(driver,extTest,Status.FAIL,"AddToCart Failure");
			return false;
		}
	}
	public boolean validateAddCartButton() {
		driver.findElement(Locators.CartButton).click();
		Base.sleep();

		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@name='continue-shopping']")));
			Reporter.generateReport(driver,extTest,Status.PASS,"AddCartProcess Successful");
			return true;
		}catch(TimeoutException te) {
			Reporter.generateReport(driver,extTest,Status.FAIL,"AddCartProcess Failure");
			return false;
		}
	}
}
