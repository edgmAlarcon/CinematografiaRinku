package com.cine.rinku.web.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cine.rinku.dm.bo.UsuariosBO;
import com.cine.rinku.dm.model.Usuarios;

@RestController
@RequestMapping("/rinku/empleados")
public class EmpleadosRest {
	@Autowired
	UsuariosBO usuarioBO;
	
	@RequestMapping("/getAllUsuarios")
	ResponseEntity<?> getAllUsuarios() {
		return new ResponseEntity<List<Usuarios>>(usuarioBO.getAllUsuarios(),HttpStatus.OK);
	}
}
