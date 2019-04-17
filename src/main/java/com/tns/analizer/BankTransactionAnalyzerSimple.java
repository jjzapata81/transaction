package com.tns.analizer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.tns.analizer.util.FechaUtil;
import com.tns.analizer.util.ManejadorArchivo;

public class BankTransactionAnalyzerSimple {
    public void execute() {
        try{
            System.out.println("Estamos listos para empezar!!");
        }catch (Exception e){
            System.out.println("Error...");
            System.out.println(e.getMessage());
        }

    }
    
    public double obtenerSumatoria(List<Double> valoresASumar) {
    	double sumatoria = 0;
    	for(double valor : valoresASumar) {
    		sumatoria = sumatoria + valor;
    	}
    	return sumatoria;
    }
    
    public boolean esPositivo(double monto) {
    	return monto > 0;
    }
    
    public double montoTotalEnEnero(List<Double> montos, List<String> fechas) throws ParseException {
    	List<Calendar> calendarios = obtenerCalendarios(fechas);
    	double sumatoria = 0;
    	for(int i = 0; i< calendarios.size(); i++) {
    		if(calendarios.get(i).get(Calendar.MONTH) == Calendar.JANUARY) {
    			sumatoria = sumatoria + montos.get(i);
    		}
    	}
    	return sumatoria;
    }

	public List<Calendar> obtenerCalendarios(List<String> fechas) throws ParseException {
		List<Calendar> calendarios = new ArrayList<>();
		for(String fecha: fechas) {
    		calendarios.add(FechaUtil.obtenerFecha(fecha));
    	}
		return calendarios;
	}
	
	public double obtenerSumatoriaPorCategoria(String categoria) throws FileNotFoundException, IOException {
		List<String> categorias = ManejadorArchivo.obtenerDatos(ManejadorArchivo.obtenerArchivoComoMatrizDeString(), 2);
		List<Double> valores = ManejadorArchivo.obtenerValoresASumar(ManejadorArchivo.obtenerArchivoComoMatrizDeString());
		double sumatoria = 0;
		for(int i = 0; i<categorias.size(); i++) {
			if(categorias.get(i).equals(categoria)) {
				sumatoria = sumatoria + valores.get(i);
			}
		}
		return sumatoria;
	}
	
	public String obtenerCategoriaQueMayorGastoMeRepresenta(List<String> categorias) throws FileNotFoundException, IOException{
		String categoriaQueMasGastoMeRepresenta = categorias.get(0);
		double gasto;
		for(String categoria : categorias) {
			gasto = obtenerSumatoriaPorCategoria(categoria);
			if(gasto < obtenerSumatoriaPorCategoria(categoriaQueMasGastoMeRepresenta)) {
				categoriaQueMasGastoMeRepresenta = categoria;
			}
		}
		return categoriaQueMasGastoMeRepresenta;
	}

}




