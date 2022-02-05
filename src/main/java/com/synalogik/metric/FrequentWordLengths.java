package com.synalogik.metric;

import java.util.*;
import java.util.stream.Collectors;

public class FrequentWordLengths implements  WordMetric {

    private final Map<Integer, Long> lengthDistribution = new HashMap<>();
    @Override
    public void addWord(String word) {
        int length = word.length();
        Long count;
        if (lengthDistribution.containsKey(length)) {
            count = lengthDistribution.get(length);
        } else {
            count = 0l;
        }
        count = count + 1;
        lengthDistribution.put(length, count);

    }

    @Override
    public String getResult() {
        Long maxWordCount = getMaxWordCount();

        if (maxWordCount == 0L) {
            return ""; // TODO is this an 'exceptional' circumstance?
        }
        List<String> mostFrequentlyOccurringWordLengths  = lengthDistribution.entrySet().stream()
                .filter(e -> e.getValue().longValue() == maxWordCount)
                .map(Map.Entry::getKey)
                .map(Object::toString)
                .collect(Collectors.toList());

        String mostFrequent = String.join(", ", mostFrequentlyOccurringWordLengths);

        // replace the last occurrence of ',' with '&'
        String reversed = new StringBuilder(mostFrequent)
                .reverse().toString()
                .replaceFirst(" ,", " & "); // <-- note that the ", " delimiter has been reversed here.
        String mostFrequent2 = new StringBuilder(reversed).reverse().toString();

        String result = "The most frequently occurring word length is "
                + maxWordCount + ", for word lengths of " + mostFrequent2;
        return result ;
    }

    private Long getMaxWordCount() {
        return lengthDistribution.values().stream()
                .max(Long::compareTo)
                .orElse(0L);
    }
}
