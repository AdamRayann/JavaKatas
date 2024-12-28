package katas.exercises;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SemanticVersionComparatorTest {
    SemanticVersionComparator semanticVersionComparator=new SemanticVersionComparator();

    @Test
    @DisplayName("valid ")
    public void test1() {
        assertEquals(-1, semanticVersionComparator.compareVersions("1.0.0", "1.0.1"));
    }
    @Test
    @DisplayName("valid ")
    public void test2() {
        assertEquals(1, semanticVersionComparator.compareVersions("2.1.0", "1.9.9"));
    }
    @Test
    @DisplayName("valid ")
    public void test3() {
        assertEquals(0, semanticVersionComparator.compareVersions("1.2.3", "1.2.3"));
    }
}
