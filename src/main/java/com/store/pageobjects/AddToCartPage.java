package com.store.pageobjects;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.store.actiondriver.Action;
import com.store.base.BaseClass;
public class AddToCartPage extends BaseClass {
	
	Action action= new Action();
	
	
	
	@FindBy(xpath="//button[@name='add-to-cart']")
	private WebElement addToCartBtn;
	
	@FindBy(xpath="(//a[text()='View cart'])[3]")
	private WebElement navigateToaddToCartBtn;
	
	@FindBy(xpath="//td[@class='product-name']")
	private WebElement productAdded;
	
	@FindBy(xpath="(//input[@class='input-text qty text'])[1]")
	private WebElement quantity;
	
	
	@FindBy(xpath="//a[@class='checkout-button button alt wc-forward']")
	private WebElement proceedToCheckOutBtn;
	
	public AddToCartPage() {
		PageFactory.initElements(getDriver(), this);
	}

	
	public void clickOnAddToCart() throws Throwable {
		action.click(getDriver(), addToCartBtn);
	}
	
	public void navigatetoCart() throws Throwable {
		action.click(getDriver(), navigateToaddToCartBtn);
	}
	
	public String validateAddtoCart() throws Throwable {
		navigateToaddToCartBtn.click();
		String productadded = productAdded.getText();
		return productadded;
	}
	public void enterQuantity(String quantity1) throws Throwable {
		action.click(getDriver(), quantity);
		action.type(quantity, quantity1);
	}
	
	
	public OrderPage clickOnCheckOut() throws Throwable {
//		action.fluentWait(getDriver(), proceedToCheckOutBtn, 10);
		action.JSClick(getDriver(), proceedToCheckOutBtn);
		return new OrderPage();
	}
}
