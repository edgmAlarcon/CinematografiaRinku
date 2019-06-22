package com.cine.rinku.dm.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cine.rinku.dm.dao.interfaces.IMovimientoDAO;
import com.cine.rinku.dm.model.Empleados;
import com.cine.rinku.dm.model.Movimientos;

@Repository
public class MovimientosDAO {
	@Autowired
	IMovimientoDAO iMovimientosDAO;
	
	public List<Movimientos> getAllMovimientos(){
		return iMovimientosDAO.findAll();
	}
	
	public void insertMovimiento(Movimientos movimiento) {
		try {
			iMovimientosDAO.save(movimiento);
		}catch(Exception e) {
			e.printStackTrace();
		}	
	}
	
}
