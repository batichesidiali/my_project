package gestion.validation;

import java.lang.reflect.Field;

public class EmptyValidator extends Validator {

	public EmptyValidator(String errorMsg) {
		super(errorMsg);
		
	}

	@Override
	public boolean validate(Object source,Field champ) {
		
		String value = ValidationUtils.getValueOf(champ, source);
		
		if(value.isEmpty()) {
			return false;
		}
		
		return true;
	}

}
