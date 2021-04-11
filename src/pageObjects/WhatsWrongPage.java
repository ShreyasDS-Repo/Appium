package pageObjects;

import java.util.List;

import org.openqa.selenium.By;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class WhatsWrongPage {
	AndroidDriver<MobileElement> driver;
	By reportPropertyTitle = By.id("com.nobroker.app:id/tv_signup_heading");
	By phoneNumberField = By.id("com.nobroker.app:id/et_signup_phone");
	By passwordRadioButton = By.id("com.nobroker.app:id/rb_signup_pwd");
	By passwordField = By.id("com.nobroker.app:id/et_signup_pwd");
	By signUp = By.id("com.nobroker.app:id/btn_signup");
	By checkBoxList = By.className("android.widget.CheckBox");
	By reportButton = By.id("com.nobroker.app:id/btn_report");
	
	public WhatsWrongPage(AndroidDriver<MobileElement> driver){
		this.driver = driver;
	}
	
	public MobileElement getReportPropertyTitle(){
		return driver.findElement(reportPropertyTitle);
	}
	public MobileElement getPhoneNumberField(){
		return driver.findElement(phoneNumberField);
	}
	public MobileElement getPasswordRadioButton(){
		return driver.findElement(passwordRadioButton);
	}
	public MobileElement getPasswordField(){
		return driver.findElement(passwordField);
	}
	public MobileElement getSignUp(){
		return driver.findElement(signUp);
	}
	public List<MobileElement> getCheckBoxes(){
		return driver.findElements(checkBoxList);
	}
	public MobileElement getReportButton(){
		return driver.findElement(reportButton);
	}

}
