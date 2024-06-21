package org.example.bh.problem3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    public void testCase1() {
        String[] survey = {"TR", "RT", "TR"};
        int[] choices = {7, 1, 3};
        String expected = "RCJA";
        assertEquals(expected, Solution.getPersonalityType(survey, choices));
    }
}