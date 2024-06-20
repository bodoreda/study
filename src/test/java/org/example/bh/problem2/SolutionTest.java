package org.example.bh.problem2;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    public void testCase1() {
        String today = "2020.01.01";
        String[] terms = {"Z 3", "D 5"};
        String[] privacies = {"2019.01.01 D", "2019.11.15 Z", "2019.08.02 D", "2019.07.01 D", "2018.12.28 Z"};

        List<Integer> expected = List.of(1, 4, 5);

        List<Integer> actual = Solution.findExpiredPrivacies(today, terms, privacies);

        assertEquals(expected, actual);
    }
}