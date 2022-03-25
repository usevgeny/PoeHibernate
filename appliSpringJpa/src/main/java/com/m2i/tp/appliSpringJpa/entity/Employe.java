package com.m2i.tp.appliSpringJpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
// @Getter @Setter // technologie lumbok
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
	

	
	

}

// @Entity , @Id sont obliigatoires
// @GeneratedValue obligatoire si les valeur sont geenres automatiquement 



