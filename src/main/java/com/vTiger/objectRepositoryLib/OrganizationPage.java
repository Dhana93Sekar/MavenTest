package com.vTiger.objectRepositoryLib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * 
 * @author Dhanashekhar
 *
 */
public class OrganizationPage
{
	@FindBy(xpath="//a[text()='Organizations']")
	private WebElement organizationLink;
	
	@FindBy(xpath="")
	private WebElement createOrganizatinBtn;
	
	@FindBy(name="accountname")
	private WebElement organizationName;
	
	@FindBy(xpath="//input[@type='button'])[1]")
	private WebElement saveBtn;
	
	/**
	 * @return the organizationLink
	 */
	public WebElement getOrganizationLink() {
		return organizationLink;
	}

	/**
	 * @return the createOrganizatinBtn
	 */
	public WebElement getCreateOrganizatinBtn() {
		return createOrganizatinBtn;
	}

	/**
	 * @return the organizationName
	 */
	public WebElement getOrganizationName() {
		return organizationName;
	}

	/**
	 * @return the saveBtn
	 */
	public WebElement getSaveBtn() {
		return saveBtn;
	}

	/**
	 * @return the successmsg1
	 */
	public WebElement getSuccessmsg1() {
		return successmsg1;
	}

	/**
	 * @return the successmsg2
	 */
	public WebElement getSuccessmsg2() {
		return successmsg2;
	}

	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement successmsg1;
	
	@FindBy(xpath="//span[@class='small']")
	private WebElement successmsg2;
}
