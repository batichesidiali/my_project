package gestion.filter;

import java.util.HashMap;
import java.util.Map;

public class Request {
	
	private Map<String,Object> parameters = new HashMap<String,Object>();
	private Object source;
	
	public void addParameter(String key,Object object) {
		parameters.put(key, object);
	}
	
	public Object getParameter(String parameter) {
		
		return parameters.get(parameter);
	}
	
	public void setParameter(String key,Object object) {
		parameters.replace(key,object);
	}
	
	public Map<String,Object> getParameters() {
		return this.parameters;
	}

	public Object getSource() {
		return source;
	}

	public void setSource(Object source) {
		this.source = source;
	}

	
}
