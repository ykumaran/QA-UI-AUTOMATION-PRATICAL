package com.pratical.base;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverIntialization {

	public static String browser = "chrome";
	public static WebDriver driver;	
	public static String URL = "https://magento.softwaretestingboard.com/";
	public static ExtentReports extent;
	public static ExtentHtmlReporter htmlreporter;
	public static ExtentTest testCase;


	@BeforeSuite
	public void main() throws IOException {

		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browser.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.get(URL);

		ExtentReport();

	}

	@AfterSuite
	public void closeChrome() {
		extent.flush();
//		 driver.close();
	}

	public static void ExtentReport() throws IOException {
		extent = new ExtentReports();
		htmlreporter = new ExtentHtmlReporter(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Report\\extentreport.html");

		extent.attachReporter(htmlreporter);
	}


}
