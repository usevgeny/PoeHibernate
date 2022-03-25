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
public interface DaoPhase extends Dao<Phase>{
	//...
	
	List<Phase>findPhaseByProject(Long codeProjet);
	

}
