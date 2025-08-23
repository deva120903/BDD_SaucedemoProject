package stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AddToCart;
import pages.CheckOut;
import pages.CustomerInformation;
import pages.LoginPage;
import pages.LogoutTest;
import pages.OverviewTest;
import pages.SelectProductPage;

public class PlaceOrderStepDef {
	LoginPage loginPage;
	SelectProductPage selectProductPage;
	AddToCart addToCart;
	AddToCart cartButton;
	CheckOut checkOut;
	CustomerInformation customerInfo;
	OverviewTest overview;
	LogoutTest backToHome;
	
	
	WebDriver driver= Hooks.driver;
	ExtentTest extTest= Hooks.extTest;
	
	@Given("the user is on the login page")
	public void the_user_is_on_the_login_page() {
	    String expResult= "https://www.saucedemo.com/";
	    String actResult= driver.getCurrentUrl();
	    Assert.assertEquals(actResult, expResult);
	}
	@When("the user enter username as {string} and password as {string} and click login button")
	public void the_user_enter_username_as_and_password_as_and_click_login_button(String userName, String password) {
	    
		loginPage= new LoginPage(driver, extTest);
	    boolean actResult= loginPage.validateLogin(userName, password);
	    Assert.assertTrue(actResult);
	}
	@When("the user selects the product")
	public void the_user_selects_the_product() {
	    
		selectProductPage= new SelectProductPage(driver, extTest);
		boolean actResult= selectProductPage.validateSelectProduct();
		Assert.assertTrue(actResult);
	}
	@When("the user clicks on Add to Cart button")
	public void the_user_clicks_on_add_to_cart_button() {
	    
		addToCart= new AddToCart(driver, extTest);
		boolean actResult= addToCart.validateAddToCart();
		Assert.assertTrue(actResult);

	}
	@When("the user clicks on the Cart icon")
	public void the_user_clicks_on_the_cart_icon() {
		
		addToCart= new AddToCart(driver, extTest);
		boolean actResult= addToCart.validateAddCartButton();
		Assert.assertTrue(actResult);
	
	}
	@When("the user clicks on the Checkout button")
	public void the_user_clicks_on_the_checkout_button() {
		
		checkOut=new CheckOut(driver, extTest);
		boolean actResult=checkOut.validateCheckOut();
		Assert.assertTrue(actResult);
	    
	}
	@When("the user enter customer information and click Continue button")
	public void the_user_enter_customer_information_and_click_continue_button() {
		
		customerInfo= new CustomerInformation(driver, extTest);
		boolean actResult=customerInfo.addCustomerDetails("Deva","Dharshini" ,"638002");
		Assert.assertTrue(actResult);
		
    }
	@When("the user verifies the product and click Finish button")
	public void the_user_verifies_the_product_and_click_finish_button() {
	  
		overview= new OverviewTest(driver, extTest);
		boolean actResult= overview.validateOverview();
		Assert.assertTrue(actResult);

		
	}
	@Then("the user clicks the logout button and validate the login button in the login page")
	public void the_user_clicks_the_logout_button_and_validate_the_login_button_in_the_login_page() {
	    
		backToHome= new LogoutTest(driver, extTest);
		boolean actResult= backToHome.validateLogout();
		Assert.assertTrue(actResult);

	
	}

}
