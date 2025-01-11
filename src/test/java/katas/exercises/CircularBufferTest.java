package katas.exercises;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CircularBufferTest {

    private CircularBuffer circularBuffer;

    @BeforeEach
    void setUp() {
        circularBuffer = new CircularBuffer(3); // Initialize a buffer with a capacity of 3
    }

    @Test
    void testAddAndGet() {
        circularBuffer.add(1);
        circularBuffer.add(2);
        circularBuffer.add(3);

        assertEquals(1, circularBuffer.get(), "The oldest element should be 1");

        circularBuffer.add(4); // Overwrites the oldest element (1)
        assertEquals(2, circularBuffer.get(), "The oldest element should now be 2 after overwrite");

        circularBuffer.add(5); // Overwrites the next oldest element (2)
        assertEquals(3, circularBuffer.get(), "The oldest element should now be 3 after overwrite");
    }

    @Test
    void testIsFull() {
        assertFalse(circularBuffer.isFull(), "Buffer should not be full initially");

        circularBuffer.add(1);
        circularBuffer.add(2);
        circularBuffer.add(3);

        assertTrue(circularBuffer.isFull(), "Buffer should be full after adding 3 elements");

        circularBuffer.add(4); // Overwrites an element
        assertTrue(circularBuffer.isFull(), "Buffer should remain full after overwriting");
    }

    @Test
    void testIsEmpty() {
        assertTrue(circularBuffer.isEmpty(), "Buffer should be empty initially");

        circularBuffer.add(1);
        assertFalse(circularBuffer.isEmpty(), "Buffer should not be empty after adding an element");
    }

    @Test
    void testGetFromEmptyBuffer() {
        assertEquals(-1, circularBuffer.get(), "Getting from an empty buffer should return -1");
    }

    @Test
    void testCircularBehavior() {
        circularBuffer.add(1);
        circularBuffer.add(2);
        circularBuffer.add(3);

        assertEquals(1, circularBuffer.get(), "The oldest element should be 1");

        circularBuffer.add(4); // Overwrites 1
        assertEquals(2, circularBuffer.get(), "The oldest element should now be 2 after overwrite");

        circularBuffer.add(5); // Overwrites 2
        assertEquals(3, circularBuffer.get(), "The oldest element should now be 3 after overwrite");

        circularBuffer.add(6); // Overwrites 3
        assertEquals(4, circularBuffer.get(), "The oldest element should now be 4 after overwrite");
    }


}
