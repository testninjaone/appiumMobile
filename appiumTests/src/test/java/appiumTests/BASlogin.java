package appiumTests;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.aspectj.lang.annotation.Before;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import java.time.Duration;
import static io.appium.java_client.touch.offset.PointOption.point;
import static io.appium.java_client.touch.WaitOptions.*;
import org.openqa.selenium.support.ui.Wait;

public class BASlogin {
	
	//Webdriver driver;
	static AppiumDriver<MobileElement> driver;
	
	//AndroidDriver

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		// TODO Auto-generated method stub
		
		
		DesiredCapabilities cap = new DesiredCapabilities();
		
		cap.setCapability("deviceName", "Android");
		cap.setCapability("udid", "emulator-5554");
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "10");
		
		cap.setCapability("appPackage", "com.bastrucks.worldapp.staging");
		cap.setCapability("appActivity", "com.bastrucks.worldapp.presentation.onboarding.SplashActivity");
		cap.setCapability("automationName", "UiAutomator2");
		cap.setCapability("noReset", true);
		
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		driver = new AppiumDriver<MobileElement>(url,cap);
		
		System.out.println("App Started");
		
		basworld();
		
		
	}
	
	public static void basworld() throws MalformedURLException, InterruptedException {
		// TODO Auto-generated method stub
		
		
		
		//Adding wait to load the app after splash
		//driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.HorizontalScrollView/android.widget.LinearLayout/androidx.appcompat.app.ActionBar.Tab[5]")));
		
		//Opening login screen
		MobileElement myBAS = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.HorizontalScrollView/android.widget.LinearLayout/androidx.appcompat.app.ActionBar.Tab[5]"));
		myBAS.click();
		
		
		// adding wait for the email field to show
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.bastrucks.worldapp.staging:id/edittext_login_email")));
				
		//entering credentials
		MobileElement email = driver.findElement(By.id("com.bastrucks.worldapp.staging:id/edittext_login_email"));
		email.sendKeys("n25a@grr.la");
				
		MobileElement password = driver.findElement(By.id("com.bastrucks.worldapp.staging:id/edittext_login_password"));
		password.sendKeys("12345678");
		
		MobileElement loginButton = driver.findElement(By.id("com.bastrucks.worldapp.staging:id/button_login_login"));
		loginButton.click();
		
		
		//verifying the login screen
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.bastrucks.worldapp.staging:id/textview_header_welcome")));
		String welcomeText = driver.findElement(By.id("com.bastrucks.worldapp.staging:id/textview_header_welcome")).getText();
		System.out.println("Logged in with " + welcomeText);
		
		
		//opening the account settings
		
		myBAS.click();
				
		MobileElement myAccount = driver.findElement(By.id("com.bastrucks.worldapp.staging:id/action_settings"));
		myAccount.click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.bastrucks.worldapp.staging:id/textview_myaccount_editaccountdetails")));
		
		//TouchAction action = new TouchAction(driver);
		
	    //action.(427, 878).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1300)).moveTo(427,554).release().perform());
	    
		//Scroll to the bottom
		new TouchAction(driver).press(point(964,506)).waitAction(waitOptions(Duration.ofMillis(1000))).moveTo(point(967, 350)).release().perform();

			
		MobileElement logout = driver.findElement(By.id("com.bastrucks.worldapp.staging:id/textview_myaccount_logout"));
		logout.click();
		
		
		wait.until(ExpectedConditions.alertIsPresent());
		
		//wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		alert.dismiss(); 
		System.out.println("log out cancelled");
		
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("com.bastrucks.worldapp.staging:id/textview_myaccount_logout")));
		
		logout.click();
		
		wait.until(ExpectedConditions.alertIsPresent());
		alert.accept();
		System.out.println("logged out");
			
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.bastrucks.worldapp.staging:id/textview_login_info1")));
		
		MobileElement loginLogo = driver.findElement(By.id("com.bastrucks.worldapp.staging:id/textview_login_info1"));
		String loginscreen = loginLogo.getText();
		System.out.println("You are on login screen with label " + loginscreen);
		System.out.println("You have successfully logged in and logged out");
		
		
	}
    
}
