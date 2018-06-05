package net.rodor.dominios;

import java.sql.SQLException;
import java.util.Collection;

import net.rodor.dominios.vo.DomainBean;

public class DomainValidator {
	

	public static boolean validateValueInDomain(String codigo, String app, String nameDomain) throws SQLException, DomainException{
	
		
		boolean resul = false;
		if( nameDomain == null || "".equalsIgnoreCase(nameDomain)){
			throw new DomainException(DomainException.NULL_DOMAIN);
		}
		if( codigo == null || "".equalsIgnoreCase(codigo)){
			throw new DomainException(DomainException.NULL_CODE);
		}
		
		DomainCache dc = DomainCache.getInstance();
		Collection<DomainBean> valoresDominio = dc.getDomainValues(app, nameDomain);
		for(DomainBean db: valoresDominio){
			if(codigo.compareToIgnoreCase(db.code) == 0){
					return true;
			}
		}
		return resul;
	}
}
