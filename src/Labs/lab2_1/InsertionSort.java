package Labs.lab2_1;

import java.util.List;

public class InsertionSort implements Sorting<Integer> {
    @Override
    public void sort(List<Integer> nums) {
        int n = nums.size();
        for (int i = 1; i < n; i++) {
            Integer key = nums.get(i);
            int j = i - 1;

            while (j >= 0 && nums.get(j) > key) {
                nums.set(j + 1, nums.get(j));
                j = j - 1;
            }
            nums.set(j + 1, key);
        }
    }
}