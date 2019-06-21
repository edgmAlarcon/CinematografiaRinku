package com.cine.rinku.dm.dao.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cine.rinku.dm.model.Movimientos;

public interface IMovimientoDAO extends JpaRepository<Movimientos, Long>{

}
