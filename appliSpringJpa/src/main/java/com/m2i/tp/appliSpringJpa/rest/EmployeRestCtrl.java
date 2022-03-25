package com.m2i.tp.appliSpringJpa.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.m2i.tp.appliSpringJpa.entity.Employe;
import com.m2i.tp.appliSpringJpa.service.ServiceEmploye;

@RestController // composatn string de type Web Service Res (cas particulier de @ Composant) 
@RequestMapping(path="/api-gestionProjet/employe",
				headers = "Accept=application/json"
		)
public class EmployeRestCtrl {
	
	@Autowired
	private ServiceEmploye serviceEmploye;
	
	
	// URL Declanchement est parmametré dans application.properties  http://localhost:8080/appliSpringJpa
	@GetMapping("")
	public List<Employe> getEmployes(){
		
		return serviceEmploye.rechercherTousEmploye();
		
		// la liste d'employe JAVA
		// sera automatiquement transormée et retourné au format JSON
	}
}
