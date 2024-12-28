package katas.exercises;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ValidParenthesesTest {
    ValidParentheses validParentheses=new ValidParentheses();
    String validInput = "()[]{}";
    String invalidInput1 = "(]";
    String invalidInput2 = "([)]";
    String validInputNested = "{[()]}";
    @Test
    @DisplayName("valid string")
    public void test1() {
        assertEquals(true, validParentheses.isValidParentheses(validInput));
    }
    @Test
    @DisplayName("invalid string")
    public void test2() {
        assertEquals(false, validParentheses.isValidParentheses(invalidInput1));
    }
    @Test
    @DisplayName("invalid string")
    public void test3() {
        assertEquals(false, validParentheses.isValidParentheses(invalidInput2));
    }
    @Test
    @DisplayName("valid string")
    public void test4() {
        assertEquals(true, validParentheses.isValidParentheses(validInputNested));
    }

}
