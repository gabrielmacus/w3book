<%@page import="w3b.PersistenceManager"%>
<%@page import="java.util.List"%>
<%@page import="javax.persistence.EntityManager"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%

EntityManager em=PersistenceManager.getInstance().getEntityManager();
 List<Object[]>provincias= em.createNativeQuery("select * from provincias ORDER BY nombre " ).getResultList();
 String JSON ="";
for(int i=0;i<provincias.size();i++)
{
	 Object[]lista = provincias.get(i);

	 if(i==provincias.size()-1){
		JSON +="{\"id\":"+"\""+String.valueOf(lista[0])+"\",\"nombre\":\""+String.valueOf(lista[1])+"\"}";
		
	 }else
	 {

			JSON +="{\"id\":"+"\""+String.valueOf(lista[0])+"\",\"nombre\":\""+String.valueOf(lista[1])+"\"},"; 
	 }
}
 em.close();
 JSON="["+JSON+"]";
 out.print(JSON);
%>