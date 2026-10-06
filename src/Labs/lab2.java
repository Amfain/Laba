package Labs;

import java.util.ArrayList;
import java.util.List;



public class lab2 {

    public static int removeElementInplace(int[] arr, int val) {
        int k = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != val) {
                arr[k] = arr[i];
                k++;
            }
        }
        return k;
    }

    public static void main(String[] args) {
        int[] arr = {3, 4, 2, 213, 4, 4};
        int u = removeElementInplace(arr, 4);
        System.out.println(u);





    }




}
