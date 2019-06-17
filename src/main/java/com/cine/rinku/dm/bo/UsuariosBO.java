package com.cine.rinku.dm.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cine.rinku.dm.dao.UsuariosDAO;
import com.cine.rinku.dm.model.Usuarios;

@Component
public class UsuariosBO {
	@Autowired
	UsuariosDAO usuarioDAO;
	
	public List<Usuarios> getAllUsuarios(){
		return usuarioDAO.getAllUsuarios();
	}
}
