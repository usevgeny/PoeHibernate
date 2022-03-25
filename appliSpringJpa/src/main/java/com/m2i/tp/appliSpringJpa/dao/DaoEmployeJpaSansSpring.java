package com.m2i.tp.appliSpringJpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.m2i.tp.appliSpringJpa.entity.Employe;

public class DaoEmployeJpaSansSpring implements DaoEmploye{
	
	
	
	// version sans spring : il n'ya pas de @PersistenceContext on a à la place le setteur qui sera appele d'exterieur, 
	// -- gestion explicite de transaction entityManager.getTransaction()...
	
	private EntityManager entityManager; //page 14 du cours, page 19
	
	
	
	
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public Employe findById(long code) {
		// TODO Auto-generated method stub
		return entityManager.find(Employe.class, code);
	}

	@Override
	public List<Employe> findAll() {
		return entityManager.createQuery("SELECT e FROM Employe e", Employe.class).getResultList(); 
	}
	

	@Override
	public Employe insertNew(Employe emp) {
		// TODO Auto-generated method stub
		
		// en entrée , emp est un nouvel objet Employe avec la cléf primaire .empId à null(encore inconnu)
		
		// déclenche automatiquement INSERT_INTO employe(firstname, ...) VALUES(emp.getFirstName()....)
		entityManager.persist(emp); //.empId n'est normalement plus nul si auto-incrementation
		return emp; // retourne l'objet modifié(avec .empId non null)
	}

	@Override
	public Employe update(Employe emp) {
		return entityManager.merge(emp); 
		
	}

	@Override
	public void deleteById(long code) {
		Employe empAsupprimer = entityManager.find(Employe.class, code);
		entityManager.remove(empAsupprimer);
		
		
	}

}
