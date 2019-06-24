package com.cine.rinku.dm.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cine.rinku.dm.dao.ConfiguracionesDAO;
import com.cine.rinku.dm.model.Configuraciones;

@Component
public class ConfiguracionesBO {
	
	@Autowired
	ConfiguracionesDAO configuracionesDAO;
	
	public Configuraciones getAllConfiguraciones(String id) throws Exception{
		return configuracionesDAO.getConfiguraciones(id);
	}

}
