package com.easy.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.easy.dao.ClassDao;

@WebServlet("/servletModificarSucursal")
public class servletModificarSucursal extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public servletModificarSucursal() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");    
        PrintWriter out = response.getWriter();    
        
        String botonModificar=request.getParameter("BTN");
		if(botonModificar!=null){
        String idsuc = request.getParameter("ID_SUCURSAL");
		int idcom = Integer.parseInt(request.getParameter("ID_COMUNA"));
		String dir = request.getParameter("DIRECCION");
		int tel = Integer.parseInt(request.getParameter("TELEFONO"));
		int rut =Integer.parseInt(request.getParameter("RUT"));


		
        if(ClassDao.validateModificarSucursal(idsuc,idcom,dir,tel,rut)){     
	            RequestDispatcher rd=request.getRequestDispatcher("modificar-sucursal.jsp");    
	            out.print("REGISTRO MODIFICADO");   
	            rd.forward(request,response);    
	        }    
	        else{    
	            out.print("NO SE PUDO MODIFICAR EL REGISTRO");    
	            RequestDispatcher rd=request.getRequestDispatcher("modificar-sucursal.jsp");    
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
