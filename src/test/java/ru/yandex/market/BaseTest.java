package ru.yandex.market;
import drivers.Manager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.engine.execution.AfterEachMethodAdapter;
import org.openqa.selenium.WebDriver;


public class BaseTest {

    protected WebDriver chromedriver;



    @BeforeEach
    public void before() {
        Manager.initChrome();
        chromedriver = Manager.getCurrentDriver();
    }

    @AfterEach
    public void closeTest() {
        chromedriver.quit();
    }


}
