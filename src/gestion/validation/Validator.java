package gestion.validation;

import java.lang.reflect.Field;

public abstract class Validator {
	
	public static final boolean VALID = true;
	public static final boolean NOT_VALID = false;
	
	private String errorMsg = null;
	
	public Validator(String errorMsg) {
		this.setErrorMsg(errorMsg);
	}
	
	public abstract boolean validate(Object source,Field champ);

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}


}
