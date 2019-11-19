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


/**
 * @author Dhanashekhar
 *
 */
@Listeners(com.vTiger.genericLib.ListenerImpClass.class)
public class CreateOrganization_Assign_IndustryTest extends BaseClass{

	@Test
	public void assignIndustryTest() throws Throwable
	{
		String org_Name = lib.getExcelData("sheet2", 28, 3);
		String industry = lib.getExcelData("sheet2", 28, 2);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		/*Step 3: Click On Organization Link*/
		driver.findElement(By.xpath("//td[@class='tabUnSelected']//a[text()='Organizations']")).click();

		String expOrgPage =lib.getPropertyKeyValue("OrganizationPage");
		String actOrgPage =driver.getTitle();
		Assert.assertEquals(expOrgPage, actOrgPage);
		Reporter.log("Organization page Displayed Successfully");

		/*Step 4: Click on Create Organization Button*/
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys(org_Name);
		WebElement wb = driver.findElement(By.name("industry"));
		Select sel = new Select(wb);
		sel.selectByValue(industry);
		
		driver.findElement(By.xpath("(//input[@type='button'])[1]")).click();
		String s1 = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		String s2 = driver.findElement(By.xpath("//span[@class='small']")).getText();
		String success_msg = s1+s2;
		System.out.println("Organization creation msg:"+success_msg);
		Reporter.log("Organization created Successfully");
	}

}
