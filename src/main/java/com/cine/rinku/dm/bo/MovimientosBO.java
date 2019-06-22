package com.cine.rinku.dm.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.cine.rinku.dm.dao.MovimientosDAO;
import com.cine.rinku.dm.model.Empleados;
import com.cine.rinku.dm.model.Movimientos;

@Component
public class MovimientosBO {
	@Autowired
	MovimientosDAO movimientosDAO;
	
	public List<Movimientos> getAllMovimientos(){
		return movimientosDAO.getAllMovimientos();
	}
	
	@Transactional
	public void insertMovimiento(Movimientos movimiento) {
		movimientosDAO.insertMovimiento(movimiento);
	}
	
	public Movimientos calcularPago(Movimientos movimiento) {
		try {
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
