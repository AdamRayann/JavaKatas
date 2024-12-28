package katas.exercises;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaxStorageCapacityTest {
    MaxStorageCapacity maxStorageCapacity=new MaxStorageCapacity();
    @Test
    @DisplayName("valid ")
    public void test1() {
        int[] containers = {2, 1, 5, 6, 2, 2};

        // Compare the actual parsed log with the expected one
        assertEquals(10, maxStorageCapacity.maxStorageArea(containers));
    }
}
