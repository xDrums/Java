package com.easy.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.easy.dao.ClassDao;

public class servletModificarProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");    
        PrintWriter out = response.getWriter();    
        
        String botonModificar=request.getParameter("BTN");
        
			if(botonModificar!=null){
				String idProd = request.getParameter("ID_SUCURSAL");
				String nom = request.getParameter("NOMBRE");
				String det = request.getParameter("DETALLE");
				int vlr = Integer.parseInt(request.getParameter("VALOR"));
				int idtipo =Integer.parseInt(request.getParameter("ID_TIPOPRODUCTO"));
				int stock = Integer.parseInt(request.getParameter("STOCK"));
				int idProveedor = Integer.parseInt(request.getParameter("ID_PROVEEDOR"));

				
		        if(ClassDao.validateModificarProducto(idProd, nom, det, vlr, idtipo, stock,idProveedor)){   
	            RequestDispatcher rd=request.getRequestDispatcher("modificar-productos.jsp");    
	            out.print("REGISTRO MODIFICADO");   
	            rd.forward(request,response);    
	        }    
	        else{    
	            out.print("NO SE PUDO MODIFICAR EL REGISTRO");    
	            RequestDispatcher rd=request.getRequestDispatcher("modificar-productos.jsp");    
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
