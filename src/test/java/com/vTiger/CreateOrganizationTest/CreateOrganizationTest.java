package com.vTiger.CreateOrganizationTest;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.vTiger.genericLib.BaseClass;
import com.vTiger.genericLib.WebDriverCommUtils;
import com.vTiger.objectRepositoryLib.OrganizationPage;

/**
 * 
 * @author Dhanashekhar
 *
 */

@Listeners(com.vTiger.genericLib.ListenerImpClass.class)
public class CreateOrganizationTest extends BaseClass
{
	static String s1,s2,success_msg;
	
	@Test
	public void createOrganization() throws Throwable
	{
		//String org_Name = lib.getExcelData("sheet2", 1, 3);
		String org_Name = "Tst";
		WebDriverCommUtils.waitForPageToLoad(driver);
		
		/*Step 3: Click on Organization Link*/
		OrganizationPage op = PageFactory.initElements(driver, OrganizationPage.class);
		op.getOrganizationLink().click();
		String expOrgPage =lib.getPropertyKeyValue("OrganizationPage");
		String actOrgPage =driver.getTitle();

		Assert.assertEquals(expOrgPage, actOrgPage);

		/*Step 4: Click on Create Organization Button*/
		op.getCreateOrganizatinBtn().click();
		op.getOrganizationName().sendKeys(org_Name);
		op.getSaveBtn().click();

		s1 = op.getSuccessmsg1().getText();
		s2 = op.getSuccessmsg2().getText();
		success_msg = s1+s2;
		System.out.println("Organization creation msg:"+success_msg);

		lib.setExcelData("Sheet2", 1, 5, success_msg);
		Reporter.log("Organization Created Successfully");
	}
}
