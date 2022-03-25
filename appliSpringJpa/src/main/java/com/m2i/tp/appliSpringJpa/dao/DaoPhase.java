package com.m2i.tp.appliSpringJpa.dao;

import java.util.List;

import com.m2i.tp.appliSpringJpa.entity.Phase;

/*
 * DaoPhasee interface de DAO = data access object 
 * qui permet de declancher les operatios CMD
 * 
 * chaque méthode peut eventuellement remonter une exception, 
 * héritant de RunTimeExceptio(ex:JPSException) trycach facultatif, car ils ont déjà un trycach
 * 
 */
public interface DaoPhase {
	
	Phase findById(long code);  // Long ira aussi
	List<Phase> findAll();
	
	
	// Phase save(Phase emp); // dans SpringData au sense SaveOrUpdate
	Phase insertNew(Phase ph); // en retoru objet sauvegardé avec le clé primaire connue(auto-incrementé)
	Phase update(Phase pf);
	void deleteById(long code); // throws;
	

}
