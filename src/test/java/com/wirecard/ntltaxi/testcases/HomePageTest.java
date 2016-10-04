package com.wirecard.ntltaxi.testcases;

import java.io.IOException;
import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.wirecard.nlttaxi.inputreader.inputReader;
import com.wirecard.ntltaxi.initializer.DriverFunctions;
import com.wirecard.ntltaxi.initializer.Initializer;
import com.wirecard.ntltaxi.pageobjects.HomePage;
import com.wirecard.ntltaxi.reportgenerator.ScreenshotGenerator;

public class HomePageTest extends Initializer {

	@BeforeClass
	public void setUp() throws IOException
	{
		initialize();
	}
	@Test(dataProvider="HomePageTest")
	public void validateHomePage(String Testdata,String Username,String Mobileno,String Pickup,String Drop,String Basic) throws IOException {

		DriverFunctions.loadURL();
		log = report.startTest(Testdata);
		
		HomePage.enterUserName(Username);
		HomePage.enterMoblieNumber(Mobileno);
		HomePage.enterPickUpAddress(Pickup);
		HomePage.enterDropAddress(Drop);
		HomePage.selectBasic(Basic);
		HomePage.clickBookLater();
				
	}

	@DataProvider(name="HomePageTest")
	public static Object[][] getHomePageData() throws Exception
	{
		
		if(inputReader.RunModeVerification("HomePageTest")){
		//Object [] [] data = new Object[3][6];
			Object [] [] data =inputReader.selectSingleDataOrMulitiData("HomePageTest");

//		data[0][0] = "HomePageTest_dataset1";
//		data[0][1] = "TestA";
//		data[0][2] = "12222222222";
//		data[0][3] = "ADYAR";
//		data[0][4] = "ADYAR";
//		data[0][5] = "Sedan";
//		
//		
//		data[1][0] = "HomePageTest_dataset2";
//		data[1][1] = "TestB";
//		data[1][2] = "12222222222";
//		data[1][3] = "ADYAR";
//		data[1][4] = "ADYAR";
//		data[1][5] = "Sedan";
//		
//		data[2][0] = "HomePageTest_dataset3";
//		data[2][1] = "TestC";
//		data[2][2] = "12222222222";
//		data[2][3] = "ADYAR";
//		data[2][4] = "ADYAR";
//		data[2][5] = "Sedan";
//		
		return data;
		}
		return null;
		
		
	}
	@AfterMethod
	public void tearDown(ITestResult result) throws IOException{
		
		ScreenshotGenerator.takeScreenShot(result);
	}
}
