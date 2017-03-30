package com.easy.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.easy.dao.ClassDao;

public class servletModificarEmpleado extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");    
        PrintWriter out = response.getWriter();    
        
        String botonModificar=request.getParameter("BTN");
        
		if(botonModificar!=null){

			int idUser = Integer.parseInt(request.getParameter("USUARIO_ID"));
			String user = request.getParameter("USUARIO");
			String pass = request.getParameter("CONTRASENA");
			String email = request.getParameter("EMAIL");
			String paterno = request.getParameter("PATERNO");
			String materno = request.getParameter("MATERNO");
			String nom =request.getParameter("NOMBRE");
			int rol = Integer.parseInt(request.getParameter("ROL"));
			
	        if(ClassDao.validateModificarEmpleado(idUser, user, pass, email, paterno, materno,nom,rol)){    
	            RequestDispatcher rd=request.getRequestDispatcher("modificar-empleado.jsp");    
	            out.print("<script>alert('NO SE PUDO MODIFICAR :D')</script>");   
	            rd.forward(request,response);    
	        }    
	        else{    
	            out.print("<script>alert('EXITO AL MODIFICAR :D')</script>");    
	            RequestDispatcher rd=request.getRequestDispatcher("modificar-empleado.jsp");    
	            rd.include(request,response);    
	        }    
	 
	        out.close();    
		}
		else
		{
			out.print("no hay datos");
		}
	}

}
