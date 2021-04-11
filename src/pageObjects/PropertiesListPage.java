package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class PropertiesListPage {
	AndroidDriver<MobileElement> driver;
	
	public PropertiesListPage(AndroidDriver<MobileElement> driver){
		this.driver = driver;
	}
	
	@SuppressWarnings("rawtypes")
	public void scrollAndClickOn4prop(){
		boolean click = false;
		while(!click)
		{
			try{
				MobileElement element = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[3]/android.widget.LinearLayout/android.widget.FrameLayout[1]/android.widget.ImageView"));
				element.click();
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
	
	@SuppressWarnings("rawtypes")
	public void scrollAndClickOnWrongInfoButton(){
		boolean click = false;
		while(!click)
		{
			try{
				MobileElement element = driver.findElement(By.id("com.nobroker.app:id/tv_report_wrong_info"));
				element.click();
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
