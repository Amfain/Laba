package Labs.lab3_3;

import java.util.List;

public class InsertionSorting<T extends Comparable<? super T>>
        implements Sorting<T> {

    @Override
    public void sort(List<T> items) {
        for (int i = 1; i < items.size(); i++) {
            T current = items.get(i);
            int j = i - 1;

            while (j >= 0 && items.get(j).compareTo(current) > 0) {
                items.set(j + 1, items.get(j));
                j--;
            }

            items.set(j + 1, current);
        }
    }
}
