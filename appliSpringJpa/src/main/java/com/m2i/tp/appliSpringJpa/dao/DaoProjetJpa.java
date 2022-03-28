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

import com.m2i.tp.appliSpringJpa.entity.Projet;

@Component //ou @Repository //pour prise en charge par framework spring
@Transactional //pour commit/rollback automatique
public class DaoProjetJpa extends DaoJpa<Projet> implements DaoProjet{
	
	

	@Override
	public Projet findById(long code) {
		return entityManager.find(Projet.class, code); //SELECT .... WHERE code=...
	}

	
	
	@Override
	public List<Projet> findAll() {
		return entityManager.createQuery("SELECT p FROM Projet p",Projet.class)
				            .getResultList();
	}



	@Override
	public Projet findProjectWithPhases(Long codeProjet) {
		return entityManager.createQuery("SELECT p FROM Projet p INNER JOIN FETCH p.phases WHERE p.code = :codeP", Projet.class)
				.setParameter("codeP", codeProjet)
	            .getSingleResult();
		
		
	};




	
	
}
