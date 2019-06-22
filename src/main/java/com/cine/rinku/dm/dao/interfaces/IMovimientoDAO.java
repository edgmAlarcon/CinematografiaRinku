package com.cine.rinku.dm.dao.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cine.rinku.dm.model.Movimientos;

@Repository
public interface IMovimientoDAO extends JpaRepository<Movimientos, Long>{

}
