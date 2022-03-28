package com.m2i.tp.appliSpringJpa.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity

// NB: la requette exprime ici est du JPQL (JPA query language) et pas du SQL ordinaire, 
//pas besoin d'indiuer ON ... =  ... car le lien esr deja exprimé près de  @ManyToMany

@NamedQuery(name = "Phase.findEmployeOfPhase", 
			query = "SELECT e from Phase p JOIN p.employes e WHERE p.code = :codePhase")

// JOIN p.employees e est à lire comme e est un alias sur une instance d'un memebre 
// de la collection des employes reliés (par jointure) à la phase p   /// page pp de JPA_HIBERNATE 
public class Phase {

	
	@Id // pour dire que EMP_ID est la cléf promaire(primary key)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long code; 
	
	
	private String label; 
	private String description;
	
	@Column(name="date_debut")    ///dates page 13 jpa et hibernate pdf  @TemporalType.DATE ou @TemporalType.TIME
	@Temporal(TemporalType.DATE)
	private Date dateDebut;   //liens bidirenctionnel il vuadrait miex de l'eviter pour ne pas avoir des bugs 
	
	
	@Column(name="date_fin_prevue")
	@Temporal(TemporalType.DATE)
	private Date dateFinPrevue;
	
	@Column(name="date_fin_effective")
	@Temporal(TemporalType.DATE)
	private Date dateFinEffective;
	
	private Double proportionProjet; // exemple 0.5 pour 50%
	//private Double montant;
	// à faire en tp les annotations de la page 31
	
	
	
	
	
	@ManyToOne()
	@JoinColumn(name="code_projet")
	private Projet projet;
	
	@ManyToMany( fetch = FetchType.LAZY)
	@JoinTable(name = "Phase_Employe",
	           joinColumns = {@JoinColumn(name = "code_phase")},
	           inverseJoinColumns = {@JoinColumn(name = "emp_id")})
	private List<Employe> employes;
	
	public void addEmploye(Employe e) {
		if(employes==null) {
			employes = new ArrayList<>();
		}
		employes.add(e);
	}
	
	
	public Long getCode() {
		return code;
	}
	public void setCode(Long code) {
		this.code = code;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}
	public Date getDateFinPrevue() {
		return dateFinPrevue;
	}
	public void setDateFinPrevue(Date dateFinPrevue) {
		this.dateFinPrevue = dateFinPrevue;
	}
	public Date getDateFinEffective() {
		return dateFinEffective;
	}
	public void setDateFinEffective(Date dateFinEffective) {
		this.dateFinEffective = dateFinEffective;
	}
	public Double getProportionProjet() {
		return proportionProjet;
	}
	public void setProportionProjet(Double proportionProjet) {
		this.proportionProjet = proportionProjet;
	}
	
	
	
	
	@ManyToOne()
	public Projet getProjet() {
		return projet;
	}
	public void setProjet(Projet projet) {
		this.projet = projet;
	}
	
	
	
	@Override
	public String toString() {
		return "Phase [code=" + code + ", label=" + label + ", description=" + description + ", dateDebut=" + dateDebut
				+ ", dateFinPrevue=" + dateFinPrevue + ", dateFinEffective=" + dateFinEffective + ", proportionProjet="
				+ proportionProjet + "]";
	}
	public Phase(Long code, String label, String description, Date dateDebut, Date dateFinPrevue, Date dateFinEffective,
			Double proportionProjet, Projet projet) {
		super();
		this.code = code;
		this.label = label;
		this.description = description;
		this.dateDebut = dateDebut;
		this.dateFinPrevue = dateFinPrevue;
		this.dateFinEffective = dateFinEffective;
		this.proportionProjet = proportionProjet;
		this.projet = projet;
	}
	public Phase() {
		super();
	} 
	
	
	
	
	
}
