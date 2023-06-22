 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infixtopostfix_stack;

import java.util.Stack;

/**
 *
 * @author leyen
 */
public class InfixToPostfix_Stack {

    public static String infixToPostfix(String infix) {
        String postfix = "";

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < infix.length(); i++) {
            char c = infix.charAt(i);

            if (Character.isLetterOrDigit(c)) {
                postfix += c;
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix += stack.peek();
                    stack.pop();
                }
                stack.pop();
            } else {
                while (!stack.isEmpty() && prec(c) <= prec(stack.peek())) {
                    postfix += stack.peek();
                    stack.pop();
                }
                stack.push(c);
            }

        }
        while (!stack.isEmpty()) {
            postfix += stack.peek();
            stack.pop();
        }

        return postfix;
    }

    public static int prec(char c) {

        switch (c) {
            case '+':
            case '-':
                return 1;

            case '*':
            case '/':
                return 2;

            case '^':
                return 3;
        }
        return -1;

    }

    public static void main(String[] args) {
        // TODO code application logic here
        String exp = "a+b*(c^d-e)^(f+g*h)-i";
       
          // Function call
        System.out.println(infixToPostfix(exp));
    }

}
