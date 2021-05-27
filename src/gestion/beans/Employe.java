package gestion.beans;

import java.io.Serializable;
import java.time.LocalDate;


public class Employe implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	private String nom ="";
	private String prenom="";
	private LocalDate date_naissance;
	private String lieu_naissance;
	private String commune="";
	private String Daira="";
	private String Wilaya="";
	private String adresse="";
	private String situation_familialle="";
	
	public Employe() {
		
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

	public LocalDate getDate_naissance() {
		return date_naissance;
	}

	public void setDate_naissance(LocalDate date) {
		this.date_naissance = date;
	}

	public String getLieu_naissance() {
		return lieu_naissance;
	}

	public void setLieu_naissance(String lieu_naissance) {
		this.lieu_naissance = lieu_naissance;
	}

	public String getCommune() {
		return commune;
	}

	public void setCommune(String commune) {
		this.commune = commune;
	}

	public String getDaira() {
		return Daira;
	}

	public void setDaira(String daira) {
		Daira = daira;
	}

	public String getWilaya() {
		return Wilaya;
	}

	public void setWilaya(String wilaya) {
		Wilaya = wilaya;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getSituation_familialle() {
		return situation_familialle;
	}

	public void setSituation_familialle(String situation_familialle) {
		this.situation_familialle = situation_familialle;
	}

	@Override
	public String toString() {
		return "Employe [nom=" + nom + ", prenom=" + prenom + ", date_naissance=" + date_naissance + ", commune="
				+ commune + ", Daira=" + Daira + ", Wilaya=" + Wilaya + ", adresse=" + adresse
				+ ", situation_familialle=" + situation_familialle + "]";
	}
	
	
	
	
	
	
	
	

}
