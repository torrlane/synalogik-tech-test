package com.synalogik.metric;

import org.junit.Test;

import static org.junit.Assert.*;

public class WordCountTest {

    @Test
    public void happyPath(){
        WordCount wordCount = new WordCount();
        assertEquals("Word count = 0", wordCount.getResult());
        wordCount.addWord("a");
        assertEquals("Word count = 1", wordCount.getResult());
    }
}