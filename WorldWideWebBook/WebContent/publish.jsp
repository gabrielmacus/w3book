<%@page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>
<%@page import="org.apache.commons.fileupload.FileItem"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.commons.fileupload.servlet.ServletFileUpload"%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
DiskFileItemFactory factory=new DiskFileItemFactory();
String titulo=request.getParameter("title");
String descripcion=request.getParameter("description");
String telefonos =request.getParameter("phone-list");
ServletFileUpload s =new ServletFileUpload(factory);
List<FileItem> fileItems =s.parseRequest(request);

for(FileItem f : fileItems)
{
	if(f.isFormField())
	{
		out.println("\n-----");
	out.write(f.getString());
	}
}
%>