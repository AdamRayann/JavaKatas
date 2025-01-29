package katas.exercises;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MedianFinderTest {

    @Test
    void testFindMedianWithOddElements() {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        medianFinder.addNum(3);
        assertEquals(2.0, medianFinder.findMedian());
    }

    @Test
    void testFindMedianWithEvenElements() {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        assertEquals(1.5, medianFinder.findMedian());
        medianFinder.addNum(3);
        medianFinder.addNum(4);
        assertEquals(2.5, medianFinder.findMedian());
    }

    @Test
    void testFindMedianWithNegativeNumbers() {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(-3);
        medianFinder.addNum(-1);
        medianFinder.addNum(-2);
        assertEquals(-2.0, medianFinder.findMedian());
    }

    @Test
    void testFindMedianWithDuplicateNumbers() {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(5);
        medianFinder.addNum(5);
        medianFinder.addNum(5);
        assertEquals(5.0, medianFinder.findMedian());
    }

    @Test
    void testFindMedianWithLargeNumbers() {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1000000);
        medianFinder.addNum(2000000);
        medianFinder.addNum(3000000);
        assertEquals(2000000.0, medianFinder.findMedian());
    }
}
