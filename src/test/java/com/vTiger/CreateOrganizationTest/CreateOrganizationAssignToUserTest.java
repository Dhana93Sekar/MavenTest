package com.vTiger.CreateOrganizationTest;

import java.util.Iterator;
import java.util.Set;
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
 */

@Listeners(com.vTiger.genericLib.ListenerImpClass.class)
public class CreateOrganizationAssignToUserTest extends BaseClass
{
	@Test
	public void assignUser() throws Throwable
	{
		String org_Name = lib.getExcelData("Sheet2", 19, 3);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//span[text()=' Administrator']/../..//td[4]/img")).click();
		driver.findElement(By.linkText("CRM Settings")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Users')]")).click();
		driver.findElement(By.xpath("//input[@title='New User [Alt+N]']")).click();
		driver.findElement(By.name("user_name")).sendKeys("Dhana");
		driver.findElement(By.name("user_password")).sendKeys("Dhana");
		driver.findElement(By.name("email1")).sendKeys("Dhana@gmail.com");
		driver.findElement(By.name("confirm_password")).sendKeys("Dhana");
		String user ="Dhanasekar";
		driver.findElement(By.name("last_name")).sendKeys(user);
		driver.findElement(By.xpath("//input[@name='role_name']/following-sibling::a")).click();
		Set<String> win = driver.getWindowHandles();
		Iterator<String> it = win.iterator();
		String pid = it.next();
		String cid = it.next();
		driver.switchTo().window(cid);
		driver.findElement(By.linkText("Sales Man")).click();
		driver.switchTo().window(pid);
		driver.findElement(By.xpath("//input[@accesskey='S']")).click();
		
		String usertext = driver.findElement(By.xpath("//b//a[contains(text(),'Dhana')]")).getText();
		if(usertext.contains(user))
		{
			System.out.println("User created successfully");
		}
		
		/* Step 3: Click on Organization Tab*/
		while(true)
		{
			try
			{
				driver.findElement(By.xpath("//td[@class='tabUnSelected']//a[text()='Organizations']")).click();
				break;
			}
			catch(Exception e)
			{
				
			}
		}
		String expOrgPage =lib.getPropertyKeyValue("OrganizationPage");
		String actOrgPage =driver.getTitle();
		Assert.assertEquals(expOrgPage, actOrgPage);
		
		/*Step 4: Create Organization*/
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		
		driver.findElement(By.name("accountname")).sendKeys(org_Name);
		
		/*Step 5:Assign User*/
		WebElement wb = driver.findElement(By.name("assigned_user_id"));
		Select sel = new Select(wb);
		sel.selectByVisibleText(user);		
		
		driver.findElement(By.xpath("(//input[@type='button'])[1]")).click();

		String s1 = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		String s2 = driver.findElement(By.xpath("//span[@class='small']")).getText();
		s1 = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		s2 = driver.findElement(By.xpath("//span[@class='small']")).getText();
		String success_msg = s1+s2;
		System.out.println("Organization creation msg:"+success_msg);

		lib.setExcelData("Sheet2", 19, 5, success_msg);
		Reporter.log("Organization Created Successfully");
	}
}
