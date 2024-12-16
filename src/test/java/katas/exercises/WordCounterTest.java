package katas.exercises;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordCounterTest {

    WordCounter wordCounter = new WordCounter(); // Instance no longer static


    @Test
    @DisplayName("Should return 0 for null input")
    public void shouldReturnZeroForNullInput() {
        assertEquals(0, wordCounter.countWords(null));
    }

    @Test
    @DisplayName("Should return 0 for empty string")
    public void shouldReturnZeroForEmptyString() {
        assertEquals(0, wordCounter.countWords(""));
    }




    @Test
    @DisplayName("valid string")
    public void test1() {
        assertEquals(1, wordCounter.countWords("null"));
    }

    @Test
    @DisplayName("valid string")
    public void test2() {
        assertEquals(4, wordCounter.countWords("one two three four"));
    }

    @Test
    @DisplayName("valid string")
    public void test3() {
        assertEquals(2, wordCounter.countWords("hello world!"));
    }


}
