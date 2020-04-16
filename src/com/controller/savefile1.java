package com.controller;

import java.io.File;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.model.BLManager;

/**
 * Servlet implementation class savefile1
 */
@WebServlet("/savefile1")

@MultipartConfig(fileSizeThreshold=1024 * 1024 * 2,
maxFileSize = 1024 * 1024 * 70,
maxRequestSize = 1024 * 1024 * 100)



public class savefile1 extends HttpServlet {
	
	BLManager bl=new BLManager();
	com.pojo.File f=new com.pojo.File();
	
	
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		String name=request.getParameter("name");
		String description=request.getParameter("description");
		
		
		PrintWriter out=response.getWriter();
		Part part=request.getPart("file");  // objectbill is name of the html tag used to upload the bill photo

    	String filename=extactFileName(part);  // name of file

    	String savepath="I:\\Foooddd\\google drive\\WebContent\\files\\"+filename;
    	
    	System.out.println("savepath==="+savepath);
    	File filesavedir=new File(savepath);
    	part.write(savepath);
    	
    	f.setName(filename);
    	f.setDescription(description);
    	f.setFile(filename);
       
    	bl.save(f);

        out.print("<script >");
		out.print("alert('Your File is Uploaded');");
		out.print("location='index.jsp';");
		out.print("</script>");
    	
	}
	
	private String extactFileName(Part image) {
		String contentDisp = image.getHeader("content-disposition");
		String[] items = contentDisp.split(";");
		for (String s : items) {
			if (s.trim().startsWith("filename")) {
				return s.substring(s.indexOf("=") + 2, s.length() - 1);
			}
		}
		
		return "";
	}


}
