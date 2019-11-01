package com.company;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class DuplicateCounter {

    private HashMap<String, Integer> wordCounter= new HashMap<String, Integer>();

    private void closeFileInput(FileInputStream file){
        try{
            if(file != null){
               file.close();
            }
        }catch (IOException excpt){
            System.out.println("Error closing file: " + excpt.getMessage());
        }
    }

    private void closeFileOutput(FileOutputStream file){
        try{
            if(file != null){
                file.close();
            }
        }catch (IOException excpt){
            System.out.println("Error closing file: " + excpt.getMessage());
        }
    }

    protected void count(File dataFile){
        FileInputStream input = null;
        try{
            input = new FileInputStream(dataFile);
            Scanner in = new Scanner(input);
            String temp;

            while(in.hasNext()) {
                temp = in.next();
                if (wordCounter.containsKey(temp))
                    wordCounter.put(temp, wordCounter.get(temp) + 1);
                else
                    wordCounter.put(temp, 1);
            }

            in.close();
        }catch (FileNotFoundException excpt){
            System.out.println("Error opening file: " + excpt.getMessage());
        }finally {
            closeFileInput(input);
        }
    }

    protected void write(File outputFile){
        FileOutputStream out = null;
        try{
            out = new FileOutputStream(outputFile);
            PrintWriter pen = new PrintWriter(out);

            pen.println("The original words: " + wordCounter.keySet());
            pen.println("Occurence of each word: " + wordCounter.values());

            pen.flush();
            pen.close();
        }catch (IOException excpt){
            System.out.println("Error opening file: " + excpt.getMessage());
        }finally {
            closeFileOutput(out);
        }
    }

}
