package gestion.validation.decoration;

import java.lang.reflect.Field;
import gestion.validation.ValidationUtils;

public class DefaultDecorator extends Decorator {

	@Override
	public void decorate(Object target,Field champ) {
		
		Class<?>[] argTypes = {String.class};
		Object[] args = {"-fx-border-color: red ; "
				        + "-fx-border-width: 2px ;"};
		
		ValidationUtils.invokeMethod(champ, target, "setStyle",argTypes,args);
	}

}
