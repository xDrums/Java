package com.easy.servlet;  
  
import java.io.IOException;  
import java.io.PrintWriter;  
  



import javax.servlet.RequestDispatcher;  
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
 


import com.easy.dao.ClassDao;

public class servletEliminarProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public servletEliminarProducto() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");    
        PrintWriter out = response.getWriter();    
        String OK=request.getParameter("OK");
        String id_producto=request.getParameter("cod");
        if(OK!=null){
        String idProd = request.getParameter("ID_PRODUCTO");
        	
	        if(ClassDao.validateEliminarProducto(idProd)){    
	            RequestDispatcher rd=request.getRequestDispatcher("eliminar-productos.jsp");    
	            out.print("<script>alert('NO SE PUDO ELIMINAR EL PRODUCTO')</script>");   
	            rd.forward(request,response);    
	        }    
	        else{    
	            out.print("<script>alert('EXITO AL ELIMINAR')</script>");    
	            RequestDispatcher rd=request.getRequestDispatcher("eliminar-productos.jsp");    
	            rd.include(request,response);    
	        }    
	 
	        out.close();    
        }
        else
        {
        out.print("no existen valores");
        }
        if(id_producto!=null)
        {
        	
	        if(ClassDao.validateEliminarProducto(id_producto)){    
	            RequestDispatcher rd=request.getRequestDispatcher("eliminar-productos.jsp");    
	            out.print("<script>alert('NO SE PUDO ELIMINAR EL PRODUCTO')</script>");   
	            rd.forward(request,response);    
	        }    
	        else{    
	            out.print("<script>alert('EXITO AL ELIMINAR')</script>");    
	            RequestDispatcher rd=request.getRequestDispatcher("eliminar-productos.jsp");    
	            rd.include(request,response);    
	        }    
	 
	        out.close();    
        }
        else
        {
        out.print("no existen valores");
        }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		 
	}

}
