package gestion;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;


public class ErrorManagerFactory {
	
	
private static ErrorManagerFactory instance = null;
	
	private ErrorManagerFactory() {
	
	}
	
	public static ErrorManagerFactory getInstance() {
		
		if(instance == null) {
			
			instance = new ErrorManagerFactory();
			return instance;
			
		}else {
			return instance;
		}
			
	}
	
	
	public ErrorManager getErrorManager()  {
		
		Properties properties = new Properties();
	    FileInputStream fis = null;
	    ErrorManager errorManager = null;
	    
	    try {
			
			fis = new FileInputStream(Constants.CONFIG_PATH);
			properties.load(fis);
			String errorManagerName = properties.getProperty("errorManagerName");
			
			try {
				
				Class<?> errorClass = Class.forName(errorManagerName);
				try {
					errorManager = (ErrorManager)errorClass.getConstructor().newInstance();
					
				} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
						| InvocationTargetException | NoSuchMethodException | SecurityException e) {
					
					e.printStackTrace();
				}
				
			} catch (ClassNotFoundException e) {
				
				System.out.println("le type ErrorManager dans le fichier de configuration est faux ");
			}
			
			
		}catch (FileNotFoundException e) {
			System.out.println("Le chemin vers le fichier de configuration est faux ");
		}catch (IOException e2) {
				
		}finally{

	        try {
	        	
				fis.close();
				
			} catch (IOException e) {
				
			}

	    } 
		
		return errorManager;
		
	}
	
	
}
