package com.m2i.tp.appliSpringJpa;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.nio.channels.UnresolvedAddressException;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.m2i.tp.appliSpringJpa.dao.DaoEmploye;
import com.m2i.tp.appliSpringJpa.entity.Adresse;
import com.m2i.tp.appliSpringJpa.entity.Employe;

@SpringBootTest
class AppliSpringJpaApplicationTests {


	@Autowired
	private DaoEmploye daoEmploye;   // l'injection de dependances via le spragwork spring, 
	//cela initialise la variable DAO employe pourque ça reference un composant pris en charge 
	//par spring et qui est copatible avec l'interface DaoEmploye dans ce projet seule la classe DaoEMploueJpa correspond à ce critere 
	
	
	
	
	
	
	@Test // appelé automatiquement après la prise en compte de @Autowired
 	public void testAvecSpring() {
		// sequence de test idéale:
		
		// 1. créer une nouvelle chose
		Employe nouveauEmploye = new Employe(null, "aurelie", "leboucher", "012345678925", "aurelie@test.com", "login", "pass");
		Adresse adr1 = new Adresse(null, "12 rue Elle", "75001", "ParIci");
		
		nouveauEmploye.setAdressePrincipale(adr1);
		daoEmploye.insertNew(nouveauEmploye);
		
		
		Long idEmp = nouveauEmploye.getEmpId();
		
		//		2. afficher tout pour verifier l'ajot
		List<Employe> employes = daoEmploye.findAll();
		for(Employe emp : employes) {
			System.out.println(emp);
		}
		
		
		// 3.recuperer une entité précise via sa clef primaire et l'afficher 
		
		Employe nouveauEmployeRelu = daoEmploye.findById(idEmp);
		System.out.println("nouveauEmployeRelu "+ nouveauEmployeRelu);
		
		System.out.println("Avec adresse "+ nouveauEmployeRelu.getAdressePrincipale());
		
		
		// 4. modifier les valeurs en mémoire et puis en base
		nouveauEmployeRelu.setPhoneNumber("456453168435415");
		daoEmploye.update(nouveauEmployeRelu);
		
		// 5.  redeclencher étape 3 pour vérifier que la mise à jour a bien été fait (à bien été ajouté n base
		
		Employe nouveauEmployeRelu2 = daoEmploye.findById(idEmp);
		System.out.println("nouveauEmployeRelu2 "+ nouveauEmployeRelu2);
		// 6. supprimer la chose ajoutée à l'étape 1
	//	daoEmploye.deleteById(idEmp);
		// 7. on vérifie si cela n'existe plus
		
		Employe nouveauEmployeRelu3 = daoEmploye.findById(idEmp);
		
		if (nouveauEmployeRelu3==null) {
		System.out.println("nouveauEmployeRelu3 n'existe pas");}
		
		// TP  on verifie la recherche par debut du nom 
		
		System.out.println("TEST TP");
		List<Employe> employes1 = daoEmploye.findEmployeWithNameBeginBy("A");
		
		for(Employe e: employes1) {
			System.out.println("Found: "+e);
		}
		
		
		
		
		
}
}
	


