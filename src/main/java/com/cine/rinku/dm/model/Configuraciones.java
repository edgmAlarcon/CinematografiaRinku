package com.cine.rinku.dm.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.dom4j.tree.AbstractEntity;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

import com.cine.rinku.dm.model.Empleados.EmpleadosBuilder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "configuraciones")
@DynamicInsert
@DynamicUpdate
@SelectBeforeUpdate
@Builder(toBuilder = true)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Configuraciones extends AbstractEntity{/**
	 * 
	 */
	private static final long serialVersionUID = 6144886405251454388L;
	
	@Id
	@Column(name = "id_Configuraciones",  unique = true, nullable = false)
	private String idConfiguracion;
	
	@Basic
	@Column(name = "valor")
	private String valor;
	
	@Basic
	@Column(name = "descripcion")
	private String descripcion;

}
