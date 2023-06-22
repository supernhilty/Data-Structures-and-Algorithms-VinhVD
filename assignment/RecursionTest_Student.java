/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package fptu.demo.recursiontest;

/**
 *
 * @author vinhvo
 */
public class RecursionTest_Student {

    public static long factorial_loop(int n) {
        long fact = 1;
        for (int i = 1; i <= n; i++) {
            fact = fact * i;
        }
        return fact;
    }

    public static long factorial_recursion(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * factorial_loop(n - 1);
        }
    }

    // Function to calculate N raised to the power P
    public static int power_recursion(int N, int P) {
        if (P == 0) {
            return 1;
        } else {
            return N * power_loop(N, P - 1);
        }
    }

    public static int power_loop(int N, int P) {
        int pow = 1;
        for (int i = 1; i <= P; i++) {
            pow *= N;
        }
        return pow;
    }

    public static int binarySearch(int[] arr, int target) {
        // search space is nums[left…right]
        int left = 0, right = arr.length - 1;

        // loop till the search space is exhausted
        while (left <= right) {
            // find the mid-value in the search space and compare it with the target
            int mid = (right + left) / 2;

            // target is found
            if (target == arr[mid]) {
                return mid;
            } // discard all elements in the right search space, including the middle element
            else if (arr[mid]> target) {
                right = mid - 1;
            } // discard all elements in the left search space, including the middle element
            else {
                left = mid + 1;
            }
        }

        // `target` doesn't exist in the array
        return -1;
    }

    public static int linearSearch(int arr[], int key, int size) {
        int i;
        for (i = 0; i < size; i++) {
            if (key == arr[i]) {
                return i;
            }
        }

        return -1;
    }

    public static int recursivelybinarySearch(int arr[], int x, int low, int high) {
        if (low > high) {
            return -1;
        }

        int mid = (high + low) / 2;

        if (arr[mid] == x) {
            return mid;
        } else if (arr[mid] < x) // go to the right
        {
            return recursivelybinarySearch(arr, x, mid + 1, high);
        } else // go to the left
        {
            return recursivelybinarySearch(arr, x, low, mid - 1);
        }
    }

    public static int recursivelylinearSearch(int arr[], int l, int r, int key) {

        // if r < l, it means that element is not present in
        // the array
        if (r < l) {
            return -1;
        }

        if (arr[l] == key) {
            return l;
        }

        if (arr[r] == key) {
            return r;
        }

        // Since element has not found on both left most and
        // rightmost boundary,ie at l and r, now recursive the
        // array to find position of x.
        return recursivelylinearSearch(arr, l + 1, r - 1, key);
    }

    public static int fibonacci_recursion(int n) {
        if (n == 0 || n == 1) {
            return 1; // base cases
        } else {
            return fibonacci_recursion(n - 1) + fibonacci_recursion(n - 2); // recursive step
        }
    }

    public static int fibonacci_loop(int n) {
        /* Declare an array to store Fibonacci numbers. */
        int f[] = new int[n + 2]; // 1 extra to handle case, n = 0
        int i;

        /* 0th and 1st number of the series are 0 and 1*/
        f[0] = 1;
        f[1] = 1;

        for (i = 2; i <= n; i++) {
            /* Compute the next number in the series and store it */
            f[i] = f[i - 1] + f[i - 2];
        }

        return f[n];
    }

    public static boolean isOdd(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Can't accept negative arguments");
        }

        return (n == 0) ? false : isEven(n-1);
    }

    public static boolean isEven(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Can't accept negative arguments");
        }

        return (n == 0) ? true : isOdd(n-1);
    }

}//End Class Definition
