package gestion.ui;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

import gestion.validation.ValidationManager;
import gestion.validation.annotation.Empty;


public class InscriptionController implements Initializable {
		
	@Empty
	@FXML
	public TextField fld_user;
	
	@Empty
	@FXML
	public TextField fld_password;
	@FXML
	public TextField fld_confirm;
	@FXML
	private Button btn_inscription;
	
	
	@FXML
	private void inscription(Event event) {
		
	}
	
	@FXML void check(Event event) {
		
		
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		ValidationManager vmanager = new ValidationManager(this);
		vmanager.validate();
	}

}
