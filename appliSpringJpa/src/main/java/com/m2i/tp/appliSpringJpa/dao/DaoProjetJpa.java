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

@Component // ou @Repository
@Transactional // pour commit rollback
public class DaoProjetJpa implements DaoProjet{
	
	
	@PersistenceContext // permet dinitialiser EntityManager à partir du fichier // permet dinitialiser l'objet techinque 
	//EntityManager à partir d'une configuration   src/mail/resources/META-INF/persistance.xml
	// ou bine une config spring equivalente dans src/main/ressources/application.properties
	private EntityManager entityManager; //page 14 du cours, page 19
	
	
	@Override
	public Projet findById(long code) {
		// TODO Auto-generated method stub
		return entityManager.find(Projet.class, code);
	}

	@Override
	public List<Projet> findAll() {
		return entityManager.createQuery("SELECT e FROM Projet e", Projet.class).getResultList(); 
	}
	

	@Override
	@Transactional
	public Projet insertNew(Projet emp) {
		// TODO Auto-generated method stub
		
		// en entrée , emp est un nouvel objet Projet avec la cléf primaire .empId à null(encore inconnu)
		
		// déclenche automatiquement INSERT_INTO Projet(firstname, ...) VALUES(emp.getFirstName()....)
		entityManager.persist(emp); //.empId n'est normalement plus nul si auto-incrementation
		return emp; // retourne l'objet modifié(avec .empId non null)
	}

	@Override
	public Projet update(Projet emp) {
		return entityManager.merge(emp); 
		
	}

	@Override
	public void deleteById(long code) {
		Projet empAsupprimer = entityManager.find(Projet.class, code);
		entityManager.remove(empAsupprimer);
		
		
	}

}
