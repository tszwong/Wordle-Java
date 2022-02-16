/*
 * Tester.java 
 * 
 * A program that you can use to make test calls to the methods that you 
 * write as part of your Wordle implementation. 
 */

import java.util.*;

public class Tester {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        // sample test for the includes method
        System.out.println("\nTesting includes method...");
        boolean result = Wordle.includes("hello", 'e');
        System.out.println("includes(\"hello\", 'e') returns " + result);

        // Add additional tests below to ensure that your methods
        // work correctly.
        System.out.println("isAlpha(\"Goodbye!\") returns: " + Wordle.isAlpha("Goodbye!"));
        System.out.println("isAlpha(\"Hello\") returns: " + Wordle.isAlpha("Hello"));
        System.out.println();

        System.out.println("numOccurs('l', \"hello\") returns: " + Wordle.numOccur('l', "hello"));
        System.out.println();

        System.out.println("numInSamePosn('p', \"apple\", \"maple\") returns: " + Wordle.numInSamePosn('p', "apple", "maple"));
        System.out.println("numInSamePosn('a', \"apple\", \"maple\") returns: " + Wordle.numInSamePosn('a', "apple", "maple"));
        System.out.println("numInSamePosn('a', \"java\", \"mama\") returns: " + Wordle.numInSamePosn('a', "java", "mama"));
        System.out.println();

        // tests for task 2
        System.out.println("isValidGuess(\"hello\") returns: " + Wordle.isValidGuess("hello"));
        System.out.println("isValidGuess(\"hi\") returns: " + Wordle.isValidGuess("hi"));
        System.out.println("isValidGuess(\"what?\") returns: " + Wordle.isValidGuess("what?"));
        System.out.println("isValidGuess(\"abcde\") returns: " + Wordle.isValidGuess("abcde"));
        System.out.println();

        // tests for task 3
        System.out.println("processGuess(\"heart\", \"depth\") returns: " + Wordle.processGuess("heart", "depth"));

        console.close();
    }
}
