package com.vTiger.genericLib;

import java.io.File;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class ListenerImpClass implements ITestListener {

	@Override
	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailure(ITestResult result) 
	{
		String currentDate = new Date().toString().replace(":", "_").replace(" ", "_");
		String failedTCName = result.getMethod().getMethodName();
		
		System.out.println("====FAILED======>"+failedTCName);
		
		EventFiringWebDriver eDriver = new EventFiringWebDriver(BaseClass.driver2);
		
		File srcFile = eDriver.getScreenshotAs(OutputType.FILE);
		File destFile = new File("./screenshot/"+failedTCName+"_"+currentDate+".png");
		try
		{
			FileUtils.copyFile(srcFile, destFile);
		}catch(Exception e)
		{
			System.out.println(e);
		}
	}

	@Override
	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSuccess(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

}
