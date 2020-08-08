package com.pairing.dynamicProgramming;

import com.paring.dynamicProgramming.DPProblems;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DPProblemsTest {
    DPProblems dp = new DPProblems();

    @Test
    public void longestPalindromeTest() {
        //  assertEquals("bab", dp.longestPalindrome("babad"));
        assertEquals("bb", dp.longestPalindrome("cbbd"));
        assertEquals("a", dp.longestPalindrome("a"));
        assertEquals("", dp.longestPalindrome(""));
        assertEquals("dcbcd", dp.longestPalindrome("abcdbaddcbcdbabb"));
        assertEquals("ccc", dp.longestPalindrome("ccc"));
    }
}
