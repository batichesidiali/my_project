package gestion;

import javafx.application.Application;
import javafx.stage.Stage;

public class GestionApplication extends Application {
	
	private ApplicationContext context = ApplicationContext.getContext();
	
	
	@Override
	public void start(Stage primaryStage) {
		
		ViewManager vmanager = ViewManager.getInstance();
		
		if(context.EstInscrit.equals("true")) {
			vmanager.openView("Login");
		}else {
			vmanager.openView("Inscription");
		}
	}
	
	
}
