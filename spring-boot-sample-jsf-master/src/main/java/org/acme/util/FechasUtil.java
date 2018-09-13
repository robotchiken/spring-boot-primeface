package org.acme.util;

import java.util.Calendar;
import java.util.Date;

public class FechasUtil {
	public static Date calcularMes(Date date,int numeroSemanas){
		Calendar fecha = Calendar.getInstance();
		fecha.setTime(date);
		int diaNuevo;
		int diaOriginal=fecha.get(Calendar.DAY_OF_WEEK);
		int diferencia;
		fecha.add(Calendar.DAY_OF_WEEK_IN_MONTH, numeroSemanas);
		diaNuevo=fecha.get(Calendar.DAY_OF_WEEK);
		diferencia= diaOriginal-diaNuevo;
		fecha.add(Calendar.DATE, diferencia);
		return fecha.getTime();		
	}
}
