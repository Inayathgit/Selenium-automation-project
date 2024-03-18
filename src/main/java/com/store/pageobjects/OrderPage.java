
package com.store.pageobjects;


import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.store.actiondriver.Action;
import com.store.base.BaseClass;

public class OrderPage extends BaseClass {
	
	Action action= new Action();
	
	@FindBy(xpath="(//span[@class='woocommerce-Price-amount amount']/bdi)[2]")
	private WebElement SubtotalPrice;
	
	@FindBy(xpath="//tr[@class='order-total']/td/strong/span/bdi")
	private WebElement totalPrice;
	
	@FindBy(xpath="(//span[@class='woocommerce-Price-amount amount'])[4]/bdi")
	private WebElement shippingPrice;
	
	@FindBy(xpath="(//span[@class='woocommerce-Price-amount amount'])[5]")
	private WebElement stateTax;
	
	@FindBy(xpath="//a[@class='checkout-button button alt wc-forward']")
	private WebElement proceedToCheckOut;
	
	public OrderPage() {
		PageFactory.initElements(getDriver(), this);
	}

	public double  getSubtotalPrice() {
		
		String subtotalprice=SubtotalPrice.getText();
//		String unit=unitPrice1.replaceAll("[^a-zA-Z0-9]","");
//		double finalUnitPrice=Double.parseDouble(unit);
	
		return Double.parseDouble(subtotalprice.substring(1));
	}
	public double  getShippingPrice() {
		String shippingprice=shippingPrice.getText();

	
		return Double.parseDouble(shippingprice.substring(1));
	}
	public double  getStateTax() {
		String statetax = stateTax.getText();

	
		return Double.parseDouble(statetax.substring(1));
	}
	
	public double getTotalPrice() {
		String totalprice = totalPrice.getText();
//		String tot=totalPrice1.replaceAll("[^a-zA-Z0-9]","");
//		double finalTotalPrice=Double.parseDouble(tot);
		return Double.parseDouble(totalprice.substring(1));
	}
	
	public LoginPage clickOnCheckOut() throws Throwable {
		action.click(getDriver(), proceedToCheckOut);
		return new LoginPage();
	}
}
