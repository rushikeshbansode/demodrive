<!DOCTYPE html>

<%@page import="org.hibernate.Session"%>
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <title>Home page</title>
    <link rel="stylesheet" href="css/index.css">
    <link rel="stylesheet" href="css/block.css">
  </head>
  
  <!-- -------------------java code -->
<%@ page import="com.model.BLManager" %>
<%@page import="com.pojo.File" %>
<%@page import="java.util.List"%>
<%
BLManager bl=new BLManager();
List <File> l=bl.getallfiles();
session.setAttribute("list",l);
%>

  <!-- -------------------java code -->

  

<body style="background-color: #f2f2f2;">
<form class="" action="addfile.jsp" method="post">
  <button class="addfiles" type="submit" name="button">ADD FILES</button>
    </form>  
  <hr>
  
     
      <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
       <c:forEach items="${sessionScope.list }" var="a">
     <div class="demo">
             
 <a class="File" href="files/${a.file}" download" ><image src="images/img1.png"></a>
          <div class="filename">${a.name}</div>
          
          <form action="rename.jsp" >
          <input type="hidden" name="name1" value="${a.name}">
           <input type="hidden" name="id" value="${a.id}">
          <button type="submit" class="but" name="b1">Rename</button>
          </form>
           <form action="deletefile" method="post">
           <input type="hidden" name="id" value="${a.id}">
           
          <button type="submit" class="but" name="b1">Delete</button>
          </form>
           <form action="deletefile" method="get">
           
            <a  id="downloadbut" href="files/${a.file}" download" >DOWNLOAD</a>
           </form>

            </div>
  
      </c:forEach>
  
</form>
  </body>
</html>
