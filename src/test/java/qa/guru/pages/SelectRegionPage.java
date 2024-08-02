package qa.guru.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SelectRegionPage {
    private static final SelenideElement geoInput = $("input[data-marker=\"popup-location/region/search-input\"]");
    private static final SelenideElement clearGeoButton = $("button[data-marker=\"popup-location/region/clearButton\"]");
    private static final ElementsCollection listOfSuggestionGeo = $$("[data-marker=\"popup-location/region/custom-option([object Object])\"]");
    private static final SelenideElement applyButton = $("[data-marker=\"popup-location/save-button\"]");

    @Step
    public SelectRegionPage setInputGeo(String geo) {
        geoInput.click();
        geoInput.setValue(geo);
        return this;
    }

    @Step
    public SelectRegionPage clickClearInput() {
        clearGeoButton.click();
        return this;
    }

    @Step
    public SelectRegionPage selectFirstGeoFromSuggestion() {
        listOfSuggestionGeo.first().click();
        return this;
    }

    @Step
    public SelectRegionPage clickApply() {
        applyButton.click();
        return this;
    }

}
