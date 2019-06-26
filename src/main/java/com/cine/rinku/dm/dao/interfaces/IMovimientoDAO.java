package com.cine.rinku.dm.dao.interfaces;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cine.rinku.dm.model.Movimientos;

/***
 *En esta interface caen heredamos de jpaRepository todos los metodos que utilizaremos como insert, select, update y delete
 * 
 **/
@Repository
public interface IMovimientoDAO extends JpaRepository<Movimientos, Long>{
	//Se genera query personalizada para obtener movimientos por empleado y entre dos fechas
	@Query(value = "select t from Movimientos t where id_Empleado = :idEmpleado and fecha_Movimiento BETWEEN :startDate AND :endDate")
	public List<Movimientos> getAllBetweenDatesAndId(@Param("idEmpleado") long idEmpleado , @Param("startDate")  String startDat,@Param("endDate") String endDate);
}
