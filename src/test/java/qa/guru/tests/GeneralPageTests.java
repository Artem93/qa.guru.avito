package qa.guru.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import qa.guru.pages.*;

public class GeneralPageTests extends GeneralPagesBaseTest {
    GeneralPage generalPage = new GeneralPage();
    BusinessPage businessPage = new BusinessPage();
    AutoCatalogPage autoCatalogPage = new AutoCatalogPage();
    SearchResultPage searchResultPage = new SearchResultPage();
    AuthPage authPage = new AuthPage();
    FavoritePage favoritePage = new FavoritePage();
    SelectRegionPage selectRegionPage = new SelectRegionPage();

    @Tag("smoke")
    @Test
    @DisplayName("Переход на страницу 'Для бизнеса' с главной")
    void checkLinkToBusinessPageFromHeaderTest() {
        generalPage.clickOnBusinessButton();
        businessPage.checkBusinessPageLoaded();
    }

    @Tag("regression")
    @Test
    @DisplayName("Переход на страницу 'Избранное' с главной")
    void checkLinkToFavoritePageFromHeaderTest() {
        generalPage.clickOnFavoriteButton();
        favoritePage.checkFavoritePageLoaded();
    }

    @Tag("regression")
    @Test
    @DisplayName("Переход на страницу автокаталога через хедер")
    void checkLinkToCatalogAutoFromHeaderTest() {
        generalPage
                .hoverOnCatalogArrow()
                .selectAutoInListCatalogs();
        autoCatalogPage
                .checkHeader()
                .checkTabs();
    }

    @Tag("smoke")
    @Test
    @DisplayName("Проверка кнопок в хедере на главной странице")
    void checkButtonsInHeaderTest() {
        generalPage.checkHeaderItems();
    }

    @Tag("regression")
    @CsvSource(value = {
            "Дом, Москва",
            "Гараж, Саранск",
    })
    @ParameterizedTest(name = "Проверка поискового запроса: {0} в городе {1}")
    void checkValidSearchRequestAndCityTest(String request, String city) {
        generalPage
                .clickSelectGeoButton();
        selectRegionPage
                .setInputGeo(city)
                .selectFirstGeoFromSuggestion()
                .clickApply();
        generalPage
                .checkSelectGeoText(city)
                .setInput(request)
                .clickInputSubmit();
        searchResultPage
                .checkSearchResultHeader(request)
                .checkSearchItem(request);
    }

    @Tag("smoke")
    @ValueSource(strings = {"дом", "гараж"})
    @ParameterizedTest(name = "Проверка поискового запроса: {0}")
    void checkValidSearchRequestTest(String request) {
        generalPage
                .setInput(request)
                .clickInputSubmit();
        searchResultPage
                .checkSearchResultHeader(request)
                .checkSearchItem(request);
    }

    @Tag("regression")
    @Test
    @DisplayName("Проверка невалидного поискового запроса")
    void checkNotValidSearchRequestTest() {
        generalPage
                .setInput("notvaliderequest")
                .clickInputSubmit();
        searchResultPage
                .checkNoResultsHeader();
    }

    @Tag("regression")
    @Test
    @DisplayName("Проверка списка категорий по клику на кнопку 'Все категории'")
    void checkCategoriesInAllCategoriesListTest() {
        generalPage
                .clickAllCategoriesButton()
                .checkCategoriesInAllCategoriesList();

    }

    @Tag("smoke")
    @Test
    @DisplayName("Проверка попапа логина")
    void checkInvalidateLoginAuthTest() {
        generalPage.clickLoginButton();
        authPage.checkAuthFormElements();
    }
}
