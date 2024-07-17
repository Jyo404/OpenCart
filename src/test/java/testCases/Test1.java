package testCases;


import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

import java.io.FileReader;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

import org.apache.logging.log4j.core.util.Integers;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.*;
import pageObjects.BasePage;
import pageObjects.HomePage;
import pageObjects.Login;




public class Test1 extends BaseClass {
	public Properties p;	
	
	
	
	//DataProvider 
	@DataProvider(name="creds")
	public Object[][] values(){
	return new Object[][]	{{"admin" ,"pa$$w0rd"}};
		}
	
	
	//Test case -1 with parameter
	@Parameters({"username","password"})
	@Test(enabled=false)
	
	public void testCase1(String Username, String PWD) {
		Login login=new Login(driver);
		try {
			logger.info(" *****Login CRM Page***** ");
			logger.info("*** Title Of The Page");
			login.getTheTitleOfBrowser();
			logger.info("****Get The  Header Image URL*****");
			login.headerImage();
			logger.info("****Login The Page*****");
			login.login(Username, PWD);
			System.out.println("Login Successfully");
		}
		catch(Exception e) {
			logger.info("Test Fail");
			Assert.fail();
			System.out.println(e);
		}
	}
	
	
	
	//Test case -2 with config file
	
	@Test(groups="sanity")
	public void testCase2() {
		
		
		Login login=new Login(driver);
		try {
			FileReader file=new FileReader(".//config");
			p=new Properties();
			p.load(file);
			String Username=p.getProperty("username");
			String PWD=p.getProperty("password");
			logger.info(" *****Login CRM Page***** ");
			logger.info("*** Title Of The Page");
			login.getTheTitleOfBrowser();
			logger.info("****Get The  Header Image URL*****");
			login.headerImage();
			logger.info("****Login The Page*****");
			login.login(Username, PWD);
			System.out.println("Login Successfully");
		}
		catch(Exception e) {
			logger.info("Test Fail");
			Assert.fail();
			System.out.println(e);
		}
	}
	
	
	// Test case -3 with dataprovider
	
	@Test(dataProvider="creds",priority=2,groups="Regression")
public void testCase3( String Username,String PWD) {
		
		
		Login login=new Login(driver);
		try {
			FileReader file=new FileReader(".//config");
			p=new Properties();
			p.load(file);
			//String Username=p.getProperty("username");
			//String PWD=p.getProperty("password");
			logger.info(" *****Login CRM Page***** ");
			logger.info("*** Title Of The Page");
			login.getTheTitleOfBrowser();
			logger.info("****Get The  Header Image URL*****");
			login.headerImage();
			logger.info("****Login The Page*****");
			login.login(Username, PWD);
			System.out.println("Login Successfully");
		}
		catch(Exception e) {
			logger.info("Test Fail");
			Assert.fail();
			System.out.println(e);
		}
	}


}