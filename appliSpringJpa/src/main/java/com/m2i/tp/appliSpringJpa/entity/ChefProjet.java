package com.m2i.tp.appliSpringJpa.entity;

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
