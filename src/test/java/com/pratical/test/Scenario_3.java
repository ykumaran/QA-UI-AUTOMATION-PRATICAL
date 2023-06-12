package com.pratical.test;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.pratical.base.DriverIntialization;
import com.pratical.page.LumaPage;

public class Scenario_3 extends DriverIntialization{
	static boolean addedValueCorrect=false;
	@Test 
	public static void senario3() throws InterruptedException {
// 		Navigate Home Page
		LumaPage.homePage().click();
		
//		Click Gear
		LumaPage.gear().click();
		
//		Click Bag
		LumaPage.bag().click();
		
		Thread.sleep(2000);
		int filteredData=LumaPage.filterData().size();
		for(int i=1; i<=filteredData; i++) {
			WebElement name=LumaPage.productName(i);
			String productName=name.getText().toUpperCase();
			if(productName.contains("Overnight Duffle".toUpperCase())) {
				LumaPage.selectProduct(i).click();
				Thread.sleep(1000);
				LumaPage.clickAddCard().click();
				break;
			}
		}

Thread.sleep(5000);
LumaPage.viewCard().click();
		
//		Validate the added cart 
		int addedValueinCard=LumaPage.addedValueCount().size();
		for(int i=1; i<=addedValueinCard; i++) {
			String filterValue=LumaPage.addedValueInCard(i).getText().toUpperCase();
			if(filterValue.contains("Overnight Duffle".toUpperCase())) {
				addedValueCorrect=true;
			} else {
				addedValueCorrect=false;
			}
		}
//		
		ExtentTest testCase=extent.createTest("Scenario-3 : Added Value Correct".toUpperCase());
		if(addedValueCorrect) {
			testCase.log(Status.INFO, "Searched data only returned".toUpperCase());
			testCase.log(Status.PASS, "TEST PASS");
		} else {
			testCase.log(Status.INFO, "Searched data wrongly returned".toUpperCase());
			testCase.log(Status.FAIL, "TEST FAIL");
		}
	}
	
}
