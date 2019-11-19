package com.vTiger.genericLib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.vTiger.objectRepositoryLib.HomePage;
import com.vTiger.objectRepositoryLib.LoginPage;

public class BaseClass 
{
	public WebDriver driver;
	public static WebDriver driver2;
	public static FileLibrary lib=new FileLibrary();
	@BeforeClass
	public void getBrowser() throws Throwable
	{
		String browser  = lib.getPropertyKeyValue("browser");
				
		if(browser.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.chrome.driver","D:\\Maven\\MavenPractise\\MavenProject\\src\\main\\resources");
			driver = new ChromeDriver();
			driver2=driver;
		}
		else if(browser.equalsIgnoreCase("chrome"))
		{
			System.out.println("Launching the Browser");
			driver = new ChromeDriver();
			driver2=driver;
		}
		else if(browser.equalsIgnoreCase("IE"))
		{
			driver = new InternetExplorerDriver();
		}
		else
		{
			driver = new SafariDriver();
		}
	}
	
	@AfterClass
	public void closeBrowser()
	{
		driver.quit();
	}
	
	@BeforeMethod
	public void LoginTest() throws Throwable
	{
		String url      = lib.getPropertyKeyValue("url");
		String username = lib.getPropertyKeyValue("username");
		String password = lib.getPropertyKeyValue("password");
		
		driver.get(url);
		driver.manage().window().maximize();
		WebDriverCommUtils.waitForPageToLoad(driver);
		
		String expLoginPage = lib.getPropertyKeyValue("loginpage");
		String actLoginPage = driver.getTitle();
		
		Assert.assertEquals(expLoginPage, actLoginPage);

		LoginPage lp = PageFactory.initElements(driver, LoginPage.class);
		lp.loginToApp(username, password);

		String expHomePage =lib.getPropertyKeyValue("homepage");
		String actHomePage =driver.getTitle();

		Assert.assertEquals(expHomePage, actHomePage);
	}
	
	@AfterMethod
	public void logout()
	{
		HomePage hp = PageFactory.initElements(driver, HomePage.class);
		hp.logout();
		
		System.out.println("Succesfully Logged Out");
	}
}
