package helpers;

import drivers.Manager;
import org.openqa.selenium.By;

import java.util.function.Consumer;

/**
 * Класс действий над элементами
 */
public class Actions {

    /**
     * Поле действия
     */
    public static org.openqa.selenium.interactions.Actions action;

    /**
     * Наведение курсора на веб элемент
     */
    public static Consumer<By> hover = (By by) -> {
        action.moveToElement(Manager.getCurrentDriver().findElement(by))
                .perform();
    };
}
