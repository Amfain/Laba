package Labs.lab2_1;

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

        List<Integer> nums = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            nums.add(scanner.nextInt());
        }

        Sorting<Integer> sorter = new InsertionSort();
        sorter.sort(nums);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(nums.get(i));
            if (i < n - 1) {
                sb.append(" ");
            }
        }
        System.out.println(sb.toString());
        scanner.close();
    }
}
