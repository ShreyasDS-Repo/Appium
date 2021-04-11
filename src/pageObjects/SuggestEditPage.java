package pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class SuggestEditPage {
	AndroidDriver<MobileElement> driver;
	By bhkDropDown = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.RelativeLayout[2]/android.widget.Spinner/android.widget.TextView");
	By bhkList = By.className("android.widget.TextView");
	By saveButton = By.id("com.nobroker.app:id/btn_save");
	By feedbackText = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.TextView[1]");
	
	
	public SuggestEditPage(AndroidDriver<MobileElement> driver){
		this.driver = driver;
	}
	
	public MobileElement getBhkDropDown(){
		return driver.findElement(bhkDropDown);
	}
	public List<MobileElement> getBhkList(){
		return driver.findElements(bhkList);
	}
	public MobileElement getSaveButton(){
		return driver.findElement(saveButton);
	}
	public MobileElement getFeedbackText(){
		return driver.findElement(feedbackText);
	}
	@SuppressWarnings("rawtypes")
	public void scrollAndAddNotes(){
		boolean click = false;
		while(!click)
		{
			try{
				MobileElement element = driver.findElement(By.id("com.nobroker.app:id/edt_others"));
				element.sendKeys("Assignment");
				click = true;
			}catch(NoSuchElementException e){
				Dimension dim = driver.manage().window().getSize();
				int startx = (int) (dim.width * 0.5);
				int starty = (int) (dim.height*0.8);
				
				int endx =  (int) (dim.width * 0.5);
				int endy = (int) (dim.height * 0.2);
				
		
				TouchAction action = new TouchAction(driver);
				action.press(PointOption.point(startx,starty))
				.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
				.moveTo(PointOption.point(endx,endy)).release().perform(); 
			}
			
		}
	}
}
