package com.vTiger.objectRepositoryLib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage 
{
	@FindBy(name="user_name")
	private WebElement userNameEdit;
	@FindBy(name="user_password")
	private WebElement passwordEdit;
	@FindBy(id="submitButton")
	private WebElement loginBtn;
	/**
	 * @return the userName
	 */
	public WebElement getUserName() {
		return userNameEdit;
	}
	/**
	 * @return the password
	 */
	public WebElement getPassword() {
		return passwordEdit;
	}
	/**
	 * @return the loginBtn
	 */
	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	public void loginToApp(String userName , String password){
		userNameEdit.sendKeys(userName);
		passwordEdit.sendKeys(password);
		loginBtn.click();
	}
	
}
