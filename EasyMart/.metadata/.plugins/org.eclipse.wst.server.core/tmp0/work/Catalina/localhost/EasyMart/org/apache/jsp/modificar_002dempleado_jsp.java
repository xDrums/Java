/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.69
 * Generated at: 2016-06-28 04:39:45 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.Date;
import com.easy.util.Conexion;
import java.io.*;
import java.util.*;
import java.net.*;
import java.sql.*;

public final class modificar_002dempleado_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("\t<head>\r\n");
      out.write("\r\n");
      out.write("   \t\t<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n");
      out.write("   \t\t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("   \t\t<script src=\"http://code.jquery.com/jquery-latest.min.js\" type=\"text/javascript\"></script>\r\n");
      out.write("   \t\t<script src=\"librerias/js/script.js\"></script>\r\n");
      out.write("\t\t<link rel=\"stylesheet\" media=\"(max-width:3000px)\" href = \"librerias/css/menuCssResponsive.css\" type = \"text/css\">\r\n");
      out.write("\t\t<link rel=\"stylesheet\" href = \"librerias/css/tablas-reponsivas.css\" type = \"text/css\">\r\n");
      out.write("\t\t<link href=\"librerias/css/styleEliminar.css\" rel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("<title>Modificar Empleado</title>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t</head>\r\n");
      out.write("<body>\r\n");
      out.write("<center>\r\n");
      out.write("<div class=\"\">\r\n");
      out.write("\t<a href=\"index.html\"><img width=\"25%\" src=\"librerias/img/easymart.png\"></a>\r\n");
      out.write("</div>\r\n");
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
      out.write("      <li class='has-sub'><a href=\"#\">Trabajadores</a>\r\n");
      out.write("   \t\t <ul>\r\n");
      out.write("   \t\t\t <li><a href=\"agregar-empleado.jsp\">Agregar Empleado</a></li>\r\n");
      out.write("   \t\t\t <li><a href=\"eliminar-empleado.jsp\">Eliminar Empleado</a></li>\r\n");
      out.write("   \t\t\t <li><a href=\"modificar-empleado.jsp\">Modificar Empleado</a></li>\r\n");
      out.write("   \t\t</ul>\r\n");
      out.write("   </li>\r\n");
      out.write("   \t  <li class='has-sub'><a href=\"#\">Sucursales</a>\r\n");
      out.write("   \t  <ul>\r\n");
      out.write("   \t\t\t <li><a href=\"agregar-sucursal.jsp\">Agregar Sucursal</a></li>\r\n");
      out.write("   \t\t\t <li><a href=\"eliminar-sucursal.jsp\">Eliminar Sucursal</a></li>\r\n");
      out.write("   \t\t\t <li><a href=\"modificar-sucursal.jsp\">Modificar Sucursal</a></li>\r\n");
      out.write("   \t\t</ul>\r\n");
      out.write("   \t  </li>\r\n");
      out.write("   \t  <li><a href=\"pedidos.jsp\">Pedidos</a></li>\r\n");
      out.write("   <li><a class=\"logout\" href=\"index.jsp\" data-title=\"Log out\">Cerrar Sesion</a></li>\r\n");
      out.write("</ul>\r\n");
      out.write("</div>\r\n");
      out.write("</center>\r\n");
      out.write("\r\n");
      out.write("<style>\r\n");
      out.write("form.formBuscar {\r\n");
      out.write("background:rgba(13, 82, 78, 0.98);\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");

// construyendo forma dinamica


//declarando y creando objetos globales
	Connection canal = null;
	ResultSet tabla= null;
	Statement instruccion=null;
	Conexion db = new Conexion();
	Connection cn = db.Conectar();
	canal = cn;
	
	out.println("<FORM id=contact-form ACTION=modificar-empleado.jsp METHOD=post>");
	out.println("Codigo Producto:<INPUT TYPE=TEXT NAME=CODEMP onChange=validarN(this.value);><BR>");
	out.println("Nombre Producto:<INPUT TYPE=TEXT NAME=NOMBRE><BR>");
	out.println("<INPUT TYPE=SUBMIT NAME=OK VALUE=BUSCAR><BR>");
	out.println("</FORM>");
	
	
	if(request.getParameter("OK") != null)
	{
//abriendo canal o enlace en su propio try-catch
	try {
		instruccion = canal.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
		ResultSet.CONCUR_UPDATABLE);
	} catch(SQLException e) {};
	
	
	String codemp = request.getParameter("CODEMP");
	String nombre = request.getParameter("NOMBRE");
	String q = null;
	
	if(codemp == "" || nombre == "")
	{
		 q = "SELECT E.ID_EMPLEADO,T.DESCRIPCION,S.DIRECCION,E.NOMBRE,E.CORREO,E.RUT,E.DIRECCION,E.TELEFONO,E.PASSWRD,E.USUARIO FROM EMPLEADO E JOIN TIPO_EMPLEADO T ON E.ID_TIPOEMPLEADO =T.ID_TIPOEMPLEADO JOIN SUCURSAL S ON E.ID_SUCURSAL = S.ID_SUCURSAL";
	}
	if(codemp != "" && nombre == "")
	{
		 q = "SELECT E.ID_EMPLEADO,T.DESCRIPCION,S.DIRECCION,E.NOMBRE,E.CORREO,E.RUT,E.DIRECCION,E.TELEFONO,E.PASSWRD,E.USUARIO FROM EMPLEADO E JOIN TIPO_EMPLEADO T ON E.ID_TIPOEMPLEADO =T.ID_TIPOEMPLEADO JOIN SUCURSAL S ON E.ID_SUCURSAL = S.ID_SUCURSAL WHERE ID_PRODUCTO = "+codemp+"";
	}
	if(codemp == "" && nombre != "")
	{
		q = "SELECT E.ID_EMPLEADO,T.DESCRIPCION,S.DIRECCION,E.NOMBRE,E.CORREO,E.RUT,E.DIRECCION,E.TELEFONO,E.PASSWRD,E.USUARIO FROM EMPLEADO E JOIN TIPO_EMPLEADO T ON E.ID_TIPOEMPLEADO =T.ID_TIPOEMPLEADO JOIN SUCURSAL S ON E.ID_SUCURSAL = S.ID_SUCURSAL WHERE NOMBRE LIKE '%"+nombre+"%'";
	}
	if(codemp != "" && nombre != "")
	{
		q = "SELECT E.ID_EMPLEADO,T.DESCRIPCION,S.DIRECCION,E.NOMBRE,E.CORREO,E.RUT,E.DIRECCION,E.TELEFONO,E.PASSWRD,E.USUARIO FROM EMPLEADO E JOIN TIPO_EMPLEADO T ON E.ID_TIPOEMPLEADO =T.ID_TIPOEMPLEADO JOIN SUCURSAL S ON E.ID_SUCURSAL = S.ID_SUCURSAL WHERE ID_EMPLEADO = "+codemp+" AND NOMBRE LIKE '%"+nombre+"%'";
	}
	

//mandando el sql a la base de datos
try { 
	tabla = instruccion.executeQuery(q);
	
	
	//mandando resultset a tabla html
	out.println("<center><TABLE class=rwd-table><TR>");
	out.println("<th>Id Empleado</th><th>Tipo Empleado</th><th>Sucursal</th><th>Nombre</th><th>Correo</th><th>Rut</th><th>Direccion</th><th>Telefono<th>Password</th><th>Usuario</th></TR>");
	while(tabla.next()) {
		//servletModificarEmpleado
	out.println("<FORM ACTION=servletModificarEmpleado METHOD=POST>");
	out.println("<TR>");
	out.println("<TD data-th=Codigo Empleado><input type=text name=ID_EMPLEADO value="+tabla.getString(1)+" required></TD>");
	out.println("<TD data-th=Tipo Empleado><input type=text name=ID_TIPOEMPLEADO value="+tabla.getString(2)+" required></TD>");
	
      out.write("\r\n");
      out.write("\t<TD data-th=\"Sucursal\"><input type=\"text\" name=\"ID_SUCURSAL\" value=\"");
      out.print(tabla.getString(3));
      out.write("\" required></TD>\r\n");
      out.write("\t");

	out.println("<TD data-th=Nombre><input type=text name=NOMBRE value="+tabla.getString(4)+" required></TD>");
	out.println("<TD data-th=Correo><input type=text name=CORREO value="+tabla.getString(5)+" required></TD>");
	out.println("<TD data-th=Rut><input type=text name=RUT value="+tabla.getString(6)+" required></TD>");
	
      out.write("\r\n");
      out.write("\t<TD data-th=\"Direccion\"><input type=\"text\" name=\"DIRECCION\" value=\"");
      out.print(tabla.getString(7));
      out.write("\" required></TD>\r\n");
      out.write("\t");

	out.println("<TD data-th=Telefono><input type=text name=TELEFONO value="+tabla.getString(8)+" required></TD>");
	out.println("<TD data-th=Password><input type=text name=PASSWRD value="+tabla.getString(9)+" required></TD>");
	out.println("<TD data-th=Usuario><input type=text name=USUARIO value="+tabla.getString(10)+" required/></TD>");
	out.println("<TD><INPUT TYPE=SUBMIT NAME=BTN VALUE=Actulizar><BR></TD>");
	out.println("</TR>");
	out.println("</form>");}; // fin while
	out.println("</TABLE></CENTER>");
	

/*	
	if(request.getParameter("BTN") != null)
	{
		int idUser = Integer.parseInt(request.getParameter("USUARIO_ID"));
		String user = request.getParameter("USUARIO");
		String pass = request.getParameter("CONTRASENA");
		String email = request.getParameter("EMAIL");
		String paterno = request.getParameter("PATERNO");
		String materno = request.getParameter("MATERNO");
		String nom =request.getParameter("NOMBRE");
		int rol = Integer.parseInt(request.getParameter("ROL"));
		out.println("Carga ="+idUser+","+user+","+pass+","+email+","+materno+","+paterno+","+nom+","+rol+"");
	}*/
}



catch(SQLException e) {};
try {tabla.close();instruccion.close();canal.close();
} catch(SQLException e) {
	
};
	}


 
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
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
