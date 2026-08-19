package helpers;


import com.codeborne.selenide.Selenide;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import static com.codeborne.selenide.Selenide.sessionId;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.openqa.selenium.logging.LogType.BROWSER;

public class Attach {
        @Attachment(value = "{attachName}", type = "image/png")
        public static byte[] screenshotAs(String attachName) {
            return ((TakesScreenshot) getWebDriver()).getScreenshotAs(OutputType.BYTES);
        }

        @Attachment(value = "Page source", type = "text/plain") // or text/html чтобы отображалась стараница
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
                    String.join("\n", Selenide.getWebDriverLogs(BROWSER)) //логи браузера консоль вкладка
            );
        }
    @Attachment(value = "Video", type = "text/html", fileExtension = ".html")
    public static String addVideo() {
        String sessionId = Selenide.sessionId() != null
                ? Selenide.sessionId().toString()
                : null;

        // Если без сессии (локальный запуск без Selenoid) — не добавляем битую ссылку
        if (sessionId == null) {
            return "<html><body><p>📹 Video not available (local run without Selenoid)</p></body></html>";
        }

        // Добавляем user1:1234@ для авторизации в Jenkins, иначе будет ошибка 401
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




