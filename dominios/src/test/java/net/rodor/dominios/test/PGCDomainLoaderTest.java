package net.rodor.dominios.test;

import java.sql.SQLException;
import java.util.Hashtable;

import junit.framework.TestCase;
import net.rodor.dominios.DomainException;
import net.rodor.dominios.DomainsLoader;
import net.rodor.dominios.vo.DomainBean;

public class PGCDomainLoaderTest extends TestCase{

	
	public void testLoadActiveDomain(){
		
		DomainsLoader domainLoader = DomainsLoader.getInstance();
		Hashtable<String, DomainBean> dvs=null;
		try {
			dvs = domainLoader.loadActiveDomain("SICOSS","CONCEPTOS GASTO" , null);
		} catch (SQLException | DomainException e) {
			e.printStackTrace();
		}
		assertEquals(2, dvs.size());
		
	}
	
	/*public void testLoadActiveSubDomain(){
		
		DomainsLoader domainLoader = DomainsLoader.getInstance();
		Hashtable<String, DomainBean> subDominio = null;
		try {
			subDominio = domainLoader.loadActiveSubDomain(DomainBean.ALL,"001002001", null);
		} catch (SQLException | DomainException e) {
			
			e.printStackTrace();
		} 
		assertEquals(2, subDominio.size());
		
	}*/
	/*
	System.out.println("numero valores del dominio:"+dvs.size());
	Enumeration<String> claves = dvs.keys();

	while(claves.hasMoreElements()){
		
		System.out.println(dvs.get(claves.nextElement()).toJSONFormat());
	}
	*/
}
