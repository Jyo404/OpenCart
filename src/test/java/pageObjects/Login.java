package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Parameters;

public class  Login extends BasePage {
	public Login(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	
	 WebElement userName=driver.findElement(By.xpath("//input[@name='user_name']"));
	WebElement password=driver.findElement(By.xpath("//input[@name='username_password']"));
WebElement button=driver.findElement(By.xpath("//input[@title='Log In']"));
	String title=driver.findElement(By.xpath("//a[@title='SuiteCRM']")).getText();
	WebElement headerImg=driver.findElement(By.xpath("//img[@alt='SuiteCRM']"));
	
	public void getTheTitleOfBrowser() {
		try {
		System.out.println("***Get The Title Of Nagivated URL***");
		Assert.assertEquals(title, "SuiteCRM");
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public void headerImage() {
		try {
			String url=headerImg.getAttribute("src");
			System.out.println(url);
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	
	
	public void login(String Username,String PWD) {
		try {
			WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(50));
			userName.sendKeys(Username);
			password.sendKeys(PWD);
			button.click();	
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='navbar-brand with-home-icon suitepicon suitepicon-action-home']")));
			String value=driver.findElement(By.xpath("//a[@class='navbar-brand with-home-icon suitepicon suitepicon-action-home']")).getText();
		if(value!=null) {
			System.out.println("** Home Page Opened **");
		}
		
		
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	

	
	
	
}
