package com.synalogik.metric;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MeanWordLengthTest {

    private MeanWordLength mwl;

    @Before
    public void setUp() {
        mwl = new MeanWordLength();
    }

    @Test
    public void outputShouldBeTo3DP() {
        mwl.addWord("12345");
        mwl.addWord("1234");
        mwl.addWord("1");
        Assert.assertEquals("Average word length = 3.334", mwl.getResult());
    }

    @Test
    public void outputCanHave2DP() {
        mwl.addWord("1");
        mwl.addWord("2");
        mwl.addWord("3");
        mwl.addWord("45");
        Assert.assertEquals("Average word length = 1.25", mwl.getResult());
    }

    @Test
    public void outputShouldNotIncludeDecimalPoint() {
        mwl.addWord("1234");
        Assert.assertEquals("Average word length = 4", mwl.getResult());
    }

    @Test
    public void emptyTextShouldHaveMeanLengthOfZero() {
        MeanWordLength meanWordLength = new MeanWordLength();
        Assert.assertEquals("Average word length = 0", meanWordLength.getResult());
    }
}
