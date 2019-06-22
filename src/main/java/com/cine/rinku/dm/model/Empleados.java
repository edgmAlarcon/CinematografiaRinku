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
public class Empleados extends AbstractEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8786488356648968164L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_Empleado",  unique = true, nullable = false)
	private Long idEmpleado;
	
	@Basic
	@Column(name="nombre")
	private String nombre;
	
	@Basic
	@Column(name="rol")
	private String rol;
	
	@Basic
	@Column(name="tipo_Empleado")
	private String tipoEmpleado;
	
	@Basic
	@Column(name = "pagar")
	float pagar;


}
