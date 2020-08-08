package com.pairing;

import com.paring.Febonacci;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FebonacciTest {
    Febonacci febonacci = new Febonacci();

    @Test
    public void splitIntoFibonacci() {
        List<Integer> expected = new ArrayList<>();
        expected.add(123);
        expected.add(456);
        expected.add(579);
        List<Integer> expected1 = new ArrayList<>();
        expected1.add(1);
        expected1.add(1);
        expected1.add(2);
        expected1.add(3);
        expected1.add(5);
        expected1.add(8);
        expected1.add(13);
        List<Integer> expected2 = new ArrayList<>();
        List<Integer> expected3 = new ArrayList<>();
        List<Integer> expected4 = new ArrayList<>();
        expected4.add(110);
        expected4.add(1);
        expected4.add(111);
        assertTrue(expected.equals(febonacci.splitIntoFibonacci("123456579")));
        assertTrue(expected1.equals(febonacci.splitIntoFibonacci("11235813")));
        assertTrue(expected2.equals(febonacci.splitIntoFibonacci("112358130")));
        assertTrue(expected3.equals(febonacci.splitIntoFibonacci("0123")));
        assertTrue(expected4.equals(febonacci.splitIntoFibonacci("1101111")));
    }

    @Test
    public void nBonnacciNumbersTest() {
        febonacci.nBonacciNumbers(3);
    }

    @Test
    public void kSumNbonacciTest() {
        List<Integer> expected = new ArrayList<>();
        expected.add(16);
        expected.add(4);
        expected.add(1);
        assertTrue(expected.equals(febonacci.kSumNbonacci(21, 5)));
    }

    @Test
    public void fibTest() {
        assertEquals(3, febonacci.fib(4));
        assertEquals(2, febonacci.fib(3));
        assertEquals(1, febonacci.fib(2));
        assertEquals(13, febonacci.fib(7));
    }

    @Test
    public void lenLongestFibSubseqTest() {
        assertEquals(5, febonacci.lenLongestFibSubseq(new int[]{1, 2, 3, 4, 5, 6, 7, 8}));
        assertEquals(3, febonacci.lenLongestFibSubseq(new int[]{1, 3, 7, 11, 12, 14, 18}));
        assertEquals(0, febonacci.lenLongestFibSubseq(new int[]{1, 3, 5}));

    }

    @Test
    public void printAllPermutations() {
        febonacci.heapPermutation(new int[]{1, 2, 3}, 3, 3);
    }
}
