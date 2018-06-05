package net.rodor.dominios.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;

import net.rodor.dominios.bbdd.DataBaseConnFactory;
import net.rodor.dominios.bbdd.PreparedStatementFactory;
import net.rodor.dominios.vo.DomainBean;
import net.rodor.dominios.vo.DomainBeanFactory;

public class DomainBeanDAOImpl implements DomainBeanDAOInt {

	
	
	public DomainBeanDAOImpl() {
		super();
		// TODO Apéndice de constructor generado automáticamente
	}

	
	public Collection<DomainBean> getAllByDomainDate(String app, String domain,java.sql.Timestamp fecha) throws SQLException {
		
		Connection conn = DataBaseConnFactory.getInstance().getConnection();
		Collection<DomainBean> beans = new ArrayList<DomainBean>();
		
		PreparedStatementFactory psf = PreparedStatementFactory.getInstance();
		String sql = psf.getSQL(DomainBeanDAOInt.DOMAIN_SELECT_ALL_BY_DOMAIN_DATE);

		String appSel =  app;
		if(app == null){
			return beans;
		}
		String domainSel = domain;
		if(domain == null){
			return beans;
		}
		java.sql.Date fechaActivo = new java.sql.Date(Calendar.getInstance().getTime().getTime());
		if(fecha != null){
			fechaActivo = new java.sql.Date(fecha.getTime());
		}
		
		
		PreparedStatement ps=null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, appSel);
			ps.setString(2, domainSel);
			ps.setDate(3, fechaActivo);
			ps.setDate(4, fechaActivo);
			
			ResultSet rs = ps.executeQuery();
			DomainBeanFactory fac = DomainBeanFactory.getInstance();
			while(rs.next()){
				
				beans.add(fac.mapRow(rs));
			}
			
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		

		return beans;
	}
	
	public Collection<DomainBean> getByCodeDate(String app,String domain,String code,java.sql.Timestamp fecha) throws SQLException {

		Collection<DomainBean> beans = new ArrayList<DomainBean>();
		
		Connection conn = DataBaseConnFactory.getInstance().getConnection();
		
		PreparedStatementFactory psf = PreparedStatementFactory.getInstance();
		String sql = psf.getSQL(DomainBeanDAOInt.DOMAIN_SELECT_BY_CODE_DATE);

		String appSel =  app;
		if(app == null){
			return beans;
		}
		String domainSel = domain;
		if(domain == null){
			return beans;
		}
		String codeSel = code;
		if(code == null){
			return beans;
		}
		java.sql.Date fechaActivo = new java.sql.Date(Calendar.getInstance().getTime().getTime());
		if(fecha != null){
			fechaActivo = new java.sql.Date(fecha.getTime());
		}
		
		PreparedStatement ps=null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, appSel);
			ps.setString(2, domainSel);
			ps.setString(3, codeSel);
			ps.setDate(4, fechaActivo);
			ps.setDate(5, fechaActivo);
			
			ResultSet rs = ps.executeQuery();
			DomainBeanFactory fac = DomainBeanFactory.getInstance();
			while(rs.next()){
				beans.add(fac.mapRow(rs));
			}
			
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		

		return beans;
	}
}
