<%@page import="java.util.Date"%>
<%@page import="com.easy.util.Conexion"%>
<%@page import="java.util.Calendar" %>
<%@ page import="java.io.*,java.util.*,java.net.*,java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	   	<meta charset='utf-8'>
   		<meta http-equiv="X-UA-Compatible" content="IE=edge">
   		<meta name="viewport" content="width=device-width, initial-scale=1">
   		<script src="http://code.jquery.com/jquery-latest.min.js" type="text/javascript"></script>
   		<script src="librerias/js/script.js"></script>
   		<link rel="stylesheet" media="(max-width:3000px)" href = "librerias/css/menuCssResponsive.css" type = "text/css">
		<link rel="stylesheet" href = "librerias/css/tablas-reponsivas.css" type = "text/css">
		<link href="librerias/css/styleEliminar.css" rel="stylesheet">

<title>Home</title>


	</head>
<body>
<center>
<div class="">
	<a href="index.html"><img width="25%" src="librerias/img/easymart.png"></a>
</div>
<div id="cssmenu">
<ul>
   <li><a href="welcome.jsp">Inicio</a></li>
   <li class='has-sub'><a href ="#">Productos</a>
   		<ul>
   			 <li><a href="agregar-productos.jsp">Agregar Productos</a></li>
   			 <li><a href="eliminar-productos.jsp">Eliminar Productos</a></li>
   			 <li><a href="modificar-productos.jsp">Modificar Productos</a></li>
   		</ul>
   </li>
      <li class='has-sub'><a href="#">Trabajadores</a>
   		 <ul>
   			 <li><a href="agregar-empleado.jsp">Agregar Empleado</a></li>
   			 <li><a href="eliminar-empleado.jsp">Eliminar Empleado</a></li>
   			 <li><a href="modificar-empleado.jsp">Modificar Empleado</a></li>
   		</ul>
   </li>
   	  <li class='has-sub'><a href="#">Sucursales</a>
   	  <ul>
   			 <li><a href="agregar-sucursal.jsp">Agregar Sucursal</a></li>
   			 <li><a href="eliminar-sucursal.jsp">Eliminar Sucursal</a></li>
   			 <li><a href="modificar-sucursal.jsp">Modificar Sucursal</a></li>
   		</ul>
   	  </li>
   	  <li><a href="pedidos.jsp">Pedidos</a></li>
   <li><a class="logout" href="index.jsp" data-title="Log out">Cerrar Sesion</a></li>
</ul>
</div>
</center>

<%


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
%>
<TD data-th="COMUNA">
<select NAME="ID_COMUNA">
        <%  while(ro.next()){ 

        %>
            <option value=<%=ro.getInt(1) %>><%= ro.getString(2)%></option>
        <% } %>
        </select>
</TD>
<%
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

%>
</html>