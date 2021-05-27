package gestion.filter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FilterChain {
	
	private List<Filter> filters = new ArrayList<Filter>();
	private Iterator<Filter> iterator;
	private Target target = null;

	public FilterChain() {
		
	}
	
	public void addFilter(Filter filter) {
		filters.add(filter);
	}
	
	public void doFilter(Request request) {
		
		if(iterator == null) {
			iterator = filters.iterator();
		}
		if(iterator.hasNext()) {
			iterator.next().doFilter(request, this);
		}else {
			target.execute(request, this);
			
		}
		
	}
	
	public Target getTarget() {
		return this.target;
	}
	
	public void setTarget(Target target) {
		this.target = target;
	}
	
	

}
