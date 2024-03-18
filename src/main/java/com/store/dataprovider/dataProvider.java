package com.store.dataprovider;

import org.testng.annotations.DataProvider;

public class dataProvider {
	
	 @DataProvider(name = "productname")
	    public Object[] productname() {
	        return new Object[][] {
	            {"Blue Jeans"}
	        };
	    }
	 
	 @DataProvider(name = "order") 
		 public Object[][] order() {
		        return new Object[][] {
		            {"Blue jeans","2"}
		        };
		    }
		 
		 
	 }
