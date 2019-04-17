package com.tns.analizer.util;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class FechaUtil {
	public static Calendar obtenerFecha(String fechaString) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		Date date = sdf.parse(fechaString);
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal;
	}
}
