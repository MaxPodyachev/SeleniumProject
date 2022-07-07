package helpers;

import org.junit.jupiter.params.provider.Arguments;
import java.util.stream.Stream;

/**
 * Класс подачи данных в тест
 */
public class DataProvider {

    /**
     * Передаем аргументы
     * @return Stream.of(Arguments.of())
     */
    public static Stream<Arguments> argumentsStream() {
        return Stream.of(
                Arguments.of("Компьютеры", "Ноутбуки", "10000", "900000", "HP", "Lenovo")
        );
    }
}
