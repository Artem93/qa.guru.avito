package qa.guru.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class BusinessPage {
    private static final String textHeroBanner = "Ведите бизнес на Авито";

    private static final SelenideElement heroBannerTitle = $(".hero-banner-module-title-_iYfw");

    @Step
    public BusinessPage checkBusinessPageLoaded() {
        heroBannerTitle
                .shouldBe(visible)
                .shouldHave(text(textHeroBanner));
        return this;
    }
}
