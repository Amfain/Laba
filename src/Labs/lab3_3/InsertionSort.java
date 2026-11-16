package Labs.lab3_3;

import java.util.List;

public class InsertionSort<T extends Comparable<? super T>>
        implements Sorting<T> {

    @Override
    public void sort(List<T> nums) {
        int n = nums.size();

        for (int i = 1; i < n; i++) {
            T key = nums.get(i);
            int j = i - 1;

            while (j >= 0 && nums.get(j).compareTo(key) > 0) {
                nums.set(j + 1, nums.get(j));
                j = j - 1;
            }

            nums.set(j + 1, key);
        }
    }
}
