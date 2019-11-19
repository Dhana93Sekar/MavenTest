package com.vTiger.CreateOrganizationTest;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
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
public class CreateOrganization_Assign_MemberOfTest extends BaseClass
{
	static String s1;
	static String s2;
	static String msg;
	@Test
	public void assignMember() throws Throwable 
	{
		String child_Org  = lib.getExcelData("Sheet2", 25, 3);
		System.out.println(child_Org);
		String parent_Org = lib.getExcelData("Sheet2", 25, 2);
		System.out.println(parent_Org);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		/*Step 1: Click On Organization Link*/
		
		driver.findElement(By.xpath("//td[@class='tabUnSelected']//a[text()='Organizations']")).click();
		
		String expOrgPage =lib.getPropertyKeyValue("OrganizationPage");
		String actOrgPage =driver.getTitle();

		Assert.assertEquals(expOrgPage, actOrgPage);

		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		System.out.println(parent_Org);
		driver.findElement(By.name("accountname")).sendKeys(parent_Org);
		driver.findElement(By.xpath("(//input[@type='button'])[1]")).click();
		
		s1 = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		s2 = driver.findElement(By.xpath("//span[@class='small']")).getText();
		msg = s1+s2;
		System.out.println("Organization creation msg:"+msg);
		
		
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys(child_Org);
		
		driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img")).click();
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();
		String pid = it.next();
		String cid = it.next();
		driver.switchTo().window(cid);
		
		driver.findElement(By.xpath("//a[contains(text(),'"+parent_Org+"')]")).click();
		driver.switchTo().alert().accept();
		driver.switchTo().window(pid);
		driver.findElement(By.xpath("(//input[@type='button'])[1]")).click();

		s1 = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		s2 = driver.findElement(By.xpath("//span[@class='small']")).getText();
		String success_msg = s1+s2;
		System.out.println("Organization creation msg:"+success_msg);

		lib.setExcelData("Sheet2", 25, 5, success_msg);
		Reporter.log("Organization Created Successfully");
	}
}
