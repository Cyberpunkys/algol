package ru.vstu.algol;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.vstu.algol.chapter1.BinarySearch;
import ru.vstu.algol.exception.ElementNotFoundException;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class BinarySearchTest {

    private static int[] testArr;

    @BeforeAll
    static void init() {
        testArr = new int[1024];
        Random rnd = ThreadLocalRandom.current();
        for (int i = 0; i < testArr.length; i++) {
            testArr[i] = rnd.nextInt(100_000);
        }
        Arrays.sort(testArr);
    }

    @Test
    public void binarySearchTest() throws Exception {
        assertEquals(9, BinarySearch.binarySearch(testArr, testArr[9]));
        assertEquals(999, BinarySearch.binarySearch(testArr, testArr[999]));
        assertEquals(0, BinarySearch.binarySearch(testArr, testArr[0]));
    }

    @Test
    public void binarySearchNotFoundTest() {
        assertThrows(ElementNotFoundException.class, () -> BinarySearch.binarySearch(testArr, -1));
    }
}
