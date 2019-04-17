package com.tns.analizer;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;

import static org.junit.Assert.assertTrue;

public class BankTransactionAnalyzerSimpleTest {

    @Test
    public void mustReadFile() throws FileNotFoundException {
        BankTransactionAnalyzerSimple analizer = new BankTransactionAnalyzerSimple();
        analizer.execute();
    }

    @Test
    public void valorPoitivoMonto() throws IOException {
       BankTransactionAnalyzerSimple prueba = new BankTransactionAnalyzerSimple();
        assertTrue(prueba.monto_total()>0);
    }
    @Test
    public void valorPositivoMontoMes() throws IOException, ParseException {
        BankTransactionAnalyzerSimple prueba = new BankTransactionAnalyzerSimple();
        assertTrue(prueba.monto_mes("01")>0);
    }
    @Test
    public void categoriaConMasGasto() throws IOException, ParseException {
        BankTransactionAnalyzerSimple prueba = new BankTransactionAnalyzerSimple();
        assertTrue(prueba.categoriaConMasGasto().equals("Entretenimiento"));
    }
    @Test
    public void categoriaConMayorIngreso() throws IOException, ParseException {
        BankTransactionAnalyzerSimple prueba = new BankTransactionAnalyzerSimple();
        assertTrue(prueba.categoriaConMayorIngreso().equals("Ventas netas"));
    }


}
