package com.m2i.tp.appliSpringJpa;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.m2i.tp.appliSpringJpa.dao.DaoEmploye;
import com.m2i.tp.appliSpringJpa.entity.Employe;

@Component
public class CodeAuDemarrageSpring {
	
	@Autowired
	private DaoEmploye daoEmploye;   // l'injection de dependances via le spragwork spring, 
	//cela initialise la variable DAO employe pourque ça reference un composant pris en charge 
	//par spring et qui est copatible avec l'interface DaoEmploye dans ce projet seule la classe DaoEMploueJpa correspond à ce critere 
	
	
	
	
	
	
	@PostConstruct // appelé automatiquement après la prise en compte de @Autowired
 	public void testAvecSpring() {
		
		
Employe nouveauEmploye = new Employe(null, "aurelie", "leboucher", "012345678925", "aurelie@test.com", "login", "pass");
		
		daoEmploye.insertNew(nouveauEmploye);
		
		List<Employe> employes = daoEmploye.findAll();
		for(Employe emp : employes) {
			System.out.println(emp);
		}
		
		
	}
}
