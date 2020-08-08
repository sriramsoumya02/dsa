package com.pairing.datastructures;

import com.paring.datastructures.Interval;
import com.paring.datastructures.Sort;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SortTest {
    Sort s = new Sort();

    @Test
    public void bubblesortTest() {
        assertTrue(Arrays.equals(new int[]{1, 3, 4, 7, 9}, Sort.bubble(new int[]{4, 1, 3, 9, 7}, 0, 4)));
    }

    @Test
    public void selctionSortTest() {
        assertTrue(Arrays.equals(new int[]{1, 3, 4, 7, 9}, Sort.selectionSort(new int[]{4, 1, 3, 9, 7})));
    }

    @Test
    public void insertionSortTest() {
        assertTrue(Arrays.equals(new int[]{1, 3, 4, 7, 9}, Sort.insertionSort(new int[]{4, 1, 3, 9, 7})));
    }

    @Test
    public void mergeSortTest() {
        assertTrue(Arrays.equals(new int[]{5, 6, 7, 11, 12, 13}, Sort.mergeSort(new int[]{12, 11, 13, 5, 6, 7}, 0, 5)));
    }

    @Test
    public void mergeIntravels() {
        Interval arr[] = new Interval[4];
        arr[0] = new Interval(6, 8);
        arr[1] = new Interval(1, 9);
        arr[2] = new Interval(2, 4);
        arr[3] = new Interval(4, 7);
        Interval result[] = new Interval[1];
        result[0] = new Interval(1, 9);
        assertTrue(Arrays.equals(result, Sort.mergeIntervals(arr)));
    }

    @Test
    public void countSortTest() {
        assertTrue(Arrays.equals(new int[]{-10, -5, -3, -1, 0, 5, 8, 10}, Sort.countingSort(new int[]{-5, -10, 0, -3, 8, 5, -1, 10})));
    }

    @Test
    public void radixSortTest() {
        assertTrue(Arrays.equals(new int[]{2, 24, 45, 66, 75, 90, 170, 802}, Sort.radixSort(new int[]{170, 45, 75, 90, 802, 24, 2, 66})));
    }

    @Test
    public void printPairs() {
        Interval result[] = new Interval[6];
        result[0] = new Interval(10, 6);
        assertTrue(Arrays.equals(result, Sort.printPairs(new int[]{1, 4, 45, 6, 10, 8}, 16)));
    }

    @Test
    public void isPair() {
        Interval result[] = new Interval[5];
        result[0] = new Interval(3, 11);
        assertTrue(Arrays.equals(result, Sort.printPairInSortedArray(new int[]{2, 3, 7, 8, 11}, 14)));
    }

    @Test
    public void tripletsTest() {
        assertEquals(",4,8,10;", Sort.findTheTriplets(new int[]{1, 4, 45, 6, 10, 8}, 22));
    }

    @Test
    public void majorityElementTest() {
        assertEquals(1, Sort.findMajority(new int[]{1, 1, 2, 1, 3, 5, 1}));
    }

    @Test
    public void medianTest() {
        assertEquals(3, Sort.medianOf2SortedArrays(new int[]{-5, 3, 6, 12, 15}, new int[]{-12, -10, -6, -3, 4, 10}));
    }
}
