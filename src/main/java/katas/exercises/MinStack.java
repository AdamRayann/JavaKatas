package katas.exercises;

import java.util.ArrayList;
import java.util.List;

/**
 * Design a stack that supports standard stack operations (push, pop, top) and also retrieves
 * the minimum element in constant time.
 */
public class MinStack {
    private List<Integer> stack;


    /** Initialize your data structure here. */
    public MinStack() {
        stack = new ArrayList<>();

    }

    public void push(int val) {
        stack.add(val);

    }

    public void pop() {
        if (!stack.isEmpty())
        {
            stack.remove(stack.size()-1);
        }
        else
            throw new IllegalStateException("The stack is empty");
    }

    public int top() {
        if (!stack.isEmpty())
        {
            return stack.getLast();
        }
        else
            throw new IllegalStateException("The stack is empty");

    }

    public int getMin() {
        if (!stack.isEmpty())
        {
            return stack.stream().min(Integer::compare).orElseThrow(()->
                    new IllegalStateException("The stack is empty"));
        }
        else
            throw new IllegalStateException("The stack is empty");

    }

    public static void main(String[] args) {
        MinStack stack = new MinStack();
        stack.push(-2);
        stack.push(0);
        stack.push(-3);
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.top());
        System.out.println(stack.getMin());
    }
}
