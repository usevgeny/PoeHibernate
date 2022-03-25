package com.m2i.tp.appliSpringJpa;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.m2i.tp.appliSpringJpa.dao.DaoPhase;
import com.m2i.tp.appliSpringJpa.dao.DaoProjet;


@SpringBootTest
class TestProjetEtPhase {


	@Autowired
	private DaoProjet daoProjet;   // l'injection de dependances via le spragwork spring, 
	

	@Autowired
	private DaoPhase daoPhase; 
	

	@Test
	public void test1() {
		
		
	}
	;
	
	

}


