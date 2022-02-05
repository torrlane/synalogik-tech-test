package com.synalogik.metric;

public class WordCount implements WordMetric {

    private long count = 0;
    @Override
    public void addWord(String word) {
        this.count++;
    }

    @Override
    public String getResult() {
        return "Word count = " + count;
    }
}
