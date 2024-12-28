package katas.exercises;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ValidGitTreeTest {
    ValidGitTree validGitTree=new ValidGitTree();
    Map<String, List<String>> validTree = new HashMap<>();
    Map<String, List<String>> invalidTree = new HashMap<>();
    public ValidGitTreeTest() {
        validTree.put("A", List.of("B", "C"));
        validTree.put("B", List.of("D"));
        validTree.put("C", List.of());
        validTree.put("D", List.of());

        invalidTree.put("A", List.of("B"));
        invalidTree.put("B", List.of("C"));
        invalidTree.put("C", List.of("A")); // cycle
    }
    @Test
    @DisplayName("valid ")
    public void test1() {
        assertEquals(true, validGitTree.isValidGitTree(validTree));
    }
    @Test
    @DisplayName("Invalid ")
    public void test2() {
        assertEquals(false, validGitTree.isValidGitTree(invalidTree));
    }
}
