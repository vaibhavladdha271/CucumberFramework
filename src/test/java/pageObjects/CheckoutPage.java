package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage {
	
	public WebDriver driver;
	public CheckoutPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By cartBag=By.cssSelector("a.cart-icon");
	
	By checkoutButton=By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]");
	By promoCodeTextField=By.className("promoCode");
	By applyButton=By.className("promoBtn");
	By placeOrderButton=By.xpath("//button[contains(text(),'Place Order')]");
	By promoMessage=By.cssSelector("span.promoInfo");
	
	public void addItemsToCart()
	{
		
	}
	public void CheckoutItems()
	{
		driver.findElement(cartBag).click();
		driver.findElement(checkoutButton).click();
	}
	public String verifyPromoMessage()
	{
		waitForElementToVisible();
		return driver.findElement(promoMessage).getText();
	}
	public void applyPromoCode()
	{
		driver.findElement(promoCodeTextField).sendKeys("rahulshettyacademy");
		driver.findElement(applyButton).click();
		
	}
	public void waitForElementToVisible()
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(promoMessage));
	}
	public void clickOnPlaceOrder()
	{
		driver.findElement(placeOrderButton).click();
	}

}
