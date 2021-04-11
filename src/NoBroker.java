import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import pageObjects.BuyPage;
import pageObjects.HomePage;
import pageObjects.PropertiesListPage;
import pageObjects.SuggestEditPage;
import pageObjects.WhatsWrongPage;

public class NoBroker {

	public static AndroidDriver<MobileElement> driver;
	@BeforeClass
	public void setup() throws MalformedURLException{
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(MobileCapabilityType.VERSION, "10");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Redmi 9");
		cap.setCapability("appPackage", "com.nobroker.app");
		cap.setCapability("appActivity", "com.nobroker.app.activities.NBSplashScreen");
		//to grant the permission
		cap.setCapability("autoGrantPermissions", true);
		cap.setCapability("resetKeyboard", true);
		cap.setCapability("unicodeKeyboard", true);
		//to not install the app everytime
		cap.setCapability(MobileCapabilityType.NO_RESET, true);
		
		driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub") ,cap);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	}
	
	@SuppressWarnings("rawtypes")
	@Test
	public void start() throws MalformedURLException, InterruptedException{
		HomePage hp = new HomePage(driver);
		BuyPage bp = new BuyPage(driver);
		PropertiesListPage pl = new PropertiesListPage(driver);
		WhatsWrongPage wp = new WhatsWrongPage(driver);
		SuggestEditPage sp = new SuggestEditPage(driver);
		
		System.err.println("Execution starting...");
		System.out.println("clicking on no broket logo");
		hp.getNoBrokerLogo().click();
		
		System.out.println("clicking on BUY tab");
		hp.getBuy().click();
		
		System.out.println("clicking on search edit field");
		hp.getSearch().click();
		
		System.out.println("Entering Marathahalli and HSR in the search edit box");
		bp.getSearchBox().sendKeys("Marathahalli");
		Thread.sleep(5000);
		bp.tap();
		
		bp.getSearchBox().sendKeys("HSR");
		Thread.sleep(5000);
		bp.tap();
		
		System.out.println("clicking on 2bhk, 3bhk, search button");
		bp.getIncludeCheckBox().click();
		bp.getbhk2Button().click();
		bp.getbhk3Button().click();
		bp.getSearchProperty().click();
		
		System.out.println("clicking 4th property");
		//Thread.sleep(2000);
		pl.scrollAndClickOn4prop();
		
		//check
		//Thread.sleep(1000);
		System.out.println("clicking Wrong info button");
		pl.scrollAndClickOnWrongInfoButton();
		
		System.out.println("Verifying Report Property title");
		String Report = wp.getReportPropertyTitle().getText();
		Assert.assertEquals(Report, "Report property");
		
		System.out.println("Entering mobile number");
		wp.getPhoneNumberField().sendKeys("1237567899");
		Thread.sleep(5000);
		TouchAction touchAction = new TouchAction(driver);
		touchAction.tap(PointOption.point(200, 400)).perform();
	
		System.out.println("clicking on password radio button and entering the pw");
		wp.getPasswordRadioButton().click();
		wp.getPasswordField().sendKeys("nobroker123");
		
		System.out.println("clicking sign up");
		wp.getSignUp().click();

		//Thread.sleep(1000);
		System.out.println("Selecting all the checkboxes");
		for(MobileElement ch : wp.getCheckBoxes()){
			ch.click();
		}
		
		System.out.println("clicking on Report button");
		wp.getReportButton().click();
		System.out.println("clicking on bhk dropdown");
		sp.getBhkDropDown().click();
		
		System.out.println("Selecting 4+ BHK");
		for(MobileElement bh : sp.getBhkList()){
			if(bh.getText().contentEquals("4+ BHK")){
				bh.click();
				break;
			}
		}
		
		System.out.println("Scrolling and adding notes");
		sp.scrollAndAddNotes();
		
		System.out.println("clicking on save button");
		sp.getSaveButton().click();
		
		System.out.println("Verifying the message");
		String success = sp.getFeedbackText().getText();
		Assert.assertEquals(success, "Thank you for the feedback");
		System.err.println("Execution Ended");
	}
	
	@AfterClass
	public void tearDown(){
		driver.quit();
	}
}
