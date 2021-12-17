package com.company.Homework10;

import java.io.*;
import java.util.Arrays;

public class Program implements FileName {
    public static void main(String[] args) throws IOException {
        KMDA kmdaHelper = new KMDA();
        kmdaHelper.GetUsersFromCSV(FileName.fileName1 );
        kmdaHelper.GetUsersFromCSV(FileName.fileName2 );
        kmdaHelper.GetUsersFromCSV(FileName.fileName3 );
        kmdaHelper.ShowMaxSalary();
        kmdaHelper.ShowMinimumSalary();
        kmdaHelper.ShowAverageSalary();
        kmdaHelper.ShowAverageSalaryPerMonth();
        kmdaHelper.ShowIndexMaxAverageSalary();

    }


}
