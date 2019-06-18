package com.cine.rinku.dm.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.cine.rinku.dm.dao.interfaces.IUsuariosDAO;
import com.cine.rinku.dm.model.Usuarios;

@Repository
public class UsuariosDAO implements IUsuariosDAO{
	
	@PersistenceContext	
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<Usuarios> getAllUsuarios() {
		String hql = "FROM Usuarios";
		return (List<Usuarios>)entityManager.createQuery(hql).getResultList();
	}

}
