package appiumTests;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class AppiumTest {
	
	//Webdriver driver;
	static AppiumDriver<MobileElement> driver;
	//AndroidDriver

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			calci();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getCause());
			System.out.println(e.getMessage());
		}
		
	}

	public static void calci() throws MalformedURLException {
		// TODO Auto-generated method stub
		
		DesiredCapabilities cap = new DesiredCapabilities();
		
		cap.setCapability("deviceName", "Android SDK built for x86");
		
		cap.setCapability("udid", "emulator-5554");
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "10");
		
		cap.setCapability("appPackage", "com.android.apps.documentsui");
		cap.setCapability("appActivity", "com.google.android.documentsui.picker.PickActivity");
		cap.setCapability("automationName", "UiAutomator2");
		
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		driver = new AppiumDriver<MobileElement>(url,cap);
		
		System.out.println("working fime");
	}

}
