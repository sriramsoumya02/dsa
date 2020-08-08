package com.pairing.practise;

import com.paring.datastructures.SinglyLinkedList;
import com.paring.practise.SingleNumber;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SingleNumberTest {
    SingleNumber s = new SingleNumber();

    @Test
    public void getSingleNumberTest() {
        //16====17, 12, 5, -6, 12, 4, 17, -5, 2, -3, 2, 4, 5, 16, -3, -4, 15, 15, -4, -5, -6
        //4====4,1,2,1,2

        assertEquals(4, s.getSingleNumber(new int[]{4, 1, 2, 1, 2}));
    }

    @Test
    public void isHappyNumberTest() {
        //19 true
        //2 false
        // assertTrue(s.isHappyNumber(19));
        assertFalse(s.isHappyNumber(36));
    }

    @Test
    public void maxSubArrayTest() {
        assertEquals(7, s.maxSubArray(new int[]{-2, -3, 4, -1, -2, 1, 5, -3}));
        assertEquals(6, s.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        assertEquals(1, s.maxSubArray(new int[]{1}));
        assertEquals(-1, s.maxSubArray(new int[]{-1}));
        assertEquals(1, s.maxSubArray(new int[]{1, -1, 1}));
        assertEquals(4, s.maxSubArray(new int[]{3, -2, -3, -3, 1, 3, 0}));
        assertEquals(7, s.maxSubArray1(new int[]{-2, -3, 4, -1, -2, 1, 5, -3}));
        assertEquals(6, s.maxSubArray1(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        assertEquals(1, s.maxSubArray1(new int[]{1}));
        assertEquals(-1, s.maxSubArray1(new int[]{-1}));
        assertEquals(1, s.maxSubArray1(new int[]{1, -1, 1}));
        assertEquals(4, s.maxSubArray1(new int[]{3, -2, -3, -3, 1, 3, 0}));
    }

    @Test
    public void moveZeroesTest() {
        s.moveZeroes(new int[]{0, 1, 0, 3, 12});
        assertTrue(Arrays.equals(new int[]{1, 3, 12, 0, 0}, s.moveZeroes(new int[]{0, 1, 0, 3, 12})));
    }

    @Test
    public void maxProfitTest() {
        assertEquals(7, s.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        assertEquals(4, s.maxProfit(new int[]{1, 2, 3, 4, 5}));
        assertEquals(0, s.maxProfit(new int[]{7, 6, 4, 3, 1}));
    }

    @Test
    public void groupAnagramsTest() {
        List<List<String>> expected = new ArrayList<>(Arrays.asList(List.of("eat", "tea", "ate"),
                List.of("bat"),
                List.of("tan", "nat")
        ));
        assertTrue(expected.equals(s.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"})));
    }

    @Test
    public void countElementsTest() {
        assertEquals(2, s.countElements(new int[]{1, 2, 3}));
        assertEquals(0, s.countElements(new int[]{1, 1, 3, 3, 5, 5, 7, 7}));
        assertEquals(3, s.countElements(new int[]{1, 3, 2, 3, 5, 0}));
        assertEquals(2, s.countElements(new int[]{1, 1, 2, 2}));
        assertEquals(2, s.countElements(new int[]{1, 1, 2}));
    }

    @Test
    public void middleNodeTest() {
        SinglyLinkedList l = new SinglyLinkedList();
        for (int i = 1; i < 7; i++)
            l.append(i);
        SinglyLinkedList l1 = new SinglyLinkedList();
        for (int i = 1; i < 6; i++)
            l1.append(i);

        assertEquals(4, s.middleNode(l.getHead()).data);
        assertEquals(3, s.middleNode(l1.getHead()).data);
    }

    @Test
    public void backspaceCompare() {
        assertEquals(true, s.backspaceCompare("ab#c", "ad#c"));
        assertEquals(true, s.backspaceCompare("ab##", "c#d#"));
        assertEquals(true, s.backspaceCompare("a##c", "#a#c"));
        assertEquals(false, s.backspaceCompare("a#c", "b"));
    }

    @Test
    public void lastStoneWeightTest() {
        assertEquals(1, s.lastStoneWeight(new int[]{2, 7, 4, 1, 8, 1}));
        assertEquals(0, s.lastStoneWeight(new int[]{1, 4, 5, 3, 6, 7}));
        assertEquals(0, s.lastStoneWeight(new int[]{1}));
        assertEquals(2, s.lastStoneWeight(new int[]{3, 7, 8}));
        assertEquals(0, s.lastStoneWeight(new int[]{316, 157, 73, 106, 771, 828, 46, 212, 926, 604, 600, 992, 71, 51, 477, 869, 425, 405, 859, 924, 45, 187, 283, 590, 303, 66, 508, 982, 464, 398}));
    }

    @Test
    public void stringShiftTest() {
        assertEquals("cab", s.stringShift("abc", new int[][]{{0, 1}, {1, 2}}));
        assertEquals("efgabcd", s.stringShift("abcdefg", new int[][]{{1, 1}, {1, 1}, {0, 2}, {1, 3}}));
    }

    @Test
    public void productExceptSelf() {
        assertTrue(Arrays.equals(new int[]{24, 12, 8, 6}, s.productExceptSelf(new int[]{1, 2, 3, 4})));
        assertTrue(Arrays.equals(new int[]{180, 600, 360, 300, 900}, s.productExceptSelf(new int[]{10, 3, 5, 6, 2})));
        assertTrue(Arrays.equals(new int[]{120, 60, 40, 30, 24}, s.productExceptSelf(new int[]{1, 2, 3, 4, 5})));
    }

    @Test
    public void checkValidString() {
        assertEquals(true, s.checkValidString("()"));
        assertEquals(true, s.checkValidString("(*)"));
        assertEquals(true, s.checkValidString("*(*))"));
        assertEquals(false, s.checkValidString("*(()*)("));
        assertEquals(true, s.checkValidString("(*))*)"));
        assertEquals(false, s.checkValidString("*()(())*()(()()((()(()()*)(*(())((((((((()*)(()(*)"));
    }

    @Test
    public void numIslandsTest() {
        assertEquals(1, s.numIslands(new char[][]{{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}}));
        assertEquals(3, s.numIslands(new char[][]{{'1', '1', '0', '0', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '1', '0', '0'}, {'0', '0', '0', '1', '1'}}));
        assertEquals(0, s.numIslands(new char[][]{{}}));
    }

    @Test
    public void minPathSumTest() {
        assertEquals(7, s.minPathSum(new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}}));
        assertEquals(3, s.minPathSum(new int[][]{{1, 2}, {1, 1}}));
        assertEquals(1, s.minPathSum(new int[][]{{1}}));
        assertEquals(0, s.minPathSum(new int[][]{{}}));
        assertEquals(6, s.minPathSum(new int[][]{{1, 1, 1, 2, 6}, {1, 1, 0, 1, 2}}));
        assertEquals(6, s.minPathSum(new int[][]{{1, 0, 1, 2, 2}}));
        assertEquals(7, s.minPathSum1(new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}}));
        assertEquals(3, s.minPathSum1(new int[][]{{1, 2}, {1, 1}}));
        assertEquals(1, s.minPathSum1(new int[][]{{1}}));
        assertEquals(0, s.minPathSum1(new int[][]{{}}));
        assertEquals(6, s.minPathSum1(new int[][]{{1, 1, 1, 2, 6}, {1, 1, 0, 1, 2}}));
        assertEquals(6, s.minPathSum1(new int[][]{{1, 0, 1, 2, 2}}));
    }

    @Test
    public void search() {
        assertEquals(4, s.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
        assertEquals(-1, s.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3));
        assertEquals(3, s.search(new int[]{5, 6, 7, 0, 1, 2, 4}, 0));
        assertEquals(2, s.search(new int[]{6, 7, 0, 1, 2, 4, 5}, 0));
        assertEquals(1, s.search(new int[]{7, 0, 1, 2, 4, 5, 6}, 0));
        assertEquals(0, s.search(new int[]{0, 1, 2, 4, 5, 6, 7}, 0));
        assertEquals(5, s.search(new int[]{2, 4, 5, 6, 7, 0, 1}, 0));
        assertEquals(6, s.search(new int[]{1, 2, 4, 5, 6, 7, 0}, 0));
        //--
        assertEquals(-1, s.search(new int[]{5, 6, 7, 0, 1, 2, 4}, 3));
        assertEquals(-1, s.search(new int[]{6, 7, 0, 1, 2, 4, 5}, 3));
        assertEquals(-1, s.search(new int[]{7, 0, 1, 2, 4, 5, 6}, 3));
        assertEquals(-1, s.search(new int[]{0, 1, 2, 4, 5, 6, 7}, 3));
        assertEquals(-1, s.search(new int[]{2, 4, 5, 6, 7, 0, 1}, 3));
        assertEquals(-1, s.search(new int[]{1, 2, 4, 5, 6, 7, 0}, 3));
        //
        assertEquals(1, s.search(new int[]{1, 3}, 3));
    }

    @Test
    public void firstBadVersionTesst() {
        assertEquals(4, s.firstBadVersion(6));//4 bad version number
        assertEquals(1, s.firstBadVersion(3));//1
        assertEquals(2, s.firstBadVersion(2));//1
    }

    @Test
    public void subarraySumTest() {
        assertEquals(2, s.subarraySum(new int[]{1, 1, 1}, 2));
        assertEquals(3, s.subarraySum(new int[]{10, 2, -2, -20, 10}, -10));
        assertEquals(2, s.subarraySum(new int[]{9, 4, 20, 3, 10, 5}, 33));
    }

    @Test
    public void numJewelsInStonesTest() {
        assertEquals(3, s.numJewelsInStones("aA", "aAAbbbb"));
        assertEquals(0, s.numJewelsInStones("z", "ZZ"));
    }

    @Test
    public void canConstructTest() {
        assertEquals(false, s.canConstruct("a", "b"));
        assertEquals(false, s.canConstruct("aa", "ab"));
        assertEquals(true, s.canConstruct("aa", "aab"));
        assertEquals(true, s.canConstruct("bjaajgea", "affhiiicabhbdchbidghccijjbfjfhjeddgggbajhidhjchiedhdibgeaecffbbbefiabjdhggihccec"));
    }

    @Test
    public void longestCommonSubsequence() {
        assertEquals(3, s.longestCommonSubsequence("abcde", "ace"));
        assertEquals(3, s.longestCommonSubsequence("abc", "abc"));
        assertEquals(0, s.longestCommonSubsequence("abc", "def"));
        assertEquals(2, s.longestCommonSubsequence("abcde", "aec"));
        assertEquals(2, s.longestCommonSubsequence("oxcpqrsvwf", "shmtulqrypy"));
    }
}
