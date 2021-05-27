package gestion;

public class ConsoleErrorManager implements ErrorManager{

	@Override
	public void printError(String erreur) {
		System.out.println("Erreur : "+erreur);
		
	}

}
