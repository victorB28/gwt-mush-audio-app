package com.mush.corp.MushAudioApp.server;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Contacto extends HttpServlet {
	
	public static final String stringJson = 
		"{\"contactos\":["
		+ "{\"name\":\"Victor Ejemploprofe\",\"phone\":\"61425585402\"},"
			+ "{\"name\":\"Erick Corral\",\"phone\":\"6142232217\"},"
			    + "{\"name\":\"Geovanny Gameros\",\"phone\":\"6141974591\"},"
			        + "{\"name\":\"Jose Castro\",\"phone\":\"6145020601\"}"
			            + "]}";

	
     @Override
 protected void doGet(HttpServletRequest req, HttpServletResponse resp)
     throws ServletException, IOException {

       PrintWriter out = resp.getWriter();
       req.getParameter("contacto_ventas");
       out.println(stringJson);         
       out.flush();
 }
}
