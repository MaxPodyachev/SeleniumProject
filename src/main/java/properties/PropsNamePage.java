package properties;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "system:env",
        "file:name.page.properties"
})

/**
 * Интерфейс проперти имени страницы
 */
public interface PropsNamePage extends Config {

    /**
     * Получаем имя страницы
     * @return namePage()
     */
    @Key("name.page")
    String namePage();
}
