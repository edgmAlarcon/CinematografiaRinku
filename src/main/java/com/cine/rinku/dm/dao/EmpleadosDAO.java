package com.cine.rinku.dm.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cine.rinku.dm.dao.interfaces.IUsuariosDAO;
import com.cine.rinku.dm.model.Empleados;

@Repository
public class EmpleadosDAO{
	@Autowired
	IUsuariosDAO iUsuarioDAO;

	public List<Empleados> getAllUsuarios() {
		return iUsuarioDAO.findAll();
	}
	
	public Empleados getEmpleado(Empleados empleado) throws Exception {
		if(iUsuarioDAO.findById(empleado.getIdEmpleado()).isPresent()) {
			return iUsuarioDAO.findById(empleado.getIdEmpleado()).get();
		}else {
			throw new Exception();
		}
		
	}
	
	public void insertUsuario(Empleados empleado) {
		try {
			iUsuarioDAO.save(empleado);
		}catch(Exception e) {
			e.printStackTrace();
		}	
	}
	
	public void deleteUsuario(Empleados empleado) {
		try {
			iUsuarioDAO.delete(empleado);
		}catch(Exception e ) {
			e.printStackTrace();
		}
	}
	

}
