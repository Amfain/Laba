package Labs.lab2_3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (!scanner.hasNextInt()) {
            return;
        }
        int n = scanner.nextInt();

        List<Student> students = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            String name = scanner.next();
            int age = scanner.nextInt();
            students.add(new Student(name, age));
        }

        Sorting<Student> sorter = new StudentSort();
        sorter.sort(students);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            Student s = students.get(i);
            sb.append(s.getName()).append(" ").append(s.getAge()).append("\n");
        }
        System.out.print(sb.toString());
        scanner.close();
    }
}
