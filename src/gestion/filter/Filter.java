package gestion.filter;

public interface Filter {
	
	public void doFilter(Request request, FilterChain chain);
	
}
