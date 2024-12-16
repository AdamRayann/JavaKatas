package katas.exercises;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TimeMeTest {

    TimeMe timeMe = new TimeMe(); // Instance no longer static

    String test1 = "Hello";
    String test2 = "World";
    String test3 = "Java";
    String test4 = "Unique";
    @Test
    @DisplayName("valid string")
    public void test1() {

        Runnable sampleFunction = () -> {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

        assertEquals(5, (int)(timeMe.measureExecutionTime(sampleFunction)/100));
    }

    @Test
    @DisplayName("valid string")
    public void test2() {
        Runnable quickFunction = () -> System.out.println("Quick task done!");
        assertEquals(0 , timeMe.measureExecutionTime(quickFunction));
    }


}
