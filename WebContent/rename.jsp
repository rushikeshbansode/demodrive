<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
  <!-- -------------------java code -->
  
<%@page import="org.hibernate.Session"%>
<%@ page import="com.model.BLManager" %>
<%@page import="com.pojo.File" %>
<%@page import="java.util.List"%>
<%


String id=request.getParameter("id");
BLManager bl=new BLManager();
File f=bl.searchfilebyid(id);
session.setAttribute("file",f);

session.getAttribute("list");
%>
<body>
<form action="renameser" method="post">


 <input  name="name"  type="text" value="${file.name}" />
 
 <input  name="id"  type="hidden" value="${file.id}" />
 
 <button type="submit" name="b1">RENAME</button>
  </form>                     
</body>
</html>