package ru.vstu.algol.chapter2;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class SelectionSortTest {

    SelectionSort sort;
    static Integer[] randomArray;

    @BeforeAll
    static void beforeAll() {
        randomArray = new Integer[100];
        Random rnd = ThreadLocalRandom.current();
        Arrays.setAll(randomArray, value -> rnd.nextInt(1000));
    }

    @BeforeEach
    void setUp() {
        sort = new SelectionSort();
    }

    @Test
    void findSmallestIndex() {
        List<Integer> list = new ArrayList<>(List.of(3, 2, 5, 4, 1));
        int smallestIndex = sort.findSmallestIndex(list);
        assertEquals(4, smallestIndex);
    }

    @Test
    void selectionSortAsc() {
        List<Integer> list = new ArrayList<>(List.of(randomArray));
        List<Integer> res = sort.selectionSortAsc(list);
        Arrays.sort(randomArray);
        assertEquals(List.of(randomArray), sort.selectionSortAsc(res));
    }

    @Test
    void testSelectionSortAsc() {
        int[] arr = new int[100];
        Random rnd = ThreadLocalRandom.current();
        Arrays.setAll(arr, el -> rnd.nextInt(1000));
        int[] copy = arr.clone();
        Arrays.sort(copy);
        sort.selectionSortAsc(arr);
        assertArrayEquals(copy, arr);
    }
}
