package com.paring;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Febonacci {
    //Split Array into Fibonacci Sequence
    //https://leetcode.com/problems/split-array-into-fibonacci-sequence/
    int max = Integer.MAX_VALUE;

    public List<Integer> splitIntoFibonacci(String S) {
        List<Integer> seq = new ArrayList<>();
        int i = 0;
        for (int j = i; j < S.length() - 2; j++) {
            long a = Long.parseLong(S.substring(i, j + 1));
            if (a > max)
                break;
            if (S.charAt(i) == '0')
                break;
            seq.add((int) a);
            if (backtracking(S, j + 1, seq)) {
                return seq;
            }
            seq.remove(seq.size() - 1);

        }
        return seq;
    }

    public boolean backtracking(String s, int index, List seq) {
        if (index == s.length())
            return true;
        int k = index;
        int end = seq.size() >= 2 ? s.length() : s.length() - 1;
        for (int j = k; j < end; j++) {
            long b = Long.parseLong(s.substring(k, j + 1));
            if (b > max)
                break;
            if (s.charAt(k) == '0')
                break;
            if (seq.size() < 2 || ((int) b == (int) seq.get(seq.size() - 1) + (int) seq.get(seq.size() - 2))) {
                seq.add((int) b);
                if (backtracking(s, j + 1, seq))
                    return true;
                else
                    seq.remove(seq.size() - 1);
            }

        }
        return false;
    }

    public int[] nBonacciNumbers(int n) {
        int[] res = new int[50];
        for (int i = 0; i < n - 1; i++) {
            res[i] = 0;
        }
        res[n - 1] = 1;
        long currentsum = 1;
        int j = n;
        for (; j < 50; j++) {
            res[j] = (int) currentsum;
            currentsum += res[j] - res[j - n];
            if (currentsum > Integer.MAX_VALUE)
                break;
        }
        while (j < 50) {
            res[j] = Integer.MAX_VALUE;
            j++;
        }
        return res;
    }

    public List<Integer> kSumNbonacci(int k, int n) {
        int[] nbonacci = nBonacciNumbers(n);
        List<Integer> res = new ArrayList<>();
        findKsum(nbonacci, res, k);
        return res;
    }

    private void findKsum(int[] nbonacci, List<Integer> res, int k) {
        int low = 0, high = nbonacci.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) / 2);
            if ((mid == nbonacci.length - 1 && nbonacci[mid] <= k) || (nbonacci[mid] <= k && nbonacci[mid + 1] > k)) {
                res.add(nbonacci[mid]);
                k = k - nbonacci[mid];
                low = 0;
                high = mid;
                if (k == 0)
                    break;
            } else if (nbonacci[mid] > k) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
    }

    public int fib(int N) {
        if (N == 0)
            return 0;
        if (N == 1)
            return 1;
        int f1 = 0, f2 = 1, count = 2, f3 = 1;
        while (count <= N) {
            f3 = f2 + f1;
            f1 = f2;
            f2 = f3;
            count++;
        }
        return f3;
    }

    public int lenLongestFibSubseq(int[] A) {
        int res = 0;
        HashSet<Integer> arr = new HashSet<>();
        for (int i = 0; i < A.length; i++) {
            arr.add(A[i]);
        }
        for (int i = 0; i < A.length - 2; i++) {
            for (int j = i + 1; j < A.length - 1; j++) {
                int f1 = A[i], f2 = A[j];
                int f3 = f1 + f2;
                int count = arr.contains(f3) ? 2 : 0;
                while (arr.contains(f3)) {
                    f1 = f2;
                    f2 = f3;
                    f3 = f1 + f2;
                    count++;
                }
                res = res > count ? res : count;
            }
        }
        return res;
    }

    //print all permutations
    //Prints the array
    public void printArr(int a[], int n) {
        for (int i = 0; i < n; i++)
            System.out.print(a[i] + " ");
        System.out.println();
    }

    //Generating permutation using Heap Algorithm
    public void heapPermutation(int a[], int size, int n) {
        // if size becomes 1 then prints the obtained
        // permutation
        if (size == 1)
            printArr(a, n);

        for (int i = 0; i < size; i++) {
            heapPermutation(a, size - 1, n);

            // if size is odd, swap first and last
            // element
            if (size % 2 == 1) {
                int temp = a[0];
                a[0] = a[size - 1];
                a[size - 1] = temp;
            }

            // If size is even, swap ith and last
            // element
            else {
                int temp = a[i];
                a[i] = a[size - 1];
                a[size - 1] = temp;
            }
        }
    }

}
