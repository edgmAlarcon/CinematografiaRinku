package com.cine.rinku.dm.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.cine.rinku.dm.dao.EmpleadosDAO;
import com.cine.rinku.dm.model.Empleados;

@Component
public class EmpleadosBO {
	@Autowired
	EmpleadosDAO usuarioDAO;
	
	public List<Empleados> getAllUsuarios(){
		return usuarioDAO.getAllUsuarios();
	}
	
	public Empleados getEmpleado(Empleados empleado) throws Exception {
		return usuarioDAO.getEmpleado(empleado);
	}
	
	@Transactional
	public void insertUsuario(Empleados empleado) {
		usuarioDAO.insertUsuario(empleado);
	}
	
	@Transactional
	public void deleteUsuario(Empleados empleado) {
		usuarioDAO.deleteUsuario(empleado);
	}
}
