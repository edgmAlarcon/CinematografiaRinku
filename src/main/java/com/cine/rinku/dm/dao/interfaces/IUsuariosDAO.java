package com.cine.rinku.dm.dao.interfaces;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cine.rinku.dm.model.Usuarios;

@Repository
public interface IUsuariosDAO {
	List<Usuarios> getAllUsuarios();
	
}
