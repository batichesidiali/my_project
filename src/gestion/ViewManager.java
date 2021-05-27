package gestion;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import jfxtras.styles.jmetro.JMetro;
import jfxtras.styles.jmetro.Style;

public class ViewManager {
	
	private static ViewManager instance = null;
	
	private ViewManager() {
		
	}
	
	public static ViewManager getInstance() {
		if(instance == null) {
			instance = new ViewManager();
		}
		return instance;
	} 
	
	// afficher une vue
	public void openView(String view){
		
		JMetro metro = new JMetro(Style.LIGHT);
		
		Stage stage = new Stage();
		stage.setTitle(view);
		
		Parent root = null;
		try {
			root = FXMLLoader.load(getClass().getResource("ui/"+view+".fxml"));
		} catch (IOException e) {
			System.out.printf("La vue %s n'existe pas",view);
		}
		
		Scene scene = new Scene(root);
		
		metro.setScene(scene);
		stage.setScene(scene);
		stage.show();
	}
	
	
	// afficher une vue en spécifiant l'objet Stage
	private void openView(String view,Stage stage){
		
		stage.setTitle(view);
		stage.setResizable(false);
		
		Parent root = null;
		try {
			root = FXMLLoader.load(getClass().getResource("ui/"+view+".fxml"));
		} catch (IOException e) {
			System.out.printf("La vue %s n'existe pas",view);
		}
		
		Scene scene = new Scene(root);
		JMetro metro = new JMetro(Style.LIGHT);
		metro.setScene(scene);
		stage.setScene(scene);
		stage.show();
	}
	
	// afficher une vue en spécifiant si la vue est undecorated ou maximized
	public void openView (String view,boolean decorated,boolean maximized) {
		
		Stage stage = new Stage();
		
		if(decorated) {
			stage.initStyle(StageStyle.UNDECORATED);
		}
		if(maximized) {

			stage.setHeight(Constants.ECRAN_HAUTEUR);
			stage.setWidth(Constants.ECRAN_LARGEUR);
		}
		
		
		openView(view,stage);
	}
	
	//Fermer une vue
	public void closeView(Stage stage) {
		stage.close();
	}

}
