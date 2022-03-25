package com.m2i.tp.appliSpringJpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.m2i.tp.appliSpringJpa.dao.DaoEmploye;
import com.m2i.tp.appliSpringJpa.entity.Employe;

@Service //cas particulier de @Component
@Transactional
public class ServiceEmployeImpl implements ServiceEmploye {
	
	@Autowired
	private DaoEmploye daoEmploye;

	@Override
	public List<Employe> rechercherTousEmploye() {
		//simple délégation de traitement
		return daoEmploye.findAll();
	}
	
	//Un service fait souvent en plus de verifs de regles de gestion

}

