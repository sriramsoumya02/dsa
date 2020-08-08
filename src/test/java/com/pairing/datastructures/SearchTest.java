package com.pairing.datastructures;


import com.paring.datastructures.Search;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SearchTest {
    @Test
    public void searchSortedArrayTest() {
        assertEquals(2, Search.searchSortedArray(new int[]{1, 2, 3, 4}, 4, 3));
        assertEquals(4, Search.searchSortedArray(new int[]{1, 2, 3, 4, 5}, 5, 5));
        assertEquals(8, Search.searchSortedArray(new int[]{16, 82, 58, 24, 37, 62, 24, 0, 36}, 9, 36));
    }

    @Test
    public void countOnesTest() {
        assertEquals(5, Search.countOnes(new int[]{1, 1, 1, 1, 1, 0, 0, 0}, 8));
        assertEquals(2, Search.countOnes(new int[]{1, 1, 0, 0, 0, 0, 0, 0}, 8));
    }

    @Test
    public void floorSqrt() {
        assertEquals(3, Search.floorSqrt(10));
        assertEquals(2, Search.floorSqrt(4));
        assertEquals(0, Search.floorSqrt(0));
        assertEquals(1, Search.floorSqrt(1));
        assertEquals(3, Search.floorSqrt(10));
        assertEquals(12345, Search.floorSqrt(152399025));
        assertEquals(12345, Search.floorSqrt(152399027));
    }

    @Test
    public void majorityElement() {
        assertEquals(3, Search.majorityElement(new int[]{3, 1, 3, 3, 2}, 5));
        assertEquals(-1, Search.majorityElement(new int[]{1, 2, 3}, 3));
        assertEquals(5, Search.majorityElement(new int[]{5}, 1));
        assertEquals(0, Search.majorityElement(new int[]{0, 0, 0, 0, 0}, 5));
        assertEquals(-1, Search.majorityElement(new int[]{3, 1, 4, 6, 7}, 5));
    }

    @Test
    public void leftIndexTest() {
        assertEquals(0, Search.leftIndex(10, new int[]{1, 1, 2, 2, 3, 4, 5, 5, 6, 7}, 1));
        assertEquals(-1, Search.leftIndex(10, new int[]{1, 1, 2, 2, 3, 4, 5, 5, 6, 7}, 8));
        assertEquals(2, Search.leftIndex(10, new int[]{1, 1, 2, 2, 3, 4, 5, 5, 6, 7}, 2));
        assertEquals(9, Search.leftIndex(10, new int[]{1, 1, 2, 2, 3, 4, 5, 5, 6, 7}, 7));

    }

    @Test
    public void peakElementTest() {
        assertEquals(1, Search.peakElement(new int[]{1, 3, 20, 4, 1, 0}, 6));
        assertEquals(1, Search.peakElement(new int[]{1, 2, 3}, 3));
    }

    @Test
    public void findFloorTest() {
        assertEquals(1, Search.findFloor(new long[]{1, 2, 8, 10, 11, 12, 19}, 0, 7, 5));
        assertEquals(78, Search.findFloor(new long[]{35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113
        }, 0, 79, 159));
        assertEquals(2, Search.findFloor(new long[]{26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107}, 0, 82, 28));
    }

    @Test
    public void minNumberTest() {
        assertEquals(1, Search.minNumber(new int[]{2, 3, 4, 5, 6, 7, 8, 9, 10, 1}, 0, 9));
        assertEquals(1, Search.minNumber(new int[]{3, 4, 5, 1, 2}, 0, 4));
        assertEquals(2, Search.minNumber(new int[]{8, 10, 2, 4, 6}, 0, 4));
    }

    @Test
    public void twoRepeatedTest() {
        Search.twoRepeated(new int[]{1, 2, 1, 3, 4, 3}, 4);
        Search.twoRepeated(new int[]{1, 2, 2, 1}, 2);
        Search.twoRepeated1(new int[]{1, 2, 1, 3, 4, 3}, 4);
        Search.twoRepeated1(new int[]{1, 2, 2, 1}, 2);
    }

    @Test
    public void maxStep() {
        assertEquals(1, Search.maxStep(new int[]{1, 2, 2, 3, 2}, 5));
        assertEquals(3, Search.maxStep(new int[]{1, 2, 3, 4}, 4));
        assertEquals(1, Search.maxStep(new int[]{6, 9, 2, 7, 5, 4, 1, 9}, 8));
    }

    @Test
    public void maxWaterTest() {
        assertEquals(8, Search.maxWater(new int[]{2, 1, 3, 4, 6, 5}, 6));
        assertEquals(0, Search.maxWater(new int[]{2, 1}, 2));
    }

    @Test
    public void missingNumberTest() {
        assertEquals(6, Search.missingNumber(new int[]{1, 2, 3, 4, 5}, 5));
        assertEquals(2, Search.missingNumber(new int[]{0, -10, 1, 3, -20}, 5));
        assertEquals(1, Search.missingNumber(new int[]{0}, 1));
        assertEquals(1, Search.missingNumber(new int[]{28, 7, -36, 21, -21, -50, 9, -32}, 8));
    }
}
