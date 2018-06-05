package net.rodor.dominios;

import java.sql.SQLException;
import java.util.Collection;
import java.util.Hashtable;

import net.rodor.dominios.dao.DomainBeanDAOImpl;
import net.rodor.dominios.dao.DomainBeanDAOInt;
import net.rodor.dominios.vo.DomainBean;

public class DomainsLoader implements DomainsLoaderInt{
	

	private  static DomainsLoader instance = new DomainsLoader();
	
	private DomainsLoader(){}
	public  static DomainsLoader getInstance(){
		return instance;
	}
	/**
	 * 
	 * @param app
	 * @param domain
	 * @param fecha
	 * @return
	 * @throws SQLException
	 * @throws DomainException 
	 */
	public Hashtable<String,DomainBean> loadActiveDomain(String app, String domain, java.sql.Timestamp fecha) throws SQLException, DomainException{
			
		if( app == null || "".equalsIgnoreCase(app)){
			throw new DomainException(DomainException.NULL_APP);
		}
		if( domain == null || "".equalsIgnoreCase(domain)){
			throw new DomainException(DomainException.NULL_DOMAIN);
		}
		
		Collection<DomainBean> valoresDominioActivos = null;
		Hashtable<String,DomainBean> resul = new Hashtable<String,DomainBean>();
		try{
			DomainBeanDAOInt cbdao = new DomainBeanDAOImpl();
			valoresDominioActivos = cbdao.getAllByDomainDate(app, domain, fecha);
			
		} finally{
			
		}
			
		for(DomainBean dv: valoresDominioActivos ){
			resul.put(dv.code, dv);
		}

		return resul;
		
	}

}
