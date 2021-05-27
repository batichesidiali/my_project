package gestion.auth;

import gestion.filter.Filter;
import gestion.filter.FilterChain;
import gestion.filter.Request;

public class AuthenticationFilter implements Filter {

	@Override
	public void doFilter(Request request, FilterChain chain) {
		
		String user = (String)request.getParameter("username");
		String password = (String)request.getParameter("password");
		
		if(user.equals("batiche") && password.equals("123")){
			request.addParameter("response",true);
		}else {
			request.addParameter("response", false);
		}		
		
		chain.doFilter(request);
	}

}
