package qa.guru.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class AuthPage {
    private static final SelenideElement authPopup = $("[data-marker=\"auth-app-root\"]");
    private static final SelenideElement loginInput = $("input[data-marker=\"login-form/login/input\"]");
    private static final SelenideElement loginError = $("[data-marker=\"field/error\"]");
    private static final SelenideElement passwordInput = $("input[data-marker=\"login-form/password/input\"]");
    private static final SelenideElement submitButton = $("button[data-marker=\"login-form/submit\"]");

    @Step
    public AuthPage checkAuthFormElements() {
        authPopup.shouldBe(visible);
        loginInput.shouldBe(visible);
        passwordInput.shouldBe(visible);
        submitButton.shouldBe(visible);
        loginError.shouldNotBe(visible);
        return this;
    }

    @Step
    public AuthPage setLogin(String login) {
        loginInput.setValue(login);
        return this;
    }

    @Step
    public AuthPage setPassword(String password) {
        passwordInput.setValue(password);
        return this;
    }

    @Step
    public AuthPage submitButton() {
        submitButton.click();
        return this;
    }

    @Step
    public AuthPage checkFailedLogin() {
        authPopup.shouldBe(visible);
        loginError.shouldBe(visible);
        return this;
    }
}
