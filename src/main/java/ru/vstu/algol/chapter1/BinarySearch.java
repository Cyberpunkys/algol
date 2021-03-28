package ru.vstu.algol.chapter1;

import ru.vstu.algol.exception.ElementNotFoundException;

public class BinarySearch {

    /**
     *
     * @param arr a sorted array
     * @param target a number to find
     * @return a position of the target
     * @throws ElementNotFoundException - if not found
     */
    public static int binarySearch(int[] arr, int target) throws ElementNotFoundException {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int guess = arr[mid];

            if (guess == target) {
                return mid;
            } else if (guess > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        throw new ElementNotFoundException("Not found");
    }
}
