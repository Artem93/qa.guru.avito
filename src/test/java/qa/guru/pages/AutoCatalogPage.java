package qa.guru.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class AutoCatalogPage {
    private static final SelenideElement header = $("h1");
    private static final SelenideElement modelTab = $("[data-marker=\"model-tab\"]");
    private static final SelenideElement autoTab = modelTab.$("[data-marker=\"model-tab/tab(auto)\"]");
    private static final SelenideElement gruzovikiTab = modelTab.$("[data-marker=\"model-tab/tab(gruzoviki_i_spetstehnika)\"]");

    private static final String headerText = "Каталог автомобилей";

    @Step
    public AutoCatalogPage checkTabs() {
        modelTab.shouldBe(exist);
        autoTab.shouldBe(visible);
        gruzovikiTab.shouldBe(visible);
        return this;
    }

    @Step
    public AutoCatalogPage checkHeader() {
        header
                .shouldBe(visible)
                .shouldHave(text(headerText));
        return this;
    }
}
