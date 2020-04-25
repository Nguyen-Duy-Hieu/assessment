package com.calendar.base;

import com.calendar.pages.HomePage;
import org.apache.log4j.Logger;
import com.calendar.utils.APPHelper;
import com.calendar.utils.Hooks;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class BasePOM {
	
	private static final Logger LOG = Logger.getLogger(BasePOM.class);
	
	HomePage homePage;

	/*LoginPage loginPage;
	ProductsPage productsPage;
	OrderPlacementPage orderPlacementPage;*/
	APPHelper appiumUtils;
	AndroidDriver<MobileElement> driver;
	APPHelper appHelper;
	
	public AndroidDriver<MobileElement> getDriver() {
		if(driver == null)
			driver = Hooks.getDriver();
		return driver;
	}
	
	public APPHelper appHelper() {
		if(appHelper == null)
			appHelper = new APPHelper(getDriver());
		return appHelper;
	}
	
	public HomePage homePage() {
		if(homePage == null)
			homePage = new HomePage();
		return homePage;
	}
	
	/*public LoginPage loginPage() {
		if(loginPage == null) 
			loginPage = new LoginPage();
		return loginPage;
	}
	
	public ProductsPage productsSearch() {
		if(productsPage == null) 
			productsPage = new ProductsPage();
		return productsPage;
	}
	
	public OrderPlacementPage orderPlacementPage() {
		if(orderPlacementPage ==null)
			orderPlacementPage =new OrderPlacementPage();
		return orderPlacementPage;
	}*/
}
