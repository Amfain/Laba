package Labs.lab3_1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in)
        );

        int n = Integer.parseInt(reader.readLine().trim());

        List<Integer> nums = new ArrayList<>(n);

        while (nums.size() < n) {
            String line = reader.readLine();

            if (line == null) {
                throw new IllegalArgumentException(
                        "Введено меньше чисел, чем указано в N"
                );
            }

            StringTokenizer tokens = new StringTokenizer(line);

            while (tokens.hasMoreTokens() && nums.size() < n) {
                int value = Integer.parseInt(tokens.nextToken());
                nums.add(value);
            }
        }

        Sorting<Integer> sorter = new CountingSort();
        sorter.sort(nums);

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < nums.size(); i++) {
            if (i > 0) {
                result.append(' ');
            }

            result.append(nums.get(i));
        }

        System.out.println(result);
    }
}
