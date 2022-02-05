package com.synalogik.metric;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class MeanWordLength implements WordMetric{
    long count = 0;
    long sumLengths = 0;
    @Override
    public void addWord(String word) {
        count++;
        sumLengths += word.length();
    }

    @Override
    public String getResult() {
        if (count == 0) {
            return "Average word length = 0";
        }
        String value = getValueUsingNumberFormat();
        return "Average word length = " + value;
    }

    private String getValueUsingNumberFormat() {
        DecimalFormat numberFormat = new DecimalFormat("###.###");
        numberFormat.setRoundingMode(RoundingMode.UP);
        return numberFormat.format((double)sumLengths / count);
    }

}
