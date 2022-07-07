package pages;

import drivers.Manager;
import drivers.Waits;
import helpers.Actions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Страница подкатегории ЯндексМаркета 
 */
public class YandexMarketPageSubCategory {

    /**
     * Задаем значение драйверу
     */
    private WebDriver driver = Manager.getCurrentDriver();

    /**
     * Поле для сохранения первого значение в списке
     */
    public static String saveFirstValueInList;

    /**
     * Переходим на следующую страницу
     */
    public void goPageByLinkName() {
        Set<String> tabs = driver.getWindowHandles();
        for (String tab: tabs) {
            driver.switchTo().window(tab);
        }
    }

    /**
     * Выбираем диапазон цены
     * @param priceFrom значение цены от
     * @param priceTo значение цены до
     */
    public void choicePrice(String priceFrom, String priceTo) {
        String xpathPriceFromV = "//label[text()='Цена, ₽ от']/following-sibling::div//input";
        String xpathPriceToV = "//label[text()='Цена, ₽ до']/following-sibling::div//input";
        driver.findElement(By.xpath(xpathPriceFromV)).sendKeys(priceFrom);
        driver.findElement(By.xpath(xpathPriceToV)).sendKeys(priceTo);
    }

    /**
     * Выбираем производителя
     * @param brandFirst значение первого производителя
     * @param brandSecond значение второго производителя
     */
    public void choiceBrand(String brandFirst, String brandSecond) {
        String xpathShowAll = "//span[text()='Показать всё']/parent::span";
        String xpathBrandFirst = "//span[text()='"+brandFirst+"']/parent::span/parent::label";
        String xpathBrandSecond = "//span[text()='"+brandSecond+"']/parent::span/parent::label";
        String xpathWait = "//span[contains(@aria-label,'Загрузка...')]";
        driver.findElement(By.xpath(xpathShowAll)).click();
        driver.findElement(By.xpath(xpathBrandFirst)).click();
        driver.findElement(By.xpath(xpathShowAll)).click();
        driver.findElement(By.xpath(xpathBrandSecond)).click();
        Waits.wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(xpathWait)));
    }

    /**
     * Нажимаем кнопку 'Показать еще'
     */
    public void showMore() {
        String xpathWait = "//span[contains(@aria-label,'Загрузка...')]";
        String xpathShowMore = "//div[@data-apiary-widget-name='@marketfront/SearchPager']//span[text()='Показать ещё']/parent::button";
        driver.findElement(By.xpath(xpathShowMore)).click();
        Waits.wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(xpathWait)));
    }

    /**
     * Находим список всех товаров на странице
     * @return resultsName
     */
    public List<String> webElementsPage() {
        String xpathTotalViewed = "//div[contains(text(),'Вы посмотрели')]";
        String xpathNamesOfAllItemsInStock = "//div[@data-apiary-widget-id='/content/cms/4/SearchSerp-SearchSerp']//h3[@data-zone-name='title']";
        Actions.hover.accept(By.xpath(xpathTotalViewed));
        List<WebElement> results = driver.findElements(By.xpath(xpathNamesOfAllItemsInStock));
        List<String> resultsName = new ArrayList<>();
        results.forEach(x->resultsName.add(x.getText()));
        return resultsName;
    }

    /**
     * Находим первый товар из полученного списка товаров
     * @return firstElement
     */
    public String firstElement() {
        return webElementsPage().get(0);
    }

    /**
     * Вставляем значение первого товара в поиск
     * @param firstElementOnPage значение первого товара
     */
    public void insertValueInSearch(String firstElementOnPage) {
        String idSearch = "header-search";
        driver.findElement(By.id(idSearch)).sendKeys(firstElementOnPage);

    }

    /**
     * Нажимаем кнопку 'Найти'
     */
    public void findElementsInSearch() {
        String xpathNamesOfAllItemsInStock = "//div[@data-apiary-widget-id='/content/cms/4/SearchSerp-SearchSerp']//h3[@data-zone-name='title']";
        String xpathButtonSearch = "//span[text()='Найти']/..";
        driver.findElement(By.xpath(xpathButtonSearch)).click();
        Waits.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathNamesOfAllItemsInStock)));
    }
}
