package com.company.Homework8;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Duplicates {
    private String [] words;
    private HashMap<String, Integer> hm = new HashMap();
    private HashMap<Integer, String> end = new HashMap();




    public void duplicates(String filename) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(filename));
        String str = sc.nextLine();
        words = str.split(" ");
        Compare();
    }

    private void Compare(){
        for (int i = 0; i < words.length; i++){
            String now = words[i];
            for (int j = i + 1; j < words.length; j++ ){
                if (now.compareTo(words[j]) == 0 && !(hm.containsKey(words[i])) ){
                    hm.put(now, i + 1);
                    break;
                }
            }
        }
        ToSort();
    }

    private void ToSort(){
      String [] duplicates = hm.keySet().toArray(new String[0]);
      Integer [] positions = hm.values().toArray(new Integer[0]);
      for (int i = 0; i < positions.length; i++ ){
          for (int j = 0; j < positions.length - 1; j++){
              if (positions[j] > positions[ j + 1]){
                  int intTemp = positions[j];
                  positions[j] = positions[j + 1];
                  positions[j + 1] = intTemp;
                  String stringTemp = duplicates[j];
                  duplicates[j] = duplicates[j + 1];
                  duplicates[j + 1] = stringTemp;
              }
          }
      }
      ShowResult(duplicates, positions);
    }

    private void ShowResult(String[] duplicates, Integer[] positions) {
        System.out.println("Duplicates:");
        for (int i = 0; i < 3; i++){
            end.put(i ,duplicates[i].toUpperCase(Locale.ROOT));
        }
        for (int i = 0; i < end.size(); i++) {
            for (int j = end.get(i).length() - 1; j >= 0; j--) {
                System.out.print(end.get(i).charAt(j));
            }
            System.out.println("");
        }
    }
}
