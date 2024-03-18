package com.mystore.testcases;
import org.testng.Assert;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.store.base.BaseClass;

import com.store.pageobjects.HomePage;
import com.store.pageobjects.IndexPage;
import com.store.pageobjects.LoginPage;

public class LoginPageTest extends BaseClass {
	private IndexPage indexPage;
	private LoginPage loginPage;
	private HomePage homePage;
	
//	@Parameters("browser")
//	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
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
	@Test
	
	public void loginTest() throws Throwable {
//		Log.startTestCase("loginTest");
		indexPage= new IndexPage();
//		Log.info("user is going to click on SignIn");
		loginPage=indexPage.clickOnSignIn();
	           Thread.sleep(5000);
//		Log.info("Enter Username and Password");
	    loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
//		homePage=loginPage.login(uname,pswd,homePage);
	    String userloggedinverification=loginPage.userloggedinverification();
	    String expecteduser="Seleniumtest";
	   
//	    Log.info("Verifying if user is able to login");
//	    Assert.assertEquals(actualURL, expectedURL);
//	    Log.info("Login is Sucess");
//	    Log.endTestCase("loginTest");
	}

}
