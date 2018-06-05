package net.rodor.dominios.dao;

import java.sql.SQLException;
import java.util.Collection;

import net.rodor.dominios.vo.DomainBean;

public interface DomainBeanDAOInt {

	public static final String DOMAIN_SELECT_ALL_BY_DOMAIN_DATE = "DOMAIN_SELECT_ALL_BY_DOMAIN_DATE";
	public static final String DOMAIN_SELECT_BY_CODE_DATE = "DOMAIN_SELECT_BY_CODE_DATE";
	
	/**
	 * Devuelve la relacion de elementos activos del dominio para una fecha para el dominio y aplicacion deseada
	 * Si la fecha es nula devuelve los activos a fecha de sistema
	 * @param app aplicacion
	 * @param domain dominio 
	 * @param fecha
	 * @return
	 */
	public Collection<DomainBean> getAllByDomainDate(String app, String domain,java.sql.Timestamp fecha) throws SQLException;
	
	/**
	 * Devuelve la relacion de elementos activos del dominio y aplicacion codigo para una fecha
	 * Si la fecha es nula devuelve los activos a fecha de sistema
	 * @param app
	 * @param domain
	 * @param code
	 * @param fecha
	 * @return
	 * @throws SQLException
	 */
	public Collection<DomainBean> getByCodeDate(String app,String domain,String code,java.sql.Timestamp fecha) throws SQLException;
	
}
