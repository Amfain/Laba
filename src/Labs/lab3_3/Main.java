package Labs.lab3_3;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class Main {

    public static void main(String[] args) {
        // 1. Integer.
        check(
                "Integer",
                Arrays.asList(4, -2, 0, 4, 1),
                Arrays.asList(-2, 0, 1, 4, 4)
        );

        // 2. String.
        check(
                "String",
                Arrays.asList("pear", "apple", "orange", "banana"),
                Arrays.asList("apple", "banana", "orange", "pear")
        );

        // 3. LocalDateTime.
        LocalDateTime firstDate =
                LocalDateTime.of(2024, 12, 31, 23, 59);

        LocalDateTime secondDate =
                LocalDateTime.of(2025, 1, 1, 9, 0);

        LocalDateTime thirdDate =
                LocalDateTime.of(2025, 1, 1, 12, 0);

        check(
                "LocalDateTime",
                Arrays.asList(thirdDate, firstDate, secondDate),
                Arrays.asList(firstDate, secondDate, thirdDate)
        );

        // 4. Student.
        Student anna20 = new Student("Анна", 20);
        Student boris19 = new Student("Борис", 19);
        Student anna18 = new Student("Анна", 18);
        Student anotherAnna20 = new Student("Анна", 20);

        List<Student> students = new ArrayList<>(Arrays.asList(
                anna20, boris19, anna18, anotherAnna20
        ));

        Sorting<Student> studentSorter = new InsertionSort<Student>();
        studentSorter.sort(students);

        List<Student> expectedStudents = Arrays.asList(
                anna18, anna20, anotherAnna20, boris19
        );

        // Проверяем порядок тех же объектов.
        // Две Анны возраста 20 лет должны сохранить взаимный порядок.
        if (!students.equals(expectedStudents)) {
            throw new AssertionError("Ошибка сортировки Student");
        }

        System.out.println("Student — OK:");

        for (Student student : students) {
            System.out.println(
                    student.getName() + " " + student.getAge()
            );
        }

        // 5. UUID.
        UUID firstId = UUID.fromString(
                "00000000-0000-0000-0000-000000000001"
        );

        UUID secondId = UUID.fromString(
                "00000000-0000-0000-0000-000000000002"
        );

        UUID thirdId = UUID.fromString(
                "00000000-0000-0000-0000-000000000003"
        );

        check(
                "UUID",
                Arrays.asList(thirdId, firstId, secondId),
                Arrays.asList(firstId, secondId, thirdId)
        );

        // Граничные случаи.
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

        System.out.println("Все проверки пройдены.");
    }

    private static <T extends Comparable<? super T>> void check(
            String testName,
            List<T> input,
            List<T> expected
    ) {
        List<T> actual = new ArrayList<>(input);

        Sorting<T> sorter = new InsertionSort<T>();
        sorter.sort(actual);

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
