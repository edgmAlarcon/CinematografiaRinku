package com.cine.rinku.common.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder(toBuilder = true)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NominaDTO {
	
	private static final long serialVersionUID = 1L;
	
	private long idEmpleado;
	private String fechaInicio;
	private String fechaFin;
	private int dias;
	private float sueldoBruto;
	private float sueldoLibre;
	private float deducciones;
	private String rol;
	private String tipoEmpleado;
	
}
