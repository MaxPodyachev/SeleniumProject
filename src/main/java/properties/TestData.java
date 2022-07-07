package properties;

import org.aeonbits.owner.ConfigFactory;

/**
 * Класс проперти полей
 */
public class TestData {

    /**
     * проперти сайта
     */
    public static PropsUrl propsUrl = ConfigFactory.create(PropsUrl.class);

    /**
     * проперти драйвера
     */
    public static PropsDriver propsDriver = ConfigFactory.create(PropsDriver.class);

    /**
     * проперти имени страницы
     */
    public static PropsNamePage propsNamePage = ConfigFactory.create(PropsNamePage.class);

    /**
     * проперти количества элементов
     */
    public static PropsCountElements propsCountElements = ConfigFactory.create(PropsCountElements.class);
}
