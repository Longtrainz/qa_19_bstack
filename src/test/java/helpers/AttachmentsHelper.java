package helpers;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.nio.charset.StandardCharsets;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static helpers.BrowserStackHelper.getBrowserstackVideoUrl;

import io.qameta.allure.Attachment;


public class AttachmentsHelper {

	@Attachment(value = "{attachName}", type = "text/plain")
	public static String attachAsText(String attachName, String message) {
		return message;
	}

	@Attachment(value = "{attachName}", type = "image/png")
	public static byte[] attachScreenshot(String attachName) {
		return ((TakesScreenshot) getWebDriver()).getScreenshotAs(OutputType.BYTES);
	}

	@Attachment(value = "Page source", type = "text/plain")
	public static byte[] attachPageSource() {
		return getWebDriver().getPageSource().getBytes(StandardCharsets.UTF_8);
	}

	@Attachment(value = "Video", type = "text/html", fileExtension = ".html")
	public static String attachVideo(String sessionId) {
		return "<html><body><video width='100%' height='100%' controls autoplay><source src='" + getBrowserstackVideoUrl(
				sessionId) + "' type='video/mp4'></video></body></html>";
	}

}
