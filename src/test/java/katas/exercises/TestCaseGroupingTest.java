package katas.exercises;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCaseGroupingTest {
    TestCaseGrouping testCaseGrouping= new TestCaseGrouping();
    List<Integer> testCaseGroupSizes1 = List.of(1, 2, 3, 3, 3, 2);
    @Test
    @DisplayName("valid ")
    public void test1() {
        List<List<Integer>> expected = List.of(
                List.of(0),        // Group of size 1
                List.of(1, 5),     // Group of size 2
                List.of(2, 3, 4)   // Group of size 3
        );
        assertEquals(expected, testCaseGrouping.groupTestCases(testCaseGroupSizes1));
    }
}
