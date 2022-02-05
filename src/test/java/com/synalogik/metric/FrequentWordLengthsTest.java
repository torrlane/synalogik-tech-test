package com.synalogik.metric;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FrequentWordLengthsTest {
    private FrequentWordLengths fwl;

    @Before
    public void setUp() {
        this.fwl = new FrequentWordLengths();
    }

    @Test
    public void empty() {
        assertEquals("", fwl.getResult());
    }

    /**
     * If there is a clear 'winner'. In this case there are more words with length 4 than any other word length.
     */
    @Test
    public void distinctWordCounts() {
        fwl.addWord("1");
        fwl.addWord("11");
        fwl.addWord("22");
        fwl.addWord("1111");
        fwl.addWord("2222");
        fwl.addWord("3333");
        assertEquals("The most frequently occurring word length is 3, for word lengths of 4", fwl.getResult());
    }

    /**
     * If there is a tie i.e there are 2 word lengths with equal highest count,
     * then they should both be included in the output
     * and they should be separated by '&'
     */
    @Test
    public void duplicateWordCounts() {
        fwl.addWord("1");
        fwl.addWord("2");
        fwl.addWord("3");
        fwl.addWord("11");
        fwl.addWord("22");
        fwl.addWord("1111");
        fwl.addWord("2222");
        fwl.addWord("3333");
        assertEquals("The most frequently occurring word length is 3, for word lengths of 1 & 4", fwl.getResult());
    }

    /**
     * If there is a multi way tie i.e there are 3+ word lengths with equal highest count,
     * then they should both be included in the output
     * and they should be separated by ',' and '&'
     */
    @Test
    public void multipleDuplicateWordCounts() {
        fwl.addWord("1");
        fwl.addWord("11");
        fwl.addWord("1111");
        assertEquals("The most frequently occurring word length is 1, for word lengths of 1, 2 & 4", fwl.getResult());
    }
}