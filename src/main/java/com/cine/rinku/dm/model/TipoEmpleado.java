package com.cine.rinku.dm.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.dom4j.tree.AbstractEntity;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "c_tipo_empleado")
@DynamicInsert
@DynamicUpdate
@SelectBeforeUpdate
@Builder(toBuilder = true)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TipoEmpleado extends AbstractEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7734293738286515889L;
	
	@Id
	@Column(name="id_Tipo_Empleado",  unique = true, nullable = false)
	private int idTipoEmpleado;
	
	@Basic
	@Column(name = "Descripcion")
	private String descripcion;
	
}
