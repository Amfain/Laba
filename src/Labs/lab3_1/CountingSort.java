package Labs.lab3_1;

import java.util.List;

import java.util.List;

public class CountingSort implements Sorting<Integer> {
    @Override
    public void sort(List<Integer> nums) {
        int[] count = new int[128];


        for (int value : nums) {
            count[value]++;
        }


        int position = 0;
        for (int value = 0; value < count.length; value++)
        {
            for (int repeat = 0; repeat < count[value]; repeat++) {
                nums.set(position, value);
                position++;
            }
        }
    }
}
