package pageObjects;

import org.openqa.selenium.By;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class HomePage {
	
	AndroidDriver<MobileElement> driver;
	
	By noBrokerLogo = By.id("com.nobroker.app:id/logo");
	By buy = By.id("com.nobroker.app:id/buyLayout");
	By search = By.id("com.nobroker.app:id/searchEditHome");
	
	public HomePage(AndroidDriver<MobileElement> driver){
		this.driver = driver;
	}
	
	public MobileElement getNoBrokerLogo() {
		return driver.findElement(noBrokerLogo);
	}
	public MobileElement getBuy() {
		return driver.findElement(buy);
	}
	public MobileElement getSearch() {
		return driver.findElement(search);
	}
	
}
