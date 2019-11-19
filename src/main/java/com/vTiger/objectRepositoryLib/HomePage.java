package com.vTiger.objectRepositoryLib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage 
{
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement userBtn;
	
	@FindBy(linkText="Sign Out")
	private WebElement logoutBtn;
	
	public void logout()
	{
		userBtn.click();
		logoutBtn.click();
	}
	
}
