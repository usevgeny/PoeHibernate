package com.m2i.tp.appliSpringJpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.m2i.tp.appliSpringJpa.dao.DaoEmployeJpaSansSpring;
import com.m2i.tp.appliSpringJpa.entity.Employe;

public class TestSansSpringApp {

	public static void main(String[] args) {
		// classe de démarrage de l'application (sans utiliser spring)

		EntityManagerFactory emf  = Persistence.createEntityManagerFactory("appliSpringJpa");
		//NB: appliSpringJpa configure dans META-INF/persistence.xml
		EntityManager entityManager = emf.createEntityManager();
		
		DaoEmployeJpaSansSpring daoEmployeJpa = new DaoEmployeJpaSansSpring();
		daoEmployeJpa.setEntityManager(entityManager);
		
		
		Employe nouveauEmploye = new Employe(null, "aurelie", "leboucher", "012345678925", "aurelie@test.com", "login", "pass");
		
		daoEmployeJpa.insertNew(nouveauEmploye);
		
		List<Employe> employes = daoEmployeJpa.findAll();
		for(Employe emp : employes) {
			System.out.println(emp);
		}
		
		entityManager.close();
		emf.close();
	}

}






/*
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.m2i.tp.appliSpringJpa.dao.DaoEmployeJpaSansSpring;
import com.m2i.tp.appliSpringJpa.entity.Employe;

public class TestSansSpring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub 
		// classe de demarrage de l'application sans utiliser Spring

		
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("appliSpringJpa;") ; //
		// nb appliSpringJpa configure dans META-INF/persistence.xml
		
		EntityManager entityManager = emf.createEntityManager();
		// DaoEmployeJpa daoEmployeJpa = new DaoEmployeJpa();
		
		DaoEmployeJpaSansSpring daoEmployeJpa = new DaoEmployeJpaSansSpring();
		
		
		List<Employe> employes = daoEmployeJpa.findAll();
		
		for(Employe emp:employes) {
			
			System.out.println(emp);
			
		}
		
		entityManager.close();
		emf.close();
		
		
	}
	
	

}
*/