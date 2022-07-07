package pages;

import drivers.Manager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Домашняя страница Яндекса
 */
public class YandexHomePage {
    /**
     * Задаем значение драйверу
     */
    protected WebDriver driver = Manager.getCurrentDriver();

    /**
     * Открываем страницу
     * @param namePage значение страницы
     */
    public void open(String namePage) {
        String xpathButtonYandexMarket = "//a[contains(@href,'"+ namePage +"')]/self::a[@data-id='market']";
        driver.findElement(By.xpath(xpathButtonYandexMarket)).click();
    }
}
