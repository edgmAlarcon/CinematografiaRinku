package com.cine.rinku.web.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cine.rinku.common.dto.ResultadoDTO;
import com.cine.rinku.dm.bo.EmpleadosBO;
import com.cine.rinku.dm.model.Empleados;

@RestController
@RequestMapping("/rinku/empleados")
public class EmpleadosRest {
	@Autowired
	EmpleadosBO usuarioBO;
	
	@RequestMapping("/getAllEmpleados")
	ResultadoDTO<?> getAllEmpleados() {
		ResultadoDTO<List<Empleados>> resultado = new ResultadoDTO<List<Empleados>>();
		try {
			resultado.setResultado(usuarioBO.getAllUsuarios());
		}catch(Exception e) {
			e.printStackTrace();
			resultado.setCodigo(-1);
		}
		return resultado;
	}
	
	@RequestMapping("/getEmpleado")
	ResultadoDTO<?> getEmpleado(@RequestBody Empleados empleado) {
		ResultadoDTO<Empleados> resultado = new ResultadoDTO<Empleados>();
		try {
			resultado.setResultado(usuarioBO.getEmpleado(empleado));
		}catch(Exception e) {
			e.printStackTrace();
			resultado.setCodigo(-1);
			resultado.setMensaje("No se encontro empleado!");
		}
		return resultado;
	}
	
	@RequestMapping("/insertUsuarios")
	ResultadoDTO<?> insertUsuarios(@RequestBody Empleados empleado){
		ResultadoDTO<Object> resultado = new ResultadoDTO<Object>();
		try {
			usuarioBO.insertUsuario(empleado);
		}catch(Exception e) {
			e.printStackTrace();
			resultado.setCodigo(-1);
			resultado.setMensaje(e.getMessage());
		}
		return resultado;
	}
	
	@RequestMapping("/deleteUsuarios")
	ResultadoDTO<?> deleteUsuarios(@RequestBody Empleados empleado){
		ResultadoDTO<Object> resultado = new ResultadoDTO<Object>();
		try {
			usuarioBO.deleteUsuario(empleado);
		}catch(Exception e) {
			e.printStackTrace();
			resultado.setCodigo(-1);
			resultado.setMensaje(e.getMessage());
		}
		return resultado;
	}
}
