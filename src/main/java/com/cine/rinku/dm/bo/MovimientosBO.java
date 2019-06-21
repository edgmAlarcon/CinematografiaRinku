package com.cine.rinku.dm.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.cine.rinku.dm.dao.MovimientosDAO;
import com.cine.rinku.dm.model.Movimientos;

public class MovimientosBO {
	@Autowired
	MovimientosDAO movimientosDAO;
	
	public List<Movimientos> getAllMovimientos(){
		return movimientosDAO.getAllMovimientos();
	}
}
