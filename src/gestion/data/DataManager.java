package gestion.data;

import gestion.beans.Employe;

public interface DataManager {
	
	public Employe lireInfos();
	public Employe EcrireInfos(Employe employe);

}
