package com.paring.dynamicProgramming;

public class DPProblems {
    /*
    * 5. Longest Palindromic Substring
Medium

6165

500

Add to List

Share
Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Example 1:

Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.
Example 2:

Input: "cbbd"
Output: "bb"
    * */
    public String longestPalindrome(String s) {
        if (!(s == null) && !s.equals("")) {
            int len = s.length();
            int[][] table = new int[len][len];
            int maxlengthPalindrome = 1;
            String longPalindrome = "";
            int startPosition = 0;
            for (int i = 0; i < len - 1; i++) {
                table[i][i] = 1;
                table[i][i + 1] = (s.charAt(i) == s.charAt(i + 1)) ? 1 : 0;
                if (table[i][i + 1] == 1 && maxlengthPalindrome == 1) {
                    maxlengthPalindrome = 2;
                    startPosition = i;
                }
            }
            table[len - 1][len - 1] = 1;
            for (int k = 3; k <= len; k++) {
                for (int i = 0; k + i <= len; i++) {
                    int j = i + k - 1;
                    if (s.charAt(i) == s.charAt(j) && table[i + 1][j - 1] == 1) {
                        table[i][j] = 1;
                        if (maxlengthPalindrome < k) {
                            maxlengthPalindrome = k;
                            startPosition = i;
                        }
                    }

                }
            }
            return s.substring(startPosition, startPosition + maxlengthPalindrome);
        }
        return "";
    }
}
