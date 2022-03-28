package com.m2i.tp.appliSpringJpa;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.m2i.tp.appliSpringJpa.dao.DaoEmploye;
import com.m2i.tp.appliSpringJpa.entity.Employe;
import com.m2i.tp.appliSpringJpa.repository.DaoEmployeSpringData;

@SpringBootTest
class TestSpringData {


	@Autowired
	private DaoEmployeSpringData daoEmploye;   // l'injection de dependances via le spragwork spring, 
	//cela initialise la variable DAO employe pourque ça reference un composant pris en charge 
	//par spring et qui est copatible avec l'interface DaoEmploye dans ce projet seule la classe DaoEMploueJpa correspond à ce critere 
	
	
	
	@Test // appelé automatiquement après la prise en compte de @Autowired
 	public void testAvecSpring() {
		// sequence de test idéale:
		
		// 1. créer une nouvelle chose
		Employe nouveauEmploye = new Employe(null, "Springaurelie", "leboucher", "012345678925", "aurelie@test.com", "login", "pass");
		
		
		daoEmploye.save(nouveauEmploye);
		
		Employe nouveauEmploye2  = new Employe(null, "SpringPascal", "leboucher", "012345678925", "aurelie@test.com", "login", "pass");
			
		daoEmploye.save(nouveauEmploye2);
		
		
		Long idEmp = nouveauEmploye.getEmpId();
		
		//		2. afficher tout pour verifier l'ajot
		List<Employe> employes = (List) daoEmploye.findAll();
		for(Employe emp : employes) {
			System.out.println(emp);
		}
		
		
		
		
		
		
		
		
}
}
	


