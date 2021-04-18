package tests;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;
import static helpers.AttachmentsHelper.*;
import static helpers.BrowserStackHelper.getBSPublicLink;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.sessionId;

import org.junit.jupiter.api.*;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.codeborne.selenide.Configuration;

import drivers.BrowserStackMobileDriver;
import io.qameta.allure.selenide.AllureSelenide;


public class TestBase {

	@BeforeAll
	public static void beforeAll() {
		addListener("AllureSelenide", new AllureSelenide());
		Configuration.browser = BrowserStackMobileDriver.class.getName();
		Configuration.startMaximized = false;
		Configuration.browserSize = null;
		Configuration.timeout = 10000;
	}

	@BeforeEach
	void startDriver() {
		step("Open application", () -> open());
	}

	@AfterEach
	public void afterEach() {
		String sessionId = getSessionId();

		attachScreenshot("Last screenshot");
		attachPageSource();
		attachAsText("Browserstack build link", getBSPublicLink(sessionId));

		closeWebDriver();

		attachVideo(sessionId);
	}

	public static String getSessionId() {
		return ((RemoteWebDriver) getWebDriver()).getSessionId().toString();
	}

}