package katas.exercises;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LongestCommonPrefixTest {
    LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix(); // Instance no longer static



    String[] test1 = {"flower", "flow", "flight"};
    String[] test2 = {"dog", "racecar", "car"};
    String[] test3 = {"interspecies", "interstellar", "interstate"};
    String[] test4 = {"apple", "apricot", "ape"};
    @Test
    @DisplayName("valid string")
    public void test1() {

        assertEquals("fl", longestCommonPrefix.longestCommonPrefix(test1));
    }
    @Test
    @DisplayName("valid string")
    public void test2() {

        assertEquals("", longestCommonPrefix.longestCommonPrefix(test2));
    }
    @Test
    @DisplayName("valid string")
    public void test3() {

        assertEquals("inters", longestCommonPrefix.longestCommonPrefix(test3));
    }
    @Test
    @DisplayName("valid string")
    public void test4() {

        assertEquals("ap", longestCommonPrefix.longestCommonPrefix(test4));
    }



}
