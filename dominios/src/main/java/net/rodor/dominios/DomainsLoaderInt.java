package net.rodor.dominios;

import java.sql.SQLException;
import java.util.Hashtable;

import net.rodor.dominios.vo.DomainBean;

public interface DomainsLoaderInt {

	/**
	 * Devuelve la relacion de elementos activos del dominio para una fecha 
	 * Si la fecha es nula devuelve los activos a fecha de sistema
	 * @param app aplicacion
	 * @param domain dominio 
	 * @param fecha
	 * @return
	 */
	public Hashtable<String,DomainBean> loadActiveDomain(String app, String domain, java.sql.Timestamp fecha) throws SQLException, DomainException;
	
}
