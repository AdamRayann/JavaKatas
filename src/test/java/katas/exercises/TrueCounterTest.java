package katas.exercises;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TrueCounterTest {

    TrueCounter trueCounter = new TrueCounter(); // Instance no longer static

    boolean[] test1 = {true, false, true, true, false};
    @Test
    @DisplayName("valid string")
    public void test1() {
        assertEquals(3, trueCounter.countTrueValues(test1));
    }



}
