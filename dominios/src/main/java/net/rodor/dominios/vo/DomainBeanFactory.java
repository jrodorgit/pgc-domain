package net.rodor.dominios.vo;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DomainBeanFactory {

	private  volatile static DomainBeanFactory instance;
	private DomainBeanFactory(){}
	public  static DomainBeanFactory getInstance(){
		if(instance == null){
			synchronized (DomainBeanFactory.class){
				if(instance == null){
					instance = new DomainBeanFactory();
				}
			}
		}
		return instance;
	}
	public DomainBean mapRow(ResultSet rs) throws SQLException {
		
		DomainBean miEntity= new DomainBean() ;
		miEntity.appdomain = rs.getString(DomainBean.APP_DOMAIN);
		miEntity.namedomain = rs.getString(DomainBean.NAME_DOMAIN);
		miEntity.code = rs.getString(DomainBean.CODE);
		miEntity.description = rs.getString(DomainBean.DESCRIPTION);
		miEntity.descriptionxl = rs.getString(DomainBean.DESCRIPTION_XL);
		miEntity.descriptionxs = rs.getString(DomainBean.DESCRIPTION_XS);
		miEntity.startdate = rs.getTimestamp(DomainBean.START_DATE);
		miEntity.enddate = rs.getTimestamp(DomainBean.END_DATE);
		
		return miEntity;
	}
	
}
