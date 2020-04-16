package com.controller;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.BLManager;
import com.pojo.File;

/**
 * Servlet implementation class renameser
 */
@WebServlet("/renameser")

public class renameser extends HttpServlet {

	BLManager bl=new BLManager();
	File f=new File();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PrintWriter out=response.getWriter();
	String id=request.getParameter("id");
	String name=request.getParameter("name");
	File f=bl.searchfilebyid(id);
	f.setName(name);
	
	bl.updatename(f);

	out.print("<script type=\"text/javascript\">");
	out.print("alert('File is Renamed');");
	out.print("location='index.jsp';");
	out.print("</script>");
		
	}

}
