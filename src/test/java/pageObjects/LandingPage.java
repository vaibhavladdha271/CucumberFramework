package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {

	public WebDriver driver;
	public LandingPage(WebDriver driver)
	{
		this.driver=driver;
	}
	By searchField=By.className("search-keyword");
	By products=By.cssSelector("h4.product-name");
	By topDealsLink=By.linkText("Top Deals");
	By addtoCart= By.xpath("//div[@class='product-action']/button");
	By incrementButton=By.className("increment");
	By decrementButton=By.className("decrement");
	By numberTextField=By.xpath("//input[@type='number']");
	
	public void searchItem(String name)
	{
		driver.findElement(searchField).sendKeys(name);
	}
	public String getSearchResult()
	{
		String productName=driver.findElement(products).getText().split("-")[0].trim();
		return productName;
	}
	public void clickOnTopDealsLink()
	{
		driver.findElement(topDealsLink).click();
	}
	public String getLandingPageTitle()
	{
		return driver.getTitle();
	}
	public void incrementQuantity(int quantity)
	{
		int i=0;
		while(i<quantity-1)
		{
			driver.findElement(incrementButton).click();
			i++;
		}
	}
	public void addToCart()
	{
		driver.findElement(addtoCart).click();
	}
}
