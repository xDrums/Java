/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.69
 * Generated at: 2016-06-26 18:40:46 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.io.*;
import java.util.*;
import java.net.*;
import java.sql.*;
import com.easy.util.Conexion;

public final class consultarproductos_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("\t<head>\r\n");
      out.write("\t   \t<meta charset='utf-8'>\r\n");
      out.write("   \t\t<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n");
      out.write("   \t\t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("   \t\t<script src=\"http://code.jquery.com/jquery-latest.min.js\" type=\"text/javascript\"></script>\r\n");
      out.write("   \t\t<script src=\"librerias/js/script.js\"></script>\r\n");
      out.write("\t\t<link rel=\"stylesheet\" media=\"(max-width:3000px)\" href = \"librerias/css/menuCssResponsive.css\" type = \"text/css\">\r\n");
      out.write("<!--  MENU \t<link rel=\"stylesheet\" href = \"librerias/css/login.css\" type = \"text/css\"> -->\r\n");
      out.write("\t\t<link rel=\"stylesheet\" href = \"librerias/css/tablas-reponsivas.css\" type = \"text/css\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<title>Consultar Producto</title>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t</head>\r\n");
      out.write("<body>\r\n");
      out.write("<center>\r\n");
      out.write("<div class=\"overstock\">\r\n");
      out.write("\t<a href=\"index.html\"><img width=\"25%\" src=\"librerias/img/overstock.png\"></a>\r\n");
      out.write("</div>\r\n");
      out.write("<!--  MENU  -->\r\n");
      out.write("<div id=\"cssmenu\">\r\n");
      out.write("<ul>\r\n");
      out.write("   <li><a href=\"welcome.jsp\">Inicio</a></li>\r\n");
      out.write("   <li class='has-sub'><a href =\"#\">Productos</a>\r\n");
      out.write("   \t\t<ul>\r\n");
      out.write("   \t\t\t <li><a href=\"agregar-productos.jsp\">Agregar Productos</a></li>\r\n");
      out.write("   \t\t\t <li><a href=\"eliminar-productos.jsp\">Eliminar Productos</a></li>\r\n");
      out.write("   \t\t\t <li><a href=\"modificar-productos.jsp\">Modificar Productos</a></li>\r\n");
      out.write("   \t\t</ul>\r\n");
      out.write("   </li>\r\n");
      out.write("   <li class='has-sub'><a href=\"#\">Trabajadores</a>\r\n");
      out.write("   \t\t <ul>\r\n");
      out.write("   \t\t\t <li><a href=\"agregar-empleado.jsp\">Agregar Empleado</a></li>\r\n");
      out.write("   \t\t\t <li><a href=\"eliminar-empleado.jsp\">Eliminar Empleado</a></li>\r\n");
      out.write("   \t\t\t <li><a href=\"modificar-empleado.jsp\">Modificar Empleado</a></li>\r\n");
      out.write("   \t\t</ul>\r\n");
      out.write("   </li>\r\n");
      out.write(" <li class='has-sub'><a href=\"#\">Sucursales</a>\r\n");
      out.write("   \t  <ul>\r\n");
      out.write("   \t\t\t <li><a href=\"agregar-sucursal.jsp\">Agregar Sucursal</a></li>\r\n");
      out.write("   \t\t\t <li><a href=\"eliminar-sucursal.jsp\">Eliminar Sucursal</a></li>\r\n");
      out.write("   \t\t\t <li><a href=\"modificar-sucursal.jsp\">Modificar Sucursal</a></li>\r\n");
      out.write("   \t\t</ul>\r\n");
      out.write("   \t  </li>\r\n");
      out.write("   <li><a class=\"logout\" href=\"php/logout.php\" data-title=\"Log out\">Cerrar Sesion</a></li>\r\n");
      out.write("</ul>\r\n");
      out.write("</div>\r\n");
      out.write("<!-- FIN MENU -->\r\n");
      out.write("</center>\r\n");
      out.write("\r\n");

// construyendo forma dinamica
out.println("<FORM ACTION=consultarproductos.jsp METHOD=post>");
out.println("Buscar Producto por nombre:<INPUT TYPE=TEXT NAME=CODNOM><BR>");
out.println("<INPUT TYPE=SUBMIT NAME=OK VALUE=BUSCAR><BR>");
out.println("</FORM>");

out.println("<FORM ACTION=consultarproductos.jsp METHOD=post>");
out.println("Buscar todos los Producto");
out.println("<INPUT TYPE=SUBMIT NAME=TODOS VALUE=BUSCAR><BR>");
out.println("</FORM>");

//declarando y creando objetos globales
	Connection canal = null;
	ResultSet tabla= null;
	Statement instruccion=null;
	Conexion db = new Conexion();
	Connection cn = db.Conectar();
	canal = cn;
	if(request.getParameter("OK") != null)
	{
	try {
		instruccion = canal.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
		ResultSet.CONCUR_UPDATABLE);
	} catch(SQLException e) {};

	//Creacion string para obtener datos por parametros 
	String w = request.getParameter("CODNOM");
	// Creacion de sentencia SQL
	String q="select * from producto where NOMBRE like '%"+w+"%'";
	//Ejecucion de Sentencia
	try { 
		if (w != null)
		{
		tabla = instruccion.executeQuery(q);
		
		out.println("<center><TABLE class=rwd-table><TR>");
		out.println("<th>Id Producto</th><th>Nombre</th><th>Descripcion</th><th>Codigo Producto</th><th>Fecha Ingreso</th><th>Id Proveedor</th><th>Id Categoria</th></TR>");
		while(tabla.next()) {
		out.println("<TR>");
		out.println("<TD data-th=Id Producto>"+tabla.getString(1)+"</TD>");
		out.println("<TD data-th=Nombre>"+tabla.getString(2)+"</TD>");
		out.println("<TD data-th=Descripcion>"+tabla.getString(3)+"</TD>");
		out.println("<TD data-th=Codigo Producto>"+tabla.getString(4)+"</TD>");
		out.println("<TD data-th=Fecha Ingreso>"+tabla.getString(5)+"</TD>");
		out.println("<TD data-th=Id Proveedor>"+tabla.getString(6)+"</TD>");
		out.println("<TD data-th=Id Categoria>"+tabla.getString(7)+"</TD>");
		out.println("</TR>"); }; // fin while
		out.println("</TABLE></center>");
		}else
		{
			out.println("<script>alert(Error);</script>");
		}
} 
catch(SQLException e) {};
try {tabla.close();instruccion.close();canal.close();} catch(SQLException e) {};
}

//Buscar Todos los Productos

if(request.getParameter("TODOS") != null)
{
//abriendo canal o enlace en su propio try-catch
try {

instruccion = canal.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
ResultSet.CONCUR_UPDATABLE);
} catch(SQLException e) {};
//construyendo select con condicion
String q = "select producto.id_producto , producto.nombre_producto, producto.descripcion,producto.codigo_producto,producto.fecha_registro,proveedor.nombre_proveedor,categoria.nombre_categoria from producto join proveedor on producto.ID_PROVEEDOR = proveedor.ID_PROVEEDOR join categoria on producto.ID_CATEGORIA = categoria.ID_CATEGORIA";
//mandando el sql a la base de datos
try { tabla = instruccion.executeQuery(q);
//mandando resultset a tabla html

out.println("<center><TABLE class=rwd-table><TR>");
out.println("<th>Id Producto</th><th>Nombre</th><th>Descripcion</th><th>Codigo Producto</th><th>Fecha Ingreso</th><th>Proveedor</th><th>Categoria</th></TR>");
while(tabla.next()) {
out.println("<TR>");
out.println("<TD data-th=Id Producto>"+tabla.getString(1)+"</TD>");
out.println("<TD data-th=Nombre>"+tabla.getString(2)+"</TD>");
out.println("<TD data-th=Descripcion>"+tabla.getString(3)+"</TD>");
out.println("<TD data-th=Codigo Producto>"+tabla.getString(4)+"</TD>");
out.println("<TD data-th=Fecha Ingreso>"+tabla.getString(5)+"</TD>");
out.println("<TD data-th=Proveedor>"+tabla.getString(6)+"</TD>");
out.println("<TD data-th=Categoria>"+tabla.getString(7)+"</TD>");
out.println("</TR>"); 
}; // fin while
out.println("</TABLE></center>");
} 
catch(SQLException e) {};
try {
//	tabla.close();
	instruccion.close();
	canal.close();
	} catch(SQLException e) {};
};



      out.write("\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
