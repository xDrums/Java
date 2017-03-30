package com.easy.servlet;  
  
import java.io.IOException;  
import java.io.PrintWriter;  
  


import javax.servlet.RequestDispatcher;  
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  


import com.easy.dao.ClassDao;

public class servletEliminarEmpleado extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletEliminarEmpleado() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");    
        PrintWriter out = response.getWriter();    
        
        String codigo=request.getParameter("cod");
        if(codigo!=null)
        {
	        if(ClassDao.validateEliminarEmpleado(codigo)){    
	            RequestDispatcher rd=request.getRequestDispatcher("eliminar-empleado.jsp");    
	            out.print("<script>alert('NO SE PUDO ELIMINAR UN REGISTRO')</script>");   
	            rd.forward(request,response);    
	        }    
	        else{    
	        	
	            out.print("<script>alert('EXITO AL ELIMINAR')</script>");    
	            RequestDispatcher rd=request.getRequestDispatcher("eliminar-empleado.jsp");    
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
