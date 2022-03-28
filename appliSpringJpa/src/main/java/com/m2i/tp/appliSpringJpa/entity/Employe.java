package com.m2i.tp.appliSpringJpa.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

@Entity
@NamedQuery(name="Employe.findEmployeWithNameBeginBy",
query="SELECT e FROM Employe e WHERE e.lastname LIKE :debut")
// @Getter @Setter // technologie lumbok


@Inheritance(strategy = InheritanceType
.SINGLE_TABLE)
@DiscriminatorColumn(name="type_employe", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("Employe") // possible de lindique car ce n'est pas une callse abstract


public class Employe {
	
	@Column(name="EMP_ID")
	@Id // pour dire que EMP_ID est la cléf promaire(primary key)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@GeneratedValue pour dire que la valeur de empI dsera généré par autoincrementation 
	// par la base des données los dun INSERT_TO sql(déclinché par entityManager.persist())
	// @GeneratedValue permet de bien remonter la valauer de EmpIden memoire dans l'attribut empId la valeur autoincrementé par la base
	// la strategie identity est une maniere dautoincrementation qui est compatible avec plein de bases recentes (avec les versions récentes de mysql/MariaDB/, PostgresQl, Oracle, H2, 
	
	
	private Long empId; // L et non pas l pour pouvoir mettre null au debut
	
	private String firstname;
	
	private String lastname;
	
	@OneToOne(cascade = CascadeType.ALL) // est proche to ManyToOne
	@JoinColumn(name = "id_adresse", unique = true, nullable = true)// null par defaut sau // unique -true pour dire quel'adresse n'est pas partagée // il vaut meux que des le debut chaque personne ait sa propre adressse, meme s'ils hanitent ensemble 
	private Adresse adressePrincipale;
	
	@Column(name="PHONE_NUMBER") // attention piège: la technogie MYSQL sous linux ne fait pas de diff Minuscule Majuscule, contrairement à Linux
	private String phoneNumber; 
	//@Column is to point a coumn whish has a different name in tatabase and also to precise length
	private String email;
	
	@Column(name="LOGIN", length= 32) // pour VARCHAR(32) si table crée automatiquement;
	private String login;
	private String password;
	public Long getEmpId() {
		return empId;
	}
	public void setEmpId(Long empId) {
		this.empId = empId;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	

	
	public Adresse getAdressePrincipale() {
		return adressePrincipale;
	}
	public void setAdressePrincipale(Adresse adressePrincipale) {
		this.adressePrincipale = adressePrincipale;
	}
	
	
	
	// constructeur par defaut obligatoire pour le fonctionnement gpa hibernate
	public Employe() {
		super();
	}
	
	// atres contucteurs sont facultatifs
	public Employe(Long empId, String firstname, String lastname, String phoneNumber, String email, String login,
			String password) {
		super();
		this.empId = empId;
		this.firstname = firstname;
		this.lastname = lastname;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.login = login;
		this.password = password;
	}
	
	
	
	
	public Employe(Long empId, String firstname, String lastname, Adresse adressePrincipale, String phoneNumber,
			String email, String login, String password) {
		super();
		this.empId = empId;
		this.firstname = firstname;
		this.lastname = lastname;
		this.adressePrincipale = adressePrincipale;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.login = login;
		this.password = password;
	}
	@Override
	public String toString() {
		return "Employe [empId=" + empId + ", firstname=" + firstname + ", lastname=" + lastname + ", phoneNumber="
				+ phoneNumber + ", email=" + email + ", login=" + login + ", password=" + password + "]";
	}
	

	
	

}

// @Entity , @Id sont obliigatoires
// @GeneratedValue obligatoire si les valeur sont geenres automatiquement 



