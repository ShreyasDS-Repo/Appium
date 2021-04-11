package pageObjects;

import org.openqa.selenium.By;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;

public class BuyPage {
	AndroidDriver<MobileElement> driver;
	
	By searchBox = By.id("com.nobroker.app:id/localityAutoCompleteTxt");
	By includeCheckBox = By.id("com.nobroker.app:id/nearByRadio");
	By bhk2Button = By.id("com.nobroker.app:id/bhktwo");
	By bhk3Button = By.id("com.nobroker.app:id/bhkthree");
	By searchProperty = By.id("com.nobroker.app:id/searchProperty");
	
	public BuyPage(AndroidDriver<MobileElement> driver){
		this.driver = driver;
	}
	
	public MobileElement getSearchBox() {
		return driver.findElement(searchBox);
	}
	public MobileElement getIncludeCheckBox() {
		return driver.findElement(includeCheckBox);
	}
	public MobileElement getbhk2Button() {
		return driver.findElement(bhk2Button);
	}
	public MobileElement getbhk3Button() {
		return driver.findElement(bhk3Button);
	}
	public MobileElement getSearchProperty() {
		return driver.findElement(searchProperty);
	}
	@SuppressWarnings("rawtypes")
	public void tap() {
		TouchAction touchAction = new TouchAction(driver);
		touchAction.tap(PointOption.point(321, 642)).perform();
	}
	
}
