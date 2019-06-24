package com.cine.rinku.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public final class FechaUtils {
	public enum FormatoFecha {

		FECHA_BD("yyyy-MM-dd"), FECHA("dd-MM-yyyy"), HORA("kk.mm"), FECHA_HORA(
				"dd/MM/yyyy HH:mm:ss"), FECHA_HORA_SIN_SEG("dd/MM/yyyy HH:mm"), CARPETA("yyyyMMddHHmm"), FOLIO(
						"yyMMdd"), FOLIO_TICKET("yyyyMMdd"), FECHA_HORA_FORMA("yyyy/MM/dd HH:mm"), FECHA_FORMA(
								"yyyy/MM/dd"), FECHA_REPORTE("dd/MM/yyyy"), ANIO_MES_REPORTE("yyyy/MM"), HORA_FORMATO(
										"HH:mm"), HORA_COMPLETA_FORMATO("HH:mm:ss"), FECHA_RECEPTORA(
												"dd/MM/yyyy HH:mm:ss:SSS"), FECHA_HORA_REPORTE_DENUNCIA(
														"dd-MM-yyyy HH:mm"), FECHA_HORA_REPORTE_EMERGENCIA(
																"yyyy-MM-dd HH:mm"), FECHA_HORA_REPORTE_GPS(
																		"yyyy-MM-dd HH:mm:ss");

		private final String formato;

		FormatoFecha(String formato) {
			this.formato = formato;
		}

		public String getFormato() {
			return formato;
		}

	}

	public static Date cadena2Fecha(final String fecha, final FormatoFecha formato) {
		return cadena2Fecha(fecha, formato.getFormato());
	}

	public static Date cadena2Fecha(final String fecha, final String formato) {
		if (fecha.isEmpty()) {
			return null;
		}
		try {
			final SimpleDateFormat dateFormat = new SimpleDateFormat(formato, Locale.getDefault());
			return dateFormat.parse(fecha);
		} catch (final ParseException e) {
			throw new IllegalArgumentException("La fecha " + fecha + " no tiene el formato " + formato, e);
		}
	}

	public static String fecha2Cadena(final Date fecha, final FormatoFecha formato) {
		return fecha2Cadena(fecha, formato.getFormato(), Locale.getDefault());
	}

	public static String fecha2Cadena(final Date fecha, final String formato) {
		return fecha2Cadena(fecha, formato, Locale.getDefault());
	}

	public static String fecha2Cadena(final Date fecha, final String formato, final Locale locale) {
		if (fecha == null) {
			return "";
		}
		final SimpleDateFormat dateFormat = new SimpleDateFormat(formato, locale);
		return dateFormat.format(fecha);
	}

	public static Date convesrsionFecha(final Date fecha) {
		final String dateFormatted = fecha2Cadena(fecha, FormatoFecha.FECHA_HORA.getFormato());
		return cadena2Fecha(dateFormatted, FormatoFecha.FECHA_HORA.getFormato());
	}
}
