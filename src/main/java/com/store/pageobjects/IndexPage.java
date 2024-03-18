package com.store.pageobjects;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;

import com.store.actiondriver.Action;
import org.openqa.selenium.support.PageFactory;
import com.store.base.BaseClass;
public class IndexPage extends BaseClass {
Action action= new Action();
private IndexPage IndexPage;
private LoginPage loginPage;
private HomePage homePage;
	@FindBy(xpath = "(//a[@class='menu-link'][text()='Account'])[1]") 
	private WebElement signInBtn;
	
	@FindBy(xpath = "//span[@class='site-title']/a")
	private WebElement myStoretitle;
	
	@FindBy(xpath="//input[@type='search']")
	private WebElement searchProductBox;
	
	@FindBy(xpath="//button[@value='Search']")
	private WebElement searchButton;
	
	@FindBy(xpath="(//a[text()='Store'])[1]")
	private WebElement StoreButton;
	
	public IndexPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public LoginPage clickOnSignIn() throws Throwable {
//		action.fluentWait(getDriver(), signInBtn, 10);
//		action.mouseOverElement(getDriver(), signInBtn);
		System.out.println(signInBtn);
		action.click(getDriver(), signInBtn);
		return new LoginPage();
		
		
	}
//	
//	public boolean validateLogo() throws Throwable {
//		Thread.sleep(20000);
//		return action.isDisplayed(getDriver(), myStoreLogo);
//	}
	
	public String getMyStoreTitle() {
		
		String myStoreTitel=myStoretitle.getText();
		System.out.println(myStoreTitel);
		return myStoreTitel;
	}
	
	public SearchResult searchProduct(String productName) throws Throwable {
		IndexPage= new IndexPage();
		loginPage=IndexPage.clickOnSignIn();
        Thread.sleep(5000);
	    loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	    StoreButton.click();
		action.click(getDriver(), searchProductBox);
		action.type(searchProductBox, productName);

		action.click(getDriver(), searchButton);
		
		return new SearchResult();
	}
//	
}
