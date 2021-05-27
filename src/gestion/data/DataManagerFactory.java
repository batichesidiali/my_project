package gestion.data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

import gestion.Constants;

public class DataManagerFactory {
	
	private static DataManagerFactory instance = null;
	
	private DataManagerFactory() {
		
	}
	
	public static DataManagerFactory getInstance() {
		
		if(instance == null) {
			
			instance = new DataManagerFactory();
			return instance;
			
		}else {
			return instance;
		}
			
	}
	
	public DataManager getDao() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		
		Properties properties = new Properties();
	    FileInputStream fis = null;
	    DataManager dao = null;
	    
		try {
			fis = new FileInputStream(Constants.CONFIG_PATH);
		} catch (FileNotFoundException e) {
			System.out.println("Le chemin vers le fichier de configuration est faux ");
		}
	    
	      try{

	         properties.load(fis);
	         String daoName = properties.getProperty("daoType");
	         
	         try {
					
					Class<?> daoClass = Class.forName(daoName);
					dao = (DataManager)daoClass.getConstructor().newInstance();
					
			 } catch (ClassNotFoundException e) {
					
					System.out.println("le type DAO dans le fichier de configuration est faux ");
			 }
	         

	      } catch (IOException e) {
			
		}finally{

	         try {
				fis.close();
			} catch (IOException e) {
				
			}

	      } 
		
		return dao;
		
	}

}
