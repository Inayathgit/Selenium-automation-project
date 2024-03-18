package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.store.base.BaseClass;
import com.store.pageobjects.HomePage;
import com.store.pageobjects.IndexPage;
import com.store.pageobjects.LoginPage;

public class HomePageTest extends BaseClass{
	private IndexPage indexPage;
	private LoginPage loginPage;
	private HomePage homePage;
	@BeforeMethod
	public void setup() {
		launchApp(); 
	}
//	
//	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	@AfterMethod
	public void tearDown() {
		getDriver().quit();
	}
	
//	@Test(groups = "Smoke",dataProvider = "credentials", dataProviderClass = DataProviders.class)
	@Test
	public void validatehomePage() throws Throwable {
//		Log.startTestCase("orderHistoryandDetailsTest");
		indexPage= new IndexPage();
		homePage = new HomePage();
		loginPage=indexPage.clickOnSignIn();
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		boolean result=homePage.validateStoreTitleText().contains("AskOmDch");
		Assert.assertTrue(result);
//		Log.endTestCase("orderHistoryandDetailsTest");
	}
}
