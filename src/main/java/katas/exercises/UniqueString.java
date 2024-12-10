package katas.exercises;

import java.util.HashSet;

public class UniqueString {

    /**
     * Checks if a string has all unique characters (case-insensitive).
     *
     * @param str the input string
     * @return true if all characters are unique, false otherwise
     */
    public static boolean isUnique(String str) {
        return true;
    }

    public static void main(String[] args) {
        String test1 = "Hello";
        String test2 = "World";
        String test3 = "Java";
        String test4 = "Unique";

        System.out.println("\"" + test1 + "\" has all unique characters: " + isUnique(test1));
        System.out.println("\"" + test2 + "\" has all unique characters: " + isUnique(test2));
        System.out.println("\"" + test3 + "\" has all unique characters: " + isUnique(test3));
        System.out.println("\"" + test4 + "\" has all unique characters: " + isUnique(test4));
    }
}