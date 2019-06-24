package com.cine.rinku.dm.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cine.rinku.dm.dao.interfaces.IConfiguracionesDAO;
import com.cine.rinku.dm.model.Configuraciones;

@Repository
public class ConfiguracionesDAO {
	
	@Autowired
	IConfiguracionesDAO iConfiguracionesDAO;
	
	public Configuraciones getConfiguraciones(String id) throws Exception{
		try {
			if(iConfiguracionesDAO.findById(id).isPresent()) {
				return iConfiguracionesDAO.findById(id).get();
			}else {
				throw new Exception("Error al obtener configuracion");
			}
		}catch(Exception e) {
			e.printStackTrace();
			throw new Exception("Error al obtener configuracion",e);
		}
	}
}
