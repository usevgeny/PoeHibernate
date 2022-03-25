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
public class DaoEmployeJpa implements DaoEmploye{
	
	
	@PersistenceContext // permet dinitialiser EntityManager à partir du fichier // permet dinitialiser l'objet techinque 
	//EntityManager à partir d'une configuration   src/mail/resources/META-INF/persistance.xml
	// ou bine une config spring equivalente dans src/main/ressources/application.properties
	private EntityManager entityManager; //page 14 du cours, page 19
	
	
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
	@Transactional
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
/*
	@Override
	public List<Employe> findEmployeWithNameBeginBy(String debutNom) {
		return entityManager.createQuery("SELECT e FROM Employe e WHERE e.lastname LIKE :debut",Employe.class)
	            .setParameter("debut", debutNom+"%")
				.getResultList();
	}*/

	@Override
	public List<Employe> findEmployeWithNameBeginBy(String debutNom) {
		return entityManager.createNamedQuery("Employe.findEmployeWithNameBeginBy",Employe.class)
	            .setParameter("debut", debutNom+"%")
				.getResultList();
	}


	
	
	
	/*
	@Override
	public List<Employe> FindEmployeWithNameBeginBy(String debut) {
				
		
		
		return entityManager.createQuery("SELECT e FROM Employe e WHERE e.name LIKE :debutNom", Employe.class)
				.setParameter("debutNom", debut+"%")
				.getResultList(); 
		
		
	}*/

}
