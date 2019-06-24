package com.cine.rinku.dm.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.cine.rinku.common.dto.NominaDTO;
import com.cine.rinku.common.utils.FechaUtils;
import com.cine.rinku.dm.dao.ConfiguracionesDAO;
import com.cine.rinku.dm.dao.MovimientosDAO;
import com.cine.rinku.dm.model.Empleados;
import com.cine.rinku.dm.model.Movimientos;

@Component
public class MovimientosBO {
	@Autowired
	MovimientosDAO movimientosDAO;
	
	@Autowired
	ConfiguracionesBO configuracionesBO;
	
	@Autowired
	EmpleadosBO empleadosBO;
	
	public List<Movimientos> getAllMovimientos(){
		return movimientosDAO.getAllMovimientos();
	}
	
	@Transactional
	public void insertMovimiento(Movimientos movimiento) throws Exception {
		try {
			Empleados empleado = Empleados.builder().idEmpleado(movimiento.getIdEmpleado()).build();
			empleado = empleadosBO.getEmpleado(empleado);
			movimiento.setIdEmpleado(empleado.getIdEmpleado());
			movimiento.setNombre(empleado.getNombre());
			movimiento.setTipoEmpleado(empleado.getTipoEmpleado());
			movimiento.setRol(empleado.getRol());
			movimiento.setFechaMovimiento(FechaUtils.convesrsionFecha(movimiento.getFechaMovimiento()));
			movimiento.setAcumulado(calcularAcumulado(movimiento));
			movimientosDAO.insertMovimiento(movimiento);
		}catch(Exception e) {
			throw new Exception("error al insertar movimiento",e);
		}
	}
	
	@Transactional
	public void deleteMovimiento(Movimientos movimiento) throws Exception {
		try {
			movimientosDAO.deleteMovimiento(movimiento);
		}catch(Exception e) {
			throw new Exception("Error al eliminar movimiento",e);
		}
	}
	
	public List<Movimientos> getAcumuladoById(NominaDTO nomina) throws Exception{
		try {
			return movimientosDAO.getAcumuladoById(nomina);
		}catch(Exception e) {
			e.printStackTrace();
			throw new Exception(e);
		}
	}
	
	public float calcularAcumulado(Movimientos movimiento) throws Exception {
		float acumulado = 0.0f;
		try {
			acumulado += movimiento.getCantidadEntregas() * Float.parseFloat(
					configuracionesBO.getConfiguraciones("PAGO_POR_ENTREGA").getValor());//sacamos dinero por entrega
			if(movimiento.getRol().equals("AUXILIAR") && movimiento.isCubrioTurno()) {//obtenemos bono cubierto para auxiliar
				acumulado += Float.parseFloat(configuracionesBO.getConfiguraciones("BONO_DIARIO_"+movimiento.getTurnoCubierto()).getValor());
			}
		}catch(Exception e) {
			e.printStackTrace();
			throw new Exception("Error al calcular el acumulado");
		}
		return acumulado;
	}
}
