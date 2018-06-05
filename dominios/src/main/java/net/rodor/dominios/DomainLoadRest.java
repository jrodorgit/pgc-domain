package net.rodor.dominios;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.rodor.dominios.vo.DomainBean;


//@javax.ws.rs.Path("/domainload")
public class DomainLoadRest {
	/*
	//URL:
	// http://127.0.0.1:9080/JRodorRest/rest/domainload?appName=SICOSS&domainName=CONCEPTOS+GASTO&date=15/01/2018
	@javax.ws.rs.GET
	 public String load(@javax.ws.rs.QueryParam("appName") String appName,
			 @javax.ws.rs.QueryParam("domainName") String domainName,
			 @javax.ws.rs.QueryParam("date") String fecha) {
		
		
		System.out.println("Ejecutando microservicio domain load");
		
		//validar que domainName no es nulo ni cadena vacia.
		if( domainName == null || "".equalsIgnoreCase(domainName)){
			return null;
		}
		
		// validar que formato fecha es correcto
		Timestamp fechaConsulta = null;
		if( fecha != null && !"".equalsIgnoreCase(fecha)){
			//validamos formato
			//formato admitido dd/mm/yyyy
			String regex = "^(3[01]|[12][0-9]|0[1-9])/(1[0-2]|0[1-9])/[0-9]{4}$";
			Pattern pattern = Pattern.compile(regex);
		    Matcher matcher = pattern.matcher(fecha);
		    if(!matcher.matches()){
		    	return null;
		    }
		    DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		    Date date = null;
		    try{
		        date = df.parse(fecha);
		        fechaConsulta = new java.sql.Timestamp(date.getTime());
		    }
		    catch ( Exception ex ){
		    	ex.printStackTrace();
		        return null;
		    }

			 
		}
		
		DomainsLoader domainLoader = DomainsLoader.getInstance();
		Hashtable<String, DomainBean> dvs = null;
		try {
			//dvs = domainLoader.loadActiveDomain("SICOSS","CONCEPTOS GASTO" , null);
			dvs = domainLoader.loadActiveDomain(appName,domainName , fechaConsulta);
		} catch (SQLException  e) {
			
			e.printStackTrace();
		} catch (DomainException e) {
			
			e.printStackTrace();
		}
		
		
		StringBuffer str = new StringBuffer("[");
		if(dvs != null && dvs.size()>0 ){
			System.out.println("numero valores del dominio:"+dvs.size());
			Enumeration<String> claves = dvs.keys();
			
			while(claves.hasMoreElements()){
				str.append(dvs.get(claves.nextElement()).toJSONFormat());
				if(claves.hasMoreElements()){
					str.append(",");
				}
				
			}
		}
		str.append("]");
	    return str.toString();
	 }*/
}
