package helpers;


import com.codeborne.selenide.Selenide;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.nio.charset.StandardCharsets;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.openqa.selenium.logging.LogType.BROWSER;

public class Attach {
        @Attachment(value = "{attachName}", type = "image/png")
        public static byte[] screenshotAs(String attachName) {
            return ((TakesScreenshot) getWebDriver()).getScreenshotAs(OutputType.BYTES);
        }

        @Attachment(value = "Page source", type = "text/plain")
        public static byte[] pageSource() {
            return getWebDriver().getPageSource().getBytes(StandardCharsets.UTF_8);
        }

        @Attachment(value = "{attachName}", type = "text/plain")
        public static String attachAsText(String attachName, String message) {
            return message;
        }

        public static void browserConsoleLogs() {
            attachAsText(
                    "Browser console logs",
                    String.join("\n", Selenide.getWebDriverLogs(BROWSER))
            );
        }
    @Attachment(value = "Video", type = "text/html", fileExtension = ".html")
    public static String addVideo() {
        String sessionId = Selenide.sessionId() != null
                ? Selenide.sessionId().toString()
                : null;

        if (sessionId == null) {
            return "<html><body><p>📹 Video not available (local run without Selenoid)</p></body></html>";
        }

        String videoBaseUrl = "https://user1:1234@selenoid.autotests.cloud/video";

        return "<html><body>" +
                "<h4>🎥 Test Execution Video</h4>" +
                "<video width='100%' height='100%' controls autoplay>" +
                "<source src='" + videoBaseUrl + "/" + sessionId + ".mp4' type='video/mp4'>" +
                "Your browser does not support the video tag. " +
                "<a href='" + videoBaseUrl + "/" + sessionId + ".mp4' target='_blank'>Download video</a>" +
                "</video></body></html>";
    }
}




