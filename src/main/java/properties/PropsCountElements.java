package properties;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "system:env",
        "file:count.elements.properties"
})

/**
 * Интерфейс проперти количества элемеентов
 */
public interface PropsCountElements extends Config{

    /**
     * Получаем количество элементов
     * @return countElements()
     */
    @Key("count.elements")
    int countElements();

}
