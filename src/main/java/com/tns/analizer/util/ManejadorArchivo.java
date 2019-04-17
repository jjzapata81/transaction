package com.tns.analizer.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ManejadorArchivo {
	private static final String COMA = ",";
	private static final String RUTA = "src/test/resources/transactions.csv";

	public static List<List<String>> obtenerArchivoComoMatrizDeString() throws FileNotFoundException, IOException {
		List<List<String>> records = new ArrayList<List<String>>();
    	try (BufferedReader br = new BufferedReader(new FileReader(RUTA))) {
    	    String line;
    	    while ((line = br.readLine()) != null) {
    	        String[] values = line.split(COMA);
    	        records.add(Arrays.asList(values));
    	    }
    	}
		return records;
	}
	
	public static List<Double> obtenerValoresASumar(List<List<String>> records) {
		List<Double> valoresASumar = new ArrayList<>();
		for(List<String> registro : records) {
			valoresASumar.add(Double.parseDouble(registro.get(1)));
		}
		return valoresASumar;
	}
	
	public static List<String> obtenerDatos(List<List<String>> records, int columna) {
		List<String> fechas = new ArrayList<>();
		for(List<String> registro : records) {
			fechas.add(registro.get(columna));
		}
		return fechas;
	}

}
