package org.example.bh.problem1;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void testSolution() {
        // (input, expectedOutput)
        List<String[]> testCases = Arrays.asList(
                new String[]{"1", "A"},
                new String[]{"10", "J"},
                new String[]{"100", "CV"},
                new String[]{"1000", "ALL"},
                new String[]{"10000", "NTP"}
        );

        for (String[] testCase : testCases) {
            String input = testCase[0];
            String expectedOutput = testCase[1];

            // 입력값 설정
            ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
            System.setIn(in);

            // 테스트 할 코드 실행 및 결과 캡처
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            System.setOut(new PrintStream(out));
            Solution.main(new String[0]);
            String actualOutput = out.toString().trim();

            // 예상 결과와 비교
            assertEquals(expectedOutput, actualOutput);
        }
    }
}