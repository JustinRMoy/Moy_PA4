package com.company;

import java.io.*;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class DuplicateRemover {

    private Set<String> uniqueWords = new HashSet<String>();

    private void closeFileInput(FileInputStream file) {
        try {
            if (file != null) {
                file.close();
            }
        } catch (IOException excpt) {
            System.out.println("Error closing file: " + excpt.getMessage());
        }
    }

    private void closeFileOutput(FileOutputStream file) {
        try {
            if (file != null) {
                file.close();
            }
        } catch (IOException excpt) {
            System.out.println("Error closing file: " + excpt.getMessage());
        }
    }

    protected void remove(File dataFile) {
        FileInputStream file = null;
        try {

            file = new FileInputStream(dataFile);
            Scanner in = new Scanner(file);

            while (in.hasNext()) {
                uniqueWords.add(in.next());
            }

        } catch (IOException excpt) {
            System.out.println("Error opening file: " + excpt.getMessage());
        } finally {
            closeFileInput(file);
        }
    }

    protected void write(File outputFile) {
        FileOutputStream file = null;
        try {
            file = new FileOutputStream(outputFile);
            PrintWriter pen = new PrintWriter(file);

            Iterator it = uniqueWords.iterator();

            while (it.hasNext()) {
                pen.println(it.next());
            }
            pen.flush();

        } catch (IOException excpt) {
            System.out.println("Error opening file: " + excpt.getMessage());
        } finally {
            closeFileOutput(file);
        }
    }
}
