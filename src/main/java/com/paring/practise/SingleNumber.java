package com.paring.practise;

import com.paring.datastructures.Node;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class SingleNumber {

    public int getSingleNumber(int nums[]) {
        Arrays.sort(nums);
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (i == nums.length - 1 && nums[i - 1] != nums[i]) {
                result = nums[i];
            } else if (nums[i - 1] != nums[i] && nums[i + 1] != nums[i]) {
                result = nums[i];
            }

        }
        return result;
    }

    public boolean isHappyNumber(int n) {
        try {
            int total = 0;
            boolean result = false;
            while (n > 0) {
                int temp = n % 10;
                total = total + (temp * temp);
                n = n / 10;
            }
            if (total == 1)
                return true;
            else if (total == 89)
                return false;
            else
                result = isHappyNumber(total);
            return result;
        } catch (StackOverflowError e) {
            return false;
        }
    }

    /**
     * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
     * <p>
     * Example:
     * <p>
     * Input: [-2,1,-3,4,-1,2,1,-5,4],
     * Output: 6
     * Explanation: [4,-1,2,1] has the largest sum = 6.
     * Follow up:
     * <p>
     * If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
     * https://www.youtube.com/watch?v=tinz1fiYv0c
     */

    public int maxSubArray(int[] nums) {
        int maxSum = 0;
        int maxSumForEachIteration = 0;
        int maxValueIndex = IntStream.range(0, nums.length).reduce((i, j) -> nums[i] >= nums[j] ? i : j).getAsInt();
        if (nums[maxValueIndex] <= 0)
            return nums[maxValueIndex];
        for (int i = 0; i < nums.length; i++) {
            if (maxSumForEachIteration + nums[i] > 0) {
                maxSumForEachIteration += nums[i];
                maxSum = Math.max(maxSum, maxSumForEachIteration);
            } else
                maxSumForEachIteration = 0;

            /*if (maxSum < maxSumForEachIteration) {
                maxSum = maxSumForEachIteration;
            }*/
        }
        return maxSum;
    }

    public int maxSubArray1(int[] nums) {
        int maxSoFar = nums[0];
        int currMax = nums[0];
        for (int i = 1; i < nums.length; i++) {
            currMax = Math.max(nums[i], currMax + nums[i]);
            maxSoFar = Math.max(maxSoFar, currMax);
        }
        return maxSoFar;
    }

    /*Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Example:

Input: [0,1,0,3,12]
Output: [1,3,12,0,0]
Note:

You must do this in-place without making a copy of the array.
Minimize the total number of operations.
    * */
    public int[] moveZeroes(int[] nums) {
        for (int k = 0, len = nums.length; k < len; k++) {
            if (k != 0) {
                int j = k;
                while ((j - 1) >= 0 && nums[j - 1] == 0) {
                    int temp = nums[j];
                    nums[j] = nums[j - 1];
                    nums[j - 1] = temp;
                    j--;
                }
            }
        }
        return nums;
    }

    /*
    Say you have an array prices for which the ith element is the price of a given stock on day i.

    Design an algorithm to find the maximum profit. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times).

    Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).

    Example 1:

    Input: [7,1,5,3,6,4]
    Output: 7
    Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
                 Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
    Example 2:

    Input: [1,2,3,4,5]
    Output: 4
    Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
                 Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
                 engaging multiple transactions at the same time. You must sell before buying again.
    Example 3:

    Input: [7,6,4,3,1]
    Output: 0
    Explanation: In this case, no transaction is done, i.e. max profit = 0.
     */
    public int maxProfit(int[] prices) {
        int profit = 0;
        int i = 0;
        int len = prices.length;
        for (int k = 1; k < len; k++) {
            if (prices[k] > prices[k - 1]) {
                continue;
            } else {
                if (i != k - 1)
                    profit += prices[k - 1] - prices[i];
                i = k;
            }
        }
        if (i != len - 1)
            profit += prices[len - 1] - prices[i];
        return profit;
    }

    /***
     * Given an array of strings, group anagrams together.
     *
     * Example:
     *
     * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
     * Output:
     * [
     *   ["ate","eat","tea"],
     *   ["nat","tan"],
     *   ["bat"]
     * ]
     * Note:
     *
     * All inputs will be in lowercase.
     * The order of your output does not matter.
     * https://stackoverflow.com/questions/27980488/java-8-stream-of-integer-grouping-indexes-of-a-stream-by-the-integers
     * Function.identity()
     * */
    public List<List<String>> groupAnagrams(String[] strs) {
        AtomicInteger counter = new AtomicInteger();
        Map<Integer, String> m = Arrays.stream(strs).map(this::sortString).collect(Collectors.toMap(c -> counter.getAndIncrement(), (c) -> c));
        Map<String, List<Integer>> result1 = m.entrySet().stream().collect(Collectors.groupingBy(Map.Entry::getValue, Collectors.mapping(Map.Entry::getKey, Collectors.toList())));
        List<List<String>> anagrams1 = new ArrayList<>();
        result1.forEach((k, v) -> anagrams1.add(v.stream().map(x -> strs[x]).collect(Collectors.toList())));

        /*List<String> a = Arrays.stream(strs).map(this::sortString).collect(Collectors.toList());
        PrimitiveIterator.OfInt indexes = IntStream.iterate(0, x -> x + 1).iterator();
        Map<String, List<Integer>> result = new HashMap<>();
        a.iterator().forEachRemaining(i -> result.merge(i, new ArrayList<>(Arrays.asList(indexes.next())),
                (l1, l2) -> {
                    l1.addAll(l2);
                    return l1;
                })
        );
        List<List<String>> anagrams = new ArrayList<>();
        result.forEach((k, v) -> anagrams.add(v.stream().map(x -> strs[x]).collect(Collectors.toList()))); */
        //collect(Collectors.groupingBy(Function.identity()));
        return anagrams1;
    }

    public String sortString(String str) {
        //char[] arr = str.toCharArray();
        //Arrays.sort(arr);
        String x = Stream.of(str.split("")).sorted().collect(Collectors.joining());
        return x;
    }

    /*
    Given an integer array arr, count element x such that x + 1 is also in arr.

If there're duplicates in arr, count them seperately.



Example 1:

Input: arr = [1,2,3]
Output: 2
Explanation: 1 and 2 are counted cause 2 and 3 are in arr.
Example 2:

Input: arr = [1,1,3,3,5,5,7,7]
Output: 0
Explanation: No numbers are counted, cause there's no 2, 4, 6, or 8 in arr.
Example 3:

Input: arr = [1,3,2,3,5,0]
Output: 3
Explanation: 0, 1 and 2 are counted cause 1, 2 and 3 are in arr.
Example 4:

Input: arr = [1,1,2,2]
Output: 2
Explanation: Two 1s are counted cause 2 is in arr.


Constraints:

1 <= arr.length <= 1000
0 <= arr[i] <= 1000
     */
    public int countElements(int[] arr) {
        Map<Integer, Long> map = Arrays.stream(arr).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        AtomicLong count = new AtomicLong();
        map.forEach((k, v) -> {
            if (map.containsKey(k + 1)) {
                count.addAndGet(map.get(k));
            }
        });
        return count.intValue();
    }

    /**
     * Given a non-empty, singly linked list with head node head, return a middle node of linked list.
     * <p>
     * If there are two middle nodes, return the second middle node.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: [1,2,3,4,5]
     * Output: Node 3 from this list (Serialization: [3,4,5])
     * The returned node has value 3.  (The judge's serialization of this node is [3,4,5]).
     * Note that we returned a ListNode object ans, such that:
     * ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, and ans.next.next.next = NULL.
     * Example 2:
     * <p>
     * Input: [1,2,3,4,5,6]
     * Output: Node 4 from this list (Serialization: [4,5,6])
     * Since the list has two middle nodes with values 3 and 4, we return the second one.
     * <p>
     * <p>
     * Note:
     * <p>
     * The number of nodes in the given list will be between 1 and 100.
     */
    public class ListNode {
        int val;
        ListNode next;

        public ListNode(int x) {
            this.val = x;
        }
    }

    public Node middleNode(Node head) {
        Node singlepointer = head;
        Node doublePointer = head;
        while (doublePointer.next != null && doublePointer.next.next != null) {
            doublePointer = doublePointer.next.next;
            singlepointer = singlepointer.next;
        }
        if (doublePointer.next == null)
            return singlepointer;

        return singlepointer.next;
    }

    /*
    Given two strings S and T, return if they are equal when both are typed into empty text editors. # means a backspace character.

Note that after backspacing an empty text, the text will continue empty.

Example 1:

Input: S = "ab#c", T = "ad#c"
Output: true
Explanation: Both S and T become "ac".
Example 2:

Input: S = "ab##", T = "c#d#"
Output: true
Explanation: Both S and T become "".
Example 3:

Input: S = "a##c", T = "#a#c"
Output: true
Explanation: Both S and T become "c".
Example 4:

Input: S = "a#c", T = "b"
Output: false
Explanation: S becomes "c" while T becomes "b".
Note:

1 <= S.length <= 200
1 <= T.length <= 200
S and T only contain lowercase letters and '#' characters.
Follow up:

Can you solve it in O(N) time and O(1) space?
     */
    public boolean backspaceCompare(String S, String T) {
        StringBuilder sbuilder = new StringBuilder();
        StringBuilder tbuilder = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (c != '#')
                sbuilder.append(c);
            else
                sbuilder.setLength(Math.max(sbuilder.length() - 1, 0));
        }
        for (int i = 0; i < T.length(); i++) {
            char c = T.charAt(i);
            if (c != '#')
                tbuilder.append(c);
            else
                tbuilder.setLength(Math.max(tbuilder.length() - 1, 0));
        }
        return (sbuilder.compareTo(tbuilder) == 0);
    }

    /*
We have a collection of stones, each stone has a positive integer weight.

Each turn, we choose the two heaviest stones and smash them together.  Suppose the stones have weights x and y with x <= y.  The result of this smash is:

If x == y, both stones are totally destroyed;
If x != y, the stone of weight x is totally destroyed, and the stone of weight y has new weight y-x.
At the end, there is at most 1 stone left.  Return the weight of this stone (or 0 if there are no stones left.)



Example 1:

Input: [2,7,4,1,8,1]
Output: 1
Explanation:
We combine 7 and 8 to get 1 so the array converts to [2,4,1,1,1] then,
we combine 2 and 4 to get 2 so the array converts to [2,1,1,1] then,
we combine 2 and 1 to get 1 so the array converts to [1,1,1] then,
we combine 1 and 1 to get 0 so the array converts to [1] then that's the value of last stone.


Note:

1 <= stones.length <= 30
1 <= stones[i] <= 1000
answer:https://github.com/fishercoder1534/Leetcode/blob/master/src/main/java/com/fishercoder/solutions/_1046.java
     */
    public int lastStoneWeight(int[] stones) {
        if (stones.length <= 1)
            return (stones != null) ? stones[0] : 0;
        Arrays.sort(stones);
        List<Integer> finalStoneWeight = smashAndinsert(Arrays.stream(stones).boxed().collect(Collectors.toList()));
        return (finalStoneWeight == null || finalStoneWeight.isEmpty()) ? 0 : finalStoneWeight.get(0);
    }

    public List<Integer> smashAndinsert(List<Integer> stones) {
        int len = stones.size();
        int last = len - 1;
        int lastButone = len - 2;
        int smashValue = stones.get(last) - stones.get(lastButone);
        stones.remove(last);
        stones.remove(lastButone);
        List<Integer> result = null;
        //part of insertion sort
        if (smashValue > 0) {
            if (stones.isEmpty())
                stones.add(smashValue);
            else {
                int i = stones.size() - 1;
                boolean isInserted = false;
                while (i >= 0) {
                    if (smashValue >= stones.get(i)) {
                        stones.add(i + 1, smashValue);
                        isInserted = true;
                        break;
                    }
                    i--;
                }
                if (!isInserted)
                    stones.add(0, smashValue);
            }
        }
        if (stones.size() > 1)
            result = smashAndinsert(stones);
        return stones;
    }

    /***
     * Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.
     *
     * Example 1:
     * Input: [0,1]
     * Output: 2
     * Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1.
     * Example 2:
     * Input: [0,1,0]
     * Output: 2
     * Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
     * Note: The length of the given binary array will not exceed 50,000.
     */
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> counts = new HashMap<>();
        counts.put(0, -1);
        int max_length = 0;
        int countVal = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0)
                countVal--;
            else
                countVal++;
            if (counts.containsKey(countVal))
                max_length = Math.max(max_length, i - counts.get(countVal));
            else
                counts.put(countVal, i);
        }
        return max_length;
    }

    /**
     * You are given a string s containing lowercase English letters, and a matrix shift, where shift[i] = [direction, amount]:
     * <p>
     * direction can be 0 (for left shift) or 1 (for right shift).
     * amount is the amount by which string s is to be shifted.
     * A left shift by 1 means remove the first character of s and append it to the end.
     * Similarly, a right shift by 1 means remove the last character of s and add it to the beginning.
     * Return the final string after all operations.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: s = "abc", shift = [[0,1],[1,2]]
     * Output: "cab"
     * Explanation:
     * [0,1] means shift to left by 1. "abc" -> "bca"
     * [1,2] means shift to right by 2. "bca" -> "cab"
     * Example 2:
     * <p>
     * Input: s = "abcdefg", shift = [[1,1],[1,1],[0,2],[1,3]]
     * Output: "efgabcd"
     * Explanation:
     * [1,1] means shift to right by 1. "abcdefg" -> "gabcdef"
     * [1,1] means shift to right by 1. "gabcdef" -> "fgabcde"
     * [0,2] means shift to left by 2. "fgabcde" -> "abcdefg"
     * [1,3] means shift to right by 3. "abcdefg" -> "efgabcd"
     * <p>
     * <p>
     * Constraints:
     * <p>
     * 1 <= s.length <= 100
     * s only contains lower case English letters.
     * 1 <= shift.length <= 100
     * shift[i].length == 2
     * 0 <= shift[i][0] <= 1
     * 0 <= shift[i][1] <= 100
     */
    public String stringShift(String s, int[][] shift) {
        int shiftdirection = 0;
        String result = s;
        int direction = 0;//-1 left 1 right 0 no
        if (s.length() == 1)
            return s;
        for (int i = 0; i < shift.length; i++) {
            if (shift[i][0] == 0) {
                shiftdirection += (-1 * shift[i][1]);
            } else {
                shiftdirection += (1 * shift[i][1]);
            }
        }
        if (shiftdirection < 0) {
            direction = -1;
            shiftdirection = -1 * shiftdirection;
        } else if (shiftdirection > 0) {
            direction = 1;
        }
        shiftdirection = shiftdirection - ((shiftdirection / s.length()) * s.length());
        if (direction < 0) {
            result = s.substring(shiftdirection) + s.substring(0, shiftdirection);
        } else if (direction > 0) {
            result = s.substring(s.length() - shiftdirection) + s.substring(0, s.length() - shiftdirection);
        }

        return result;
    }

    /*
    Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

Example:

Input:  [1,2,3,4]
Output: [24,12,8,6]
Constraint: It's guaranteed that the product of the elements of any prefix or suffix of the array (including the whole array) fits in a 32 bit integer.

Note: Please solve it without division and in O(n).

Follow up:
Could you solve it with constant space complexity? (The output array does not count as extra space for the purpose of space complexity analysis.)
     */
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] prefix = new int[len];
        int[] sufix = new int[len];
        int[] result = new int[len];
        prefix[0] = 1;
        sufix[len - 1] = 1;
        for (int i = 1, j = len - 2; i < len && j >= 0; j--, i++) {
            prefix[i] = prefix[i - 1] * nums[i - 1];
            sufix[j] = sufix[j + 1] * nums[j + 1];
        }
        for (int k = 0; k < len; k++)
            result[k] = prefix[k] * sufix[k];
        return result;
    }

    /*
    *iven a string containing only three types of characters: '(', ')' and '*', write a function to check whether this string is valid. We define the validity of a string by these rules:

Any left parenthesis '(' must have a corresponding right parenthesis ')'.
Any right parenthesis ')' must have a corresponding left parenthesis '('.
Left parenthesis '(' must go before the corresponding right parenthesis ')'.
'*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string.
An empty string is also valid.
Example 1:
Input: "()"
Output: True
Example 2:
Input: "(*)"
Output: True
Example 3:
Input: "(*))"
Output: True
Note:
The string size will be in the range [1, 100].
*
* https://www.youtube.com/watch?v=KuE_Cn3xhxI
    *
     */
    public boolean checkValidString(String s) {
        char[] charArray = s.toCharArray();
        Stack<Integer> paranthesisArray = new Stack<>();
        Stack<Integer> startArray = new Stack<>();
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == '(')
                paranthesisArray.push(i);
            else if (charArray[i] == '*')
                startArray.push(i);
            else {
                if (!paranthesisArray.isEmpty())
                    paranthesisArray.pop();
                else if (!startArray.isEmpty())
                    startArray.pop();
                else
                    return false;
            }
        }
        while (!paranthesisArray.isEmpty()) {
            if (startArray.isEmpty())
                return false;
            if (paranthesisArray.pop() > startArray.pop())
                return false;

        }
        return true;
    }

    /*
    Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:

Input:
11110
11010
11000
00000

Output: 1
Example 2:

Input:
11000
11000
00100
00011

Output: 3
https://www.geeksforgeeks.org/find-number-of-islands/
https://www.geeksforgeeks.org/find-the-number-of-islands-set-2-using-disjoint-set/
     */
    public int numIslands(char[][] grid) {
        int count = 0;
        try {
            if (grid == null || grid.length == 0 || grid[0].length == 0)
                return 0;
            int rows = grid.length;
            int cols = grid[0].length;
            boolean[][] visited = new boolean[rows][cols];
            for (boolean[] arr1 : visited)
                Arrays.fill(arr1, false);
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (grid[i][j] == '1' && !visited[i][j]) {
                        DFS(grid, i, j, visited);
                        count++;
                    }
                }
            }
        } catch (Error e) {
            System.out.println(e);
        }
        return count;
    }

    public void DFS(char[][] grid, int i, int j, boolean[][] visited) {
        int[] rownumbers = new int[]{-1, 0, 1, 0};
        int[] colnumbers = new int[]{0, 1, 0, -1};
        visited[i][j] = true;
        int rows = grid.length;
        int cols = grid[0].length;
        for (int k = 0; k < 4; k++) {
            int rowno = i + rownumbers[k];
            int colno = j + colnumbers[k];
            if ((rowno >= 0) && (rowno < rows) && (colno >= 0) && (colno < cols) && (grid[rowno][colno] == '1') && !visited[rowno][colno])
                DFS(grid, rowno, colno, visited);
        }
    }

    /*Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.

Example:

Input:
[
  [1,3,1],
  [1,5,1],
  [4,2,1]
]
Output: 7
Explanation: Because the path 1→3→1→1→1 minimizes the sum.*/
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;
        return DFSForminPathSum(grid, grid.length - 1, grid[0].length - 1);
    }

    public int DFSForminPathSum(int[][] grid, int i, int j) {
        int resultRow, resultCol;
        if (i == 0 && j == 0)
            return grid[i][j];
        if (i - 1 >= 0) {
            resultRow = DFSForminPathSum(grid, i - 1, j);
        } else {
            resultRow = Integer.MAX_VALUE;
        }
        if (j - 1 >= 0) {
            resultCol = DFSForminPathSum(grid, i, j - 1);
        } else {
            resultCol = Integer.MAX_VALUE;
        }
        return ((resultRow > resultCol) ? resultCol : resultRow) + grid[i][j];
    }

    public int minPathSum1(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;
        int rows = grid.length;
        int cols = grid[0].length;
        int temp[][] = new int[rows][cols];
        temp[0][0] = grid[0][0];
        for (int i = 1; i < cols; i++) {
            temp[0][i] = temp[0][i - 1] + grid[0][i];
        }
        for (int j = 1; j < rows; j++) {
            temp[j][0] = temp[j - 1][0] + grid[j][0];
        }
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                temp[i][j] = Math.min(temp[i - 1][j], temp[i][j - 1]) + grid[i][j];
            }
        }
        return temp[rows - 1][cols - 1];
    }

    /*
    Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.

Your algorithm's runtime complexity must be in the order of O(log n).

Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
Example 2:

Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1
     */
    public int search(int[] nums, int target) {
        return binarySearch(nums, 0, nums.length - 1, target);
    }

    public int binarySearch(int[] nums, int startIndex, int endIndex, int target) {
        int middle = startIndex + (endIndex - startIndex) / 2;
        if (startIndex <= endIndex) {
            if (target == nums[middle])
                return middle;
            if (nums[startIndex] <= nums[middle]) {
                if (target >= nums[startIndex] && target <= nums[middle])
                    return binarySearch(nums, startIndex, middle - 1, target);
                else
                    return binarySearch(nums, middle + 1, endIndex, target);
            } else if (target >= nums[middle] && target <= nums[endIndex]) {
                return binarySearch(nums, middle + 1, endIndex, target);
            } else
                return binarySearch(nums, startIndex, middle - 1, target);
        }

        return -1;
    }

    public int firstBadVersion(int n) {
        int i = 1;
        int last = n;
        int mid = 1;
        while (i <= last) {
            mid = i + ((last - i) / 2);
            if (isBadVersion(mid) && mid > 1 && !isBadVersion(mid - 1))
                break;
            else if (mid == 1 && isBadVersion(mid))
                break;
            else if (isBadVersion(mid))
                last = mid - 1;
            else
                i = mid + 1;
        }
        return mid;
    }

    public boolean isBadVersion(int n) {
        int badVersion = 2;
        if (n >= badVersion)
            return true;
        return false;
    }

    /*
    Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.

Example 1:
Input:nums = [1,1,1], k = 2
Output: 2
Note:
The length of the array is in range [1, 20,000].
The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].
     */
    public int subarraySum(int[] nums, int k) {
        int no_of_subArrays = 0;
        int countTillnow = 0;
        for (int i = 0, len = nums.length; i <= len; i++) {
            countTillnow = 0;
            for (int j = i; j < len; j++) {
                countTillnow += nums[j];
                if (countTillnow == k)
                    no_of_subArrays++;
            }

        }
        return no_of_subArrays;
    }

    /*
     Jewels and Stones
    You're given strings J representing the types of stones that are jewels, and S representing the stones you have.  Each character in S is a type of stone you have.  You want to know how many of the stones you have are also jewels.

The letters in J are guaranteed distinct, and all characters in J and S are letters. Letters are case sensitive, so "a" is considered a different type of stone from "A".

Example 1:

Input: J = "aA", S = "aAAbbbb"
Output: 3
Example 2:

Input: J = "z", S = "ZZ"
Output: 0
Note:

S and J will consist of letters and have length at most 50.
The characters in J are distinct.
     */
    public int numJewelsInStones(String J, String S) {
        char[] stones = S.toCharArray();
        int result = 0;
        for (int i = 0, len = stones.length; i < len; i++) {
            if (J.indexOf(stones[i]) >= 0)
                result++;
        }
        return result;
    }

    /*
      Ransom Note
Given an arbitrary ransom note string and another string containing letters from all the magazines, write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.

Each letter in the magazine string can only be used once in your ransom note.

Note:
You may assume that both strings contain only lowercase letters.

canConstruct("a", "b") -> false
canConstruct("aa", "ab") -> false
canConstruct("aa", "aab") -> true
     */
    public boolean canConstruct(String ransomNote, String magazine) {
      /*  StringBuilder newMagazine = new StringBuilder(magazine);
        char[] newRansomNote = ransomNote.toCharArray();
        for (char c : newRansomNote) {
            if (newMagazine.indexOf(c + "") >= 0)
                newMagazine.deleteCharAt(newMagazine.indexOf(c + ""));
            else
                return false;
        }
        return true;*/
        char[] newRansomNote = ransomNote.toCharArray();
        for (char c : newRansomNote) {
            int isIndex = magazine.indexOf(c);
            if (isIndex >= 0)
                magazine = magazine.replaceFirst(c + "", "");
            else
                return false;
        }
        return true;
    }

    /*
      Longest Common Subsequence
Solution
Given two strings text1 and text2, return the length of their longest common subsequence.

A subsequence of a string is a new string generated from the original string with some characters(can be none) deleted without changing the relative order of the remaining characters. (eg, "ace" is a subsequence of "abcde" while "aec" is not). A common subsequence of two strings is a subsequence that is common to both strings.



If there is no common subsequence, return 0.



Example 1:

Input: text1 = "abcde", text2 = "ace"
Output: 3
Explanation: The longest common subsequence is "ace" and its length is 3.
Example 2:

Input: text1 = "abc", text2 = "abc"
Output: 3
Explanation: The longest common subsequence is "abc" and its length is 3.
Example 3:

Input: text1 = "abc", text2 = "def"
Output: 0
Explanation: There is no such common subsequence, so the result is 0.


Constraints:

1 <= text1.length <= 1000
1 <= text2.length <= 1000
The input strings consist of lowercase English characters only.
     */
    public int longestCommonSubsequence(String text1, String text2) {
        //https://en.wikipedia.org/wiki/Longest_common_subsequence_problem
        return 0;
    }
}
