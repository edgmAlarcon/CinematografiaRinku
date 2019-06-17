package com.cine.rinku.dm.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "empleados")
@DynamicInsert
@DynamicUpdate
@SelectBeforeUpdate
@Builder(toBuilder = true)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Usuarios extends AbstractEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8786488356648968164L;
	
	@Id
	@Column(name="id_Empleado",  unique = true, nullable = false)
	private String idEmpleado;
	
	@Basic
	@Column(name="nombre")
	private String nombre;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_Rol")
	private Roles rol;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_Tipo_Empleado")
	private TipoEmpleado tipoEmpleado;

}
