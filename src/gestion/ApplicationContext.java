package gestion;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;

public class ApplicationContext {
	
	private static ApplicationContext context = null;
	
	public ErrorManager errorManager = null;
	public String EstInscrit = "false"; 
	public String validator = null;
	
	private ApplicationContext() {
		loadProperties();
		errorManager = ErrorManagerFactory.getInstance().getErrorManager();
	}
	
	public static ApplicationContext getContext() {
		
		if(context == null) {
			
			context = new ApplicationContext();
			return context;
		}else {
			return context;
	}
		
	}
	
	// Charger les propriétés globales de l'application 
		
	private Properties loadProperties() {
		
		InputStream fis = null;
		try {
			fis = Files.newInputStream(Path.of(Constants.CONFIG_PATH));
			
		} catch (IOException e) {
			System.out.println("Erreur chemin introuvable vers le fichier de conifguration");
		}
		
		Properties properties = new Properties();
		try {
			properties.load(fis);
			this.EstInscrit = properties.getProperty("estInscrit");
			this.validator = properties.getProperty("validatorType");
			
		} catch (IOException e) {
			System.out.println("Erreur du chargement de fichier de configuration");
		}
		
		
		return properties;
		
	}
		
	}
	
	
	


