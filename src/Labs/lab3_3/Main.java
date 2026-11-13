package Labs.lab3_3;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class Main {

    public static void main(String[] args) {
        // 1. Целые числа.
        check(
                "Integer",
                Arrays.asList(4, -2, 0, 4, 1),
                Arrays.asList(-2, 0, 1, 4, 4)
        );

        // 2. Строки.
        check(
                "String",
                Arrays.asList("pear", "apple", "orange", "banana"),
                Arrays.asList("apple", "banana", "orange", "pear")
        );

        // 3. Дата и время.
        LocalDateTime early =
                LocalDateTime.of(2024, 12, 31, 23, 59);

        LocalDateTime middle =
                LocalDateTime.of(2025, 1, 1, 9, 0);

        LocalDateTime late =
                LocalDateTime.of(2025, 1, 1, 12, 0);

        check(
                "LocalDateTime",
                Arrays.asList(late, early, middle),
                Arrays.asList(early, middle, late)
        );

        // 4. Студенты: сортируем по среднему баллу.
        Student anna = new Student("Анна", 4.5);
        Student boris = new Student("Борис", 3.2);
        Student vera = new Student("Вера", 4.5);
        Student gleb = new Student("Глеб", 5.0);

        // Анна и Вера имеют одинаковый балл.
        // После сортировки Анна должна остаться перед Верой.
        check(
                "Student",
                Arrays.asList(anna, gleb, boris, vera),
                Arrays.asList(boris, anna, vera, gleb)
        );

        // 5. UUID: используем заранее заданные значения.
        UUID first = UUID.fromString(
                "00000000-0000-0000-0000-000000000001"
        );

        UUID second = UUID.fromString(
                "00000000-0000-0000-0000-000000000002"
        );

        UUID third = UUID.fromString(
                "00000000-0000-0000-0000-000000000003"
        );

        check(
                "UUID",
                Arrays.asList(third, first, second),
                Arrays.asList(first, second, third)
        );

        // Дополнительные проверки.
        check(
                "Пустой список",
                new ArrayList<Integer>(),
                new ArrayList<Integer>()
        );

        check(
                "Один элемент",
                Arrays.asList(7),
                Arrays.asList(7)
        );

        check(
                "Уже отсортированный список",
                Arrays.asList(1, 2, 3, 4),
                Arrays.asList(1, 2, 3, 4)
        );

        check(
                "Обратный порядок",
                Arrays.asList(4, 3, 2, 1),
                Arrays.asList(1, 2, 3, 4)
        );

        check(
                "Одинаковые элементы",
                Arrays.asList(5, 5, 5),
                Arrays.asList(5, 5, 5)
        );

        check(
                "Два элемента",
                Arrays.asList(2, 1),
                Arrays.asList(1, 2)
        );

        System.out.println("Все проверки пройдены.");
    }

    // Создаёт изменяемый список, сортирует его
    // и сравнивает результат с ожидаемым.
    private static <T extends Comparable<? super T>> void check(
            String testName,
            List<T> input,
            List<T> expected
    ) {
        List<T> actual = new ArrayList<>(input);

        Sorting<T> sorting = new InsertionSorting<T>();
        sorting.sort(actual);

        if (!actual.equals(expected)) {
            throw new AssertionError(
                    testName
                            + ": ожидалось " + expected
                            + ", получено " + actual
            );
        }

        System.out.println(testName + ": " + actual + " — OK");
    }
}