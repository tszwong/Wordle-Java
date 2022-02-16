/*
 * Wordle.java 
 * 
 * An console-based implementation of a popular word-guessing game
 * 
 * starter code: Computer Science 112 staff (cs112-staff@cs.bu.edu)
 *
 * completed by: Tsz Kit Wong
 */

import java.util.*;

public class Wordle {
    // the name of a file containing a collection of English words, one word per line
    public static final String WORD_FILE = "words.txt";

    /*
     * printWelcome - prints the message that greets the user at the beginning of the game
     */  
    public static void printWelcome() {
        System.out.println();   
        System.out.println("Welcome to Wordle!");
        System.out.println("The mystery word is a 5-letter English word.");
        System.out.println("You have 6 chances to guess it.");
        System.out.println();
    }
    
    /*
     * initWordList - creates the WordList object that will be used to select
     * the mystery work. Takes the array of strings passed into main(),
     * since that array may contain a random seed specified by the user 
     * from the command line.
     */
    public static WordList initWordList(String[] args) {
        int seed = -1;
        if (args.length > 0) {
            seed = Integer.parseInt(args[0]);
        }

        return new WordList(WORD_FILE, seed);
    }

    /*
     * readGuess - reads a single guess from the user and returns it
     * inputs:
     *   guessNum - the number of the guess (1, 2, ..., 6) that is being read
     *   console - the Scanner object that will be used to get the user's inputs
     */
    public static String readGuess(int guessNum, Scanner console) {
        String guess;
        do {
            System.out.print("guess " + guessNum + ": \n");
            guess = console.next();
        } while (! isValidGuess(guess));

        return guess.toLowerCase();
    }

    /**** ADD YOUR METHODS FOR TASK 1 HERE ****/
     public static boolean includes( String s, char c){
        // takes two parameters: an arbitrary String object s followed by a single char c. The method should return the boolean literal true if c is found somewhere in s, and it should return the boolean literal false otherwise
        if (s.indexOf(c)!= -1){
            return true;
        }else{
            return false;
        }
    }
     public static boolean isAlpha(String s) {
         //takes an arbitrary String object s as its only parameter and returns true if all of the characters in s are letters of the alphabet, and returns false otherwise.
         for (int i = 0; i < s.length(); i++){
            if (Character.isAlphabetic(s.charAt(i))){
                
            }
            else {
                return false ;
            }
        }
        return true ; 
     }

     public static int numOccur(char c, String s) {
         //takes two parameters: a single char c followed by an arbitrary String object s and counts and return the number of times that c occurs in s
        int num_times = 0;
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == c){
                num_times += 1;
            }
        }
        return num_times;
    }
    public static int numInSamePosn(char c, String s1, String s2){
        //takes three parameters: a single char c followed by two String objects s1 and s2 that have the same length; counts and returns the number of times that c occurs in the same position in both s1 and s2
        int num_times = 0;
        for (int i = 0; i < s1.length(); i++){
            if (s1.charAt(i) == s2.charAt(i) && s1.charAt(i) == c && s2.charAt(i) == c){
                return num_times += 1;
            }
        }
        return num_times;
    }


    /*
     * TASK 2: Implement this method
     * 
     * isValidGuess -  takes an arbitrary string guess and returns true
     * if it is a valid guess for Wordle, and false otherwise
     */
    public static boolean isValidGuess(String guess) {
        //takes an arbitrary String object guess as its only parameter and returns a boolean value
        if (guess.length() != 5) {
            System.out.println("Your guess must be 5 letters long.");
            return false;
        }
        if (isAlpha(guess) != true){
            System.out.println("Your guess must only contain letters of the alphabet.");
            return false;
        }

        return true;
    }

    /**** ADD YOUR METHOD FOR TASKS 3 and 5 HERE. ****/

    public static boolean processGuess(String guess, String mystery){
        //two parameters: a 5-character String object guess representing a guess made by the user and a 5-character String object mystery representing the “mystery” word that the user is trying to guess; provide feedback to the user about how guess compares to mystery by printing the appropriate sequence of characters;return true if guess is equal to mystery and false otherwise
        System.out.print("  ");
        if (guess.equals(mystery)){
            for (int i = 0; i < guess.length(); i++){
                char guess_letter = guess.charAt(i);
                System.out.print(guess_letter + " ");
            }
            return true;
        } else {
            for (int i = 0; i < guess.length(); i++){
                if (guess.charAt(i) == mystery.charAt(i)){
                    System.out.print(guess.charAt(i) + " ");
                } else if (numOccur(guess.charAt(i), mystery) > 0){
                    if (numOccur(mystery.charAt(i), mystery) >= numOccur(guess.charAt(i), guess))
                        System.out.print("[" + guess.charAt(i) + "]" + " ");
                    else{
                        System.out.print("_" + " ");
                    }
                } else {
                    System.out.print("_" + " ");
                }
            }
        }

        System.out.println();
        return false;

    }

    
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        
        printWelcome();

        // Create the WordList object for the collection of possible words.
        WordList words= initWordList(args);

        // Choose one of the words as the mystery word.
        String mystery = words.getRandomWord();
        
        /*** TASK 4: Implement the rest of the main method below. ***/

        for (int i = 1; i < 7; i++){
            String guess = readGuess(i, console);
            if (processGuess(guess, mystery) == true){
                System.out.println("\nCongrats! You guessed it!");
                i = 7;
            }
            if (i == 6) {
                System.out.println();
                System.out.println();
                System.out.println("Sorry! Better luck next time!");
                System.out.println("The word was " + mystery + ".");
            }
        }

        console.close();
    }
}