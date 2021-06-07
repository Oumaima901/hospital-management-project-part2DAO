package gest.hosp.web.model;

import java.io.Serializable;

public class Docteur implements Serializable {
	
	private int id;
	private String nom;
	private String prenom;
	private String email;
	private String specialisation ;
	private String numero;
	private String adresse;
	public Docteur() {
		super();
	}
	public Docteur(int id, String nom, String prenom, String email, String specialisation, String numero, String adresse) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.specialisation = specialisation;
		this.numero = numero;
		this.adresse = adresse;
	}
	public Docteur( String nom, String prenom, String email, String specialisation, String numero, String adresse) {
		super();
	
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.specialisation = specialisation;
		this.numero = numero;
		this.adresse = adresse;
	}
	@Override
	public String toString() {
		return "Docteur [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", specialisation="
				+ specialisation + ", numero=" + numero + ", adresse=" + adresse + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSpecialisation() {
		return specialisation;
	}
	public void setSpecialisation(String specialisation) {
		this.specialisation = specialisation;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	
	

}
