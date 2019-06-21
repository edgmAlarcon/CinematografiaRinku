package com.cine.rinku.dm.dao.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cine.rinku.dm.model.Empleados;

@Repository
public interface IUsuariosDAO extends JpaRepository<Empleados, Long> {

}
