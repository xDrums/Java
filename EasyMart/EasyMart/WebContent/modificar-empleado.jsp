<%@page import="java.sql.Date"%>
<%@page import="com.easy.util.Conexion"%>
<%@ page import="java.io.*,java.util.*,java.net.*,java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>

   		<meta http-equiv="X-UA-Compatible" content="IE=edge">
   		<meta name="viewport" content="width=device-width, initial-scale=1">
   		<script src="http://code.jquery.com/jquery-latest.min.js" type="text/javascript"></script>
   		<script src="librerias/js/script.js"></script>
		<link rel="stylesheet" media="(max-width:3000px)" href = "librerias/css/menuCssResponsive.css" type = "text/css">
		<link rel="stylesheet" href = "librerias/css/tablas-reponsivas.css" type = "text/css">
		<link href="librerias/css/styleEliminar.css" rel="stylesheet">

<title>Modificar Empleado</title>


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

<style>
form.formBuscar {
background:rgba(13, 82, 78, 0.98);
}


</style>

<%
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
	%>
	<TD data-th="Sucursal"><input type="text" name="ID_SUCURSAL" value="<%=tabla.getString(3)%>" required></TD>
	<%
	out.println("<TD data-th=Nombre><input type=text name=NOMBRE value="+tabla.getString(4)+" required></TD>");
	out.println("<TD data-th=Correo><input type=text name=CORREO value="+tabla.getString(5)+" required></TD>");
	out.println("<TD data-th=Rut><input type=text name=RUT value="+tabla.getString(6)+" required></TD>");
	%>
	<TD data-th="Direccion"><input type="text" name="DIRECCION" value="<%=tabla.getString(7)%>" required></TD>
	<%
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


 %>



</html>