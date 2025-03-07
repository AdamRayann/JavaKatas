package katas.exercises;

import java.util.Stack;

public class ValidParentheses {

    /**
     * Checks if a given string has valid parentheses (try in O(n)).
     *
     * A string has valid parentheses if:
     * 1. Every opening parenthesis has a matching closing parenthesis.
     * 2. The parentheses are correctly nested.
     *
     * @param s the input string containing parentheses
     * @return true if the string has valid parentheses, false otherwise
     */
    public static boolean isValidParentheses(String s) {
        Stack<Character> stack = new Stack<Character>();

        if(s.isEmpty())
            return true;
        for(char c : s.toCharArray())
        {
            if (stack.empty())
            {
                stack.push(c);
            }
            else
            {
                if(stack.peek()+1==c && stack.peek().equals('(') || stack.peek()+2==c)
                {
                    stack.pop();
                }
                else
                {
                    stack.push(c);
                }
            }
        }
        if (stack.empty())
            return true;
        return false;
    }

    public static void main(String[] args) {
        String validInput = "()[]{}";
        String invalidInput1 = "(]";
        String invalidInput2 = "([)]";
        String validInputNested = "{[()]}";

        System.out.println("Is valid: " + isValidParentheses(validInput));
        System.out.println("Is valid: " + isValidParentheses(invalidInput1));
        System.out.println("Is valid: " + isValidParentheses(invalidInput2));
        System.out.println("Is valid: " + isValidParentheses(validInputNested));
    }
}
