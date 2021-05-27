package gestion.reporting;

import gestion.data.DataManager;
import gestion.data.DataManagerFactory;
import net.sf.jasperreports.engine.JRException;

public abstract class ReportFactory {
	
	protected DataManager dao = null;
	
	public ReportFactory() throws Exception {
		
		this.dao = DataManagerFactory.getInstance().getDao();
	}
	
	
	
	public abstract void createReport() throws JRException;

}
