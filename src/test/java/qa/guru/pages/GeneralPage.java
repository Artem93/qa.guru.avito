package qa.guru.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class GeneralPage {
    private static final String businessText = "Для бизнеса";
    private static final String careerText = "Карьера в Авито";
    private static final String helpText = "Помощь";
    private static final String catalogText = "Каталоги";
    private static final String careText = "Польза";
    private static final String autoGridCategoryText = "Авто";
    private static final String loginButtonText = "Вход и регистрация";
    private static final String addAdButtonText = "Разместить объявление";

    private static final String autoListCategoryText = "Транспорт";
    private static final String houseListCategoryText = "Недвижимость";
    private static final String workListCategoryText = "Работа";
    private static final String servicesListCategoryText = "Услуги";
    private static final String personalThingsListCategoryText = "Личные вещи";
    private static final String forHomeListCategoryText = "Для дома и дачи";
    private static final String sparePartsListCategoryText = "Запчасти и аксессуары";
    private static final String electronicsListCategoryText = "Электроника";
    private static final String hobbiesListCategoryText = "Хобби и отдых";
    private static final String petListCategoryText = "Животные";
    private static final String businessListCategoryText = "Бизнес и оборудование";

    private static final SelenideElement navbar = $("[data-marker=\"header/navbar\"]");
    private static final SelenideElement navbarBusinessButton = navbar.$("[href=\"/business\"]");
    private static final SelenideElement navbarCareerButton = navbar.$("[href=\"//career.avito.com/" +
            "?utm_source=avito.ru&utm_medium=referral&utm_campaign=test_placement_to_career&utm_content=top_vacancy\"]");
    private static final SelenideElement navbarHelpButton = navbar.$("[href=\"//support.avito.ru\"]");
    private static final SelenideElement navbarCatalogsArrow = navbar.$("[name=\"chevron-narrow\"]");
    private static final SelenideElement navbarCatalogs = navbarCatalogsArrow.parent();
    private static final SelenideElement catalogAutoInList = $("[data-catalog-slug=\"catalog_auto\"]");
    private static final SelenideElement navbarCareButton = navbar.$("[href=\"/avito-care?from=mp_header\"]");
    private static final SelenideElement navbarFavoriteButton = navbar.$("[name=\"favorites-filled\"]");
    private static final SelenideElement navbarCartButton = navbar.$("[name=\"cart\"]");
    private static final SelenideElement navbarLoginButton = navbar.$("[data-marker=\"header/login-button\"]");
    private static final SelenideElement navbarAddAd = navbar.$(byText(addAdButtonText));

    private static final SelenideElement searchInput = $("input[data-marker=\"search-form/suggest\"]");
    private static final SelenideElement searchSubmitButton = $("[data-marker=\"search-form/submit-button\"]");
    private static final SelenideElement allCategoriesButton = $("[data-marker=\"top-rubricator/all-categories\"]");
    private static final SelenideElement selectGeoButton = $("[data-marker=\"search-form/change-location\"]");

    private static final SelenideElement autoCategoryInAllCategories = $("[data-marker=\"top-rubricator/root-category-25984\"]");
    private static final SelenideElement houseCategoryInAllCategories = $("[data-marker=\"top-rubricator/root-category-26113\"]");
    private static final SelenideElement workCategoryInAllCategories = $("[data-marker=\"top-rubricator/root-category-26400\"]");
    private static final SelenideElement servicesCategoryInAllCategories = $("[data-marker=\"top-rubricator/root-category-26486\"]");
    private static final SelenideElement personalThingsCategoryInAllCategories = $("[data-marker=\"top-rubricator/root-category-26127\"]");
    private static final SelenideElement forHomeCategoryInAllCategories = $("[data-marker=\"top-rubricator/root-category-26047\"]");
    private static final SelenideElement sparePartsCategoryInAllCategories = $("[data-marker=\"top-rubricator/root-category-30757\"]");
    private static final SelenideElement electronicsCategoryInAllCategories = $("[data-marker=\"top-rubricator/root-category-26195\"]");
    private static final SelenideElement hobbiesCategoryInAllCategories = $("[data-marker=\"top-rubricator/root-category-26315\"]");
    private static final SelenideElement petCategoryInAllCategories = $("[data-marker=\"top-rubricator/root-category-26098\"]");
    private static final SelenideElement businessCategoryInAllCategories = $("[data-marker=\"top-rubricator/root-category-26382\"]");
    private static final ElementsCollection listOfCategories = autoCategoryInAllCategories.parent().$$("[data-marker]");

    private static final SelenideElement searchCategoryAuto = $("[data-marker=\"visual-rubricator/image-Авто\"]");

    @Step
    public GeneralPage clickAllCategoriesButton() {
        allCategoriesButton.click();
        return this;
    }

    @Step
    public GeneralPage clickSelectGeoButton() {
        selectGeoButton.click();
        return this;
    }

    @Step
    public GeneralPage checkSelectGeoText(String city) {
        selectGeoButton.shouldHave(text(city));
        return this;
    }

    @Step
    public GeneralPage checkCategoriesInAllCategoriesList() {
        int sizeOfCategories = 11;

        autoCategoryInAllCategories
                .shouldBe(visible)
                .shouldHave(text(autoListCategoryText));
        houseCategoryInAllCategories
                .shouldBe(visible)
                .shouldHave(text(houseListCategoryText));
        workCategoryInAllCategories
                .shouldBe(visible)
                .shouldHave(text(workListCategoryText));
        servicesCategoryInAllCategories
                .shouldBe(visible)
                .shouldHave(text(servicesListCategoryText));
        personalThingsCategoryInAllCategories
                .shouldBe(visible)
                .shouldHave(text(personalThingsListCategoryText));
        forHomeCategoryInAllCategories
                .shouldBe(visible)
                .shouldHave(text(forHomeListCategoryText));
        sparePartsCategoryInAllCategories
                .shouldBe(visible)
                .shouldHave(text(sparePartsListCategoryText));
        electronicsCategoryInAllCategories
                .shouldBe(visible)
                .shouldHave(text(electronicsListCategoryText));
        hobbiesCategoryInAllCategories
                .shouldBe(visible)
                .shouldHave(text(hobbiesListCategoryText));
        petCategoryInAllCategories
                .shouldBe(visible)
                .shouldHave(text(petListCategoryText));
        businessCategoryInAllCategories
                .shouldBe(visible)
                .shouldHave(text(businessListCategoryText));

        Assertions.assertEquals(
                listOfCategories.size(),
                sizeOfCategories,
                String.format("Должно быть %d категорий", sizeOfCategories)
        );
        return this;
    }

    @Step
    public GeneralPage clickOnBusinessButton() {
        navbarBusinessButton
                .shouldHave(text(businessText))
                .click();
        return this;
    }

    @Step
    public GeneralPage clickOnFavoriteButton() {
        navbarFavoriteButton.click();
        return this;
    }

    @Step
    public GeneralPage clickOnAutoCategory() {
        searchCategoryAuto
                .shouldHave(text(autoGridCategoryText))
                .click();
        return this;
    }

    @Step
    public GeneralPage hoverOnCatalogArrow() {
        navbarCatalogsArrow.hover();
        return this;
    }

    @Step
    public GeneralPage selectAutoInListCatalogs() {
        catalogAutoInList.click();
        return this;
    }

    @Step
    public GeneralPage setInput(String request) {
        searchInput.setValue(request);
        return this;
    }

    @Step
    public GeneralPage clickInputSubmit() {
        searchSubmitButton.click();
        return this;
    }

    @Step
    public GeneralPage checkHeaderItems() {
        navbarBusinessButton
                .shouldBe(visible)
                .shouldHave(text(businessText));
        navbarCareerButton
                .shouldBe(visible)
                .shouldHave(text(careerText));
        navbarHelpButton
                .shouldBe(visible)
                .shouldHave(text(helpText));
        navbarCatalogs
                .shouldBe(visible)
                .shouldHave(text(catalogText));
        navbarCareButton
                .shouldBe(visible)
                .shouldHave(text(careText));
        navbarFavoriteButton
                .shouldBe(visible);
        navbarCartButton
                .shouldBe(visible);
        navbarLoginButton
                .shouldBe(visible)
                .shouldHave(text(loginButtonText));
        navbarAddAd
                .shouldBe(visible);
        return this;
    }

    @Step
    public GeneralPage clickLoginButton() {
        navbarLoginButton.click();
        return this;
    }
}
