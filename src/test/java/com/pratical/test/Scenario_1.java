package com.pratical.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.pratical.base.DriverIntialization;
import com.pratical.page.LumaPage;

public class Scenario_1 extends DriverIntialization {
static boolean wrongFilter=true;
	@Test
	public static void senario1() throws InterruptedException {
// 		Navigate Home Page
		LumaPage.homePage().click();
		
//		Search Value
		LumaPage.searchField().sendKeys("Bag");
		Thread.sleep(2000);
		
//		Take the search data count
		int searchValueOpctionCount=LumaPage.searchedValue().size();
		
//		Validate the search data
		for(int i=1; i<=searchValueOpctionCount; i++) {
			Thread.sleep(100);
			String filterValue=LumaPage.filterValue(i).getText().toUpperCase();
			String testData="bag";
			if(!filterValue.contains(testData.toUpperCase())) {
				wrongFilter=false;
			} else {
				wrongFilter=true;
			} 
		}
		
		ExtentTest testCase = extent.createTest("Scenario-1 : Validate that the results returned matches the search term".toUpperCase()); 
		if(wrongFilter) {
			testCase.log(Status.INFO, "Searched data only returned");
			testCase.log(Status.PASS, "TEST PASS");
		} else {
			testCase.log(Status.INFO, "Searched data wrongly returned");
			testCase.log(Status.FAIL, "TEST FAIL");
		}
	}

	

	

}
