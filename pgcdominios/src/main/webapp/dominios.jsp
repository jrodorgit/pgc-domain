<%@ page import="net.rodor.dominios.*" %>
<%@ page import="java.util.*" %>
<%@ page import="net.rodor.dominios.vo.*" %>
<%@ page import="java.sql.*" %>
<!-- http://localhost:8080/pgcdominios/pgcdomain/dominio -->
<html>
   <head><title>Dominios</title></head>
   
   <body>
      
      <%
        
      	DomainsLoader domainLoader = DomainsLoader.getInstance();
		Hashtable<String, DomainBean> dvs=null;
		try {
			dvs = domainLoader.loadActiveDomain("SICOSS","CONCEPTOS GASTO", null);
			
		} catch (SQLException | DomainException e) {
			
			e.printStackTrace();
		}
		//out.println("<p>numero valores del dominio:"+dvs.size()+"</p>");
		 %>
		  Conceptos de Gasto:<select>
		<option value=""></option>
		<%
			Enumeration<String> claves = dvs.keys();

			while (claves.hasMoreElements()) {
				DomainBean vo = ((DomainBean) dvs.get(claves.nextElement()));
				out.println("<option value=\"" + vo.code + "\">" + vo.description + "</option>");
			}
		%>
	</select> 
	<p></p>
	<%
        
      	DomainCache domainCache = DomainCache.getInstance();
		Collection<DomainBean> dvscache=null;
		try {
			dvscache = domainCache.getDomainValues("SICOSS","CONCEPTOS GASTO");
			
		} catch (SQLException | DomainException e) {
			
			e.printStackTrace();
		}
		//out.println("<p>numero valores del dominio:"+dvs.size()+"</p>");
		 %>
		  Conceptos de Gasto Cacheados:<select>
		<option value=""></option>
		<%
			Iterator<DomainBean> iterd = dvscache.iterator();

			while (iterd.hasNext()) {
				DomainBean vo = (DomainBean) iterd.next();
				out.println("<option value=\"" + vo.code + "\">" + vo.description + "</option>");
			}
		%>
	</select> 
	
	
	
   </body>
</html>