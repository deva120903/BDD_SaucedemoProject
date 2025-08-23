package objectRepository;

import org.openqa.selenium.By;

public class Locators {

	//below are the login page locators
	
	public static By userName= By.id("user-name");
	public static By password= By.id("password");
	public static By loginButton= By.id("login-button");
	
	public static By product=By.xpath("//div[text()='Sauce Labs Backpack']");
	
	public static By AddToCart=By.xpath("//button[@name='add-to-cart']");
	public static By CartButton=By.xpath(("//span[text()='1']"));
	
	public static By CheckOut=By.xpath("//button[@name='checkout']");
	
	public static By firstName=By.id("first-name");
	public static By lastName= By.id("last-name");
	public static By postalCode=By.id("postal-code");
	public static By Continue=By.id("continue");
	
	public static By finish=By.xpath("//button[@name='finish']");
	
	public static By logout=By.id("react-burger-menu-btn");
	public static By logoutButton=By.xpath("//a[text()='Logout']");

}
