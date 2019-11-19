package com.vTiger.CreateOrganizationTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.vTiger.genericLib.BaseClass;

@Listeners(com.vTiger.genericLib.ListenerImpClass.class)
public class CreateOrganizationUsingQuickCreateAndAssignToGroupTest extends BaseClass
{
	@Test
	public void qc_GroupAssign() throws Throwable
	{
	
		String org_Name = lib.getExcelData("sheet2", 16, 3);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		/*Step 3: Click on Quick Create Link*/
	//	driver.findElement(By.id("qccombo")).click();
		driver.findElement(By.xpath("//option[@value='Accounts']")).click();
		
		driver.findElement(By.name("accountname")).sendKeys(org_Name);
		driver.findElement(By.xpath("//input[@value='S']")).click();
		
		/*Step 4: Assign Group to Organization*/
		WebElement wb = driver.findElement(By.name("assigned_group_id"));
		Select sel = new Select(wb);
		sel.selectByVisibleText("Support Group");
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		String s1 = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		String s2 = driver.findElement(By.xpath("//span[@class='dvHeaderText']/following-sibling::span")).getText();
		String msg = s1 + s2;
		System.out.println(msg);
		
		lib.setExcelData("Sheet2", 16, 5, msg);
		Reporter.log("Organization Created Successfully");
	}

}
