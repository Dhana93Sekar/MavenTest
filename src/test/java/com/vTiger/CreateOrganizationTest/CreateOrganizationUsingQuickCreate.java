package com.vTiger.CreateOrganizationTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.vTiger.genericLib.BaseClass;

@Listeners(com.vTiger.genericLib.ListenerImpClass.class)
public class CreateOrganizationUsingQuickCreate extends BaseClass
{
	@Test
	public void qc_OrganizationCreate() throws Throwable 
	{
		String org_Name = lib.getExcelData("sheet2", 10, 3);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		/*Step 3: Create Organization Using Quick Create Link*/
		driver.findElement(By.id("qccombo")).click();
		driver.findElement(By.xpath("//option[@value='Accounts']")).click();
		driver.findElement(By.name("accountname")).sendKeys(org_Name);
	
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		String s1 = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		String s2 = driver.findElement(By.xpath("//span[@class='small']")).getText();
		String success_msg = s1+s2;
		System.out.println("Organization creation msg:"+success_msg);

		lib.setExcelData("Sheet2", 10, 5, success_msg);
		
		Reporter.log("Organization Created Successfully");
	}
}
