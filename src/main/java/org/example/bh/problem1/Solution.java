package org.example.bh.problem1;

import java.util.Scanner;
import java.util.Stack;

/*
*       문제 링크 -> https://euler.synap.co.kr/quiz=4
*       네이버 오피스 셀이나 마이크로소프트 엑셀과 같은 스프레드시트 프로그램은
*       열(column)을 표시하기 위해 알파벳 대문자를 사용합니다.
*       예를 들면 1열=A, 2열=B, 26열=Z 와 같이 표시되고, 26열이 넘어가면
*       앞쪽에 문자 하나를 추가해서 27열=AA, 28열=AB, 52열=AZ, 53열=BA가 되며,
*       동일한 원리로 ZZ의 다음 열은 AAA, AAB, ... 처럼 이어집니다.
*
*       숫자를 입력받으면 그 순서에 대응되는 스프레드시트 컬럼을 출력하는 프로그램을 작성하세요.
*
*       입력은 다음과 같습니다.
*       1
*       10
*       100
*       1000
*       10000
*
*       출력은 다음과 같습니다.
*       A
*       J
*       CV
*       ALL
*       NTP
* */

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
