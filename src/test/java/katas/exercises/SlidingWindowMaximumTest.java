package katas.exercises;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SlidingWindowMaximumTest {
    SlidingWindowMaximum slidingWindowMaximum=new SlidingWindowMaximum();
    @Test
    @DisplayName("valid ")
    public void test1(){
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        assertEquals(List.of(3, 3, 5, 5, 6, 7), slidingWindowMaximum.maxSlidingWindow(nums,k));
    }
}
