package com.vTiger.CreateOrganizationTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.vTiger.genericLib.BaseClass;

@Listeners(com.vTiger.genericLib.ListenerImpClass.class)
public class CreateDuplicateOrganizationTest extends BaseClass
{
	@Test
	public  void cretaeDuplicate_OrgTest() throws Throwable
	{
		String org_Name = lib.getExcelData("Sheet2", 7, 2);
		String org_Duplicate = lib.getExcelData("Sheet2", 7, 3);
		String exp_alert = lib.getExcelData("Sheet2", 7, 4);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		/* Step 3:Click on Organization */
		driver.findElement(By.xpath("//td[@class='tabUnSelected']//a[text()='Organizations']")).click();

		String expOrgPage =lib.getPropertyKeyValue("OrganizationPage");
		String actOrgPage =driver.getTitle();
		System.out.println(expOrgPage);
		System.out.println(actOrgPage);
		Assert.assertEquals(expOrgPage, actOrgPage);
		Reporter.log("Organization Page Displayed Successfully");

		/*Step 4: CLick on Create Organization Link*/
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();

		/*Step 5: Enter the Organization Name and Save it*/
		driver.findElement(By.name("accountname")).sendKeys(org_Duplicate);
		driver.findElement(By.xpath("(//input[@type='button'])[1]")).click();

		/*Step 6: Click on Create Organization*/
		while(true)
		{
			try 
			{
				driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
				break;
			}
			catch(Exception e)
			{

			}
		}
		/*Step 7: Enter Duplicate Organization Name and Save it*/
		driver.findElement(By.name("accountname")).sendKeys(org_Name);
		driver.findElement(By.xpath("(//input[@type='button'])[1]")).click();

		/*Step 8: Handle the Alert Pop-Up */
		Alert alert;
		while(true)
		{
			try 
			{
				alert = driver.switchTo().alert();
				break;
			}
			catch(Exception e)
			{

			}
		}
		String act_Alert = alert.getText();
		System.out.println(act_Alert);
		alert.accept();
		lib.setExcelData("Sheet2", 7, 5	,act_Alert);
		Assert.assertEquals(exp_alert, act_Alert);
		Reporter.log("Alert Message Handled");
	}
}
