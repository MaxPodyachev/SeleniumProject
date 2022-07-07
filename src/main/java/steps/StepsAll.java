package steps;

import drivers.Manager;
import drivers.Waits;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.*;
import java.util.List;


/**
 * Класс в котором будут описываться все шаги
 */
public class StepsAll {

    /**
     * Переходим на сайт
     * @param url ссылка на сайт
     */
    @Step("Переходим на веб-сайт: {url}")
    public static void openSiteYandex(String url) {
        Manager.getCurrentDriver().get(url);
    }

    /**
     * Переходим на страницу
     * @param namePage значение страницы
     */
    @Step("Переодим на страницу: {namePage}")
    public static void openSiteYandexMarket(String namePage) {
        YandexHomePage yandexHomePage = new YandexHomePage();
        yandexHomePage.open(namePage);
        YandexMarketPageSubCategory yandexMarketPageSubCategory = new YandexMarketPageSubCategory();
        yandexMarketPageSubCategory.goPageByLinkName();
    }

    /**
     * Нводим курсор на категорию
     * @param category значение категори
     */
    @Step("Наводим курсор на раздел: {category}")
    public static void moveCursorOnCategory(String category) {
        YandexMarketCatalog yandexMarketCatalog = new YandexMarketCatalog();
        yandexMarketCatalog.openCatalog();
        yandexMarketCatalog.moveCursor(category);
    }

    /**
     * Выбираем подкатегорию
     * @param subCategory значеие подкатегории
     */
    @Step("Выбираем подраздел: {subCategory}")
    public static void openSectionSubCategory(String subCategory) {
        YandexMarketCatalog yandexMarketCatalog = new YandexMarketCatalog();
        yandexMarketCatalog.categorySelector(subCategory);
    }

    /**
     * Задаем параметр цены
     * @param priceFrom значение цены от
     * @param priceTo значеие цены до
     */
    @Step("Задаем параметр Цены от : {priceFrom} до : {priceTo}")
    public static void choicePrice(String priceFrom, String priceTo) {
        YandexMarketPageSubCategory yandexMarketPageSubCategory = new YandexMarketPageSubCategory();
        yandexMarketPageSubCategory.choicePrice(priceFrom, priceTo);
    }

    /**
     * Выбираем производителя
     * @param brandFirst значение первого производителя
     * @param brandSecond значение второго производителя
     */
    @Step("Выбираем производителя : {brandFirst} и : {brandSecond}")
    public static void choiceBrand(String brandFirst, String brandSecond) {
        YandexMarketPageSubCategory yandexMarketPageSubCategory = new YandexMarketPageSubCategory();
        yandexMarketPageSubCategory.choiceBrand(brandFirst, brandSecond);
    }

    /**
     * Устанавливаем количество показываемых элементов на страницу
     */
    @Step("Устанавливаем количество показываемых элементов на страницу")
    public static void numberOfResultsOnPage() {
        YandexMarketPageSubCategory yandexMarketPageSubCategory = new YandexMarketPageSubCategory();
        yandexMarketPageSubCategory.showMore();
    }

    /**
     * Обновление результатов
     */
    @Step("Дожидаемся обновления результатов")
    public static void updateResults() {
        Waits.wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@data-apiary-widget-id='/content/cms/4/SearchSerp-SearchSerp']//span[contains(@aria-label,'Загрузка...')]")));
    }

    /**
     * Проверяем, что на странице отображается нужное число элементов
     * @param countElement количество элементов
     */
    @Step("Проверяем, что на странице отображается: {countElement} элементов")
    public static void amountOfElementsPage(int countElement) {
        YandexMarketPageSubCategory yandexMarketPageSubCategory = new YandexMarketPageSubCategory();
        Assertions.assertTrue((yandexMarketPageSubCategory.webElementsPage().size()==countElement),
                "На странице отображается не {countElement} элементов");
    }

    /**
     * Запоминаем наименование первого значения в списке
     */
    @Step("Запоминаем наименование первого значения в списке")
    public static void firstValueInTheList() {
        YandexMarketPageSubCategory yandexMarketPageSubCategory = new YandexMarketPageSubCategory();
        YandexMarketPageSubCategory.saveFirstValueInList = yandexMarketPageSubCategory.firstElement();
    }

    /**
     * В поисковую строку вводим запомненное значение
     */
    @Step("В поисковую строку вводим запомненное значение")
    public static void findFirstValueInTheSearch() {
        YandexMarketPageSubCategory yandexMarketPageSubCategory = new YandexMarketPageSubCategory();
        yandexMarketPageSubCategory.insertValueInSearch(YandexMarketPageSubCategory.saveFirstValueInList);
    }

    /**
     * Нажимаем кнопку 'Найти'
     */
    @Step("Нажимаем кнопку 'Найти'")
    public static void findElementsInSearch() {
        YandexMarketPageSubCategory yandexMarketPageSubCategory = new YandexMarketPageSubCategory();
        yandexMarketPageSubCategory.findElementsInSearch();
    }

    /**
     * Проверяем, что в результатах поиска есть товар с наименованием равным сохраненному значению
     */
    @Step("Проверяем, что в результатах поиска есть товар с наименованием равным первому значению")
    public static void firstValueInTheListIsPresentInTheGivenSearch() {
        YandexMarketPageSubCategory yandexMarketPageSubCategory = new YandexMarketPageSubCategory();
        List<String> webElements = yandexMarketPageSubCategory.webElementsPage();
        Assertions.assertTrue(webElements.stream().anyMatch(x->x.equals(YandexMarketPageSubCategory.saveFirstValueInList)),
                "Не найдено в результатах поиска товаров с наименованием равным первому значению");
    }
}