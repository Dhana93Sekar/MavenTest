package com.vTiger.CreateOrganizationTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.vTiger.genericLib.BaseClass;

@Listeners(com.vTiger.genericLib.ListenerImpClass.class)
public class CreateOrganizationAssignToGroupTest extends BaseClass {

	@Test
	public void assignTOGroupTest() throws Throwable
	{
		String org_Name = lib.getExcelData("Sheet2", 22, 3);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		/*Step 3: Click on Organization Link*/
		driver.findElement(By.xpath("//td[@class='tabUnSelected']//a[text()='Organizations']")).click();
		String expOrgPage =lib.getPropertyKeyValue("OrganizationPage");
		String actOrgPage =driver.getTitle();

		Assert.assertEquals(expOrgPage, actOrgPage);
		
		/*Step 4: Create Organization*/
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys(org_Name);
		
		/*Step 5: Select Group to Assign */
		driver.findElement(By.xpath("//input[@value='T']")).click();
		WebElement wb = driver.findElement(By.name("assigned_group_id"));
		Select sel = new Select(wb);
		sel.selectByVisibleText("Support Group");
		driver.findElement(By.xpath("(//input[@type='button'])[1]")).click();

		String s1 = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		String s2 = driver.findElement(By.xpath("//span[@class='small']")).getText();
		String success_msg = s1+s2;
		System.out.println("Organization creation msg:"+success_msg);

		lib.setExcelData("Sheet2", 22, 5, success_msg);
		
		Reporter.log("Organization Created Successfully");
	}

}
