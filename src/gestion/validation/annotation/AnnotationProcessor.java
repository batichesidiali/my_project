package gestion.validation.annotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class AnnotationProcessor {

	public static Object buildValidator(String packageName,String annotationName) {
		
		String validatorName = packageName.concat(".").concat(annotationName).concat("Validator");
		Object validator = null;
		try {
			Class<?> validatorClass = Class.forName(validatorName);
			Constructor<?> constructor = validatorClass.getConstructor(String.class);
			validator = constructor.newInstance("Erreur sur le champ");
			
		} catch (ClassNotFoundException e) {
			System.out.println("Erreur nom de classe");
		} catch (IllegalAccessException e) {
			
		} catch (IllegalArgumentException e) {
			
		} catch (InvocationTargetException e) {
			
		} catch (NoSuchMethodException e) {
		
		} catch (SecurityException e) {
		
		} catch (InstantiationException e) {
	
		}
		
		return validator;
		
	}
}
