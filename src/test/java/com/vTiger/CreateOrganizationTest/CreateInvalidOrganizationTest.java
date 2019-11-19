package com.vTiger.CreateOrganizationTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.vTiger.genericLib.BaseClass;

@Listeners(com.vTiger.genericLib.ListenerImpClass.class)
public class CreateInvalidOrganizationTest extends BaseClass
{
	@Test
	public void create_Invalid_OrganizationTest() throws Throwable
	{
		String org_Name = lib.getExcelData("Sheet2", 4, 3);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		/*Step 3: Click on Organization Link*/
		driver.findElement(By.xpath("//td[@class='tabUnSelected']//a[text()='Organizations']")).click();
		String expOrgPage = lib.getPropertyKeyValue("organizationPage");
		String actOrgPage =driver.getTitle();
		Assert.assertEquals(expOrgPage, actOrgPage);
		
		/*Step 4: Click on Create Organization Button*/
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys(org_Name);
		driver.findElement(By.xpath("(//input[@type='button'])[1]")).click();
		
		/*Step 5: Check Alert PopUp*/
		Alert alert = null;
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
		
		String act_Text = alert.getText();
		System.out.println(act_Text);
		alert.accept();
		lib.setExcelData("Sheet2", 4, 5, act_Text);
		String exp_Text = lib.getExcelData("Sheet2", 4, 4);
		Assert.assertEquals(exp_Text, act_Text);
	}
}
