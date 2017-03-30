<%@page import="java.sql.Date"%>
<%@page import="com.easy.util.Conexion"%>
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

<title>Modificar Producto</title>


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

//declarando y creando objetos globales
	Connection canal = null;
	ResultSet tabla= null;
	Statement instruccion=null;
	Conexion db = new Conexion();
	Connection cn = db.Conectar();
	canal = cn;
//BUSCAR PRODUCTO
	out.println("<FORM id=contact-form ACTION=modificar-productos.jsp METHOD=post>");
	out.println("Codigo Producto:<INPUT TYPE=TEXT NAME=CODPRO><BR>");
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
	
	
	String codpro = request.getParameter("CODPRO");
	String nombre = request.getParameter("NOMBRE");
	String q = null;
	
	
	if(codpro == "" || nombre == "")
	{
		 q = "SELECT ID_PRODUCTO,NOMBRE,DETALLE,VALOR,ID_TIPOPRODUCTO,STOCK FROM PRODUCTO";
	}
	if(codpro != "" && nombre == "")
	{
		 q = "SELECT ID_PRODUCTO,NOMBRE,DETALLE,VALOR,ID_TIPOPRODUCTO,STOCK FROM PRODUCTO WHERE ID_PRODUCTO = "+codpro+"";
	}
	if(codpro == "" && nombre != "")
	{
		q = "SELECT ID_PRODUCTO,NOMBRE,DETALLE,VALOR,ID_TIPOPRODUCTO,STOCK FROM PRODUCTO WHERE NOMBRE LIKE '%"+nombre+"%'";
	}
	if(codpro != "" && nombre != "")
	{
		q = "SELECT ID_PRODUCTO,NOMBRE,DETALLE,VALOR,ID_TIPOPRODUCTO,STOCK FROM PRODUCTO WHERE ID_PRODUCTO = "+codpro+" AND NOMBRE LIKE '%"+nombre+"%'";
	}	
		

	
//mandando el sql a la base de datos
	try { 
		tabla = instruccion.executeQuery(q);
		
		
		%>
		
		
		<center><TABLE class=rwd-table><TR>
		<th>Id Producto</th><th>Nombre</th><th>Detalle</th><th>Valor</th><th>Id Tipo producto</th><th>STOCK</th><th>Proveedor</th><th></th></TR>
			<% while(tabla.next()) {%>
		<FORM ACTION=servletModificarProducto METHOD=POST>
		<TR>
		<TD data-th="Codigo Producto"><input type="text" name="ID_PRODUCTO" value=<%=tabla.getString(1)%> readonly =readonly></TD>
		<TD data-th="Nombre"><input type="text" name="NOMBRE" value="<%=tabla.getString(2)%>" required></TD>
		<TD data-th="Descripcion"><input type="text" name="DETALLE" value="<%=tabla.getString(3)%>" required></TD>
		<TD data-th="Valor"><input type="text" name="VALOR" value="<%=tabla.getString(4)%>"required></TD>
	<%
		ResultSet ro = null;
		Statement stam = db.Conectar().createStatement();
		ro = stam.executeQuery("SELECT ID_TIPOPRODUCTO, DESCRIPCION FROM TIPO_PRODUCTO");
	%>
		<TD data-th="TIPO PRODUCTO">
		<select NAME="ID_TIPOPRODUCTO">
		        <%  while(ro.next()){ 

		        %>
		            <option value=<%=ro.getInt(1) %>><%= ro.getString(2)%></option>
		        <% } %>
		        </select>
		</TD>
		<%
		ro.close();
		stam.close();
		out.println("<TD data-th=Stock><input type=text name=Stock value="+tabla.getString(6)+" required></TD>");
		
		ResultSet pro = null;
		Statement stame = db.Conectar().createStatement();
		pro = stame.executeQuery("SELECT ID_PROVEEDOR,NOMBRE FROM PROVEEDOR");
		
		
		%>
		
		<TD data-th="PROVEEDOR">
		<select NAME="ID_PROVEEDOR">
		        <%  while(pro.next()){ %>
		            <option  value=<%=pro.getString(1)%>><%=pro.getString(2)%></option>
		        <% } %>
		        </select>
		</TD>
		<%
		pro.close();
		stame.close();
		out.println("<TD><INPUT TYPE=SUBMIT NAME=BTN VALUE=Actulizar><BR></TD>");
		out.println("</TR>");
		out.println("</form>");}; // fin while
		out.println("</TABLE></CENTER>");	

	}
	catch(SQLException e) {};
	try {tabla.close();instruccion.close();canal.close();} catch(SQLException e) {};
	}
	// Pruebas de Boton
	/*
	if(request.getParameter("BTN") != null)
	{
		int idUser = Integer.parseInt(request.getParameter("ID_PRODUCTO"));
		String user = request.getParameter("NOMBRE");
		String pass = request.getParameter("DETALLE");
		int email = Integer.parseInt(request.getParameter("VALOR"));
		int paterno = Integer.parseInt(request.getParameter("ID_TIPOPRODUCTO"));
		int materno = Integer.parseInt(request.getParameter("STOCK"));
		String nom =request.getParameter("FECHA_INGRESO");
		int rol = Integer.parseInt(request.getParameter("ID_PROVEEDOR"));
		out.println("Carga ="+idUser+","+user+","+pass+","+email+","+paterno+","+materno+","+nom+","+rol+"");
	}*/

 %>
	<script>
	  function validarN(numero){
	    if (!/^([0-9])*$/.test(numero))
	      alert("El valor " + numero + " no es un número");
	  }
	</script>
</html>