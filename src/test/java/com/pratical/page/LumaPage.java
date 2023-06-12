package com.pratical.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.pratical.base.DriverIntialization;

public class LumaPage extends DriverIntialization{
	public static WebElement searchField() {
		return driver.findElement(By.id("search"));
	}
	
	public static WebElement homePage() {
		return driver.findElement(By.xpath("//a[@class='logo']"));
	}
	
	public static List<WebElement> searchedValue() {
		return driver.findElements(By.xpath("//ul[@role='listbox']/li"));
	}
	
	public static WebElement filterValue(int i) {
		return driver.findElement(By.xpath("//ul[@role='listbox']/li["+i+"]/span[1]"));
	}
	public static List<WebElement> addedValueCount() {
		return driver.findElements(By.xpath("//ol[@id='mini-cart']/li"));
	}
	public static WebElement addedValueInCard(int i) {
		return driver.findElement(By.xpath("//ol[@id='mini-cart']/li["+i+"]//strong[@class='product-item-name']"));
	}
	public static WebElement viewCard() {
		return driver.findElement(By.xpath("//a[@class='action showcart']"));
	}
	public static WebElement clickAddCard() {
		return driver.findElement(By.xpath("//button[@type='submit']/span[text()='Add to Cart']"));
	}
	public static WebElement selectProduct(int i) {
		return driver.findElement(By.xpath("//div[@class='products wrapper grid products-grid']/ol/li["+i+"]"));
	}
	public static WebElement productName(int i) {
		return driver.findElement(By.xpath("//div[@class='products wrapper grid products-grid']/ol/li["+i+"]//a[@class='product-item-link']"));
	}
	public static List<WebElement> filterData() {
		return driver.findElements(By.xpath("//div[@class='products wrapper grid products-grid']/ol/li"));
	}
	public static WebElement bag() {
		return driver.findElement(By.xpath("//div[@class='block filter']//a[text()='Bags']"));
	}
	public static WebElement gear() {
		return driver.findElement(By.xpath("//span[text()='Gear']"));
	}
	public static WebElement filterColor() {
		return driver.findElement(By.xpath("//div[@class='swatch-option color selected'][@option-label='Black']"));
	}
	public static WebElement filterCategory(int i) {
		return driver.findElement(By.xpath("//div[@class='products wrapper grid products-grid']/ol/li["+i+"]//a[@class='product-item-link']"));
	}
	public static List<WebElement> filterCount() {
		return driver.findElements(By.xpath("//div[@class='products wrapper grid products-grid']/ol/li"));
	}
	public static WebElement clickBlack() {
		return driver.findElement(By.xpath("//div[@class='filter-options']//a[@aria-label='Black']/div"));
	}
	public static WebElement clickColor() {
		return driver.findElement(By.xpath("//div[@class='block-content filter-content']/div//div[text()='Color'] "));
	}
	public static WebElement clickJacket() {
		return driver.findElement(By.xpath("//div[@class='block-content filter-content']/div/div[1]/div[2]/ol/li[1]/a"));
	}
	public static WebElement clickCategory() {
		return driver.findElement(By.xpath("//div[@class='block-content filter-content']//div[text()='Category']"));
	}
	public static WebElement clickTop() {
		return driver.findElement(By.xpath("//div[@class='sidebar sidebar-main']//a[text()='Tops']"));
	}
	public static WebElement clickWomen() {
		return driver.findElement(By.xpath("//nav[@class='navigation']/ul/li[2]"));
	}
}
