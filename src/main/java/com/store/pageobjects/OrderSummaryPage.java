package com.store.pageobjects;
//import java.security.PublicKey;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.store.actiondriver.Action;
import com.store.base.BaseClass;


public class OrderSummaryPage extends BaseClass {
	
	Action action= new Action();
	
	@FindBy(xpath="//input[@id='billing_first_name']")
	private WebElement firstName;
	
	@FindBy(xpath="//input[@id='billing_last_name']")
	private WebElement lastName;
	
	@FindBy(xpath="//input[@id='billing_address_1']")
	private WebElement streetAddress;
	
	@FindBy(xpath="//input[@id='billing_city']")
	private WebElement city;
	
	@FindBy(xpath="//input[@id='billing_postcode']")
	private WebElement zipCode;
	
	@FindBy(xpath="//button[@id='place_order']")
	private WebElement placeOrder;
	
	@FindBy(xpath="//span[contains(text(),'I confirm my order')]")
	private WebElement confirmOrderBtn;
	
	public OrderSummaryPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public void enteruserdetails(String FirstName,String LastName,String City,String StreetAddress,String ZipCode) {
		
		action.type(firstName, FirstName);
		action.type(lastName, LastName);
		action.type(streetAddress, StreetAddress);
		action.type(city, City);
		action.type(zipCode, ZipCode);
		
		
		
	}
	
	public void clickonPlaceOrder() {
		
		action.click(getDriver(), placeOrder);
	}
	public OrderConfirmationPage clickOnconfirmOrderBtn() throws Throwable {
		action.click(getDriver(), confirmOrderBtn);
		return new OrderConfirmationPage();
	}
	
}
