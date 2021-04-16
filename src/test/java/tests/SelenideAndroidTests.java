package tests;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selenide.*;
import static io.appium.java_client.MobileBy.AccessibilityId;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import com.codeborne.selenide.Configuration;

import drivers.BrowserStackMobileDriver;
import io.appium.java_client.MobileBy;

@Tag("android")
public class SelenideAndroidTests {

	@Test
	void searchTest() {
		Configuration.browser = BrowserStackMobileDriver.class.getName();
		Configuration.startMaximized = false;
		Configuration.browserSize = null;
		Configuration.timeout = 10000;

		open();
		$(AccessibilityId("Search Wikipedia")).click();
		$(MobileBy.id("org.wikipedia.alpha:id/search_src_text")).setValue("BrowserStack");
		$$(MobileBy.id("org.wikipedia.alpha:id/page_list_item_container")).shouldHave(sizeGreaterThan(0));

	}
}
