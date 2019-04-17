package com.tns.analizer;

import org.junit.Test;

import java.util.Scanner;

public class BankTransactionAnalyzerSimpleTest {

    @Test
    public void mustReadFile(){
        BankTransactionAnalyzerSimple analizer = new BankTransactionAnalyzerSimple();
        analizer.execute();

        AnalizerApplicationTests test = new AnalizerApplicationTests();

        Scanner sc = new Scanner("./transactions.csv");





    }
}
