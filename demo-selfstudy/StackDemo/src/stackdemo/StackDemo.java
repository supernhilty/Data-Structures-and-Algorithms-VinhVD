/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stackdemo;

import java.util.Stack;

/**
 *
 * @author leyen
 */
public class StackDemo {

    public static boolean isOperand(String ele) {
        if (ele.matches("[0-9]+")) {
            return true;
        }
        return false;
    }

    private static double caculator(double num1, double num2, String operator) {
        double val = 0;
        switch (operator) {
            case "+":
                val = num1 + num2;
                break;
            case "-":
                val = num1 - num2;
                break;
            case "*":
                val = num1 * num2;
                break;
            case "/":
                val = num1 / num2;
                break;
            case "%":
                val = num1 % num2;
                break;
        }
        return val;
    }

    public static double PostfixOpe(String PE) {
        double value = 0;
        Stack<String> s = new Stack<>();
        String ele[] = PE.split(" ");
        for (String x : ele) {
            if (isOperand(x)) {
                s.push(x);
            } else {
                double tmp1 = Double.parseDouble(s.pop());
                double tmp2 = Double.parseDouble(s.pop());
                value = caculator(tmp2, tmp1, x);
                s.push(value + "");
            }
        }
        return value;
    }

    public static void main(String[] args) {
        double value = PostfixOpe("12 23 1 * + 29 -");
        System.out.println("The result of the postfix operation is: " + value);
    }

}
