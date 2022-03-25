package com.m2i.tp.appliSpringJpa.dao;

import java.lang.reflect.Field;

import com.m2i.tp.appliSpringJpa.entity.Employe;

public class TestIntrospection {

	public static void main(String[] args) {
		Employe emp1 = new Employe(1L, "jean", "bon", "012345678925", "jean@test.com", "login", "pass");
		
		try {
			Class c = emp1.getClass();
			for(Field f: c.getDeclaredFields()) {
				
				f.setAccessible(true); // popur pouvoir accedeer aux éléments privés, s
				Object valeur = f.get(emp1);
				System.out.println(f.getName()+" "+f.getType().getName()+" "+valeur);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//field est un objet techinque aui decrit d'un attribut de la classe
	}

}
