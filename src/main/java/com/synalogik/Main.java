package com.synalogik;

import com.synalogik.metric.*;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    /**
     * Read the contents of a file and print out some metrics about the words in it.
     *
     * The contents of the file should be UTF8 encoded.
     *
     * A word is assumed to be made up of alphanumeric characters (e.g. a-z, A-Z, 1-9) and '/' and '&'.
     * Any other characters are ignored.
     *
     * @param args
     * @throws IOException
     */
    public static void main(String...args) throws IOException {
        String file = args[0];

        List<WordMetric> metrics = new ArrayList<>();
        metrics.add(new WordCount());
        metrics.add(new MeanWordLength());
        metrics.add(new WordLengthDistribution());
        metrics.add(new FrequentWordLengths());

        // read content from file
        try (InputStream fIn = Files.newInputStream(Paths.get(file));
             BufferedInputStream in = new BufferedInputStream(fIn)) {
            Scanner scanner = new Scanner(in, StandardCharsets.UTF_8);

            // TODO delete as required...
            // split words by blank space and '.' ',' ':' ';'
            scanner.useDelimiter("[\\p{Blank}\\\\.,:;]+");

            // alternatively, specify that words are made up of alphanums '/' '&'
            scanner.useDelimiter("[^\\p{Alnum}\\\\/\\\\&]+");
            while (scanner.hasNext()) {
                String word = scanner.next();
                updateMetrics(metrics, word);
            }
        }

        printMetrics(metrics);
    }

    private static void updateMetrics(List<WordMetric> metrics, String word) {
        for(WordMetric m : metrics) {
            m.addWord(word);
        }
    }

    private static void printMetrics(List<WordMetric> metrics) {
        for(WordMetric m : metrics) {
            System.out.println(m.getResult());
        }
    }

}
