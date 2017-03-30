<%@ page import="java.io.*,java.util.*,java.net.*,java.sql.*" %>
<%@page import="com.easy.util.Conexion"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	   	<meta charset='utf-8'>
   		<meta http-equiv="X-UA-Compatible" content="IE=edge">
   		<meta name="viewport" content="width=device-width, initial-scale=1">
   		<script src="http://code.jquery.com/jquery-latest.min.js" type="text/javascript"></script>
   		<script src="librerias/js/script.js"></script>
		<link rel="stylesheet" media="(max-width:3000px)" href = "librerias/css/menuCssResponsive.css" type = "text/css">
		<link href="librerias/css/styleEliminar.css" rel="stylesheet">
		<link rel="stylesheet" href = "librerias/css/tablas-reponsivas.css" type = "text/css">


<title>Eliminar Empleado</title>


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
// construyendo forma dinamica
	out.println("<form id=contact-form action=eliminar-empleado.jsp method=post>");
	out.println("Eliminar Empleado ID:<input type=text name=ID_EMPLEADO><BR>");
	out.println("<input type=submit name=OK value=Eliminar><BR>");
	out.println("</FORM>");
	
	
	out.println("<form id=contact-form action=eliminar-empleado.jsp METHOD=POST>");
	out.println("Eliminar en Lista:");
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
	//abriendo canal o enlace en su propio try-catch
		try {
			instruccion = canal.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
			ResultSet.CONCUR_UPDATABLE);
			} catch(SQLException e) {};
	//preparando condicion de busqueda
		int w = Integer.parseInt(request.getParameter("ID_EMPLEADO"));
		//construyendo select con condicion
		String q="DELETE from EMPLEADO where ID_EMPLEADO ="+w;
	//mandando el sql a la base de datos
		try { 
			tabla = instruccion.executeQuery(q);
		} 
		catch(SQLException e) {};
		try {
			instruccion.close();canal.close();} catch(SQLException e) {};
		};
//Buscar Todos los Productos

if(request.getParameter("TODOS") != null)
{
//abriendo canal o enlace en su propio try-catch
try {

instruccion = canal.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
ResultSet.CONCUR_UPDATABLE);
} catch(SQLException e) {};
//construyendo select con condicion


//construyendo select con condicion
String q = "SELECT E.ID_EMPLEADO,T.DESCRIPCION,S.DIRECCION,E.NOMBRE,E.CORREO,E.RUT,E.DIRECCION,E.TELEFONO,E.PASSWRD,E.USUARIO FROM EMPLEADO E JOIN TIPO_EMPLEADO T ON E.ID_TIPOEMPLEADO =T.ID_TIPOEMPLEADO JOIN SUCURSAL S ON E.ID_SUCURSAL = S.ID_SUCURSAL";
//mandando el sql a la base de datos
try { tabla = instruccion.executeQuery(q);
//mandando resultset a tabla html
out.println("<center><TABLE class=rwd-table><TR>");
out.println("<th>ID</th><th>Tipo Empleado</th><th>Sucursal</th><th>Nombre</th><th>Correo</th><th>Rut</th><th>Direccion</th><th>Telefono</th><th>Password</th><th>Usuario</th></tr>");
while(tabla.next()) {
out.println("<TR>");
out.println("<TD data-th=Id Empleado NAME=ID>"+tabla.getString(1)+"</TD>");
out.println("<TD data-th=Tipo Empleado>"+tabla.getString(2)+"</TD>");
out.println("<TD data-th=Sucursal>"+tabla.getString(3)+"</TD>");
out.println("<TD data-th=Nombre>"+tabla.getString(4)+"</TD>");
out.println("<TD data-th=Correo>"+tabla.getString(5)+"</TD>");
out.println("<TD data-th=Rut>"+tabla.getString(6)+"</TD>");
out.println("<TD data-th=Direccion>"+tabla.getString(7)+"</TD>");
out.println("<TD data-th=Telefono>"+tabla.getString(8)+"</TD>");
out.println("<TD data-th=Password>"+tabla.getString(9)+"</TD>");
out.println("<TD data-th=Usuario>"+tabla.getString(10)+"</TD>");
out.println("<TD><a href=servletEliminarEmpleado?cod="+tabla.getString(1)+"><INPUT TYPE=SUBMIT NAME=btnEliminar VALUE=Eliminar><BR></a></TD>");
out.println("</TR>");
}; // fin while
out.println("</TABLE></CENTER>");
} 
catch(SQLException e) {};
try {tabla.close();instruccion.close();canal.close();} catch(SQLException e) {};
};



%>
</html>