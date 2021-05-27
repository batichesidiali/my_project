package gestion.validation;

import java.lang.reflect.Field;

public class FixedValidator extends Validator{

	public FixedValidator(String errorMsg) {
		super(errorMsg);
	}

	@Override
	public boolean validate(Object source,Field champ) {
		
		String value = ValidationUtils.getValueOf(champ, source);
		
		if(value.length()>5) {
			return false;
		}
		
		return true;
	}

}
