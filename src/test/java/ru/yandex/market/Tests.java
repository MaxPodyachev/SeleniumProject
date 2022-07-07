package ru.yandex.market;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import properties.TestData;
import static steps.StepsAll.*;

public class Tests extends BaseTest{

    @DisplayName("Тестирование сайта: ЯндекМаркет")
    @ParameterizedTest(name = "{displayName}: {arguments}")
    @MethodSource("helpers.DataProvider#argumentsStream")
    public void testYandexMarketSelenium(String category, String subCategory, String priceFrom, String priceTo, String brandFirst, String brandSecond) {
        openSiteYandex(TestData.propsUrl.baseURLYandex());
        openSiteYandexMarket(TestData.propsNamePage.namePage());
        moveCursorOnCategory(category);
        openSectionSubCategory(subCategory);
        choicePrice(priceFrom, priceTo);
        choiceBrand(brandFirst, brandSecond);
        updateResults();
        numberOfResultsOnPage();
        updateResults();
        amountOfElementsPage(TestData.propsCountElements.countElements());
        firstValueInTheList();
        findFirstValueInTheSearch();
        findElementsInSearch();
        firstValueInTheListIsPresentInTheGivenSearch();
    }
}



