package com.m2i.tp.appliSpringJpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Adresse {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	
	private String numEtRue;
	@Column(name = "code_postal", length =12)
	private String codePostal;
	private String ville;
	
	
	public Adresse() {
		super();
	}

	public Adresse(Long id, String numEtRue, String codePostal, String ville) {
		super();
		this.id = id;
		this.numEtRue = numEtRue;
		this.codePostal = codePostal;
		this.ville = ville;
	}

	public String getNumEtRue() {
		return numEtRue;
	}
	public void setNumEtRue(String numEtRue) {
		this.numEtRue = numEtRue;
	}
	public String getCodePostal() {
		return codePostal;
	}
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	@Override
	public String toString() {
		return "Adresse [numEtRue=" + numEtRue + ", codePostal=" + codePostal + ", ville=" + ville + "]";
	}
	
	
	
	
}
