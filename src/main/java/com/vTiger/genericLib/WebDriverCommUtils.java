package com.vTiger.genericLib;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverCommUtils 
{
	static public void waitForPageToLoad(WebDriver driver){
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	public void waitForElemnetPresent(WebElement element,WebDriver driver){
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void select(WebElement element , String data){
		Select sel = new Select(element);
		sel.selectByVisibleText(data);
	}
	public void select(WebElement element , int index){
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}
	public void moveMouse(WebElement element,WebDriver driver)
	{
		Actions act = new Actions(driver);
		act.moveToElement(element);
	}
}
