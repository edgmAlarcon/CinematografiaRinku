package com.cine.rinku.dm.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cine.rinku.common.dto.NominaDTO;
import com.cine.rinku.dm.model.Movimientos;

@Component
public class NominaBO {
	
	@Autowired
	MovimientosBO movimientosBO;
	
	@Autowired
	ConfiguracionesBO configuracionesBO;
	
	public NominaDTO generaNomina(NominaDTO nomina) throws Exception {
		float sueldoBruto;
		float deducciones;
		float sueldoNeto;
		try {
			sueldoBruto = calculaSueldoBruto(nomina);
			nomina.setSueldoBruto(sueldoBruto);
			deducciones = calculaDeducciones(nomina);
			nomina.setDeducciones(deducciones);
			sueldoNeto = nomina.getSueldoBruto()-nomina.getDeducciones();
			nomina.setSueldoLibre(sueldoNeto);
			return nomina;
		}catch(Exception e) {
			e.printStackTrace();
			throw new Exception("Error al generar reporte");
		}
	}
	
	public float calculaDeducciones(NominaDTO nomina) throws Exception {
		double decimal;
		float deduccion = 0.0f;
		try {
			if(nomina.getSueldoBruto()<=Double.parseDouble(configuracionesBO.getConfiguraciones("TOPE_ISR_INFERIOR").getValor())) {
				decimal = (Double.parseDouble(configuracionesBO.getConfiguraciones("RETENCION_ISR_INFERIOR").getValor())/100);
				deduccion = (float) (nomina.getSueldoBruto()*decimal);
			}else {
				decimal = (Double.parseDouble(configuracionesBO.getConfiguraciones("RETENCION_ISR_SUPERIOR").getValor())/100);
				deduccion = (float) (nomina.getSueldoBruto()*decimal);
			}
				
		}catch(Exception e) {
			e.printStackTrace();
			throw new Exception(e);
		}
		return deduccion;
	}
	
	public float calculaSueldoBruto(NominaDTO nomina) throws Exception {
		float sueldoBruto = 0.0f;
		try {
			List<Movimientos> movimientos = movimientosBO.getAcumuladoById(nomina);
			for(Movimientos movimiento: movimientos) {//obtenemos el total acumulado en el mes por entregas
				sueldoBruto += movimiento.getCantidadEntregas() * Float.parseFloat(
						configuracionesBO.getConfiguraciones("PAGO_POR_ENTREGA").getValor());//sacamos dinero por entrega
				if(movimiento.getRol().equals("AUXILIAR") && movimiento.isCubrioTurno()) {//obtenemos bono cubierto para auxiliar
					sueldoBruto += Float.parseFloat(configuracionesBO.getConfiguraciones("BONO_DIARIO_"+movimiento.getTurnoCubierto()).getValor());
				}
			}
			
			sueldoBruto += (Float.parseFloat(configuracionesBO.getConfiguraciones("SUELDO_BASE_DIARIO").getValor())*nomina.getDias());//obtenmos sueldo base mensual
			
			if(!nomina.getRol().equals("AUXILIAR")) {//el auxiliar ya acumulo estos bonos
				sueldoBruto += (Float.parseFloat(configuracionesBO.getConfiguraciones("BONO_DIARIO_"+nomina.getRol()).getValor())*nomina.getDias());//obtenemos el bono acumulado por hora
			}
			
			if(nomina.getTipoEmpleado().equals("INTERNO")) {
				sueldoBruto += ((Float.parseFloat(configuracionesBO.getConfiguraciones("VALE_DESPENSA").getValor())/100)*sueldoBruto);//Calcula el vale de despensa
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			throw new Exception("error al calcular total");
		}
		return sueldoBruto;
	}
}
