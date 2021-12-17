package com.company.Homework8;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Frequency {
    private String[] words;
    private HashMap<String, Integer> hm = new HashMap<>();
    private HashMap<String, Integer> end = new HashMap<>();


    public void frequency(String filename) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(filename));
        String str = sc.nextLine();
        words = str.split(" ");
        CompareAndCalculateFrequency();
    }

    private void CompareAndCalculateFrequency() {
        for (int i = 0; i < words.length; i++) {
            if (hm.containsKey(words[i])) {
                hm.put(words[i], hm.get(words[i]) + 1);
            } else {
                hm.put(words[i], 1);
            }
        }
        Integer[] frequences = hm.values().toArray(new Integer[0]);
        String[] words = hm.keySet().toArray(new String[0]);
        for (int i = 0; i < frequences.length; i++) {
            for (int j = 0; j < frequences.length - 1; j++) {
                if (frequences[j] < frequences[j + 1]) {
                    int intTemp = frequences[j];
                    frequences[j] = frequences[j + 1];
                    frequences[j + 1] = intTemp;
                    String stringTemp = words[j];
                    words[j] = words[j + 1];
                    words[j + 1] = stringTemp;
                }
            }
        }
        ShowResult(words, frequences);
    }

    private void ShowResult(String[] words, Integer[] freq) {
        for (int i = 0; i < 3; i++) {
            end.put(words[i], freq[i]);
        }
        System.out.println("Frequency:");
        end.entrySet().stream()
                .sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))
                .forEach(e-> System.out.println(e.getKey() + " ==> " + e.getValue()));

    }
}
