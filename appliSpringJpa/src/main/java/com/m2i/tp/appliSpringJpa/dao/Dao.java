package com.m2i.tp.appliSpringJpa.dao;

import java.util.List;

// version generique d'un DAO
// ou la letttre T sera remplacée par de fois projet, ou bine Phase ou bien EMploye
public interface Dao<T> {

		
	T findById(long code);  // Long ira aussi
	List<T> findAll();     /// t c'est la premiere lettre de Type

	// T save(T emp); // dans SpringData au sense SaveOrUpdate
	T insertNew(T p); // en retoru objet sauvegardé avec le clé primaire connue(auto-incrementé)
	T update(T p);
	void deleteById(long code); // throws;
	

}
