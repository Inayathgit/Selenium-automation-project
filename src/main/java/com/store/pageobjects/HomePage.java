package com.store.pageobjects;


import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.store.actiondriver.Action;
import com.store.base.BaseClass;

public class HomePage  extends BaseClass {
	
	Action action= new Action();
	
	@FindBy(xpath="//span[text()='My wishlists']")
	private WebElement myWishList;
	
	
	@FindBy(xpath = "(//a[text()='Home'])[1]")
	private WebElement homeBtn;
	
	
	@FindBy(xpath = "//a[@id='nav-orders']")
	private WebElement orderBtn;
	
	@FindBy(xpath = "//h1[@class='site-title']")
	private WebElement storeTitle;
	
	@FindBy(xpath = "//h1[text()='Your Orders']")
	private WebElement orderHistory;
	
	public HomePage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	
	public String validateStoreTitleText() {
		action.click(getDriver(), homeBtn);
		String storetitletext = storeTitle.getText();
		return storetitletext;
		
	}

	
	public boolean validateMyWishList() throws Throwable {
		return action.isDisplayed(getDriver(), myWishList);
	}
	
	public boolean validateOrderHistory() throws Throwable {
		action.click(getDriver(), orderBtn);
		return action.isDisplayed(getDriver(), orderHistory);
	}
	
	
}
