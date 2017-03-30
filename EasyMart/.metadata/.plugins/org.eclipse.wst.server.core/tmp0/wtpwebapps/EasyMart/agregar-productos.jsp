<%@page import="com.easy.util.Conexion"%>
<%@page import="java.util.Date"%>
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
		<link href="librerias/css/styleAgregar.css" rel="stylesheet">



<title>Agregar Producto</title>

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
Conexion db = new Conexion();


out.println("<FORM id=contact-form ACTION=agregar-productos.jsp METHOD=post>");
out.println("Nombre Producto:<INPUT TYPE=TEXT NAME=NOMBRE pattern=[a-zA-Z]* required/><BR>");
out.println("Detalle:<INPUT TYPE=TEXT NAME=DETALLE pattern=[a-zA-Z]* required/><BR>");
out.println("Valor:<INPUT TYPE=NUMBER NAME=VALOR required/><BR>");

ResultSet ro = null;
Statement stam = db.Conectar().createStatement();
ro = stam.executeQuery("SELECT * FROM TIPO_PRODUCTO");
%>
Tipo Producto :<TD data-th="Tipo Producto">
<select NAME="ID_TIPOPRODUCTO">
        <%  while(ro.next()){ %>
            <option value=<%=ro.getString(1) %>><%= ro.getString(2)%></option>
        <% } %>
</select>
</TD><BR>
<%
ro.close();
stam.close();
out.println("Stock:<INPUT TYPE=NUMBER NAME=STOCK required/><BR>");


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
    position: inherit; onclick=validacion()">

<%
out.println("</form>");



if(request.getParameter("OK") != null)
{
	Connection canal = null;
	ResultSet tabla= null;
	Statement instruccion=null;

	Connection cn = db.Conectar();
	canal = cn;

	try {		
		instruccion = canal.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
		ResultSet.CONCUR_UPDATABLE);
	}catch(SQLException e) {};



	String nom = request.getParameter("NOMBRE");
	String det = request.getParameter("DETALLE");
	int vlr = Integer.parseInt(request.getParameter("VALOR"));
	int idtipo = Integer.parseInt(request.getParameter("ID_TIPOPRODUCTO"));
	int stock = Integer.parseInt(request.getParameter("STOCK"));

//construyendo select con condicion
String q="INSERT INTO PRODUCTO(NOMBRE, DETALLE, VALOR, ID_TIPOPRODUCTO, STOCK) VALUES ('"+nom+"','"+det+"',"+vlr+","+idtipo+","+stock+")";

try {
// agregando renglon (insert)
int n=instruccion.executeUpdate(q);
//avisando que se hizo la instruccion
%>
<script>alert("REGISTRO INSERTADO")</script>
<%

}
catch(SQLException e) {};
try {instruccion.close();canal.close();} catch(SQLException e) {};
}



%>
<script>
	  function validarN(numero){
	    if (!/^([0-9])*$/.test(numero))
	      alert("El valor " + numero + " no es un número");
	  }
	<script src="librerias/js/scripts.js"></script>
</html>