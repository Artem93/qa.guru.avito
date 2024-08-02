package qa.guru.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;
import qa.guru.utils.Attachments;

import java.util.Map;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class GeneralPagesBaseTest {

    @BeforeAll
    static void setUp() {
        var browser = System.getProperty("browser", "chrome:100.0").split(":")[0];
        var version = System.getProperty("browser", "chrome:100.0").split(":")[1];
        Configuration.baseUrl = "https://www.avito.ru/";
        Configuration.browser = browser;
        Configuration.browserVersion = version;
        Configuration.remote = System.getProperty(
                "remoteUrl",
                "https://user1:1234@selenoid.autotests.cloud/wd/hub");
        Configuration.browserSize = System.getProperty(
                "resolution",
                "1920x1280");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        Configuration.browserCapabilities = capabilities;
    }

    @BeforeEach
    void setTest() {
        open("");
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterEach
    void post() {
        Attachments.attachPage();
        Attachments.attachScreenshot();
        Attachments.addVideo();
        closeWebDriver();
    }
}
