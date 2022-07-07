package properties;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "system:env",
        "file:driver.properties"
})

/**
 * Интерфейс проперти драйвера
 */
public interface PropsDriver extends Config {

    /**
     * Получаем время ожидания
     * @return defaultTimeout()
     */
    @Key("default.timeout")
    int defaultTimeout();

    /**
     * Получаем адресс драйвера
     * @return addressChromeDriver()
     */
    @Key("address.chrome.driver")
    String addressChromeDriver();
}
