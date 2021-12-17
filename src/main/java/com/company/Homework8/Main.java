package com.company.Homework8;

import java.io.FileNotFoundException;

public class Main {
        public static void main(String[] args) throws FileNotFoundException {
            Frequency words = new Frequency();
            words.frequency("note.txt");
            Length words1 = new Length();
            words1.length("note.txt");
            Duplicates words2 = new Duplicates();
            words2.duplicates("note.txt");
        }

}
