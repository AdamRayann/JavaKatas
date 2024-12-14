package katas.exercises;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DoNTimesTest {
    DoNTimes doNTimes= new DoNTimes();
    Runnable sayHello = () -> System.out.println("Hello!");
    @Nested
    @DisplayName("Tests for valid input")
    class ValidInput {

        @Test
        @DisplayName("valid string")
        void test1() {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            PrintStream originalOut = System.out;
            System.setOut(new PrintStream(outputStream));

            try {
                // Test data


                // Call the method
                doNTimes.doNTimes(sayHello, 0);

                // Verify the captured output
                String expectedOutput = "";
                assertEquals(expectedOutput, outputStream.toString());
            } finally {
                // Restore the original System.out
                System.setOut(originalOut);
            }


        }

    }
}
