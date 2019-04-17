package com.tns.analizer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import org.junit.Test;

import com.tns.analizer.util.ManejadorArchivo;

public class BankTransactionAnalyzerSimpleTest {

    @Test
    public void mustReadFile(){
        BankTransactionAnalyzerSimple analizer = new BankTransactionAnalyzerSimple();
        analizer.execute();
    }
    
    @Test
    public void cualEsElMontoTotalDelArchivo() throws FileNotFoundException, IOException {
    	BankTransactionAnalyzerSimple bankTransactionAnalyzerSimple = new BankTransactionAnalyzerSimple();
    	List<Double> valores = Arrays.asList(2000000.0, -1000000.0, 4920000.0, 3000000.0, -1000000.0);
    	assertEquals(7920000, bankTransactionAnalyzerSimple.obtenerSumatoria(valores), 0);
    }
    
    @Test
    public void elMontoEsPositivo() throws FileNotFoundException, IOException {
    	BankTransactionAnalyzerSimple bankTransactionAnalyzerSimple = new BankTransactionAnalyzerSimple();
    	assertTrue(bankTransactionAnalyzerSimple.esPositivo(1));
    }
    
    @Test
    public void elMontoEsNegativo() throws FileNotFoundException, IOException {
    	BankTransactionAnalyzerSimple bankTransactionAnalyzerSimple = new BankTransactionAnalyzerSimple();
    	assertFalse(bankTransactionAnalyzerSimple.esPositivo(-3));
    }
    
    @Test
    public void obtenerCalendariosTest() throws FileNotFoundException, IOException, ParseException {
    	List<String> fechas = new ArrayList<>();
    	fechas.add("12-11-2009");
    	fechas.add("11-02-2004");
    	BankTransactionAnalyzerSimple bankTransactionAnalyzerSimple = new BankTransactionAnalyzerSimple();
    	assertEquals(Calendar.NOVEMBER, bankTransactionAnalyzerSimple.obtenerCalendarios(fechas).get(0).get(Calendar.MONTH));
    }
    
    @Test
    public void cualEsElMontoTotalDeEnero() throws FileNotFoundException, IOException, ParseException {
    	List<Double> montos = Arrays.asList(2000000.0, -1000000.0, 4920000.0, 3000000.0, -1000000.0);
    	List<String> fechas = Arrays.asList("12-01-2015", "12-01-2015", "12-02-2015", "12-02-2015", "12-01-2015");
    	BankTransactionAnalyzerSimple bankTransactionAnalyzerSimple = new BankTransactionAnalyzerSimple();
    	assertEquals(0, bankTransactionAnalyzerSimple.montoTotalEnEnero(montos, fechas),0);
    }
    
    @Test
    public void montoTotalCategoriaCobroCuenta() throws FileNotFoundException, IOException{
    	String categoria = "Cobro cuenta";
    	BankTransactionAnalyzerSimple bankTransactionAnalyzerSimple = new BankTransactionAnalyzerSimple();
    	assertEquals(2500000, bankTransactionAnalyzerSimple.obtenerSumatoriaPorCategoria(categoria),0);
    }
    
    @Test
    public void cualEsLaCategoriaQueMayorGastoMeRepresenta() throws FileNotFoundException, IOException{
    	List<String> categorias = ManejadorArchivo.obtenerDatos(ManejadorArchivo.obtenerArchivoComoMatrizDeString(),2);
    	String categoria = "Entretenimiento";
    	BankTransactionAnalyzerSimple bankTransactionAnalyzerSimple = new BankTransactionAnalyzerSimple();
    	assertEquals(categoria, bankTransactionAnalyzerSimple.obtenerCategoriaQueMayorGastoMeRepresenta(categorias));
    }
}
