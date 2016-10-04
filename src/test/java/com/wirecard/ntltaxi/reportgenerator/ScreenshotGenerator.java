package com.wirecard.ntltaxi.reportgenerator;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.LogStatus;
import com.wirecard.ntltaxi.initializer.Initializer;

public class ScreenshotGenerator extends Initializer {
	public static void takeScreenShot(ITestResult result) throws IOException
	{
		Object[] data=result.getParameters();
		if(result.isSuccess())
		{
			String path = getScreenShot(data[0].toString());
			log.addScreenCapture(path);
			log.log(LogStatus.PASS, "TestCase Passed", path);
		}
		else
		{
			String path = getScreenShot(data[0].toString());
			log.addScreenCapture(path);
			log.log(LogStatus.FAIL, "TestCase Failed", path);
		}
		report.endTest(log);
		report.flush();
	}
	public static String getScreenShot(String name) throws IOException
	{
		File src = ((TakesScreenshot)wd).getScreenshotAs(OutputType.FILE);
		File dest = new File("C:\\seleniumWorkspace\\DDDTest\\ScreenShot\\"+name+".jpg");
		FileUtils.copyFile(src, dest);
		return dest.toString();
	}	
}
