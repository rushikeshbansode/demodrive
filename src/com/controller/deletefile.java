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
 * Servlet implementation class deletefile
 */
@WebServlet("/deletefile")
public class deletefile extends HttpServlet {
	    BLManager bl =new BLManager();

	    @Override
	    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    	
	    }
	    
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        PrintWriter out=response.getWriter();
			String id=request.getParameter("id");
			File f=bl.searchfilebyid(id);
			
			bl.deletefile(f);

			out.print("<script type=\"text/javascript\">");
			out.print("alert('File deleted succesfully');");
			out.print("location='index.jsp';");
			out.print("</script>");

		}

}
