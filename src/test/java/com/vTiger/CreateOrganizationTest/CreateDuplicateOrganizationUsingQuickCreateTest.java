package com.vTiger.CreateOrganizationTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.vTiger.genericLib.BaseClass;

@Listeners(com.vTiger.genericLib.ListenerImpClass.class)
public class CreateDuplicateOrganizationUsingQuickCreateTest extends BaseClass 
{
	@Test
	public void qc_Duplicate_Organization() throws Throwable 
	{
		String org_Name = lib.getExcelData("sheet2", 13, 3);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		/*Step 3: Click on Quick Create Options*/
		driver.findElement(By.id("qccombo")).click();
		driver.findElement(By.xpath("//option[@value='Accounts']")).click();

		driver.findElement(By.name("accountname")).sendKeys(org_Name);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		String s1 = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		String s2 = driver.findElement(By.xpath("//span[@class='dvHeaderText']/following-sibling::span")).getText();
		String msg = s1 + s2;
		System.out.println(msg);

		driver.findElement(By.id("qccombo")).click();
		driver.findElement(By.xpath("//option[@value='Accounts']")).click();

		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(By.name("accountname")));
		driver.findElement(By.name("accountname")).sendKeys(org_Name);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		Alert alert;
		while(true)
		{
			try
			{
				alert=driver.switchTo().alert();
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
		String exp_Text = lib.getExcelData("Sheet2", 13, 4);
		Assert.assertEquals(exp_Text, act_Text);
		Reporter.log("Alert Handled Successfully");
	}
}

