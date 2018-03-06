package testfrm1;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class AndroidTest {
	@Test
	public void LoginApp() throws MalformedURLException{
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Nexus5Demo");
		//File f = new File("src/main/java");
		//File fs = new File (f,"Twitter_v7.35.0_apkpure.com.apk");
		cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.twitter.android");
		cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.twitter.android.StartActivity");
		AndroidDriver<AndroidElement> Adriver = new AndroidDriver<> (new URL("http://127.0.0.1:4723/wd/hub"),cap);
		Adriver.findElementByAndroidUIAutomator("text(\"Have an account already? Log in\")").click();
		Adriver.findElementById("com.twitter.android:id/login_identifier").sendKeys("svr_dheerendra@yahoo.co.in");
		Adriver.findElementById("com.twitter.android:id/login_password").sendKeys("MOMICHAT123#");
		Adriver.findElementByAndroidUIAutomator("text(\"LOG IN\")").click();
	}
}
