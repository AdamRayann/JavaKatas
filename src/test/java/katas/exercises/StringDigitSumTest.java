package katas.exercises;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringDigitSumTest
{

    StringDigitSum stringDigitSum = new StringDigitSum(); // Instance no longer static


    @Nested
    @DisplayName("Tests for valid input")
    class ValidInput {

        @Test
        @DisplayName("valid string")
        void test1() {
            String input1 = "abc123";


            assertEquals(6, (stringDigitSum.sumOfDigits(input1)));
        }

        @Test
        @DisplayName("valid string")
        void test2() {
            String input2 = "5 cats and 2 dogs";

            assertEquals(7 , stringDigitSum.sumOfDigits(input2));
        }

        @Test
        @DisplayName("valid string")
        void test3() {
            String input3 = "No digits here!";

            assertEquals(0 , stringDigitSum.sumOfDigits(input3));
        }
    }
}
