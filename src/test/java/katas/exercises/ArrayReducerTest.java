//package katas.exercises;
//
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Nested;
//import org.junit.jupiter.api.Test;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//public class ArrayReducerTest {
//    ArrayReducer arrayReducer = new ArrayReducer();
//    int[] sampleArray = {10, 15, 7, 20, 25};
//
//
//        @Test
//        @DisplayName("valid string")
//        void test1() {
//
//
//            assertEquals(true, true);
//        }
//
//
//
//    }

package katas.exercises;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class ArrayReducerTest {

    int[] testArray= {6, 500, 3, -3, 0, 6, -60};
    ArrayDifference arrayDifference = new ArrayDifference();
    @Test
    public void arrayDifference()
    {
        assertEquals(560,arrayDifference.findDifference(testArray));
    }


}

