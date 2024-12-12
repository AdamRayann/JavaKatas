package katas.exercises;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import katas.exercises.ArrayDifference.*;
public class ArrayDifferenceTest {

    int[] testArray= {6, 500, 3, -3, 0, 6, -60};
    ArrayDifference arrayDifference = new ArrayDifference();
    @Test
    public void arrayDifference()
    {
        assertEquals(560,arrayDifference.findDifference(testArray));
    }


}
