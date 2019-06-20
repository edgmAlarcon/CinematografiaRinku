package com.cine.rinku.dm.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.cine.rinku.dm.dao.interfaces.IUsuariosDAO;
import com.cine.rinku.dm.model.Empleados;

@Repository
public class UsuariosDAO implements IUsuariosDAO{
	
	@PersistenceContext	
	private EntityManager entityManager;


	@SuppressWarnings("unchecked")
	@Override
	public List<Empleados> getAllUsuarios() {
		String hql = "FROM Empleados";
		return (List<Empleados>)entityManager.createQuery(hql).getResultList();
	}

	@Override
	public void insertUsuario(Empleados empleado) {
		entityManager.getTransaction();
		entityManager.persist(empleado);
		entityManager.getTransaction().commit();
	}

}
