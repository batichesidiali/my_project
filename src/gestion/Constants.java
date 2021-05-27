package gestion;

import java.io.File;

import javafx.stage.Screen;

public class Constants {
	
	public static final String USER_HOME = System.getProperty("user.home");

	public static final String LOGIN_ERROR_MSG = "Le mot de passe ou le nom d'utilisateur est invalide";
	
	public static double ECRAN_LARGEUR = Screen.getPrimary().getVisualBounds().getWidth();
	public static double ECRAN_HAUTEUR = Screen.getPrimary().getVisualBounds().getHeight();
	
	public static String CONFIG_PATH = USER_HOME + File.separatorChar + "Desktop\\config.properties";
	public static String DATA_FILE = USER_HOME + File.separatorChar + "Desktop\\employe.emp";
	
	public static String REPORT_PATH = USER_HOME + File.separatorChar + "eclipse-workspace\\my_project\\res\\employe.jrxml";
	public static String REPORT_TARGET = USER_HOME + File.separatorChar + "Desktop\\employe.pdf";
	
	
}
