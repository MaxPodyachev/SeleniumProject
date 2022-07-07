package pages;

import drivers.Manager;
import helpers.Actions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Страница каталога ЯндексМаркета
 */
public class YandexMarketCatalog {

    /**
     * Задаем значение драйверу
     */
    protected WebDriver driver = Manager.getCurrentDriver();

    /**
     * Открываем католог
     */
    public void openCatalog() {
        driver.findElement(By.id("catalogPopupButton")).click();
    }

    /**
     * Выбираем подкатегорию
     * @param subCategory значение подкатегории
     */
    public void categorySelector(String subCategory) {
        String xpathSubCategory = "//a[text()='" + subCategory + "']";
        driver.findElement(By.xpath(xpathSubCategory)).click();
    }

    /**
     * Наводим курсор на категорию
     * @param category значение категории
     */
    public void moveCursor(String category) {
        String xpathCategory = "//span[text()='"+category+"']/parent::a/parent::li";
        Actions.hover.accept(By.xpath(xpathCategory));
    }
}
