package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.log4testng.Logger;

public class BasePage {
WebDriver driver;

public BasePage(WebDriver driver) {
	this.driver=driver;
	
	}

}
