package drivers;

import helpers.Actions;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import properties.TestData;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Класс веб драйвера
 */
public class Manager {

    /**
     * Веб драйвер
     */
    private static WebDriver currentDriver;

    /**
     * Геттер на веб драйвер
     * @return currentDriver
     */
    public static WebDriver getCurrentDriver() {return currentDriver;}

    /**
     * Задаем начальные значения драйверу
     */
    public static void initChrome() {
        System.setProperty("webdriver.chrome.driver", System.getenv("CHROME_DRIVER"));
        ChromeOptions options = new ChromeOptions();
        options.addArguments(List.of("start-maximized"));
        try {
            currentDriver = new ChromeDriver(options);
        } catch (SessionNotCreatedException e) {
            Assertions.fail("Данный драйвер не совместим с текущим браузером.");
        }
        setDriverDefaultSetting();
        initStaticObjects();
    }

    /**
     * Устанавливаем настройки драйверу
     */
    private static void setDriverDefaultSetting() {
        currentDriver.manage().timeouts().implicitlyWait(TestData.propsDriver.defaultTimeout(), TimeUnit.SECONDS);
        currentDriver.manage().deleteAllCookies();
    }

    /**
     * Задаем статические объекты
     */
    private static void initStaticObjects() {
        Actions.action = new org.openqa.selenium.interactions.Actions(Manager.getCurrentDriver());
    }
}
