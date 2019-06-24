package com.cine.rinku.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cine.rinku.common.dto.NominaDTO;
import com.cine.rinku.common.dto.ResultadoDTO;
import com.cine.rinku.dm.bo.NominaBO;

@RestController
@RequestMapping("/rinku/nomina")
public class NominaRest {
	@Autowired
	NominaBO nominaBO;
	
	@RequestMapping("/generaNomina")
	ResultadoDTO<?> generaNomina(@RequestBody NominaDTO nomina) {
		ResultadoDTO<NominaDTO> resultado = new ResultadoDTO<NominaDTO>();
		try {
			resultado.setResultado(nominaBO.generaNomina(nomina));
		}catch(Exception e) {
			e.printStackTrace();
			resultado.setCodigo(-1);
			resultado.setMensaje("No se pudo generar nomina");
		}
		return resultado;
	}
}
