package com.cine.rinku.common.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder(toBuilder = true)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ResultadoDTO<E>{
	  private static final long serialVersionUID = 1L;
	  private int codigo = 0;
	  private String mensaje;
	  private E resultado;
}
