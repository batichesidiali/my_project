package gestion.ui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import gestion.ViewManager;
import gestion.auth.AuthenticationManager;
import gestion.beans.User;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class LoginControler implements Initializable {
	
	ViewManager viewManager = ViewManager.getInstance();
	
	@FXML private AnchorPane fen_connexion;
	@FXML private TextField userField;
	@FXML private PasswordField passwordField;
	@FXML private Button btnConnexion;
	
	@FXML
	public void connect(Event event) throws IOException {
		
		KeyCode kcode = null;
		if(event.getClass()==KeyEvent.class) {
			KeyEvent ke = (KeyEvent)event;
			kcode = ke.getCode();
		}
		
		if(event.getSource()==btnConnexion | kcode == KeyCode.ENTER) {
			
			Stage viewLogin = (Stage)btnConnexion.getScene().getWindow();
			
			User user= new User();
			user.setUsername(userField.getText());
			user.setPassword(passwordField.getText());
			
			AuthenticationManager authManager = new AuthenticationManager();
			authManager.authenticate(user);
			
			if(AuthenticationManager.isAuthenticated) {
				viewManager.closeView(viewLogin);
				viewManager.openView("Main", true, true);
			}else {
				
			}
		
		}
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
	}

}
