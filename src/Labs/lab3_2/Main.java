package Labs.lab3_2;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int n = scanner.nextInt();


        List<BigInteger> nums = new ArrayList<>(n);


        for (int i = 0; i < n; i++) {
            nums.add(scanner.nextBigInteger());
        }


        RadixSort sorter = new RadixSort();
        sorter.sort(nums);


        for (BigInteger number : nums) {
            System.out.println(number);
        }

        scanner.close();
    }
}
