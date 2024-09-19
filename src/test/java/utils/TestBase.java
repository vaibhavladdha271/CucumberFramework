package utils;

import java.io.FileInputStream;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.Properties;

public class TestBase {
	
	public WebDriver driver;
	
	public WebDriver WebDriverManager() throws Exception
	{
		FileInputStream fis=new FileInputStream("C:\\Users\\vaibh\\eclipse-workspace\\CucumberDesign\\src\\test\\resources\\globalData.properties");
		Properties prop=new Properties();
		prop.load(fis);
		String url=prop.getProperty("url");
		String browserName_properties=prop.getProperty("browser");
		String browserName_maven=System.getProperty("browser");
		String browser=(browserName_maven!=null)? browserName_maven:browserName_properties;
				
		if(driver==null)
		{
			if(browser.equalsIgnoreCase("firefox"))
			{
		System.setProperty("webdriver.firefox.driver",System.getProperty("user.dir")+"\\src\\test\\resources\\geckodriver.exe");
	    driver=new FirefoxDriver();
			}
			else if(browser.equalsIgnoreCase("chrome"))
			{
				
			}
			else
			{
				System.setProperty("webdriver.edge.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\msedgedriver.exe");
				driver=new EdgeDriver();
			}
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	    driver.get(url);
		}
	    return driver;
	}

}
