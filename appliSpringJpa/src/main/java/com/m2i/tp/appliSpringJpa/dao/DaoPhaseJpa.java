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
import com.m2i.tp.appliSpringJpa.entity.Phase;

@Component // ou @Repository
@Transactional // pour commit rollback
public class DaoPhaseJpa extends DaoJpa<Phase> implements DaoPhase{
	

	
	@Override
	public List<Phase> findAll() {
		return entityManager.createQuery("SELECT p FROM Phase p",Phase.class)
				            .getResultList();
	}


	@Override
	public Phase findById(long code) {
		// TODO Auto-generated method stub
		return entityManager.find(Phase.class, code); //SELECT .... WHERE code=...
	}



	@Override
	public List<Phase> findPhasesByProject(Long codeProjet) {
		return entityManager.createQuery("SELECT p FROM Phase p WHERE p.projet.code = :codeP",Phase.class)
	            .setParameter("codeP", codeProjet)
	            .getResultList();
	}


	@Override
	public List<Employe> findEmployeOfPhase(Long code_phase) {
		// TODO Auto-generated method stub
		return entityManager.createNamedQuery("Phase.findEmployeOfPhase", Employe.class)
				.setParameter("codePhase", code_phase)
				.getResultList();
				
	}

}

