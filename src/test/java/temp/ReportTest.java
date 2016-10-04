package temp;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ReportTest {
	public static WebDriver wd;
	public static ExtentReports report;
	public static ExtentTest log;

	@Test(priority = 1)
	public void googleTest() {
		wd=new FirefoxDriver();
		report = new ExtentReports(
				"C:\\seleniumWorkspace\\DDDTest\\reports\\Sample.html");
		log = report.startTest("GooleTest");// log get start here
		wd.get("https://www.google.co.in/");
	}

	@Test(priority = 2)
	public void yahooTest() {
		log = report.startTest("YahooTest");
		wd.get("https://in.yahoo.com/");
	}

	@Test(priority = 3)
	public void bingTest() {
		log = report.startTest("BingTest");
		wd.get("https://www.bing.com/");
	}
	@AfterMethod
	public void tearDown(ITestResult result) throws IOException
	{
		if(result.isSuccess())
		{
			String path = getScreenShot(result.getName());
			log.addScreenCapture(path);
			log.log(LogStatus.PASS, "TestCase Passed", path);
		}
		else
		{
			String path = getScreenShot(result.getName());
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
