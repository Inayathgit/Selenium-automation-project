package com.store.pageobjects;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;


import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.store.actiondriver.Action;
import com.store.base.BaseClass;

public class SearchResult extends BaseClass  {
	
	Action action= new Action();
	
	@FindBy(xpath="(//h2[@class='woocommerce-loop-product__title'])[1]")
	private WebElement productfound;
	
	@FindBy(xpath = "//div[@id='nav-logo']")
	private WebElement myStoreLogo;
	
//	@FindBy(xpath="(//img[@class='s-image'])[1]")
//	private WebElement productResult;
//	
	public SearchResult() throws Throwable {
		PageFactory.initElements(getDriver(), this);
	}
	
	public boolean isProductAvailable() throws Throwable {
	String expectedtext = "Denim Blue Jeans";
	System.out.println(productfound.getText());
	boolean res = productfound.getText().contains(expectedtext);
	System.out.println(productfound.getText().substring(0,5));
	return res;
	}
	
	
	public AddToCartPage clickOnProduct() throws Throwable {
		action.click(getDriver(), productfound);
		return new AddToCartPage();
	}
}
