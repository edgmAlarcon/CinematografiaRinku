package com.cine.rinku.dm.dao.interfaces;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cine.rinku.dm.model.Empleados;

@Repository
public interface IUsuariosDAO {
	List<Empleados> getAllUsuarios();
	void insertUsuario(Empleados empleado);
}
