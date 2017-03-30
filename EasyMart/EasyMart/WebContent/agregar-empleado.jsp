<%@page import="java.util.Date"%>
<%@page import="com.easy.util.Conexion"%>
<%@page import="java.util.Calendar" %>
<%@ page import="java.io.*,java.util.*,java.net.*,java.sql.*" %>
<!DOCTYPE html>
<html>
	<head>
	   	<meta charset='utf-8'>
   		<meta http-equiv="X-UA-Compatible" content="IE=edge">
   		<meta name="viewport" content="width=device-width, initial-scale=1">
   		<script src="http://code.jquery.com/jquery-latest.min.js" type="text/javascript"></script>
   		<script src="librerias/js/script.js"></script>
   		<link rel="stylesheet" media="(max-width:3000px)" href = "librerias/css/menuCssResponsive.css" type = "text/css">
		<link rel="stylesheet" href = "librerias/css/tablas-reponsivas.css" type = "text/css">
		<link href="librerias/css/styleAgregar.css" rel="stylesheet">

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
Connection canal = null;
ResultSet tabla= null;
Statement instruccion=null;
Conexion db = new Conexion();
Connection cn = db.Conectar();
canal = cn;

	if(request.getParameter("OK") != null)
	{
// objetos de enlace
	try {
		instruccion = canal.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
		ResultSet.CONCUR_UPDATABLE);
	}catch(SQLException e) {};
//cargando los campos a grabar
// excepto clave porque en mysql es de tipo auto-increment
//ID_TIPOEMPLEADO,ID_SUCURSAL,NOMBRE,CORREO,RUT,DIRECCION,TELEFONO,PASSWRD,USUARIO

		int tipo = Integer.parseInt(request.getParameter("TIPOEMPLEADO"));
		int suc = Integer.parseInt(request.getParameter("SUCURSAL"));
		String nom = request.getParameter("NOMBRE");
		String correo = request.getParameter("CORREO");
		int rut = Integer.parseInt(request.getParameter("RUT"));
		String dir = request.getParameter("DIRECCION");
		int tel = Integer.parseInt(request.getParameter("TELEFONO"));
		String pass = request.getParameter("PASSWRD");
		String user = request.getParameter("USUARIO");


String q="INSERT INTO EMPLEADO(ID_TIPOEMPLEADO,ID_SUCURSAL,NOMBRE,CORREO,RUT,DIRECCION,TELEFONO,PASSWRD,USUARIO)VALUES("+tipo+","+suc+",'"+nom+"','"+correo+"',"+rut+",'"+dir+"',"+tel+",'"+pass+"','"+user+"')";

try {
// agregando renglon (insert)
int n=instruccion.executeUpdate(q);
//avisando que se hizo la instruccion
%>
<script>alert("USUARIO INSERTADO")</script>
<%

} catch(SQLException e) {out.println(e);};
try{

// tabla.close();
instruccion.close();
canal.close();
} catch(SQLException e) {out.println(e);};
};






out.println("<FORM id=contact-form ACTION=agregar-empleado.jsp METHOD=post>");
out.println("Nombre:<INPUT TYPE=TEXT pattern=[a-zA-Z]* NAME=NOMBRE required/><BR>");
out.println("Email:<INPUT TYPE=EMAIL NAME=CORREO required/><BR>");
out.println("RUT:<INPUT TYPE=NUMBER NAME=RUT required/><BR>");
out.println("Direccion:<INPUT TYPE=TEXT pattern=[a-zA-Z]* required/><BR>");
out.println("Telefono:<INPUT TYPE=NUMBER NAME=TELEFONO required/><BR>");

ResultSet pro = null;
Statement stamm = db.Conectar().createStatement();
pro = stamm.executeQuery("SELECT	ID_SUCURSAL,DIRECCION FROM SUCURSAL");

%>
	Sucursal :<TD data-th="SUCURSAL">
	<select NAME="SUCURSAL">
	        <%  while(pro.next()){ %>
	            <option value=<%=pro.getString(1) %>><%= pro.getString(2)%></option>
	        <% } %>
	</select>
	</TD><BR>
<%	
pro.close();
stamm.close();
out.println("Password:<INPUT TYPE=Password NAME=PASSWRD required/> <BR>");
out.println("Usuario:<INPUT TYPE=TEXT NAME=USUARIO required/><BR>");
ResultSet ro = null;
Statement stam = db.Conectar().createStatement();
ro = stam.executeQuery("SELECT * FROM TIPO_EMPLEADO");
%>
Tipo Empleado :<TD data-th="TipoEmpleado">
<select NAME="TIPOEMPLEADO">
        <%  while(ro.next()){ %>
            <option value=<%=ro.getString(1) %>><%= ro.getString(2)%></option>
        <% } %>
</select>
</TD><BR>
<%
ro.close();
stam.close();
%>
<input type="submit" name="OK" value="Agregar" style="
    cursor: pointer;
    width:100%;
    border:none;
    background: #272526;
    background-image:linear-gradient(bottom, #8C1C50 0%, #991D57 52%);
    background-image:-moz-linear-gradient(bottom, #8C1C50 0%, #991D57 52%);
    background-image: -webkit-linear-gradient(bottom, #686D6F 0%, #000000 52%);
    color:#FFF;
    margin:0 0 5px;
    padding:10px;
    border-radius:5px;
    top: 10px;
    position: inherit;" >

<%
out.println("</FORM>");
%>

	<script src="librerias/js/scripts.js"></script>
</html>