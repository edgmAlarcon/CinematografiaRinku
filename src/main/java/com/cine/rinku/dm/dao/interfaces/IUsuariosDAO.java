package com.cine.rinku.dm.dao.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cine.rinku.dm.model.Empleados;

/***
 *En esta interface caen heredamos de jpaRepository todos los metodos que utilizaremos como insert, select, update y delete
 * 
 **/
@Repository
public interface IUsuariosDAO extends JpaRepository<Empleados, Long> {

}
