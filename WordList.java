/*
 * WordList.java
 * 
 * A WordList object represents a collection of 5-letter English words 
 * in which each word is associated with a unique integer key.
 * It allows Wordle to select a 5-letter word at random.
 * 
 * Computer Science 112, Boston University
 * 
 * You should *NOT* modify this file.
 */

import java.io.*;
import java.util.*;

public class WordList {
    // key = an integer
    // value = a 5-letter word
    private HashMap<Integer, String> contents;
    
    // random-number generator
    private Random rand;
    
    /*
     * constructor for a WordList object that is built from a text file
     * with the specified file name. In the text file, the words should appear
     * one word per line. Only the 5-letter words from the text file 
     * will be added to the WordList. 
     * 
     * To allow for repeatable results, you can pass in an integer for the second 
     * parameter that will be used as the seed of the random-number generator
     * that allows us to select a word at random. For non-repeatable results, 
     * you should pass in -1 for the random
     */
    public WordList(String fileName, int randomSeed) {
        this.contents = new HashMap<Integer, String>();
 
        if (randomSeed != -1) {
            this.rand = new Random(randomSeed);
        } else {
            this.rand = new Random();
        }

        try {
            Scanner f = new Scanner(new File(fileName));
            
            int i = 0;
            while (f.hasNextLine()) {
                String word = f.nextLine();
                if (word.length() == 5) {
                    this.contents.put(i, word);
                    i++;
                }
            }
            
            f.close();
        } catch (FileNotFoundException e) {
            throw new IllegalStateException("could not process file of words");
        }
    }



    /*
     * getRandomWord - randomly selects one of the 5-letter words stored in 
     * the WordList and returns it
     */
    public String getRandomWord() {
        int whichOne = Math.abs(this.rand.nextInt()) % this.contents.size();
        return this.contents.get(whichOne);
    }
}