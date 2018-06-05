package net.rodor.dominios.test;

import java.sql.SQLException;
import java.util.Enumeration;
import java.util.Hashtable;

import junit.framework.TestCase;
import net.rodor.dominios.DomainException;
import net.rodor.dominios.DomainsLoader;
import net.rodor.dominios.vo.DomainBean;

//public class PGCDomainsTest extends TestCase{
	public class PGCDomainsTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PGCDomainsTest test = new PGCDomainsTest();
		//test.test();

	}
	
	public void test(){
		System.out.println("Lanzando pruebas...");
/***/
		//valores de un dominio
		DomainsLoader domainLoader = DomainsLoader.getInstance();
		Hashtable<String, DomainBean> dvs=null;
		try {
			dvs = domainLoader.loadActiveDomain(DomainBean.ALL,"AMBITO" , null);
			//dvs = domainLoader.loadActiveDomain("SICOSS","CONCEPTOS GASTO" , null);
		} catch (SQLException | DomainException e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
		}
		System.out.println("numero valores del dominio:"+dvs.size());
		Enumeration<String> claves = dvs.keys();

		while(claves.hasMoreElements()){
			
			System.out.println(dvs.get(claves.nextElement()).toJSONFormat());
		}
		/***/
		/***
		
		DomainCache dc = DomainCache.getInstance();
		Collection<DomainBean> valoresDominio = null;
		try {
			valoresDominio = dc.getDomainValues("SICOSS", "CONCEPTOS GASTO");
		} catch (SQLException e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
		}
		System.out.println(valoresDominio.toString());
		try {
			valoresDominio =dc.getDomainValues("SICOSS", "CONCEPTOS GASTO");
		} catch (SQLException e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
		}
		System.out.println(valoresDominio.toString());
		try {
			valoresDominio =dc.getDomainValues("SICOSS", "CONCEPTOS FACT");
		} catch (SQLException e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
		}
		System.out.println(valoresDominio.toString());
		dc.resetDomainCache();
		try {
			valoresDominio = dc.getDomainValues("SICOSS", "CONCEPTOS GASTO");
		} catch (SQLException e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
		}
		System.out.println(valoresDominio.toString());
		
		try {
			System.out.println("Validacion:"+DomainValidator.validateValueInDomain("36", "SICOSS", "CONCEPTOS GASTO"));
		} catch (SQLException e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
		}
		***/
		/**
		//DomainsLoader domainLoader = DomainsLoader.getInstance();
		Hashtable<String, DomainBean> subDominio = null;
		try {
			subDominio = domainLoader.loadActiveSubDomain(DomainBean.ALL,"001002001", null);
			//subDominio = domainLoader.loadActiveSubDomain("SICOSS","36", null);
		} catch (SQLException e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
		} catch (DomainException e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
		}
		System.out.println("numero valores del subdominio:"+subDominio.size());
		//Enumeration<String> claves = subDominio.keys();
		claves = subDominio.keys();

		while(claves.hasMoreElements()){
			
			System.out.println(subDominio.get(claves.nextElement()).toJSONFormat());
		}
		***/
		System.out.println("Fin");
		
	}
}
