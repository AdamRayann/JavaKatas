package katas.exercises;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MinStackTest {

    @Test
    void testPushAndTop() {
        MinStack stack = new MinStack();
        stack.push(5);
        assertEquals(5, stack.top());
        stack.push(3);
        assertEquals(3, stack.top());
        stack.push(7);
        assertEquals(7, stack.top());
    }

    @Test
    void testPop() {
        MinStack stack = new MinStack();
        stack.push(1);
        stack.push(2);
        stack.pop();
        assertEquals(1, stack.top());
    }

    @Test
    void testGetMin() {
        MinStack stack = new MinStack();
        stack.push(2);
        stack.push(3);
        stack.push(1);
        assertEquals(1, stack.getMin());
        stack.pop();
        assertEquals(2, stack.getMin());
    }

    @Test
    void testPopOnEmptyStack() {
        MinStack stack = new MinStack();
        Exception exception = assertThrows(IllegalStateException.class, stack::pop);
        assertEquals("The stack is empty", exception.getMessage());
    }

    @Test
    void testTopOnEmptyStack() {
        MinStack stack = new MinStack();
        Exception exception = assertThrows(IllegalStateException.class, stack::top);
        assertEquals("The stack is empty", exception.getMessage());
    }

    @Test
    void testGetMinOnEmptyStack() {
        MinStack stack = new MinStack();
        Exception exception = assertThrows(IllegalStateException.class, stack::getMin);
        assertEquals("The stack is empty", exception.getMessage());
    }
}
