package com.company;

import java.io.File;

public class Application {

    public static void main(String[] args) throws Exception {

        DuplicateRemover duplicateRemover = new DuplicateRemover();

        File fp = new File("problem1.txt");
        File out = new File("unique_words.txt");

        duplicateRemover.remove(fp);
        duplicateRemover.write(out);
    }
}
