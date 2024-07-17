package pageObjects;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class HomePage extends BasePage{

	public HomePage(WebDriver driver) {
		super(driver);
		
	}
	WebElement img=driver.findElement(By.xpath("//img[@title='Your Store']"));
	WebElement Login=driver.findElement(By.xpath("//a[text()='Login']"));
	WebElement Register=driver.findElement(By.xpath("//a[text()='Register']"));
	WebElement RegisterPage=driver.findElement(By.xpath("//h1[text()='Register Account']"));
	WebElement LoginPage=driver.findElement(By.xpath("//h2[text()='Returning Customer']"));
	public void login() {
		
		Login.click();
		Assert.assertEquals(LoginPage.getText(),"Returning Customer");
	}
	public void SignUp() {
		Register.click();
		Assert.assertEquals(RegisterPage.getText(),"Register Account");
		
		
	}
	
	 
	
}
