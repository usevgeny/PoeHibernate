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

import com.m2i.tp.appliSpringJpa.entity.Phase;

@Component // ou @Repository
@Transactional // pour commit rollback
public class DaoPhaseJpa implements DaoPhase{
	
	
	@PersistenceContext // permet dinitialiser EntityManager à partir du fichier // permet dinitialiser l'objet techinque 
	//EntityManager à partir d'une configuration   src/mail/resources/META-INF/persistance.xml
	// ou bine une config spring equivalente dans src/main/ressources/application.properties
	private EntityManager entityManager; //page 14 du cours, page 19
	
	
	@Override
	public Phase findById(long code) {
		// TODO Auto-generated method stub
		return entityManager.find(Phase.class, code);
	}

	@Override
	public List<Phase> findAll() {
		return entityManager.createQuery("SELECT e FROM Phase e", Phase.class).getResultList(); 
	}
	

	@Override
	@Transactional
	public Phase insertNew(Phase ph) {
		// TODO Auto-generated method stub
		
		// en entrée , emp est un nouvel objet Phase avec la cléf primaire .empId à null(encore inconnu)
		
		// déclenche automatiquement INSERT_INTO Phase(firstname, ...) VALUES(emp.getFirstName()....)
		entityManager.persist(ph); //.empId n'est normalement plus nul si auto-incrementation
		return ph; // retourne l'objet modifié(avec .empId non null)
	}

	@Override
	public Phase update(Phase ph) {
		return entityManager.merge(ph); 
		
	}

	@Override
	public void deleteById(long code) {
		Phase phAsupprimer = entityManager.find(Phase.class, code);
		entityManager.remove(phAsupprimer);
		
		
	}
/*
	@Override
	public List<Phase> findPhaseWithNameBeginBy(String debutNom) {
		return entityManager.createQuery("SELECT e FROM Phase e WHERE e.lastname LIKE :debut",Phase.class)
	            .setParameter("debut", debutNom+"%")
				.getResultList();
	}*/

	

}
