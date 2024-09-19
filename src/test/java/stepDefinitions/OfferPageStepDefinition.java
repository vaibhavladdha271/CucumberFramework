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
import pageObjects.OfferPage;
import pageObjects.PageObjectManager;
import utils.TestContextSetup;

import java.util.Iterator;

public class OfferPageStepDefinition {
	public String offerPageProductName;
	TestContextSetup testContextSetup;
	OfferPage offerPage;
	public PageObjectManager pageObjectManager;
	
	public OfferPageStepDefinition(TestContextSetup testContextSetup)
	{
		this.testContextSetup=testContextSetup;
		offerPage=testContextSetup.pageObjectManager.getOfferPage();
	}
	@Then("^User searched for (.+) in offers to check if product exists$")
	public void user_searched_for_in_offers_to_check_if_product_exists(String shortName) 
	{
		
		switchToOffersPage();
		offerPage.getSearchResult(shortName);
		offerPageProductName=offerPage.getProductName();
	    System.out.println("Product is verified"+offerPageProductName);
	    Assert.assertEquals(testContextSetup.landingPageProductName, offerPageProductName);
	}
	public void switchToOffersPage()
	{
		LandingPage landingPage=testContextSetup.pageObjectManager.getlandingPage();
		landingPage.clickOnTopDealsLink();
		testContextSetup.genericUtils.switchToWindow();
	}

}
