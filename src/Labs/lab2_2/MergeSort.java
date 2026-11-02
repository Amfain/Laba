package Labs.lab2_2;

import java.util.ArrayList;
import java.util.List;

public class MergeSort implements Sorting<Integer> {

    private void slice(List<Integer> nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int middle = start + (end - start) / 2;
        slice(nums, start, middle);
        slice(nums, middle + 1, end);
        merge(nums, start, middle, end);
    }

    private void merge(List<Integer> nums, int start, int middle, int end) {
        List<Integer> left = new ArrayList<>(middle - start + 1);
        List<Integer> right = new ArrayList<>(end - middle);

        for (int i = start; i <= middle; i++) {
            left.add(nums.get(i));
        }
        for (int j = middle + 1; j <= end; j++) {
            right.add(nums.get(j));
        }

        int i = 0;
        int j = 0;
        int k = start;

        while (i < left.size() && j < right.size()) {
            if (left.get(i) <= right.get(j)) {
                nums.set(k, left.get(i));
                i++;
            } else {
                nums.set(k, right.get(j));
                j++;
            }
            k++;
        }

        while (i < left.size()) {
            nums.set(k, left.get(i));
            i++;
            k++;
        }

        while (j < right.size()) {
            nums.set(k, right.get(j));
            j++;
            k++;
        }
    }

    @Override
    public void sort(List<Integer> nums) {
        if (nums == null || nums.size() <= 1) {
            return;
        }
        slice(nums, 0, nums.size() - 1);
    }
}
