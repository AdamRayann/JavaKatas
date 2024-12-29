package katas.exercises;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RequirementsCoverageTest {
    RequirementsCoverage requirementsCoverage = new RequirementsCoverage();
    List<List<Integer>> testCases = List.of(
            List.of(1, 2, 3),
            List.of(1, 4),
            List.of(2, 3, 4),
            List.of(1, 5),
            List.of(3, 5)
    );
    @Test
    @DisplayName("valid ")
    public void test1(){
        assertEquals(List.of(2,3), requirementsCoverage.selectMinimalTestCases(testCases));
    }

}
