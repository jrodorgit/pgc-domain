package net.rodor.dominios;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;


public class DomainRestService extends Application{
	private Set<Object> singletons = new HashSet<Object>();
	   private Set<Class<?>> empty = new HashSet<Class<?>>();
	 
	   public DomainRestService() {
	      singletons.add(new DomainLoadRest());
	   }
	 
	   @Override
	   public Set<Class<?>> getClasses() {
	      return empty;
	   }
	 
	   @Override
	   public Set<Object> getSingletons() {
	      return singletons;
	   }
}
