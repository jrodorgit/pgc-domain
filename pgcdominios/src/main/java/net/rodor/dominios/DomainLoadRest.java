package net.rodor.dominios;

import java.sql.SQLException;
import java.util.Collection;
import java.util.Iterator;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;

import net.rodor.dominios.vo.DomainBean;


//http://localhost:8080/pgcdominios/rest/dominios/load
@Path("/dominios")
public class DomainLoadRest{
	
	@GET
	@Path("/load")
	 public Response load() {
		
		
		System.out.println("Ejecutando microservicio domain load");
		return Response.ok().build();
	}
	@GET
	@Path("/loadb")
	@Produces("application/json")
	 public String loadb() {
		
		
		System.out.println("Ejecutando microservicio domain loadb***");
		DomainCache domainCache = DomainCache.getInstance();
		Collection<DomainBean> dvscache=null;
		try {
			dvscache = domainCache.getDomainValues("SICOSS","CONCEPTOS GASTO");
			
		} catch (SQLException | DomainException e) {
			
			e.printStackTrace();
		}
		
		return dvscache.toString();
		//return "[{\"name\":\"jose\"}]";
	}
	@GET
	@Path("/loadc/{app}/{domain}")
	@Produces("application/json")
	 public String loadc(@PathParam("app") String app, @PathParam("domain") String domain) {
		
		System.out.println("*** Ejecutando microservicio domain loadc ***");
		System.out.println("*** app:"+app);
		System.out.println("*** domain:"+domain);
		DomainCache domainCache = DomainCache.getInstance();
		Collection<DomainBean> dvscache=null;
		try {
			dvscache = domainCache.getDomainValues(app, domain);
			
		} catch (SQLException | DomainException e) {
			
			e.printStackTrace();
		}
		
		return dvscache.toString();
		//return "[{\"name\":\"jose\"}]";
	}
//	
//	@GET
//	@Path("/{param}")
//	public Response printMessage(@PathParam("param") String msg) {
//
//		System.out.println("Ejecutando microservicio domain");
//		String result = "Restful example : " + msg;
//
//		return Response.status(200).entity(result).build();
//
//	}
	/*//URL:
	// http://127.0.0.1:9080/JRodorRest/rest/domainload?appName=SICOSS&domainName=CONCEPTOS+GASTO&date=15/01/2018
	@javax.ws.rs.GET
	 public String load(@javax.ws.rs.QueryParam("appName") String appName,
			 @javax.ws.rs.QueryParam("domainName") String domainName) {
		
		
		System.out.println("Ejecutando microservicio domain");
		
		//validar que domainName no es nulo ni cadena vacia.
		if( domainName == null || "".equalsIgnoreCase(domainName)){
			return null;
		}
		if( appName == null || "".equalsIgnoreCase(appName)){
			return null;
		}
		
		
		
		DomainCache domainLoader = DomainCache.getInstance();
		Collection<DomainBean> dvs = null;
		try {
			
			dvs = domainLoader.getDomainValues(appName, domainName);
		} catch (SQLException  e) {
			e.printStackTrace();
			
		} catch (DomainException e) {
			e.printStackTrace();
			
		}
		if(dvs != null) {
			return dvs.toString();
		}
		return "Error";
		
		StringBuffer str = new StringBuffer("[");
		if(dvs != null && dvs.size()>0 ){
			System.out.println("numero valores del dominio:"+dvs.size());
			Iterator<DomainBean> iter = dvs.iterator();
			while(iter.hasNext()){
				DomainBean db = iter.next();
				str.append(db.toJSONFormat());
				str.append(",");
				
				
			}
		}
		str.append("]");
	    return str.toString();
	 }*/
}
