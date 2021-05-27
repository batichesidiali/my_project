package gestion.reporting;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import gestion.Constants;
import gestion.beans.Employe;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

public class PDFReportFactory extends ReportFactory {
	

	public PDFReportFactory() throws Exception {
		super();
	}

	@Override
	public void createReport() throws JRException {
		
		String report_path = Constants.REPORT_PATH;
		String output_path = Constants.REPORT_TARGET;
		
		JasperReport report = JasperCompileManager.compileReport(report_path);
		
		List<Employe> employees = new ArrayList<Employe>();
		Employe employe = dao.lireInfos() ;
		
		employees.add(employe);
		
		JRBeanCollectionDataSource datasource = new JRBeanCollectionDataSource(employees);
		
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("beansource", datasource);
		
		JasperPrint jasperPrint = JasperFillManager.fillReport(report, params, datasource);
		
		JasperViewer.viewReport(jasperPrint);
		
		OutputStream ws = null;
		
		try {
			
			ws = new FileOutputStream(new File(output_path));
			
		} catch (FileNotFoundException e) {
			System.out.println("Erreur : export du fichier impossible");
		}
		
		// Exporter le fichier PDF
		JasperExportManager.exportReportToPdfStream(jasperPrint, ws);

	}

}
