package com.mystore.testcases;

import org.testng.Assert;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.store.base.BaseClass;
import com.store.pageobjects.IndexPage;
import com.store.pageobjects.SearchResult;

public class SearchResultPageTest extends BaseClass {

	private IndexPage index;
	private SearchResult searchResult;
	
	@BeforeMethod
	public void setup() {
		launchApp(); 
	}
	
	@AfterMethod
	public void tearDown() {
		getDriver().quit();
	}
	
	@Test
	public void productAvailabilityTest() throws Throwable {
//		Log.startTestCase("productAvailabilityTest");
		index= new IndexPage();
		searchResult=index.searchProduct(prop.getProperty("productname"));
		boolean result = searchResult.isProductAvailable();
		Assert.assertTrue(result);
//		Log.endTestCase("productAvailabilityTest");
	}
}
