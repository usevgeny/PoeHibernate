package com.m2i.tp.appliSpringJpa.repository;

import org.springframework.data.repository.CrudRepository;

import com.m2i.tp.appliSpringJpa.entity.Employe;
// CrudRepository<TypeEntite, TypeClefPrimaire> est une interface de DAO automatique
// predefini dans ce que l'on appel SpringData
// si activé dans l'application.properties alors le framework gènére automatiquement 
//le code colet de la csse d'implementation avec la technologie JPA
// ----> plus qu'a tester/utiliser

public interface DaoEmployeSpringData extends CrudRepository<Employe, Long> {

// simpleent par heritage on herite findALl deja codé, findById, Save() ...
	
	
	
	
	
}
