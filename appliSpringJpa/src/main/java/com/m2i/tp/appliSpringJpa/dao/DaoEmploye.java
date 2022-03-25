package com.m2i.tp.appliSpringJpa.dao;

import java.util.List;

import com.m2i.tp.appliSpringJpa.entity.Employe;

/*
 * DaoEmployee interface de DAO = data access object 
 * qui permet de declancher les operatios CMD
 * 
 * chaque méthode peut eventuellement remonter une exception, 
 * héritant de RunTimeExceptio(ex:JPSException) trycach facultatif, car ils ont déjà un trycach
 * 
 */
public interface DaoEmploye {
	
	Employe findById(long code);  // Long ira aussi
	List<Employe> findAll();
	
	// ...
	
	// Employe save(Employe emp); // dans SpringData au sense SaveOrUpdate
	Employe insertNew(Employe emp); // en retoru objet sauvegardé avec le clé primaire connue(auto-incrementé)
	Employe update(Employe emp);
	void deleteById(long code); // throws;
	

}
