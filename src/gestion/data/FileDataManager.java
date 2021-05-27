package gestion.data;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import gestion.Constants;
import gestion.beans.Employe;

public class FileDataManager implements DataManager{

	private String chemin = Constants.DATA_FILE;
	
	@Override
	public Employe lireInfos() {
		
		File dataSource = new File(chemin);
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		Employe employe = null;
		
		try {
			
			fis = new FileInputStream(dataSource);
			ois = new ObjectInputStream(fis);
			
			employe = (Employe)ois.readObject();
	
		}catch (IOException | ClassNotFoundException e){
			e.printStackTrace();
		}finally {
			try {
				if(ois != null) {
					fis.close();
					ois.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return employe;
	}

	@Override
	public Employe EcrireInfos(Employe employe) {
		
		File dataSource = new File(chemin);
		ObjectOutputStream oos = null;
		FileOutputStream fos = null;
		
		try {
			
			fos = new FileOutputStream(dataSource);
		    oos = new ObjectOutputStream(fos);
			oos.writeObject(employe);
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}finally {
			
			if(oos != null) {
				try {
					fos.close();
					oos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}
		}
		
		return employe;
	}

}
