package gestion.validation;


import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import gestion.validation.annotation.AnnotationProcessor;
import gestion.validation.decoration.Decorator;
import gestion.validation.decoration.DefaultDecorator;
import javafx.scene.Node;

public class ValidationManager {
	
	private Object target;
	private Map<Field,List<Validator>> validators = new HashMap<Field,List<Validator>>();
	private Decorator decorator;
	
	
	
	public ValidationManager(Object target) {
		super();
		this.target = target;
		this.setDecorator(new DefaultDecorator());
		build();
	}
	
	public Decorator getDecorator() {
		return decorator;
	}

	public void setDecorator(Decorator decorator) {
		this.decorator = decorator;
	}

	private void build(){
		
		Field[] fields = target.getClass().getDeclaredFields();
		
		for (Field field : fields) {
			
			List<Validator> listValidators = new ArrayList<Validator>();
			validators.put(field, listValidators);
			
			for(Annotation annotation:field.getDeclaredAnnotations() ) {
				
				if(!annotation.annotationType().getSimpleName().equals("FXML")) {
					
				Package packag = this.getClass().getPackage();
				Validator validator = (Validator) AnnotationProcessor
						.buildValidator(packag.getName(),annotation.annotationType().getSimpleName());
				
				registerValidator(field,validator);
				}
			}
			
		}	
	}
	
	public boolean validate() {
		
		Set<Field> fields = validators.keySet();
		for(Field field:fields) {
			try {
				Node node = (Node)field.get(target);
				node.setOnKeyTyped(f -> validateField(field));
				
			} catch (IllegalArgumentException | IllegalAccessException e) {
				
			}
			
		}
		
		return true;
	}
	
	
	private void validateField(Field champ) {
		
		Iterator<Validator> iterator = validators.get(champ).iterator();
		while(iterator.hasNext()) {
			Validator validator = iterator.next();
			if(validator.validate(target, champ)==Validator.NOT_VALID) {
				decorator.decorate(target, champ);
			}else {
				decorator.initDecor(target, champ);
			}
		}
	}
	
	private void registerValidator(Field champ,Validator validator) {
		validators.get(champ).add(validator);
	}	
	

}
