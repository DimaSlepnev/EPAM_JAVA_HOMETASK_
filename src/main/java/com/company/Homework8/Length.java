package com.company.Homework8;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Length {
    private String[] words;
    private HashMap<String, Integer> hm = new HashMap<>();
    private HashMap<String, Integer> end = new HashMap<>();


    public void length(String filename) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(filename));
        String str = sc.nextLine();
        words = str.split(" ");
        PutValues();
    }

    private void PutValues() {
        for (String word : words) {
            hm.put(word, word.length());
        }
        Compare();
    }

    private void Compare() {
        Integer[] lengths = hm.values().toArray(new Integer[0]);
        String[] words = hm.keySet().toArray(new String[0]);
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length - 1; j++) {
                if (lengths[j] < lengths[j + 1]) {
                    int intTemp = lengths[j];
                    lengths[j] = lengths[j + 1];
                    lengths[j + 1] = intTemp;
                    String stringTemp = words[j];
                    words[j] = words[j + 1];
                    words[j + 1] = stringTemp;
                }
            }
        }
        ShowResult(words,lengths );
    }

    private void ShowResult(String[] words, Integer[] lengths) {
        for (int i = 0; i < 3; i++){
            end.put(words[i], lengths[i]);
        }
        System.out.println("Length:");
        end.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEach(e-> System.out.println(e.getKey() + " ==> " + e.getValue()));
    }

}
