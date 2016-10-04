package com.wirecard.ntltaxi.initializer;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.wirecard.ntltaxi.reportgenerator.ReportOptimizer;

public class Initializer {

	
	public static boolean isarchive = true;
	
	
	
	// initializing the environment properties
	public static FileInputStream envfis;
	public static Properties envpro;
	
	// initializing the locator properties
	public static FileInputStream locfis;
	public static Properties locpro;
	
	/** 
	 * initializing the webdriver
	 */
	public static WebDriver wd;
	
	/**
	 * initializing extents Report
	 * @throws IOException
	 */
		
	public static ExtentReports report;
	public static ExtentTest log;

	public static void initialize() throws IOException{
		
		envfis = new FileInputStream(new File("C:"+File.separator+"seleniumWorkspace"+File.separator+"DDDTest"+File.separator+"src"+File.separator+"test"+File.separator+"resources"+File.separator+"com"+File.separator+"wirecard"+File.separator+"ntltaxi"+File.separator+"config"+File.separator+"env.properties"));
		 envpro = new Properties();
		envpro.load(envfis);
		
		locfis = new FileInputStream(new File("C:"+File.separator+"seleniumWorkspace"+File.separator+"DDDTest"+File.separator+"src"+File.separator+"test"+File.separator+"resources"+File.separator+"com"+File.separator+"wirecard"+File.separator+"ntltaxi"+File.separator+"config"+File.separator+"locator.properties"));
		 locpro = new Properties();
		locpro.load(locfis);
		
		report = new ExtentReports("C:\\seleniumWorkspace\\DDDTest\\reports\\Sample.html");
		
		/**
		 * calling reports archive file to clear
		 */
		ReportOptimizer.archivefiles();
				
		if (envpro.getProperty("BROWSER").equals("FIREFOX")){
			 wd = new FirefoxDriver();
		
		
			
		}else if (envpro.getProperty("BROWSER").equals("CHROME")){
			
		}
		 wd.manage().window().maximize();
		 wd.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		 wd.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		 
	}
	
	public static WebElement getElementByXpath(String xpath){
		
		return wd.findElement(By.xpath(locpro.getProperty(xpath)));
				
	}
}
