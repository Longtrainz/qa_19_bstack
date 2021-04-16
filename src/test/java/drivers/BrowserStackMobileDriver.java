package drivers;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.codeborne.selenide.WebDriverProvider;

import io.appium.java_client.android.AndroidDriver;


public class BrowserStackMobileDriver implements WebDriverProvider {

	@Override
	public WebDriver createDriver(DesiredCapabilities capabilities) {
		// Set your access credentials
		capabilities.setCapability("browserstack.user", "teacat1");
		capabilities.setCapability("browserstack.key", "aRxpWp2ayMJvWfVRMtyP");

		// Set URL of the application under test
		capabilities.setCapability("app", "bs://c700ce60cf13ae8ed97705a55b8e022f13c5827c");

		// Specify device and os_version for testing
		capabilities.setCapability("device", "Google Pixel 3");
		capabilities.setCapability("os_version", "9.0");

		// Set other BrowserStack capabilities
		capabilities.setCapability("project", "First Java Project");
		capabilities.setCapability("build", "Java Android");
		capabilities.setCapability("name", "first_test");

		return new AndroidDriver<>(getBrowserStackUrl(), capabilities);
	}

	public static URL getBrowserStackUrl() {
		try {
			return new URL("http://hub.browserstack.com/wd/hub");
		} catch (MalformedURLException e) {
			throw new RuntimeException(e);
		}
	}
}
