package com.synalogik.metric;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class WordLengthDistributionTest {

    private WordLengthDistribution wld;

    @Before
    public void setup(){
        wld = new WordLengthDistribution();
    }

    @Test
    public void empty(){
        assertEquals("", wld.getResult());
    }

    /**
     * The data should be presented in length order - shortest lengths first.
     */
    @Test
    public void outputInOrder(){
        wld.addWord("ab");
        wld.addWord("abc");
        wld.addWord("a");
        String expected = String.join(System.lineSeparator(),
                line(1, 1),
                line(2, 1),
                line(3, 1));
        assertEquals(expected, wld.getResult());
    }

    /**
     * If there are no words of a particular length, then there should be no output for that length
     */
    @Test
    public void skipEmptyLengths() {
        wld.addWord("ab");
        wld.addWord("abcde");String expected = String.join(System.lineSeparator(),
                line(2, 1),
                line(5, 1));
        assertEquals(expected, wld.getResult());
    }

    private String line(int length, int count) {
        return "Number of words of length " + length + " is " + count;
    }
}