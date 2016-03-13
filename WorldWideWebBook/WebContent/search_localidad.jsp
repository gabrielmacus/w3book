<%@page import="java.util.List"%>
<%@page import="javax.persistence.EntityManager"%>
<%@page import="w3b.PersistenceManager"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
int id_provincia = Integer.parseInt(request.getParameter("id"));

EntityManager em=PersistenceManager.getInstance().getEntityManager();

List<Integer> listaDepartamentos =em.createNativeQuery("select id from departamentos where provincia_id="+id_provincia).getResultList();
String JSON ="";


for(int i=0;i<listaDepartamentos.size();i++)
{
	List<Object[]>listaLocalidades = em.createNativeQuery("select id,nombre from localidades where departamento_id ="+listaDepartamentos.get(i)+" ORDER BY nombre ASC").getResultList();
	
	for(int j=0;j< listaLocalidades.size();j++){
		
			Object[] lista = listaLocalidades.get(j);
	
			if(i==listaDepartamentos.size()-1&& j==listaLocalidades.size()-1)
			{
				JSON +="{\"id\":"+"\""+String.valueOf(lista[0])+"\",\"nombre\":\""+String.valueOf(lista[1])+"\"}";
			}
			else
			{
				JSON +="{\"id\":"+"\""+String.valueOf(lista[0])+"\",\"nombre\":\""+String.valueOf(lista[1])+"\"},";
				
			}
	
	}
}
JSON ="["+JSON+"]";
out.write(JSON);
em.close();
 //List<Object[]>lista=em.createNativeQuery("select * from localidades where departamento_id= ").getResultList();

%>