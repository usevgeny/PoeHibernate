package com.m2i.tp.appliSpringJpa.dao;

import java.util.List;

/*
 * cette version du DAO sera utilisé par Spring-JPA
 * et spring va initialiser automatiquement le entitymanager grace à l'annotation @PersistanceContext.
 * 
 * 
 * pour chauqe version spring va aussi declencher automatiquement des commit rollback 
 * si no place @Transactionnal sur la classe ou une méthide
 */

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component; //pour prise ne charge par le framework Spring , pourque la classe soit vue comme un component spring
import org.springframework.transaction.annotation.Transactional;

import com.m2i.tp.appliSpringJpa.entity.Employe;

@Component // ou @Repository
@Transactional // pour commit rollback
public class DaoEmployeJpa extends DaoJpa<Employe>implements DaoEmploye{
	
	
	
	@Override
	public List<Employe> findAll() {
		return entityManager.createQuery("SELECT e FROM Employe e",Employe.class)
				            .getResultList();
	}

	@Override
	public List<Employe> findEmployeWithNameBeginBy(String debutNom) {
		/*
		return entityManager.createQuery("SELECT e FROM Employe e WHERE e.lastname LIKE :debut",Employe.class)
	            .setParameter("debut", debutNom+"%")
				.getResultList();
		*/
		return entityManager.createNamedQuery("Employe.findEmployeWithNameBeginBy",Employe.class)
	            .setParameter("debut", debutNom+"%")
				.getResultList();
	}


	@Override
	public Employe findById(long code) {
		// TODO Auto-generated method stub
		 return entityManager.find(Employe.class, code); //SELECT .... WHERE empId=...
	}

	
}

