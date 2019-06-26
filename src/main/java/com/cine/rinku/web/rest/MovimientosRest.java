package com.cine.rinku.web.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cine.rinku.common.dto.ResultadoDTO;
import com.cine.rinku.dm.bo.MovimientosBO;
import com.cine.rinku.dm.model.Movimientos;

/***
 *En esta clase caen todas las peticiones echas desde el front end y se retorna un objeto ResultadoDTO con un 
 *codigo de respuesta y un mensaje informativo/error 
 * 
 **/
@RestController
@RequestMapping("/rinku/movimientos")
public class MovimientosRest {
	@Autowired
	MovimientosBO movimientosBO;
	
	@RequestMapping("/getAllMovimientos")
	ResultadoDTO<?> getAllMovimientos() {
		ResultadoDTO<List<Movimientos>> resultado = new ResultadoDTO<List<Movimientos>>();
		try {
			resultado.setResultado(movimientosBO.getAllMovimientos());
		}catch(Exception e) {
			e.printStackTrace();
			resultado.setCodigo(-1);
		}
		return resultado;
	}
	
	@RequestMapping("/insertMovimientos")
	ResultadoDTO<?> insertMovimientos(@RequestBody Movimientos movimiento){
		ResultadoDTO<Object> resultado = new ResultadoDTO<Object>();
		try {
			movimientosBO.insertMovimiento(movimiento);
		}catch(Exception e) {
			e.printStackTrace();
			resultado.setCodigo(-1);
			resultado.setMensaje(e.getMessage());
		}
		return resultado;
	}
	
	@RequestMapping("/deleteMovimiento")
	ResultadoDTO<?> deleteMovimiento(@RequestBody Movimientos movimiento){
		ResultadoDTO<Object> resultado = new ResultadoDTO<Object>();
		try {
			movimientosBO.deleteMovimiento(movimiento);
		}catch(Exception e) {
			e.printStackTrace();
			resultado.setCodigo(-1);
			resultado.setMensaje(e.getMessage());
		}
		
		return resultado;
	}
}
