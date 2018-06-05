package net.rodor.dominios;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Hashtable;

import net.rodor.dominios.vo.DomainBean;

public class DomainCache {

	private  static DomainCache instance = new DomainCache();
	private  DomainCache() {}
	
	public  static DomainCache getInstance(){
		return instance;
	}
	private static Hashtable<String,Hashtable<String,DomainBean>> dominios = new Hashtable<String,Hashtable<String,DomainBean>>();
	
	/**
	 * Obtiene los elementos activos del dominio nameDomain de la aplicacion app
	 * @param app
	 * @param nameDomain
	 * @return Si no tiene elementos coleccion vacia
	 * @throws SQLException 
	 * @throws DomainException 
	 */
	public Collection<DomainBean> getDomainValues(String app, String nameDomain) throws SQLException, DomainException{
		
		String domainKey  = app+"/"+nameDomain;
		
		if( app == null || "".equalsIgnoreCase(app)){
			throw new DomainException(DomainException.NULL_APP);
		}
		
		if( nameDomain == null || "".equalsIgnoreCase(nameDomain)){
			throw new DomainException(DomainException.NULL_DOMAIN);
		}
		
		Collection<DomainBean> dvs = new ArrayList<DomainBean>();
		
		Hashtable<String,DomainBean> dominio = null;
		if( dominios.containsKey(domainKey)){
			System.out.println("obteniendo valores desde cache...");
			dominio = dominios.get(domainKey);
			
			
		}else{
			System.out.println("cargando valores...");
			DomainsLoader domainLoader = DomainsLoader.getInstance();
			dominio = domainLoader.loadActiveDomain(app, nameDomain, null);
			dominios.put(domainKey, dominio);

		}
		Enumeration<String> claves = dominio.keys();
		while(claves.hasMoreElements()){
			dvs.add(dominio.get(claves.nextElement()));
		}
		
		return dvs;
	}
	
	public void resetDomainCache(){

		dominios = null;
		dominios = new Hashtable<String,Hashtable<String,DomainBean>>();
	}
	
}
