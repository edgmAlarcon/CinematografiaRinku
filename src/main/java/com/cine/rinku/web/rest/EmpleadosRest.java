package com.cine.rinku.web.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cine.rinku.common.dto.ResultadoDTO;
import com.cine.rinku.common.dto.UsuarioDTO;
import com.cine.rinku.dm.bo.UsuariosBO;
import com.cine.rinku.dm.model.Empleados;

@RestController
@RequestMapping("/rinku/empleados")
public class EmpleadosRest {
	@Autowired
	UsuariosBO usuarioBO;
	
	@RequestMapping("/getAllUsuarios")
	ResultadoDTO<?> getAllUsuarios() {
		ResultadoDTO<List<Empleados>> resultado = new ResultadoDTO<List<Empleados>>();
		try {
			resultado.setResultado(usuarioBO.getAllUsuarios());
		}catch(Exception e) {
			e.printStackTrace();
			resultado.setCodigo(-1);
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
		}
		return resultado;
	}
}
