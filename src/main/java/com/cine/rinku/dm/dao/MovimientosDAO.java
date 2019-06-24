package com.cine.rinku.dm.dao;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

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
	
	public void deleteMovimiento(Movimientos movimiento) throws Exception {
		try {
			iMovimientosDAO.deleteById(movimiento.getIdMovimiento());
		}catch(Exception e) {
			e.printStackTrace();
			throw new Exception("error al eliminar movimiento");
		}
	}
	
}
