<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
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
ServletFileUpload s =new ServletFileUpload(factory);
List<FileItem> fileItems =s.parseRequest(request);

Map<String,String>fieldMap =new HashMap<String,String>();


out.write("<ul>");
for(FileItem f : fileItems)
{
	if(f.isFormField())
	{
		fieldMap.put(f.getFieldName(),f.getString());
	out.println("<li>"+f.getFieldName()+"</li>");
	}
}out.write("</ul>");
%>