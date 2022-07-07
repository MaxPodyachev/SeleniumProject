package properties;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "system:env",
        "file:url.properties"
})

/**
 * Интерфейс проперти сайта
 */
public interface PropsUrl extends Config {

    /**
     * Получаем ссылку на сайт
     * @return baseURLYandex()
     */
    @Key("base.url.yandex")
    String baseURLYandex();
}
