package stepDefinitions;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.CheckoutPage;
import pageObjects.LandingPage;
import pageObjects.PageObjectManager;
import utils.TestContextSetup;

import java.util.Iterator;

public class CheckoutPageStepDefinition {
	//public WebDriver driver;
	public String landingPageProductName;
	public String offerPageProductName;
	TestContextSetup testContextSetup;
	public PageObjectManager pageObjectManager;
	public CheckoutPage checkoutPage;
	
	public CheckoutPageStepDefinition(TestContextSetup testContextSetup)
	{
		this.testContextSetup=testContextSetup;
		this.checkoutPage=testContextSetup.pageObjectManager.getCheckoutPage();
	}
	@Then("user has entered the promo code and placed the order")
	public void user_has_entered_the_promo_code_and_placed_the_order()
	{
		checkoutPage.applyPromoCode();
		String promoMessage=checkoutPage.verifyPromoMessage();
		Assert.assertEquals("Code applied ..!", promoMessage);
	}
	@Then("^user proceeds to checkout page & validate the (.+) items in checkout page$")
	public void user_proceeds_to_checkout_page(String name) throws Exception
	{
		checkoutPage.CheckoutItems();
		Thread.sleep(2000);
	}
	

}
