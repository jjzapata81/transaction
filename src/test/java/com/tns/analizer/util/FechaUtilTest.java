package com.tns.analizer.util;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.util.Calendar;

import org.junit.Test;

public class FechaUtilTest {
	
	 @Test
	  public void obtenerDiaDelMesTest() throws ParseException {
	    String fecha = "15-05-2015";
	    assertEquals(15, FechaUtil.obtenerFecha(fecha).get(Calendar.DAY_OF_MONTH));
	  }
	 
	 @Test
	  public void obtenerElMesTest() throws ParseException {
	    String fecha = "15-05-2015";
	    assertEquals(Calendar.MAY, FechaUtil.obtenerFecha(fecha).get(Calendar.MONTH));
	  }
	 
	 @Test
	  public void obtenerElAnioTest() throws ParseException {
	    String fecha = "15-05-2015";
	    assertEquals(2015, FechaUtil.obtenerFecha(fecha).get(Calendar.YEAR));
	  }
}
