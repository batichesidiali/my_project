package gestion.auth;

import gestion.beans.User;
import gestion.filter.FilterChain;
import gestion.filter.Request;
import gestion.filter.Target;

public class AuthenticationManager implements Target {
	
	public final static boolean AUTHENTICATION_OK = true;
	public static boolean isAuthenticated = false;
	FilterChain chain = null;
	
	public AuthenticationManager() {
		
		chain = new FilterChain();
		chain.setTarget(this);
	}

	@Override
	public void execute(Request request,FilterChain chain) {
		
		isAuthenticated = (Boolean)request.getParameter("response");
		
	}
	
	public void authenticate(User user) {
		
		Request request = new Request();
		request.addParameter("username", user.getUsername());
		request.addParameter("password", user.getPassword());
		
		AuthenticationFilter filter = new AuthenticationFilter();
		
		chain.addFilter(filter);
		chain.doFilter(request);
		
	}

}
