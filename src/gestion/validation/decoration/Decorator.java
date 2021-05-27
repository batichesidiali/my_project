package gestion.validation.decoration;

import java.lang.reflect.Field;

import javafx.scene.Node;

public abstract class Decorator {
	
	public abstract void decorate(Object target,Field champ);
	
	public void initDecor(Object target,Field champ) {
		try {
			Node node = (Node)champ.get(target);
			node.setStyle(null);
			
		} catch (IllegalArgumentException e) {
	
		} catch (IllegalAccessException e) {
			
		}
	} 

}
