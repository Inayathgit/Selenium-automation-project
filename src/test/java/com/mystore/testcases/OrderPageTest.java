package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.store.base.BaseClass;
import com.store.dataprovider.dataProvider;
import com.store.pageobjects.AddToCartPage;
import com.store.pageobjects.IndexPage;
import com.store.pageobjects.OrderPage;
import com.store.pageobjects.SearchResult;

public class OrderPageTest extends BaseClass {
	
	private IndexPage index;
	private SearchResult searchResultPage;
	private AddToCartPage addToCartPage;
	private OrderPage orderPage;
	
	@BeforeMethod()
	public void setup() {
		launchApp(); 
	}
	
	@AfterMethod()
	public void tearDown() {
		getDriver().quit();
	}
	
	@Test (dataProvider = "order" ,dataProviderClass = dataProvider.class)
	public void verifyTotalPrice(String productName, String qty) throws Throwable {
//		Log.startTestCase("verifyTotalPrice");
		index= new IndexPage();
		index= new IndexPage();
		orderPage = new OrderPage();
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
//		Log.endTestCase("verifyTotalPrice");
	}
}
