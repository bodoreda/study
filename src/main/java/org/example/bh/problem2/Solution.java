package org.example.bh.problem2;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 2023 KAKAO BLIND RECRUITMENT > 개인정보 수집 유효기간
// https://school.programmers.co.kr/learn/courses/30/lessons/150370

public class Solution {
    public static void main(String[] args) {
        String today = "2022.05.19";
        String[] terms = {"A 6", "B 12", "C 3"};
        String[] privacies = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};

        List<Integer> answer = findExpiredPrivacies(today, terms, privacies);

        System.out.println("result(개인정보 파기 대상 번호) : " + answer);  // [1, 3]
    }

    public static List<Integer> findExpiredPrivacies(String todayStr, String[] terms, String[] privacies) {
        List<Integer> answer = new ArrayList<>();

        // terms를 HashMap에 옮겨담고 k/v로 관리
        Map<String, Integer> termsMap = new HashMap<>();
        for (String term : terms) {
            String[] parts = term.split(" ");
            String key = parts[0];
            int value = Integer.parseInt(parts[1]);
            termsMap.put(key, value);
        }

        // String to Date
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
        LocalDate today_dateType = LocalDate.parse(todayStr, formatter);

        // privacies
        int pnum = 1;   // 개인정보 primary key
        for (String privacy : privacies) {
            String[] parts = privacy.split(" ");

            LocalDate date = LocalDate.parse(parts[0], formatter);  // String to Date

            int exp_period = termsMap.get(parts[1]); // 유효기간(Month)

            LocalDate delDate = date.plusMonths(exp_period);    // 개인정보 파기 날짜

            if (today_dateType.isAfter(delDate) || today_dateType.equals(delDate)) {  // 개인정보 파기 대상
                answer.add(pnum);
            }
            pnum += 1;
        }

        return answer;
    }
}
