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
		<link rel="stylesheet" href = "librerias/css/tablas-reponsivas.css" type = "text/css">
		<link href="librerias/css/styleEliminar.css" rel="stylesheet">


<title>Eliminar Producto</title>

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
out.println("<FORM id=contact-form ACTION=servletEliminarProducto METHOD=get>");
out.println("Eliminar Producto:<INPUT TYPE=TEXT NAME=ID_PRODUCTO><BR>");
out.println("<INPUT TYPE=SUBMIT NAME=OK VALUE=Eliminar><BR>");
out.println("</FORM>");


out.println("<FORM id=contact-form ACTION=eliminar-productos.jsp METHOD=POST>");
out.println("Lista de Productos");
out.println("<INPUT TYPE=SUBMIT NAME=TODOS VALUE=BUSCAR><BR>");
out.println("</FORM>");

//declarando y creando objetos globales
	Connection canal = null;
	ResultSet tabla= null;
	Statement instruccion=null;
	Conexion db = new Conexion();
	Connection cn = db.Conectar();
	canal = cn; 

//Buscar Todos los Productos

if(request.getParameter("TODOS") != null)
{
//abriendo canal o enlace en su propio try-catch
try {
instruccion = canal.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
ResultSet.CONCUR_UPDATABLE);
}catch(SQLException e) {};
//construyendo select con condicion


//construyendo select con condicion
String q = "SELECT P.ID_PRODUCTO,P.NOMBRE,P.DETALLE,P.VALOR,T.DESCRIPCION,STOCK FROM PRODUCTO P JOIN TIPO_PRODUCTO T ON P.ID_TIPOPRODUCTO = T.ID_TIPOPRODUCTO ";

//mandando el sql a la base de datos
try { tabla = instruccion.executeQuery(q);
//mandando resultset a tabla html
out.println("<center><TABLE class=rwd-table><TR>");
out.println("<th>Id Producto</th><th>Nombre</th><th>Detalle</th><th>Valor</th><th>Tipo Producto</th><th>Stock</th><th>Eliminar</th></TR>");
while(tabla.next()) {

out.println("<TR>");
out.println("<TD data-th=Id Producto>"+tabla.getString(1)+"</TD>");
out.println("<TD data-th=Nombre>"+tabla.getString(2)+"</TD>");
out.println("<TD data-th=Detalle>"+tabla.getString(3)+"</TD>");
out.println("<TD data-th=Valor>"+tabla.getString(4)+"</TD>");
out.println("<TD data-th=Tipo Producto>"+tabla.getString(5)+"</TD>");
out.println("<TD data-th=Stock>"+tabla.getString(6)+"</TD>");
out.println("<TD><a href=servletEliminarProducto?cod="+tabla.getString(1)+"><INPUT TYPE=SUBMIT NAME=btnEliminar VALUE=Eliminar><BR></a></TD>");
out.println("</TR>"); 

}; // fin while
out.println("</TABLE></CENTER>");
} 
catch(SQLException e) {};
try {tabla.close();instruccion.close();canal.close();} catch(SQLException e) {};
};


%>
</html>