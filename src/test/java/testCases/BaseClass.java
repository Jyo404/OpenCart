package testCases;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.apache.logging.log4j.Logger;

public class BaseClass {
	public WebDriver driver;
	public Logger logger;
	
	@BeforeTest(groups= {"Regression","Sanity"})
	@Parameters({"os","Browser"})
	public void setup(String os,String browser) {
		
		logger= LogManager.getLogger(this.getClass());
		switch(browser.toLowerCase()) {
		case "chrome":
			driver=new ChromeDriver();
			break;
		case "edge":
			driver=new EdgeDriver();
			break;
			default:
				System.out.println("Invaild Browser");
				break;
			
		}
		
		driver.manage().deleteAllCookies();
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(200));
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("http://alchemy.hguy.co/crm");
		
		//wait.until(ExpectedConditions.urlToBe("http://alchemy.hguy.co/crm"));
		driver.manage().window().maximize();
	}
	@AfterTest(groups= {"Regression","Sanity"})
	public void teardown(){
		driver.quit();
	}
}
