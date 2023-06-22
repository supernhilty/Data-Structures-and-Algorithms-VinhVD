/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursion;

import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author leyen
 */
public class Recursion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println(factorial(5));
        
        System.out.println(josephus(5, 2));
    }

    public static int fib(int n) {
        if (n < 2) {
            return 1; //base case
        } else {
            return fib(n - 1) + fib(n - 2); //recursion
        }
    }

    public static int factorial(int n) {
        if (n == 0) {
            return 1;
        } else {
            return factorial(n - 1) * n;
        }
    }

    public static int josephus(int n, int k) {
        if (n == 1) {
            return 1;
        }
        return (josephus(n - 1, k) + k) % n;
    }

    public static void reverseStr() throws IOException {
        char c = (char) System.in.read();
        if (c != '\n') {
            reverseStr();
            System.out.println(c);
        }
    }

    public static void DecBin(int n) {
        if (n == 0) {
            return;
        }
        DecBin(n / 2);
        System.out.println(n % 2);
    }

    public static int Combinator(int n, int k) {
        if (k == 0 || k == n) return 1;       
        return Combinator(n-1, k) + Combinator(n-1, k-1);
    }
    
    
}
