package org.example.bh.problem3;

import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {
        String[] survey = {"AN", "CF", "MJ", "RT", "NA"};
        int[] choices = {5, 3, 2, 7, 5};
        // result = "TCMA"

        String answer = getPersonalityType(survey, choices);

        System.out.println("최종 성격 유형 결과 => " + answer);
    }

    public static String getPersonalityType(String[] survey, int[] choices) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("R", 0);
        map.put("T", 0);
        map.put("C", 0);
        map.put("F", 0);
        map.put("J", 0);
        map.put("M", 0);
        map.put("A", 0);
        map.put("N", 0);

        // 각 성격 유형 별 획득 점수 계산
        for (int i=0; i< survey.length; i++) {
            if(choices[i] < 4) {
                String perType = survey[i].substring(0, 1);
                int currentScore = map.get(perType);
                int additionalScore = (choices[i]-4)*(-1);
                map.put(perType, currentScore+additionalScore);
            } else if(choices[i] > 4) {
                String perType = survey[i].substring(1, 2);
                int currentScore = map.get(perType);
                int additionalScore = (choices[i]-4);
                map.put(perType, currentScore+additionalScore);
            }
        }
        System.out.println("각 성격 유형 별 획득 점수 => " + map);

        // 최종 성격 유형 결과
        StringBuilder result = new StringBuilder();

        String biggerKey = (map.get("R") >= map.get("T")) ? "R" : "T";
        result.append(biggerKey);

        biggerKey = (map.get("C") >= map.get("F")) ? "C" : "F";
        result.append(biggerKey);

        biggerKey = (map.get("J") >= map.get("M")) ? "J" : "M";
        result.append(biggerKey);

        biggerKey = (map.get("A") >= map.get("N")) ? "A" : "N";
        result.append(biggerKey);

        String personalityType = result.toString();
        return personalityType;
    }
}
