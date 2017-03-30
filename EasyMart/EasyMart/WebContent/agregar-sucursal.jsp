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
	if(request.getParameter("OK") != null)
	{
		Connection canal = null;
		ResultSet tabla= null;
		Statement instruccion=null;
		Conexion db = new Conexion();
		Connection cn = db.Conectar();
		canal = cn;
		

	try {
		instruccion = canal.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
		ResultSet.CONCUR_UPDATABLE);
	}catch(SQLException e) {};
//cargando los campos a grabar
// excepto clave porque en mysql es de tipo auto-increment
//ID_TIPOEMPLEADO,ID_SUCURSAL,NOMBRE,CORREO,RUT,DIRECCION,TELEFONO,PASSWRD,USUARIO


		int comu = Integer.parseInt(request.getParameter("ID_COMUNA"));
		String dir = request.getParameter("DIRECCION");
		int tel = Integer.parseInt(request.getParameter("TELEFONO"));
		int rut = Integer.parseInt(request.getParameter("RUT"));



String q="INSERT INTO SUCURSAL(ID_COMUNA,DIRECCION,TELEFONO,RUT)VALUES("+comu+",'"+dir+"',"+tel+","+rut+")";

try {
// agregando renglon (insert)
int n=instruccion.executeUpdate(q);
//avisando que se hizo la instruccion
%>
<script>alert("Sucursal Insertado")</script>
<%

} catch(SQLException e) {out.println(e);};
try{

// tabla.close();
instruccion.close();
canal.close();
} catch(SQLException e) {out.println(e);};
};



Conexion db = new Conexion();


%>
<FORM id="contact-form" ACTION="agregar-sucursal.jsp" METHOD="post">

<%
		ResultSet pro = null;
		Statement stamm = db.Conectar().createStatement();
		pro = stamm.executeQuery("SELECT ID_COMUNA ,DESCRIPCION FROM COMUNA");
%>
	Comuna :<TD data-th="COMUNA">
	<select NAME="ID_COMUNA">
	        <%  while(pro.next()){ %>
	            <option value=<%=pro.getString(1) %>><%= pro.getString(2)%></option>
	        <% } %>
	</select>
	</TD><BR>
<%		
out.println("Direccion:<INPUT TYPE=TEXT NAME=DIRECCION pattern=[a-zA-Z]* required/><BR>");
out.println("Telefono Empresa:<INPUT TYPE=number NAME=TELEFONO required/> <BR>");
out.println("Rut Empresa:<INPUT TYPE=number NAME=RUT required/><BR>");
out.println("<INPUT TYPE=SUBMIT NAME=OK VALUE=Agregar><BR>");
out.println("</FORM>");

%>
</body>
</html>