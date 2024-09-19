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
import pageObjects.LandingPage;
import pageObjects.PageObjectManager;
import utils.TestContextSetup;

import java.util.Iterator;

public class LandingPageStepDefinition {
	//public WebDriver driver;
	public String landingPageProductName;
	public String offerPageProductName;
	TestContextSetup testContextSetup;
	public PageObjectManager pageObjectManager;
	public LandingPage landingPage;
	
	public LandingPageStepDefinition(TestContextSetup testContextSetup)
	{
		this.testContextSetup=testContextSetup;
		this.landingPage=testContextSetup.pageObjectManager.getlandingPage();
	}
	
	@Given("User is on Greenkart landing page")
	public void user_is_on_greenkart_landing_page() throws Exception {
	   // testContextSetup.testBase.WebDriverManager();
	    String landingPageTitle=landingPage.getLandingPageTitle();
	    Assert.assertEquals(landingPageTitle, "GreenKart - veg and fruits kart");
	}
	@When("^user searched with shortname (.+) and extracted actual name of product$")
	public void user_searched_with_shortname_and_extracted_actual_name_of_product(String shortName) throws InterruptedException {
		
		landingPage.searchItem(shortName);
		Thread.sleep(2000);
		testContextSetup.landingPageProductName=landingPage.getSearchResult();
		System.out.println("Product name is"+testContextSetup.landingPageProductName);
	}
	@When("added {string} items of selected product to the cart")
	public void add_items_to_cart(String quantity)
	{
		landingPage.incrementQuantity(Integer.parseInt(quantity));
		landingPage.addToCart();
	}
	

}
