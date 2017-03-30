package com.easy.servlet;  
  
import java.io.IOException;  
import java.io.PrintWriter;  
  



import javax.servlet.RequestDispatcher;  
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  



import com.easy.dao.ClassDao;

public class servletEliminarSucursal extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletEliminarSucursal() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");    
        PrintWriter out = response.getWriter();    
        String OK=request.getParameter("OK");
        String id_sucursal=request.getParameter("cod");
        if(OK!=null){
        String idSuc = request.getParameter("ID_SUCURSAL");
        	
	        if(ClassDao.validateEliminarSucursal1(idSuc)){    
	            RequestDispatcher rd=request.getRequestDispatcher("eliminar-sucursal.jsp");    
	            out.print("<script>alert('NO SE PUDO ELIMINAR LA SUCURSAL')</script>");   
	            rd.forward(request,response);    
	        }    
	        else{    
	            out.print("<script>alert('EXITO AL ELIMINAR')</script>");    
	            RequestDispatcher rd=request.getRequestDispatcher("eliminar-sucursal.jsp");    
	            rd.include(request,response);    
	        }    
	 
	        out.close();    
        }
        else
        {
        
        }
        if(id_sucursal!=null)
        {
        	
	        if(ClassDao.validateEliminarSucursal2(id_sucursal)){    
	            RequestDispatcher rd=request.getRequestDispatcher("eliminar-sucursal.jsp");    
	            out.print("<script>alert('NO SE PUDO ELIMINAR LA SUCURSAL')</script>");   
	            rd.forward(request,response);    
	        }    
	        else{    
	            out.print("<script>alert('EXITO AL ELIMINAR')</script>");    
	            RequestDispatcher rd=request.getRequestDispatcher("eliminar-sucursal.jsp");    
	            rd.include(request,response);    
	        }    
	 
	        out.close();    
        }
        else
        {
        
        }
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
