package com.synalogik.metric;

import java.util.*;
import java.util.stream.Collectors;

public class WordLengthDistribution implements WordMetric {

    private final Map<Integer, Long> lengthDistribution = new HashMap<>();

    @Override
    public void addWord(String word) {
        int length = word.length();
        lengthDistribution.compute(length, (key, count) ->
            (count == null) ? 1L: count + 1
        );
    }

    @Override
    public String getResult() {
        List<String> lines = lengthDistribution.entrySet().stream()
                .sorted((e1, e2) -> e1.getKey().compareTo(e2.getKey()))
                .map(e -> "Number of words of length " + e.getKey() + " is " + e.getValue())
                .collect(Collectors.toList());

        return String.join(System.lineSeparator(), lines) ;
    }
}
