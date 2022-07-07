package drivers;

import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Класс явных ожиданий
 */
public class Waits {

    /**
     * Явное ожидание
     */
    public static WebDriverWait wait = new WebDriverWait(Manager.getCurrentDriver(), 15);

}
