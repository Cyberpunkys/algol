package ru.vstu.algol.chapter2;

import java.util.ArrayList;
import java.util.List;

public class SelectionSort {

    /**
     *
     * @param arr list to sort
     * @return sorted copy of the list arr
     */
    public List<Integer> selectionSortAsc(List<Integer> arr) {
        arr = new ArrayList<>(arr);
        List<Integer> result = new ArrayList<>(arr.size());
        int len = arr.size();

        for (int i = 0; i < len; i++) {
            int minIdx = findSmallestIndex(arr);
            result.add(arr.remove(minIdx));
        }
        return result;
    }

    /**
     * primitive mutable array sort
     * @param arr an array to sort
     */
    public void selectionSortAsc(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIdx = i;
            int minEl = arr[i];
            for (int j = i+1; j < arr.length; j++) {
                if (arr[j] < minEl) {
                    minEl = arr[j];
                    minIdx = j;
                }
            }
            int tmp = arr[i];
            arr[i] = arr[minIdx];
            arr[minIdx] = tmp;
        }
    }

    /**
     * @return index of the min element
     */
    int findSmallestIndex(List<Integer> arr) {
        int minEl = arr.get(0);
        int minIdx = 0;

        for (int i = 1; i < arr.size(); i++) {
            if (arr.get(i) < minEl) {
                minEl = arr.get(i);
                minIdx = i;
            }
        }
        return minIdx;
    }
}
