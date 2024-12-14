package katas.exercises;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordCounterTest {

    WordCounter wordCounter = new WordCounter(); // Instance no longer static

    @Nested
    @DisplayName("Tests for Invalid input")
    class InvalidInput {

        @Test
        @DisplayName("Should return 0 for null input")
        void shouldReturnZeroForNullInput() {
            assertEquals(0, wordCounter.countWords(null));
        }

        @Test
        @DisplayName("Should return 0 for empty string")
        void shouldReturnZeroForEmptyString() {
            assertEquals(0, wordCounter.countWords(""));
        }
    }

    @Nested
    @DisplayName("Tests for valid input")
    class ValidInput {

        @Test
        @DisplayName("valid string")
        void test1() {
            assertEquals(1, wordCounter.countWords("null"));
        }

        @Test
        @DisplayName("valid string")
        void test2() {
            assertEquals(4, wordCounter.countWords("one two three four"));
        }

        @Test
        @DisplayName("valid string")
        void test3() {
            assertEquals(2, wordCounter.countWords("hello world!"));
        }
    }

}
