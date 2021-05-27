package gestion.filter;

public interface Target {
	
	public void execute(Request request,FilterChain chain);
}
