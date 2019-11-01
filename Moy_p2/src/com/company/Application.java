package com.company;

import java.io.File;

public class Application {

    public static void main(String[] args) {
        DuplicateCounter duplicateCounter = new DuplicateCounter();

        File in = new File("problem2.txt");
        File out = new File("unique_word_counts.txt");

        duplicateCounter.count(in);
        duplicateCounter.write(out);

    }
}
