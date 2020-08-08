package com.paring.datastructures;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Stack;

public class Sort {
    public static int[] bubble(int arr[], int i, int n) {
        int swaps = 1;
        // add your code here
        for (int k = arr.length - 1; (k >= 0) && (swaps == 1); k--) {
            swaps = 0;
            for (int j = 0; j < k; j++) {
                if (arr[j] > arr[j + 1]) {
                    swaps = 1;
                    arr[j] = arr[j] + arr[j + 1];
                    arr[j + 1] = arr[j] - arr[j + 1];
                    arr[j] = arr[j] - arr[j + 1];
                }
            }
        }
        return arr;
    }

    public static int[] selectionSort(int arr[]) {

        for (int k = arr.length - 1; k >= 0; k--) {
            int max = k;
            for (int j = k - 1; j >= 0; j--) {
                if (arr[j] > arr[max]) {
                    max = j;
                }
            }
            if (max != k) {
                arr[max] = arr[max] + arr[k];
                arr[k] = arr[max] - arr[k];
                arr[max] = arr[max] - arr[k];
            }
        }
        return arr;
    }

    public static int[] insertionSort(int arr[]) {

        for (int k = 1; k < arr.length; k++) {
            int selectedElement = k;
            for (int j = k - 1; (j >= 0) && (arr[j] > arr[selectedElement]); j--) {
                arr[selectedElement] = arr[selectedElement] + arr[j];
                arr[j] = arr[selectedElement] - arr[j];
                arr[selectedElement] = arr[selectedElement] - arr[j];
                selectedElement = j;
            }
        }
        return arr;
    }

    public static int[] mergeSort(int arr[], int l, int h) {

        if (l < h) {
            int mid = l + ((h - l) / 2);
            mergeSort(arr, l, mid);
            mergeSort(arr, mid + 1, h);
            merge(arr, l, mid, h);
        }
        return arr;
    }

    private static void merge(int[] arr, int l, int mid, int h) {

        int[] L = new int[mid - l + 1];
        int[] R = new int[h - mid];
        for (int i = l, k = 0; i < mid + 1; i++, k++) {
            L[k] = arr[i];
        }
        for (int i = mid + 1, k = 0; i < h + 1; i++, k++) {
            R[k] = arr[i];
        }
        int k = l, i = 0, j = 0;

        while (i < L.length && j < R.length) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;

            } else if (L[i] > R[j]) {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        while (i < L.length) {
            arr[k] = L[i];
            i++;
            k++;
        }
        while (j < R.length) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    public static Interval[] mergeIntervals(Interval arr[]) {
        Stack<Interval> result = new Stack<Interval>();
        if (arr.length > 0) {
            Arrays.sort(arr);
            result.push(arr[0]);
            for (int i = 1; i < arr.length; i++) {
                Interval top = result.peek();
                if (top.start <= arr[i].start && arr[i].start <= top.end) {
                    int start = arr[i].start < top.start ? arr[i].start : top.start;
                    int end = arr[i].end < top.end ? top.end : arr[i].end;
                    result.pop();
                    result.push(new Interval(start, end));
                } else {
                    result.push(arr[i]);
                }
            }
        }
        return (Interval[]) result.toArray(new Interval[result.size()]);
    }

    public static int[] countingSort(int arr[]) {
        int min = Arrays.stream(arr).min().getAsInt();
        int max = Arrays.stream(arr).max().getAsInt();
        int[] count = new int[max - min + 1];
        int[] output = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            count[arr[i] - min]++;
        }
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            output[count[arr[i] - min] - 1] = arr[i];
            count[arr[i] - min]--;
        }
        return output;
    }

    public static int[] radixSort(int arr[]) {
        int max = Arrays.stream(arr).max().getAsInt();
        int maxDigits = (int) Math.log10(max) + 1;
        //finiding number of digits in every number
//        for (int i = 0; i < arr.length; i++) {
//            maxDigits = Math.max(maxDigits, (int) Math.log10(arr[i]) + 1);
//        }
        for (int i = 1; i <= maxDigits; i++) {
            countSortForRadix(arr, i);
        }
        return arr;
    }

    public static void countSortForRadix(int arr[], int digitplace) {
        int[] count = new int[10];
        int[] output = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int temp1 = arr[i] % (int) Math.pow(10, digitplace);
            int temp2 = (int) temp1 / (int) Math.pow(10, digitplace - 1);
            count[temp2]++;
        }
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            int temp1 = arr[i] % (int) Math.pow(10, digitplace);
            int temp2 = (int) temp1 / (int) Math.pow(10, digitplace - 1);
            output[count[temp2] - 1] = arr[i];
            count[temp2]--;
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = output[i];
        }
    }

    //Find pair in unsorted array which gives sum X
    //	int A[] = { 1, 4, 45, 6, 10, 8 };
    //  int n=16
    public static Interval[] printPairs(int arr[], int n) {
        HashSet<Integer> h = new HashSet<>();
        Interval[] result = new Interval[arr.length];
        int r = 0;
        for (int i = 0; i < arr.length; i++) {
            int x = n - arr[i];
            if (h.contains(x)) {
                System.out.println("Pair with given sum is" + arr[i] + ',' + x);
                result[r] = new Interval(arr[i], x);
                r++;
            } else {
                h.add(arr[i]);
            }
        }
        return result;
    }

    //Find pair in sorted array which gives sum
//    int arr[] = new int[]{2, 3, 7, 8, 11};
//    int n = arr.length;
//    int sum = 14;
    public static Interval[] printPairInSortedArray(int arr[], int sum) {
        Interval[] result = new Interval[arr.length];
        int l = 0, h = arr.length - 1;
        int k = 0, i = 0, j = 0;
        while (l < h) {
            int x = arr[l] + arr[h];
            if (x == sum) {
                result[k] = new Interval(arr[l], arr[h]);
                k++;
                l++;
                h--;
            } else if (x > sum) {
                h--;
            } else {
                l++;
            }
        }
        return result;
    }

    //Find triplet in an array which gives sum X
    /*int A[] = { 1, 4, 45, 6, 10, 8 };
		int sum = 22; */
    public static String findTheTriplets(int arr[], int sum) {
        int n = arr.length;
        String result = null;
        for (int i = 0; i < n - 2; i++) {
            HashSet<Integer> s = new HashSet<>();
            for (int j = i + 1; j < n; j++) {
                int x = sum - (arr[i] + arr[j]);
                if (s.contains(x)) {
                    result = "," + arr[i] + ',' + arr[j] + ',' + x + ";";
                } else {
                    s.add(arr[j]);
                }
            }
        }
        return result;
    }

    public static int findMajority(int[] arr) {
        //identify majority element
        int count = 1, res = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[res]) {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                res = i;
                count = 1;
            }
        }
        //majority element count
        count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[res] == arr[i])
                count++;
        }
        if (count <= arr.length / 2)
            return -1;
        return arr[res];
    }

    public static double medianOf2SortedArrays(int[] a, int[] b) {
        int[] a1 = (a.length > b.length) ? b : a;
        int[] b1 = (a.length > b.length) ? a : b;
        int m = a1.length;
        int n = b1.length;
        int minIndex = 0;
        int maxIndex = m;
        int i = 0, j = m, median = 0;
        while (minIndex <= maxIndex) {
            i = (minIndex + maxIndex) / 2;
            j = ((m + n + 1) / 2) - i;
            if (i > 0 && j < n && b1[j] < a1[i - 1]) {
                maxIndex = i - 1;
            } else if (i < m && j > 0 && b1[j - 1] > a1[i]) {
                minIndex = i + 1;
            } else {
                if (i == 0) {
                    median = b1[j - 1];
                } else if (j == 0) {
                    median = a1[i - 1];
                } else {
                    //a1[i - 1] < b1[j] && b1[j - 1] < a1[i]
                    median = a1[i - 1] > b1[j - 1] ? a1[i - 1] : b1[j - 1];
                }
                break;
            }
        }
        if (((m + n) % 2) == 0) {
            if (i == 0) {
                return (median + b1[j]) / 2;
            } else if (j == 0) {
                return (median + a1[i]) / 2;
            } else {
                return (median + a1[i] > b1[j] ? b1[i] : a1[j]) / 2;
            }
        } else {
            return median;
        }
    }
}


