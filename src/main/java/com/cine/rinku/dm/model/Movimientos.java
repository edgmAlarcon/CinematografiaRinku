package com.cine.rinku.dm.model;

import java.util.Date;

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
public class Movimientos extends AbstractEntity{/**
	 * 
	 */
	private static final long serialVersionUID = 6813858250815728643L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_Movimiento",  unique = true, nullable = false)
	private Long idMovimiento;
	
	@Basic
	@Column(name="id_Empleado", nullable = false)
	private Long idEmpleado;
	
	@Basic
	@Column(name="nombre", nullable = false)
	private String nombre;
	
	@Basic
	@Column(name="rol", nullable = false)
	private String rol;
	
	@Basic
	@Column(name="tipo_Empleado", nullable = false)
	private String tipoEmpleado;
	
	@Basic
	@Column(name = "fecha_Movimiento", nullable = false)
	private Date fechaMovimiento;
	
	@Basic
	@Column(name = "cantidad_Entregas", nullable = false)
	private int cantidadEntregas;
	
	@Basic
	@Column(name = "cubrio_Turno", nullable = false)
	private boolean cubrioTurno;

	
	

}