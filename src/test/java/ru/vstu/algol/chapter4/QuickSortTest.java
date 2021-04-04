package ru.vstu.algol.chapter4;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class QuickSortTest {

    int[] array;

    @BeforeEach
    void setUp() {
        array = new int[10];
        Random rnd = ThreadLocalRandom.current();
        Arrays.setAll(array, e -> rnd.nextInt(100));
    }

    @Test
    void quickSort() {
        int[] expect = array.clone();
        log.info(Arrays.toString(array));
        Arrays.sort(expect); // JDK impl
        QuickSort.quickSort(array, 0, array.length - 1);
        log.info(Arrays.toString(array));
        assertArrayEquals(expect, array);
    }
}
