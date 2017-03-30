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
<!--  MENU 	<link rel="stylesheet" href = "librerias/css/login.css" type = "text/css"> -->
		<link rel="stylesheet" href = "librerias/css/tablas-reponsivas.css" type = "text/css">


<title>Consultar Producto</title>


	</head>
<body>
<center>
<div class="overstock">
	<a href="index.html"><img width="25%" src="librerias/img/overstock.png"></a>
</div>
<!--  MENU  -->
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
   <li><a class="logout" href="php/logout.php" data-title="Log out">Cerrar Sesion</a></li>
</ul>
</div>
<!-- FIN MENU -->
</center>

<%
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


%>
</html>