package com.cine.rinku.dm.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.cine.rinku.dm.dao.interfaces.IMovimientoDAO;
import com.cine.rinku.dm.model.Movimientos;

public class MovimientosDAO {
	@Autowired
	IMovimientoDAO iMovimientosDAO;
	
	public List<Movimientos> getAllMovimientos(){
		return iMovimientosDAO.findAll();
	}
}
