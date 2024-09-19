package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OfferPage {
	
	public WebDriver driver;
	
	public OfferPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By searchField=By.id("search-field");
	By productName=By.xpath("//table[contains(@class,'table-bordered')]/tbody/tr/td[1]");
	
	
	public void getSearchResult(String searchName)
	{
		driver.findElement(searchField).sendKeys(searchName);
	}
	public String getProductName()
	{
		return driver.findElement(productName).getText();
	}
}
