package gestion.validation;

import java.lang.reflect.Field;
import java.util.regex.Pattern;

public class RegexValidator extends Validator {

	public RegexValidator(String errorMsg) {
		super(errorMsg);
	}

	@Override
	public boolean validate(Object source,Field champ) {
		
		String value = ValidationUtils.getValueOf(champ, source);
		
		if(Pattern.matches("[a-z]*", value)) {
			return false;
		}
		
		return true;
	}

}
