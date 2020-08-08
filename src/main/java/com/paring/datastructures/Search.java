package com.paring.datastructures;

public class Search {

    public static int searchSortedArray(int arr[], int N, int X) {
        // Your code here
        int low = 0, high = N - 1;
        while (low <= high) {
            int mid = low + ((high - low) / 2);
            if (arr[mid] == X) {
                return mid;
            } else if (arr[mid] < X) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static int countOnes(int arr[], int N) {

        int low = 0, high = N - 1;
        int lasthighestMid = 0;
        while (low <= high) {
            int mid = low + ((high - low) / 2);
            if (arr[mid] == 1) {
                lasthighestMid = mid + 1;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return lasthighestMid;

    }

    public static long floorSqrt(long x) {
        long mid = x / 2;
        long lastSquareRoot = 0;
        while (true) {
            if (mid * mid == x) {
                return mid;
            } else if (mid * mid > x && lastSquareRoot == 0) {
                mid = mid / 2;
            } else if (mid * mid < x) {
                lastSquareRoot = mid;
                mid++;
            } else {
                return lastSquareRoot;
            }
        }
    }

    public static int majorityElement(int a[], int size) {
        if (a.length == 1)
            return a[0];
        int res = a[0], count = 1;
        for (int i = 1; i < size; i++) {
            if (a[i] == res)
                count++;
            else
                count--;
            if (count == 0) {
                res = a[i];
                count = 1;
            }
        }
        count = 0;
        for (int i = 0; i < size; i++) {
            if (a[i] == res)
                count++;
        }
        if (count > size / 2)
            return res;
        else
            return -1;
    }

    public static int leftIndex(int N, int arr[], int X) {

        int low = 0, high = N - 1;
        int leftIndex = -1;
        while (low <= high) {
            int mid = low + ((high - low) / 2);
            if (arr[mid] == X) {
                leftIndex = mid;
                high = mid - 1;
            } else if (arr[mid] > X && leftIndex == -1) {
                high = mid - 1;
            } else if (arr[mid] < X && leftIndex == -1) {
                low = mid + 1;
            } else {
                return leftIndex;
            }
        }
        return leftIndex;
    }

    public static int peakElement(int[] a, int n) {
        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) / 2);
            if ((mid == 0 && a[mid + 1] < a[mid]) || (mid == n - 1 && a[mid] > a[mid - 1]) || ((a[mid] > a[mid - 1]) && (a[mid + 1] < a[mid]))) {
                return 1;
            } else if (mid + 1 <= high && a[mid] < a[mid + 1]) {
                low = mid + 1;
            } else if (mid - 1 >= low && a[mid - 1] > a[mid]) {
                high = mid - 1;
            } else {
                return 0;
            }
        }
        return 0;
    }

    public static int findFloor(long arr[], int left, int right, long x) {
        int ans = -1;
        right = right - 1;
        int low = left;
        int high = right;
        while (low <= high) {
            int mid = low + ((high - low) / 2);
            if (arr[mid] == x) {
                return mid;
            } else if (x > arr[mid]) {
                ans = mid;
                if (mid + 1 <= right && arr[mid + 1] <= x)
                    low = mid + 1;
                else
                    break;

            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    public static int minNumber(int arr[], int low, int high) {
        if (arr[low] < arr[high])
            return arr[low];
        while (low <= high) {
            int mid = low + ((high - low) / 2);
            if (mid - 1 >= 0 && arr[mid - 1] > arr[mid]) {
                return arr[mid];
            } else if (mid + 1 <= high && arr[mid + 1] < arr[mid]) {
                return arr[mid + 1];
            } else if (arr[mid] > arr[high]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;

    }

    public static void twoRepeated(int[] arr, int N) {
        // Your code here
        int last = N + 1;
        for (int i = 0; i < N; i++) {
            while (i + 1 != arr[i]) {
                if (arr[i] > i + 1) {
                    int temp = arr[arr[i] - 1];
                    arr[arr[i] - 1] = arr[i];
                    arr[i] = temp;
                } else {
                    //  System.out.println(arr[i]);
                    int temp = arr[i];
                    arr[i] = arr[last];
                    arr[last] = temp;
                    last--;
                }
            }
        }
        System.out.println(arr[N - 1] + "," + arr[N - 2]);
    }

    public static void twoRepeated1(int[] arr, int N) {
        // Your code here
//        int additionofNintegers = (N * (N + 1)) / 2;
//        int factofN = 1;
//        int arraySum = 0;
//        int arrayMulti = 1;
//        for (int i = 1; i <= N; i++) {
//            factofN = factofN * i;
//        }
//        for (int i = 0; i < arr.length; i++) {
//            arraySum += arr[i];
//            arrayMulti *= arr[i];
//        }
//        int xPlusY = arraySum - additionofNintegers;
//        int xy = arrayMulti / factofN;
//        int xMinusY = (int) Math.sqrt((xPlusY * xPlusY) - (4 * xy));
//        int x = (xPlusY + xMinusY) / 2;
//        int y = (xy / x);
//        System.out.println(x + "," + y);
        int x = 0, y = 0;
        for (int i = 0; i < N + 2; i++) {
            if (arr[Math.abs(arr[i])] > 0) {
                arr[Math.abs(arr[i])] = -arr[Math.abs(arr[i])];
            } else {
                if (x == 0)
                    x = Math.abs(arr[i]);
                else
                    y = Math.abs(arr[i]);
            }
        }
        System.out.println(x + "," + y);
    }

    public static int maxStep(int A[], int N) {
        int count = 0;
        int res = 0;
        for (int i = 1; i < N; i++) {
            if (A[i] > A[i - 1]) {
                count++;
                res = res > count ? res : count;
            } else {
                count = 0;
            }
        }
        return res;
    }

    public static int maxWater(int height[], int n) {
        int i = 0, j = n - 1, maxwater = 0, water = 0;
        while (i < j) {
            int min = height[i] < height[j] ? height[i] : height[j];
            water = min * (j - i - 1);
            maxwater = maxwater > water ? maxwater : water;
            if (height[i] < height[j])
                i++;
            else
                j--;
        }
        return maxwater;
    }

    public static int missingNumber(int arr[], int size) {

        boolean[] ispresent = new boolean[size + 1];
        for (int i = 0; i < size; i++) {
            if (arr[i] > 0 && arr[i] < size + 1) {
                ispresent[arr[i]] = true;
            }
        }

        for (int i = 1; i < size + 1; i++) {
            if (!ispresent[i]) {
                return i;
            }
        }
        return size + 1;
    }

    public static void rearrange(int arr[], int n) {
        int max_index = n - 1;
        int min_index = 0;
        int max_element = arr[n - 1] + 1;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                arr[i] += (arr[max_index] % max_element) * max_element;
                max_index--;
            } else {
                arr[i] += (arr[min_index] % max_element) * max_element;
                min_index++;
            }
        }
        for (int i = 0; i < n; i++) {
            arr[i] = arr[i] / max_element;
        }
    }

    public static void arrange(long arr[], int n) {

        for (int i = 0; i < n; i++) {
            long arrElement = arr[i];
            long resultElement = arr[(int) arr[i]];
            arr[i] += (resultElement % n) * n;
            System.out.println(arr[i]);
        }
        for (int i = 0; i < n; i++) {
            arr[i] = arr[i] / n;
        }
    }
}
