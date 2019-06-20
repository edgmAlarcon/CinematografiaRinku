package com.cine.rinku.common.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
public class UsuarioDTO {
	private static final long serialVersionUID = -1L;
	private String nombre;
	private String rol;
	private String tipoEmpleado;
}
