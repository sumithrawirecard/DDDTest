package com.wirecard.ntltaxi.pageobjects;

import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.wirecard.ntltaxi.initializer.DriverFunctions;
import com.wirecard.ntltaxi.initializer.Initializer;

public class HomePage extends Initializer {

	public static void enterUserName(String UserName){
		//wd.findElement(By.xpath(".//*[@id='nameid']")).sendKeys("TEST A");
		
		getElementByXpath("HOMEPAGE_TYPE_USERNAME_XPATH").sendKeys(UserName);
		
		
	}
	
	public static void enterMoblieNumber(String MoblieNumber){
		//wd.findElement(By.xpath(".//*[@id='mobid']")).sendKeys("1111111111");
		getElementByXpath("HOMEPAGE_TYPE_MOBILENUMBER_XPATH").sendKeys(MoblieNumber);
	}
	
	public static void enterPickUpAddress(String PickUpAddress){
		getElementByXpath("HOMEPAGE_TYPE_PICKUPADDRESS_XPATH").sendKeys(PickUpAddress);
	}
	
	public static void enterDropAddress(String DropAddress){
		getElementByXpath("HOMEPAGE_TYPE_DROPADDRESS_XPATH").sendKeys(DropAddress);
	}
	
	public static void clickBookLater(){
		getElementByXpath("HOMEPAGE_TYPE_BOOKLATER_XPATH").click();
	}
	
	public static void selectBasic(String option){
		WebElement element = getElementByXpath("HOMEPAGE_TYPE_BASIC_XPATH");
		DriverFunctions.selectDropDownByVisableText(element, option);
	}
}
