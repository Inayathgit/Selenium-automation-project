package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.store.base.BaseClass;
import com.store.dataprovider.dataProvider;
import com.store.pageobjects.AddToCartPage;
import com.store.pageobjects.IndexPage;
import com.store.pageobjects.SearchResult;

public class AddtoCartPageTest extends BaseClass {
	private IndexPage index;
	private SearchResult searchResultPage;
	private AddToCartPage addToCartPage;
	@BeforeMethod
	public void setup() {
		launchApp(); 
	}
	
	@AfterMethod
	public void tearDown() {
		getDriver().quit();
	}
	
	
	@Test(dataProvider = "productname" ,dataProviderClass = dataProvider.class)
	public void addToCartTest(String productName) throws Throwable {
//		Log.startTestCase("addToCartTest");
		index= new IndexPage();
		searchResultPage=index.searchProduct(productName);
		addToCartPage=searchResultPage.clickOnProduct();
		addToCartPage.clickOnAddToCart();
		String productadded=addToCartPage.validateAddtoCart();
		String expectedproduct = "Denim Blue Jeans";
		boolean result = productadded.contains(expectedproduct);
		Assert.assertTrue(result);
//		Log.endTestCase("addToCartTest");
		
	}
}
