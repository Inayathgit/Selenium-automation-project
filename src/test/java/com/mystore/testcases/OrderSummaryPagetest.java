package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.store.base.BaseClass;
import com.store.dataprovider.dataProvider;
import com.store.pageobjects.AddToCartPage;
import com.store.pageobjects.IndexPage;
import com.store.pageobjects.OrderConfirmationPage;
import com.store.pageobjects.OrderPage;
import com.store.pageobjects.OrderSummaryPage;
import com.store.pageobjects.SearchResult;

public class OrderSummaryPagetest  extends BaseClass{
	
	private IndexPage index;
	private SearchResult searchResultPage;
	private AddToCartPage addToCartPage;
	private OrderPage orderPage;
	private OrderSummaryPage ordersummaryPage;
	private OrderConfirmationPage orderconfirmationPage;
	
	@BeforeMethod()
	public void setup() {
		launchApp(); 
	}
	
	@AfterMethod()
	public void tearDown() {
		getDriver().quit();
	}
	
	@Test (dataProvider = "order" ,dataProviderClass = dataProvider.class)
	public void verifyOrderSummaryPage(String productName, String qty) throws Throwable {
//		Log.startTestCase("verifyTotalPrice");
		index= new IndexPage();
		index= new IndexPage();
		orderPage = new OrderPage();
		ordersummaryPage = new OrderSummaryPage();
		orderconfirmationPage = new OrderConfirmationPage();
		searchResultPage=index.searchProduct(productName);
		addToCartPage=searchResultPage.clickOnProduct();
		addToCartPage.clickOnAddToCart();
		addToCartPage.navigatetoCart();
		addToCartPage.enterQuantity(qty);
		Double subtotalPrice=orderPage.getSubtotalPrice();
		Double shippingPrice = orderPage.getShippingPrice();
		Double stateTax = orderPage.getStateTax();
		Double totalPrice=orderPage.getTotalPrice();
		Double Expectedtotalprice = subtotalPrice + shippingPrice + stateTax;
		Assert.assertEquals(totalPrice, Expectedtotalprice);
		orderPage.clickOnCheckOut();
		ordersummaryPage.enteruserdetails(prop.getProperty("FirstName"), prop.getProperty("LastName"), prop.getProperty("StreetAddress"), prop.getProperty("City"), prop.getProperty("Zipcode"));
		ordersummaryPage.clickonPlaceOrder();
		String message = orderconfirmationPage.validateConfirmMessage();
		String expectedmessage = "Thank you. Your order has been received.";
		Assert.assertEquals(message, expectedmessage);
//		Log.endTestCase("verifyTotalPrice");
	}
}

