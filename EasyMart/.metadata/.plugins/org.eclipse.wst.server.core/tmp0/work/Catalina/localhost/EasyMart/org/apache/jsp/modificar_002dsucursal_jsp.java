/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.69
 * Generated at: 2016-07-21 23:53:55 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Date;
import com.easy.util.Conexion;
import java.util.Calendar;
import java.io.*;
import java.util.*;
import java.net.*;
import java.sql.*;

public final class modificar_002dsucursal_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("\t<head>\r\n");
      out.write("\t   \t<meta charset='utf-8'>\r\n");
      out.write("   \t\t<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n");
      out.write("   \t\t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("   \t\t<script src=\"http://code.jquery.com/jquery-latest.min.js\" type=\"text/javascript\"></script>\r\n");
      out.write("   \t\t<script src=\"librerias/js/script.js\"></script>\r\n");
      out.write("   \t\t<link rel=\"stylesheet\" media=\"(max-width:3000px)\" href = \"librerias/css/menuCssResponsive.css\" type = \"text/css\">\r\n");
      out.write("\t\t<link rel=\"stylesheet\" href = \"librerias/css/tablas-reponsivas.css\" type = \"text/css\">\r\n");
      out.write("\t\t<link href=\"librerias/css/styleEliminar.css\" rel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("<title>Home</title>\r\n");
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



out.println("<FORM id=contact-form ACTION=modificar-sucursal.jsp METHOD=post>");
out.println("Codigo Sucursal:<INPUT TYPE=TEXT NAME=ID_SUCURSAL><BR>");
out.println("Comuna:<INPUT TYPE=TEXT NAME=COMUNA><BR>");
out.println("Rut:<INPUT TYPE=TEXT NAME=RUT onChange=validarN(this.value);><BR>");
out.println("<INPUT TYPE=SUBMIT NAME=OK VALUE=BUSCAR><BR>");
out.println("</FORM>");


Connection canal = null;
ResultSet tabla= null;
Statement instruccion=null;
Conexion db = new Conexion();
Connection cn = db.Conectar();
canal = cn;


if(request.getParameter("OK") != null)
{
//abriendo canal o enlace en su propio try-catch
try {

instruccion = canal.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
ResultSet.CONCUR_UPDATABLE);
} catch(SQLException e) {};

String id = request.getParameter("ID_SUCURSAL");
String com = request.getParameter("COMUNA");
String rut = request.getParameter("RUT");

String q = null;


if(id == "" || com == "" || rut == "")
{
	 q = "SELECT S.ID_SUCURSAL,C.DESCRIPCION,S.DIRECCION,S.TELEFONO,S.RUT FROM SUCURSAL S JOIN COMUNA C ON S.ID_COMUNA = C.ID_COMUNA";
}
if(id != "" && com == "" && rut == "")
{
	 q = "SELECT S.ID_SUCURSAL,C.DESCRIPCION,S.DIRECCION,S.TELEFONO,S.RUT FROM SUCURSAL S JOIN COMUNA C ON S.ID_COMUNA = C.ID_COMUNA WHERE S.ID_SUCURSAL = "+id+"";
}
if(id == "" && com != "" && rut == "")
{
	q = "SELECT S.ID_SUCURSAL,C.DESCRIPCION,S.DIRECCION,S.TELEFONO,S.RUT FROM SUCURSAL S JOIN COMUNA C ON S.ID_COMUNA = C.ID_COMUNA WHERE C.DESCRIPCION LIKE '%"+com+"%'";
}
if(id != "" && com != "" && rut == "")
{
	q = "SELECT S.ID_SUCURSAL,C.DESCRIPCION,S.DIRECCION,S.TELEFONO,S.RUT FROM SUCURSAL S JOIN COMUNA C ON S.ID_COMUNA = C.ID_COMUNA WHERE C.DESCRIPCION WHERE S.ID_SUCURSAL = "+id+" AND C.DESCRIPCION LIKE '%"+com+"%'";
}
if(id == "" && com == "" && rut != ""){
	 q = "SELECT S.ID_SUCURSAL,C.DESCRIPCION,S.DIRECCION,S.TELEFONO,S.RUT FROM SUCURSAL S JOIN COMUNA C ON S.ID_COMUNA = C.ID_COMUNA WHERE S.RUT = "+rut+"";
}

//mandando el sql a la base de datos
try { tabla = instruccion.executeQuery(q);
//mandando resultset a tabla html

out.println("<center><TABLE class=rwd-table><TR>");
out.println("<th>Id Sucursal</th><th>Comuna</th><th>Direccion</th><th>Telefono</th><th>Rut</th><th>Modificar</th></TR>");
while(tabla.next()) {
out.println("<FORM ACTION=servletModificarSucursal METHOD=POST>");
out.println("<TR>");
out.println("<TD data-th=Id Sucursal><input type=text name=ID_SUCURSAL value="+tabla.getString(1)+" required></TD>");
ResultSet ro = null;
Statement stam = db.Conectar().createStatement();
ro = stam.executeQuery("SELECT ID_COMUNA, DESCRIPCION FROM COMUNA");

      out.write("\r\n");
      out.write("<TD data-th=\"COMUNA\">\r\n");
      out.write("<select NAME=\"ID_COMUNA\">\r\n");
      out.write("        ");
  while(ro.next()){ 

        
      out.write("\r\n");
      out.write("            <option value=");
      out.print(ro.getInt(1) );
      out.write('>');
      out.print( ro.getString(2));
      out.write("</option>\r\n");
      out.write("        ");
 } 
      out.write("\r\n");
      out.write("        </select>\r\n");
      out.write("</TD>\r\n");

ro.close();
stam.close();

out.println("<TD data-th=Direccion><input type=text name=DIRECCION value="+tabla.getString(3)+" required></TD>");
out.println("<TD data-th=Telefono><input type=text name=TELEFONO value="+tabla.getString(4)+" required></TD>");
out.println("<TD data-th=Rut><input type=text name=RUT value="+tabla.getString(5)+" required></TD>");
out.println("<TD><INPUT TYPE=SUBMIT NAME=BTN VALUE=Actulizar><BR></TD>");
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
