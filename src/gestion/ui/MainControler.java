package gestion.ui;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ResourceBundle;

import gestion.Constants;
import gestion.beans.Employe;
import gestion.data.DataManager;
import gestion.data.DataManagerFactory;
import gestion.reporting.PDFReportFactory;
import gestion.reporting.ReportFactory;
import gestion.validation.ValidationManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class MainControler implements Initializable {
	
	private static DataManager dao = null;
	private static ReportFactory reportFactory = null;
	private boolean estModifiable; 
	
	@FXML private Button btnClose;
	@FXML private Button btnMinimize;
	@FXML private Button btn_lire;
	@FXML private Button btn_ecrire;
	@FXML private Button btn_imprimer;
	@FXML private TextField fld_nom;
	@FXML private TextField fld_prenom;
	@FXML private DatePicker fld_date_naissance;
    @FXML private TextField fld_lieu_naissance;
    @FXML private ComboBox<String> cmb_situation_famille;
    @FXML private ComboBox<String> cmb_commune;
    @FXML private ComboBox<String> cmb_daira;
    @FXML private ComboBox<String> cmb_wilaya;
    @FXML private TextField fld_adresse;
	
	public MainControler() throws Exception {
		dao = DataManagerFactory.getInstance().getDao();
	}
		
	
	@FXML void close(ActionEvent event){
		Stage stage = (Stage)btnClose.getScene().getWindow();
		stage.close();
				
	}
	
	@FXML void minimize(ActionEvent event) {
		Stage stage = (Stage)btnClose.getScene().getWindow();
		if(stage.isIconified()==false) {
			stage.setIconified(true);
		}
	}
	
	@FXML void lire() {
		
		Employe employe = dao.lireInfos();
		System.out.println(employe.toString());
	}
	
	@FXML void valider() {
		
		
	}
	
	@FXML void ecrire() {
		
		Employe employe = new Employe();
		employe.setNom(fld_nom.getText());
		employe.setPrenom(fld_prenom.getText());
		employe.setDate_naissance(fld_date_naissance.getValue());
		employe.setCommune(cmb_commune.getValue());
		employe.setDaira(cmb_daira.getValue());
		employe.setWilaya(cmb_wilaya.getValue());
		employe.setAdresse(fld_adresse.getText());
		employe.setSituation_familialle(cmb_situation_famille.getValue());
		employe.setLieu_naissance(fld_lieu_naissance.getText());
				
		dao.EcrireInfos(employe);
	}
	
	@FXML void imprimer() throws Exception {
		
		reportFactory = new PDFReportFactory();
		reportFactory.createReport();
	}


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		estModifiable = false;
		//btn_ecrire.setDisable(true);
		
		if(Files.exists(Path.of(Constants.DATA_FILE))) {
			
			Employe employe = dao.lireInfos();
			fld_nom.setText(employe.getNom());
			fld_prenom.setText(employe.getPrenom());
			fld_date_naissance.setValue(employe.getDate_naissance());
			fld_lieu_naissance.setText(employe.getLieu_naissance());
			cmb_situation_famille.setValue(employe.getSituation_familialle());
			cmb_commune.setValue(employe.getCommune());
			cmb_daira.setValue(employe.getDaira());
			cmb_wilaya.setValue(employe.getWilaya());
			fld_adresse.setText(employe.getAdresse());
			
			ValidationManager vmanager = new ValidationManager(this);
			vmanager.validate();
			
			
		}

		
		ObservableList<String> list = FXCollections.observableArrayList("marié","célibataire");
		ObservableList<String> communes = FXCollections.observableArrayList("Akbou","Oued ghir","Béjaia");
		ObservableList<String> dairas = FXCollections.observableArrayList("Akbou","Béjaia","Smaoun");
		ObservableList<String> wilayas = FXCollections.observableArrayList("Béjaia","Alger","Oran","Annaba");
		
		cmb_commune.setItems(communes);
		cmb_daira.setItems(dairas);
		cmb_wilaya.setItems(wilayas);
		cmb_situation_famille.setItems(list);
		
	}


	public boolean EstModifiable() {
		return estModifiable;
	}


	public void setModifiable(boolean estModifiable) {
		this.estModifiable = estModifiable;
	}
	
}
