package com.cibertec.edu.matricula.entidades;

public class Provincia {
	
	public Integer id_prov;
	public String nombre;
	public Integer id_depa;
	public String nom_depa;
	
	public Provincia() {
	}
	
	public Provincia(Integer id_prov, String nombre, Integer id_depa) {
		super();
		this.id_prov = id_prov;
		this.nombre = nombre;
		this.id_depa = id_depa;
	}


	public Provincia(Integer id_prov, String nombre, Integer id_depa, String nom_depa) {
		super();
		this.id_prov = id_prov;
		this.nombre = nombre;
		this.id_depa = id_depa;
		this.nom_depa = nom_depa;
	}



	public Integer getId_prov() {
		return id_prov;
	}

	public void setId_prov(Integer id_prov) {
		this.id_prov = id_prov;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getId_depa() {
		return id_depa;
	}

	public void setId_depa(Integer id_depa) {
		this.id_depa = id_depa;
	}

	public String getNom_depa() {
		return nom_depa;
	}

	public void setNom_depa(String nom_depa) {
		this.nom_depa = nom_depa;
	}

	
	
	
}
