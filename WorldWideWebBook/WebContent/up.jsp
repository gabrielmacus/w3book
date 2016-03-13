<%@page import="w3b.Property"%>
<%@page import="javax.persistence.EntityTransaction"%>
<%@page import="w3b.DAOs.ImagenDAO"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="javax.imageio.ImageReader"%>
<%@page import="org.apache.tomcat.util.codec.binary.StringUtils"%>
<%@page import="w3b.PersistenceManager"%>
<%@page import="w3b.Entidades.Imagen"%>
<%@page import="javax.persistence.EntityManager"%>
<%@page import="w3b.DAOs.GenericDAO"%>
<%@page import="w3b.Upload"%>
<%@ page import="java.io.*,java.util.*, javax.servlet.*"%>
<%@ page import="javax.servlet.http.*"%>
<%@ page import="org.apache.commons.fileupload.*"%>
<%@ page import="org.apache.commons.fileupload.disk.*"%>
<%@ page import="org.apache.commons.fileupload.servlet.*"%>
<%@ page import="org.apache.commons.io.output.*"%>

<%
	List<FileItem> files = new ArrayList<>();
	try {
		files = Upload.uploadImage(request);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	String bytes = "";
	EntityManager em = PersistenceManager.getInstance().getEntityManager();
	EntityTransaction t=em.getTransaction();
	t.begin();
	
	int maxSize = Integer.parseInt(Property.getProp("max-image-size"));
	System.out.print(Property.getProp("max-image-size"));
	for (FileItem f : files) {


		    
		if (f.getSize() > 0 && f.getSize()<=maxSize) {

			BufferedInputStream bf = new BufferedInputStream(f.getInputStream());

		byte[] array = new byte[(int) f.getSize()];

			bf.read(array);
	
			em.persist(new Imagen(array,f.getName()));
			bf.close();

                       
		

		}
		else if(f.getSize()>maxSize)
		{
			t.rollback();
			em.close();
			throw new Exception("1500");
		}
	}
	em.close();
	t.commit();
%>

