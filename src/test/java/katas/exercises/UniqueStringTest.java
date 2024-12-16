package katas.exercises;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UniqueStringTest {
    UniqueString uniqueString = new UniqueString(); // Instance no longer static

//tested
    @Nested
    @DisplayName("Tests for valid input")
    class ValidInput {
        String test1 = "Hello";
        String test2 = "World";
        String test3 = "Java";
        String test4 = "Unique";
        @Test
        @DisplayName("valid string")
        void test1() {
            assertEquals(false, uniqueString.isUnique(test1));
        }

        @Test
        @DisplayName("valid string")
        void test2() {
            assertEquals(true , uniqueString.isUnique(test2));
        }

        @Test
        @DisplayName("valid string")
        void test3() {
            assertEquals(false, uniqueString.isUnique(test3));
        }

        @Test
        @DisplayName("valid string")
        void test4() {
            assertEquals(false, uniqueString.isUnique(test4));
        }
    }
}
