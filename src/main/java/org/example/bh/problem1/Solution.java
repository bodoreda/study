package org.example.bh.problem1;

import java.util.Scanner;
import java.util.Stack;

public class Solution {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        long inputNum = sc.nextLong();

        Stack<Long> stack = new Stack<>();

        while (inputNum > 0) {
            long remainder = inputNum % 26;
            stack.push(remainder);
            inputNum = inputNum / 26;
        }

        StringBuilder result = new StringBuilder();

        while (!stack.isEmpty()) {
            char alphabet = (char) (stack.pop() + 64);
            result.append(alphabet);
        }

        System.out.println(result);
    }
}
