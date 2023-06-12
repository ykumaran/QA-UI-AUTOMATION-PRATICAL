package com.pratical.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.pratical.base.DriverIntialization;
import com.pratical.page.LumaPage;

public class Scenario_2 extends DriverIntialization{
	static boolean correctFilter=false;
	@Test
	public static void senario2() throws InterruptedException { 
// 		Navigate Home Page
		LumaPage.homePage().click();
		
//		Click Women
		LumaPage.clickWomen().click();
		
//		Click Top
		LumaPage.clickTop().click();
		
//		Click Category
		LumaPage.clickCategory().click();
		
		Thread.sleep(500);
//		Click Jacket
		LumaPage.clickJacket().click();
		
//		Click Color
		LumaPage.clickColor().click();
		
		Thread.sleep(1500);
//		Click Black Color
		LumaPage.clickBlack().click();
		
//		Validate the search value
		Thread.sleep(2000);
		int filteredData=LumaPage.filterCount().size();
		for(int i=1; i<=filteredData; i++) {
			WebElement name=LumaPage.filterCategory(i);
			String productName=name.getText().toUpperCase();
			if(productName.contains("Jacket".toUpperCase())) {
					try {
				WebElement blackSelected=LumaPage.filterColor();
				correctFilter=true;
			} catch (NoSuchElementException e) {
				correctFilter=false;
			}
			}
		}
		
		ExtentTest testCase=extent.createTest("Scenario-2 : Validate that the results returned matches the search term".toUpperCase());
		if(correctFilter) {
			testCase.log(Status.INFO, "Searched data only returned".toUpperCase());
			testCase.log(Status.PASS, "TEST PASS");
		} else {
			testCase.log(Status.INFO, "Searched data wrongly returned".toUpperCase());
			testCase.log(Status.FAIL, "TEST FAIL");
		}
	}
	
}
