package com.store.pageobjects;
import org.openqa.selenium.WebElement;


import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.store.actiondriver.Action;
import com.store.base.BaseClass;
public class LoginPage extends BaseClass {
Action action= new Action();
	
	@FindBy(xpath="//input[@id='username']")
	private WebElement userName;
	
	@FindBy(xpath="//input[@id='continue']")
	private WebElement continueBtn;
	
	@FindBy(xpath="//input[@id='password']")
	private WebElement password;

	@FindBy(xpath="//button[@name='login']")
	private WebElement signInBtn;
	
	@FindBy(xpath = "(//strong)[1]")
	private WebElement loggedinUserDetails;
	
	@FindBy(name="email_create")
	private WebElement emailForNewAccount;
	
	@FindBy(name="SubmitCreate")
	private WebElement createNewAccountBtn;
	
	public LoginPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
//	public HomePage login(String uname, String pswd,HomePage homePage) throws Throwable {
//		action.scrollByVisibilityOfElement(getDriver(), userName);
//		action.type(userName, uname);
//		action.type(password, pswd);
//		action.JSClick(getDriver(), signInBtn);
//		Thread.sleep(2000);
//		homePage=new HomePage();
//		return homePage;
//	}
	public void login(String uname, String pswd) throws Throwable {
//		action.scrollByVisibilityOfElement(getDriver(), userName);
		System.out.println(uname);
		System.out.println(pswd);
		action.type(userName, uname);
//		continueBtn.click();
		action.type(password, pswd);
//		action.JSClick(getDriver(), signInBtn);
		signInBtn.click();
//		Thread.sleep(2000);
//		homePage=new HomePage();
//		return homePage;
	}
	public String userloggedinverification(){
		String homePageURL= loggedinUserDetails.getText();
		return homePageURL;
	}
	
	public AddressPage login(String uname, String pswd,AddressPage addressPage) throws Throwable {
		action.scrollByVisibilityOfElement(getDriver(), userName);
		action.type(userName, uname);
		action.type(password, pswd);
		action.click(getDriver(), signInBtn);
		Thread.sleep(2000);
		addressPage=new AddressPage();
		return addressPage;
	}

//	public CreateAccountPage createNewAccount(String newEmail) throws Throwable {
//		action.type(emailForNewAccount, newEmail);
//		action.click(getDriver(), createNewAccountBtn);
//		return new CreateAccountPage();
//	}
}
