package katas.exercises;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TrueCounterTest {

    TrueCounter trueCounter = new TrueCounter(); // Instance no longer static


    @Nested
    @DisplayName("Tests for valid input")
    class ValidInput {
        boolean[] test1 = {true, false, true, true, false};
        @Test
        @DisplayName("valid string")
        void test1() {
            assertEquals(3, trueCounter.countTrueValues(test1));
        }


    }
}
