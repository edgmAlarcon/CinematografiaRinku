package com.cine.rinku.web.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cine.rinku.common.dto.ResultadoDTO;
import com.cine.rinku.dm.bo.MovimientosBO;
import com.cine.rinku.dm.model.Movimientos;

@RestController
@RequestMapping("/rinku/movimientos")
public class MovimientosRest {
	@Autowired
	MovimientosBO movimientosBO;
	
	@RequestMapping("/getAllMovimientos")
	ResultadoDTO<?> getAllUsuarios() {
		ResultadoDTO<List<Movimientos>> resultado = new ResultadoDTO<List<Movimientos>>();
		try {
			resultado.setResultado(movimientosBO.getAllMovimientos());
		}catch(Exception e) {
			e.printStackTrace();
			resultado.setCodigo(-1);
		}
		return resultado;
	}
}
