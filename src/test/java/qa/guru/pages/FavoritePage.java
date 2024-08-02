package qa.guru.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class FavoritePage {
    private final String headerText = "Избранное";
    private final String tabItemsText = "Объявления";
    private final String tabSearchesText = "Поиски";
    private final String tabSellersText = "Профили";

    private static final SelenideElement favoriteHeader = $("h1");
    private static final SelenideElement tabItems = $("[data-marker=\"favorites-tabs/tab(items)\"]");
    private static final SelenideElement tabSearches = $("[data-marker=\"favorites-tabs/tab(searches)\"]");
    private static final SelenideElement tabSellers = $("[data-marker=\"favorites-tabs/tab(sellers)\"]");

    public FavoritePage checkFavoritePageLoaded() {
        favoriteHeader
                .shouldBe(visible)
                .shouldHave(text(headerText));
        tabItems
                .shouldBe(visible)
                .shouldHave(text(tabItemsText));
        tabSearches
                .shouldBe(visible)
                .shouldHave(text(tabSearchesText));
        tabSellers
                .shouldBe(visible)
                .shouldHave(text(tabSellersText));
        return this;
    }
}
