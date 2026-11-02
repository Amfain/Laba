package Labs.lab2_3;

import java.util.ArrayList;
import java.util.List;

public class StudentSort implements Sorting<Student> {

    // 1. НЕСТАБИЛЬНАЯ сортировка (QuickSort) — сортируем по возрасту
    private void quickSortByAge(List<Student> students, int low, int high) {
        if (low >= high) {
            return;
        }
        int i = low;
        int j = high;
        int pivotAge = students.get(low + (high - low) / 2).getAge();

        while (i <= j) {
            while (students.get(i).getAge() < pivotAge) {
                i++;
            }
            while (students.get(j).getAge() > pivotAge) {
                j--;
            }
            if (i <= j) {
                Student temp = students.get(i);
                students.set(i, students.get(j));
                students.set(j, temp);
                i++;
                j--;
            }
        }

        if (low < j) {
            quickSortByAge(students, low, j);
        }
        if (i < high) {
            quickSortByAge(students, i, high);
        }
    }

    // 2. СТАБИЛЬНАЯ сортировка (MergeSort) — сортируем по имени
    private void mergeSortByName(List<Student> students, int start, int end) {
        if (start >= end) {
            return;
        }
        int middle = start + (end - start) / 2;
        mergeSortByName(students, start, middle);
        mergeSortByName(students, middle + 1, end);
        mergeByName(students, start, middle, end);
    }

    private void mergeByName(List<Student> students, int start, int middle, int end) {
        List<Student> left = new ArrayList<>(middle - start + 1);
        List<Student> right = new ArrayList<>(end - middle);

        for (int i = start; i <= middle; i++) {
            left.add(students.get(i));
        }
        for (int j = middle + 1; j <= end; j++) {
            right.add(students.get(j));
        }

        int i = 0;
        int j = 0;
        int k = start;

        while (i < left.size() && j < right.size()) {
            // compareTo возвращает число <= 0, если левое имя меньше или равно правому по алфавиту
            if (left.get(i).getName().compareTo(right.get(j).getName()) <= 0) {
                students.set(k, left.get(i));
                i++;
            } else {
                students.set(k, right.get(j));
                j++;
            }
            k++;
        }

        while (i < left.size()) {
            students.set(k, left.get(i));
            i++;
            k++;
        }

        while (j < right.size()) {
            students.set(k, right.get(j));
            j++;
            k++;
        }
    }

    @Override
    public void sort(List<Student> students) {
        if (students == null || students.size() <= 1) {
            return;
        }
        // Шаг 1: Сортируем по возрасту (нестабильной сортировкой QuickSort)
        quickSortByAge(students, 0, students.size() - 1);

        // Шаг 2: Сортируем по имени (стабильной сортировкой MergeSort), сохраняя порядок возрастов
        mergeSortByName(students, 0, students.size() - 1);
    }
}
