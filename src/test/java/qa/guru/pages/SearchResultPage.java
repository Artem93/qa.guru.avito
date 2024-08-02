package qa.guru.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SearchResultPage {
    private static final SelenideElement searchResultHeader = $("[data-marker=\"page-title/text\"]");
    private static final SelenideElement noResultsHeader = $("h2");
    private static final ElementsCollection searchResultItems = $$("[data-marker=\"item-title\"]");


    @Step
    public SearchResultPage checkSearchResultHeader(String result) {
        searchResultHeader
                .shouldBe(visible)
                .shouldHave(text(result));
        return this;
    }

    @Step
    public SearchResultPage checkSearchItem(String result) {
        searchResultItems.first()
                .shouldBe(visible)
                .shouldHave(text(result));
        return this;
    }

    @Step
    public SearchResultPage checkNoResultsHeader() {
        noResultsHeader
                .shouldBe(visible)
                .shouldHave(text("Ничего не найдено"))
                .shouldHave(text("в выбранной области поиска"));
        return this;
    }
}
