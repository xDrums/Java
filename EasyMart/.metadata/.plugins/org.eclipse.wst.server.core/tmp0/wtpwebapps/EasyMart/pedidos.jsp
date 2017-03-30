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
		<link rel="stylesheet" href = "librerias/css/tabla.css" type = "text/css">
	<!--  	<link href="librerias/css/styleEliminar.css" rel="stylesheet">-->

<title>Pedidos</title>

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

<script language="javascript">
function marcado(){
if (document.form.termin.checked) {
document.form.submit(); 
     }
	 else{
	 alert("Debes aceptar los t�rminos y condiciones");
	  document.form.termin.focus();
       return false; 
	 }

}
</script>


<%
// construyendo forma dinamica

out.println("<FORM id=contact-form ACTION=pedidos.jsp METHOD=post>");
out.println("Buscar pedidos");
out.println("<INPUT TYPE=SUBMIT NAME=TODOS VALUE=BUSCAR><BR>");
out.println("</FORM>");

Connection canal = null;
ResultSet tabla= null;
Statement instruccion=null;
Conexion db = new Conexion();
Connection cn = db.Conectar();
canal = cn;



if(request.getParameter("boleta")!=null && request.getParameter("pedido")!=null){
	
	Conexion con = new Conexion();
    Connection cnn = con.Conectar();
    String pedido = request.getParameter("pedido");
    String boleta = request.getParameter("boleta");
    String codigo = boleta + pedido;
 	String w = "UPDATE PEDIDO SET ID_TIPOESTADO = 4 WHERE ID_PEDIDO = "+pedido;
	try { 
		if(codigo!=null){
		Statement st = cnn.createStatement();
		st.executeUpdate(w);
		out.println("<center><img src=/EasyMart/qrservlet?qrtext="+codigo+" >");
		%>
		<div>
			<h3>Codigo generado para la confirmacion del usuario</h3>
		</div>
		<div>
			<h3>Porfavor entregar a la persona para la lectura del codigo</h3>
		</div>
			</center>
		<%
		}
		else
		{
			%>
			<div><h3>No se pudo generar el Pedido</h3>></div>
			<%	
		}
	}catch(SQLException e) {};
		
	
    }
    


if(request.getParameter("cod") != null && request.getParameter("ped")!=null)
{
	try {
		instruccion = canal.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
		ResultSet.CONCUR_UPDATABLE);
		} catch(SQLException e) {};
	String codigo = request.getParameter("cod");
	String pedido = request.getParameter("ped");
	String z = "SELECT BP.ID_BOLETA,BP.ID_PRODUCTO,P.NOMBRE,SUM(BP.CANTIDAD) AS CANTIDAD FROM BOLETA_PRO BP JOIN PRODUCTO P ON P.ID_PRODUCTO = BP.ID_PRODUCTO WHERE BP.ID_BOLETA ="+codigo+" GROUP BY BP.ID_BOLETA,BP.ID_PRODUCTO,NOMBRE";
	try { tabla = instruccion.executeQuery(z);
		
	out.println("<form method=post action=pedidos.jsp?boleta="+codigo+"&pedido="+pedido+">");
	
	out.println("<center><TABLE class=rwd-table>");
	out.println("<tr><th>Codigo Producto</th><th>Nombre Producto</th><th>Cantidad</th></tr>");
	
		while(tabla.next()) {
			out.println("<th>"+tabla.getString(2)+"</th>");
			out.println("<th>"+tabla.getString(3)+"</th>");
			out.println("<th>"+tabla.getString(4)+"</th>");
			out.println("<th><input type=checkbox required></th>");
			out.println("<tr>");
				
		}; 
		out.println("</TABLE></center>");
		%>
		
		<center><INPUT TYPE=SUBMIT NAME=btnEntrega value="Entregar Productos"></center></form>
		
		<%
	} 
	catch(SQLException e) {};
}

if(request.getParameter("TODOS") != null)
{
//abriendo canal o enlace en su propio try-catch
try {

instruccion = canal.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
ResultSet.CONCUR_UPDATABLE);
} catch(SQLException e) {};
//construyendo select con condicion
String q = "SELECT P.ID_PEDIDO,P.ID_BOLETA,TE.DESCRIPCION,P.RUT_USUARIO,P.FECHA_INGRESO "+
		"FROM PEDIDO P "+
		"JOIN TIPO_ESTADO TE ON TE.ID_TIPOESTADO = P.ID_TIPOESTADO "+
		"WHERE TE.ID_TIPOESTADO = 1 AND FECHA_ENTREGA IS NULL";

try { tabla = instruccion.executeQuery(q);
//mandando resultset a tabla html
	while(tabla.next()) {
		
		out.println("<center><TABLE class=rwd-table>");
		out.println("<tr><th>N� Pedido : "+tabla.getString(1)+"</th></tr>");
		out.println("<tr><th>N� Boleta : "+tabla.getString(2)+"</th></tr>");
		out.println("<tr><th>Estado : "+tabla.getString(3)+"</th></tr>");
		out.println("<tr><th>Rut Usuario : "+tabla.getString(4)+"</th></tr>");
		out.println("<tr><th>Fecha Ingreso : "+tabla.getString(5)+"</th></tr>");
		
		out.println("<tr><th><a href=pedidos.jsp?cod="+tabla.getString(2)+"&ped="+tabla.getString(1)+">");
		%>
		<center><INPUT TYPE=SUBMIT NAME=btnEliminar VALUE=+></center></a>
		</th></tr>
		</TABLE></center>
		<%
		}; 
} 
catch(SQLException e) {};
try {
//	tabla.close();
	instruccion.close();
	canal.close();
	} catch(SQLException e) {};
};


%>
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
	<script src="librerias/js/jquery.slicknav.js"></script>
	<script type="text/javascript">
$(document).ready(function(){
	$('#menu').slicknav();
});
</script>
