package com.m2i.tp.appliSpringJpa.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity // entité persistance
//@DiscriminatorValue("ChefProjet") // en fait la valeur par defaut c'est le nom de la classe; donc meme pas besoin de le preciser si c'est le meme 
public class ChefProjet extends Employe{
	
	private String methodologie; // exemple "XP;SCRUM;MERISE" ou "SCRUM"  

	
	
	
	public ChefProjet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ChefProjet(Long empId, String firstname, String lastname, String phoneNumber, String email, String login,
			String password) {
		super(empId, firstname, lastname, phoneNumber, email, login, password);
		// TODO Auto-generated constructor stub
	}

	public String getMethodologie() {
		return methodologie;
	}

	public void setMethodologie(String methodologie) {
		this.methodologie = methodologie;
	}

	@Override
	public String toString() {
		return "ChefProjet [methodologie=" + methodologie + ", getEmpId()=" + getEmpId() + ", getFirstname()="
				+ getFirstname() + ", getLastname()=" + getLastname() + ", getPhoneNumber()=" + getPhoneNumber()
				+ ", getEmail()=" + getEmail() + ", getLogin()=" + getLogin() + ", getPassword()=" + getPassword()
				+ ", toString()=" + super.toString() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ "]";
	}
	
	
	
	

}
