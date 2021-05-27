package gestion.validation;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class ValidationUtils {
	
	public static Object invokeMethod(Field field,Object object,String methodName) {
	
		Method method = null;
		Object target = null;
		Object result = null;
		
		try {
			method = field.getType().getMethod(methodName);
			target = field.get(object); 
			result = method.invoke(target);
			
		} catch (NoSuchMethodException e) {
		
			System.out.println("Erreur nom méthode : "+methodName+" "+field.getName()+" "+object);
		} catch (SecurityException e) {
			System.out.println("Erreur acces méthode");
			
		} catch (IllegalAccessException e) {
			System.out.println("Acces interdit au champs privé");
			
		} catch (IllegalArgumentException e) {
			
			System.out.println("Argument faux pour la méthode");
		} catch (InvocationTargetException e) {
			System.out.println("L'objet qui invoke la méthode n'exite pas");
		}
		
		return result;
	}
	
	public static Object invokeMethod(Field field,Object object,String methodName,Class<?>[] params,Object[] paramValues) {
		
		Method method = null;
		Object target = null;
		Object result = null;
		try {
			method = field.getType().getMethod(methodName,params);
			target = field.get(object); 
			result = method.invoke(target,paramValues);
			
		} catch (NoSuchMethodException e) {
		
			System.out.println("Erreur nom méthode : "+methodName+" "+field.getName()+" "+object);
		} catch (SecurityException e) {
			System.out.println("Erreur acces méthode");		
		} catch (IllegalAccessException e) {
			System.out.println("Acces interdit au champs privé");
			
		} catch (IllegalArgumentException e) {
			
			System.out.println("Argument faux pour la méthode");
		} catch (InvocationTargetException e) {
			System.out.println("L'objet qui invoke la méthode n'exite pas");
		}
		
		return result;
	}
	
	public static String getValueOf(Field field,Object source) {
		
		String fieldValue = null;
		
		if( field.getType().equals(TextField.class)) {
			fieldValue = (String) ValidationUtils.invokeMethod(field, source, "getText");
		}else if(field.getType().equals(ComboBox.class)) {
			fieldValue = (String) ValidationUtils.invokeMethod(field, source, "getValue");
		}
		
		return fieldValue;
	}

//Fin de la classe
}

