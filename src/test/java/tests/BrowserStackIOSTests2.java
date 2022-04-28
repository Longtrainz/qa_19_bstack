package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.MobileBy;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selenide.$x;


@Tag("ios")
public class BrowserStackIOSTests2 {

	@Test
	void searchTest() throws MalformedURLException, InterruptedException {
		DesiredCapabilities caps = new DesiredCapabilities();

		// Set your access credentials
		caps.setCapability("browserstack.user", "teacat1");
		caps.setCapability("browserstack.key", "aRxpWp2ayMJvWfVRMtyP");

		// Set URL of the application under test
		caps.setCapability("app", "bs://9ffd3fbeaeb8639a3b5ede5697c5c6fffe5cc205");

		// Specify device and os_version for testing
		caps.setCapability("device", "iPhone XS");
		caps.setCapability("os_version", "12");
		caps.setCapability("autoAcceptAlerts", true);

		// Set other BrowserStack capabilities
		caps.setCapability("project", "First Java Project");
		caps.setCapability("build", "Java iOS");
		caps.setCapability("name", "first_test");


		// Initialise the remote Webdriver using BrowserStack remote URL
		// and desired capabilities defined above
		IOSDriver<IOSElement> driver = new IOSDriver<IOSElement>(new URL("http://hub-cloud.browserstack.com/wd/hub"),
				caps);


		// Test case for the BrowserStack sample iOS app.
		// If you have uploaded your app, update the test case here.
//		IOSElement continueWithoutAuthButton = (IOSElement) new WebDriverWait(driver, 30).until(
//				ExpectedConditions.elementToBeClickable(MobileBy.xpath("//XCUIElementTypeButton[@name='ПРОДОЛЖИТЬ БЕЗ АВТОРИЗАЦИИ']")));
//		continueWithoutAuthButton.click();

		WebElement continueWithoutAuthButton = new WebDriverWait(driver, 30).until(
				ExpectedConditions.elementToBeClickable(MobileBy.xpath("//XCUIElementTypeButton[@name='ПРОДОЛЖИТЬ БЕЗ АВТОРИЗАЦИИ']")));
		continueWithoutAuthButton.click();

		System.out.println("Attribute name: " + continueWithoutAuthButton.getAttribute("name"));
		System.out.println("Attribute label: " + continueWithoutAuthButton.getAttribute("label"));
		System.out.println("Text: " + continueWithoutAuthButton.getText());

		Thread.sleep(5000);

		// Invoke driver.quit() after the test is done to indicate that the test is completed.
		driver.quit();

	}

}