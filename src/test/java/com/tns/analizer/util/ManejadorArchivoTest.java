package com.tns.analizer.util;

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.junit.Test;

public class ManejadorArchivoTest {
	@Test
    public void obtenerValorDeUnGastoTest() throws FileNotFoundException, IOException {
    	List<List<String>> archivo = ManejadorArchivo.obtenerArchivoComoMatrizDeString();
    	assertEquals("-500000", archivo.get(2).get(1));
    }
	
	@Test
    public void obtenerDescripcionTest() throws FileNotFoundException, IOException {
    	List<List<String>> archivo = ManejadorArchivo.obtenerArchivoComoMatrizDeString();
    	assertEquals("Cobro cuenta", archivo.get(4).get(2));
    }
	
	@Test
    public void obtenerUnValorEntreLosMontos() throws FileNotFoundException, IOException {
    	List<List<String>> archivo = ManejadorArchivo.obtenerArchivoComoMatrizDeString();
    	assertEquals(1500000, ManejadorArchivo.obtenerValoresASumar(archivo).get(4).doubleValue(), 0);
    }
	
	@Test
    public void obtenerFechaTest() throws FileNotFoundException, IOException {
    	List<List<String>> archivo = ManejadorArchivo.obtenerArchivoComoMatrizDeString();
    	assertEquals("05-02-2018", ManejadorArchivo.obtenerDatos(archivo,0).get(2));
    }
}
