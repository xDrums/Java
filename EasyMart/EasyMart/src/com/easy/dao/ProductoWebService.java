package com.easy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Collection;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import com.easy.entidad.Boleta;
import com.easy.entidad.Boleta_pro;
import com.easy.entidad.CaminantesOscuros;
import com.easy.entidad.Pedido;
import com.easy.entidad.Producto;
import com.easy.entidad.Usuario;
import com.easy.util.Conexion;

@WebService(serviceName = "ProductoWebService")
public class ProductoWebService {
	
	
	@WebMethod(operationName = "detalleProducto")
    public Producto[] detalleProducto(@WebParam(name = "id_producto") String id_producto) {
		ArrayList<Producto> list = new ArrayList<Producto>();
		ResultSet rs = null;
        Conexion db = new Conexion();
        Connection cn = db.Conectar();
    	try{
			Statement st = cn.createStatement();
			String sql="SELECT NOMBRE,DETALLE,VALOR,STOCK,FOTO "
					+ "FROM PRODUCTO WHERE ID_PRODUCTO = "+id_producto+"";
			rs = st.executeQuery(sql);
			while(rs.next()){
				Producto pr = new Producto();
				pr.setNombre(rs.getString(1));
				pr.setDetalle(rs.getString(2));
				pr.setValor(rs.getString(3));
				pr.setStock(Integer.parseInt(rs.getString(4)));
				pr.setFoto(rs.getBytes(5));
				list.add(pr);
				//Pruebas Error
        		System.out.println("Producto Detalle Ok "+ id_producto+"");
			}
		}catch(SQLException ex){
			//Pruebas Error
			System.out.println("fallo en el try producto detalle");
        	ex.printStackTrace();
		}
    	return (Producto[])list.toArray(new Producto[list.size()]);
    }
	
	@WebMethod(operationName = "boletas")
    public Boleta[] boletas(@WebParam(name = "rut") String rut) {
		ArrayList<Boleta> list = new ArrayList<Boleta>();
		ResultSet rs = null;
        Conexion db = new Conexion();
        Connection cn = db.Conectar();
    	try{
			Statement st = cn.createStatement();
			String sql="SELECT RUT_USER,ID_BOLETA,ID_SUCURSAL,TOTAL,FECHA "
					+ "FROM BOLETA WHERE RUT_USER = '"+rut+"'";
			rs = st.executeQuery(sql);
			while(rs.next()){
				Boleta bl = new Boleta();
				bl.setRut(Integer.parseInt(rs.getString(1)));
				bl.setIdBoleta(Integer.parseInt(rs.getString(2)));
				//bl.setIdSucursal(Integer.parseInt(rs.getString(3)));
				bl.setTotal(Integer.parseInt(rs.getString(4)));
				bl.setFecha(rs.getString(5));
				list.add(bl);
				//Pruebas Error
        		System.out.println("Boletas "+	rut+"");
			}
		}catch(SQLException ex){
			//Pruebas Error
			System.out.println("fallo en el try producto detalle");
        	ex.printStackTrace();
		}
    	return (Boleta[])list.toArray(new Boleta[list.size()]);
    }
	
	@WebMethod(operationName = "agregarBoleta")
    public int agregarBoleta(@WebParam(name = "rut") String rut,@WebParam(name = "total") int total)
	{
		int resultado = 0;
        Conexion db = new Conexion();
        Connection cn = db.Conectar();
    	try{
    		Statement st = cn.createStatement();
    		// SE CAE SE DEJA EN 0 PARA PODER CREAR UNA BOLETA 
			String sql="INSERT INTO BOLETA (RUT_USER , TOTAL , FECHA)VALUES("+rut+" , "+total+", GETDATE())";
	        st.executeUpdate(sql);
	        resultado=1;
	        st.close();
	        	//pruebas por consola
	        System.out.println("Inserto Boleta");
	    }catch(SQLException ex){
	        ex.printStackTrace();
	        resultado=0;
	        	//pruebas por consola
	        System.out.println("Error al insertar el Boleta");
	    }
    	return resultado;
	}
	
	@WebMethod(operationName = "selectBoleta")
    public Boleta[] selectBoleta(@WebParam(name = "rut") int rut) {
		ArrayList<Boleta> list = new ArrayList<Boleta>();
        Conexion db = new Conexion();
        Connection cn = db.Conectar();
        String sql = "SELECT TOP 1 ID_BOLETA,FECHA FROM BOLETA WHERE RUT_USER = "+rut+" ORDER BY ID_BOLETA DESC";
    	try {
    		ResultSet rs= null;
    		Statement st = cn.createStatement();
			rs = st.executeQuery(sql);	
			while(rs.next()){
				Boleta bl = new Boleta();
	    		bl.setIdBoleta(Integer.parseInt(rs.getString(1)));
	    		bl.setFecha(rs.getString(2));
	    		list.add(bl);
	    		System.out.println("resultado es "+ bl.getIdBoleta()+"");
	    	}
		}
    	catch (SQLException e) {
			System.out.println("no se pudo seleccionar la boleta");
			e.printStackTrace();
		}
    	return (Boleta[])list.toArray(new Boleta[list.size()]);
	}
	@WebMethod(operationName = "crearPedido")
	public String crearPedido (@WebParam(name="id_boleta") String id_boleta,@WebParam(name="rut")String rut){
		int resultado = 0;
        Conexion db = new Conexion();
        Connection cn = db.Conectar();
        String ped="0";
    	try{
    		Statement st = cn.createStatement();
    		// SE CAE SE DEJA EN 0 PARA PODER CREAR UNA BOLETA 
			String sql="INSERT INTO PEDIDO VALUES("+id_boleta+",1,1,NULL,"+rut+",NULL,getdate())";
	        st.executeUpdate(sql);
	        resultado=1;
	        st.close();
	        System.out.println("Inserto Pedido");
	    }catch(SQLException ex){
	        ex.printStackTrace();
	        resultado=0;
	        	//pruebas por consola
	        System.out.println("Error al insertar el Pedido");
	    }
    	if(resultado == 1){
    		try{
    	    	String sql = "SELECT ID_PEDIDO FROM PEDIDO WHERE ID_BOLETA = "+id_boleta;
    	    	ResultSet rs= null;
    	    	Statement st = cn.createStatement();
    			rs = st.executeQuery(sql);	
    			while(rs.next()){
    				Pedido p = new Pedido();
    		    	p.setIdPedido(rs.getString(1));
    		    	System.out.println("Pedido: "+rs.getString(1));
    		    	ped=rs.getString(1);
    		    }
    	    }catch(SQLException e){
    	    	e.printStackTrace();
    	    	ped = "0";
    	    }   		
    	}
    	return ped;
	}
	@WebMethod(operationName = "insertBoletaProducto")
	public int insertBoletaProducto(@WebParam(name = "tommy") String tommy,@WebParam(name="asu") String asu,
			@WebParam(name = "bianka")String bianka){
		ArrayList<Boleta> list = new ArrayList<Boleta>();
	    Conexion db = new Conexion();
	    Connection cn = db.Conectar();
	    int boleta = 0;
	    int resultado = 0;
	    try {
	    	String sql = "SELECT TOP 1 ID_BOLETA FROM BOLETA WHERE RUT_USER = "+tommy+" ORDER BY ID_BOLETA DESC";
	    	ResultSet rs= null;
	    	Statement st = cn.createStatement();
			rs = st.executeQuery(sql);	
			while(rs.next()){
				Boleta bl = new Boleta();
		    	bl.setIdBoleta(Integer.parseInt(rs.getString(1)));
		    	list.add(bl);
		    	boleta = bl.getIdBoleta();
		    	resultado = 1;
		    }
			System.out.println("la boleta es "+boleta);
	    }
	    catch (SQLException e) {
			System.out.println("select Boleta no funciono");
			resultado = 0;
			e.printStackTrace();
		}
	    if(resultado==1){
			try {
				Statement stm = cn.createStatement();
				String sql2="INSERT INTO BOLETA_PRO (ID_BOLETA,ID_PRODUCTO,CANTIDAD) VALUES ("+boleta+","+asu+","+bianka+")";
		    	stm.executeUpdate(sql2);
		    	System.out.println("Inserto ("+boleta+","+asu+","+bianka+")");
		        resultado=1;
		        stm.close();
			} catch (SQLException e) {
				System.out.println("No inserto Nada");
				resultado=0;
				e.printStackTrace();
			}
		}
	    return resultado; 
	}
	@WebMethod(operationName = "CamitantesBlancos")
	public CaminantesOscuros[] CamitantesBlancos(@WebParam(name="id_boleta") String id_boleta){
		ArrayList<CaminantesOscuros> list = new ArrayList<CaminantesOscuros>();
		Conexion db = new Conexion();
	    Connection cn = db.Conectar();
	    try{
	    	String sql = "SELECT P.NOMBRE,SUM(B.CANTIDAD)AS CANTIDAD,SUM(B.CANTIDAD*P.VALOR)AS PRECIO "
	    			+ "FROM BOLETA_PRO B JOIN PRODUCTO P ON P.ID_PRODUCTO = B.ID_PRODUCTO "
	    			+ "WHERE B.ID_BOLETA = "+id_boleta+" GROUP BY B.ID_PRODUCTO,P.NOMBRE";
	    	ResultSet rs= null;
	    	Statement st = cn.createStatement();
			rs = st.executeQuery(sql);	
			while(rs.next()){
				CaminantesOscuros co = new CaminantesOscuros();
		    	co.setX(rs.getString(1)+" Cant: "+ rs.getString(2)+" Total: "+rs.getString(3));
		    	list.add(co);
		    	System.out.println("Producto: "+rs.getString(1)+" Cant: "+ rs.getString(2)+" Total: "+rs.getString(3));
		    }
	    }catch(SQLException e){
	    	e.printStackTrace();
	    }
		return (CaminantesOscuros[])list.toArray(new CaminantesOscuros[list.size()]);
	}
	
	@WebMethod(operationName = "CamitantesBlancosPro")
	public CaminantesOscuros[] CamitantesBlancosPro(@WebParam(name="id_boleta") String id_boleta){
		ArrayList<CaminantesOscuros> list = new ArrayList<CaminantesOscuros>();
		Conexion db = new Conexion();
	    Connection cn = db.Conectar();
	    try{
	    	String sql = "SELECT P.ID_PRODUCTO,P.NOMBRE,SUM(B.CANTIDAD)AS CANTIDAD,P.VALOR,SUM(B.CANTIDAD*P.VALOR)AS TOTAL "
	    			+ "FROM BOLETA_PRO B JOIN PRODUCTO P ON P.ID_PRODUCTO = B.ID_PRODUCTO "
	    			+ "WHERE B.ID_BOLETA = "+id_boleta+" GROUP BY P.ID_PRODUCTO,P.NOMBRE,P.VALOR";
	    	ResultSet rs= null;
	    	Statement st = cn.createStatement();
			rs = st.executeQuery(sql);	
			while(rs.next()){
				CaminantesOscuros co = new CaminantesOscuros();
		    	co.setU(rs.getString(1));
		    	co.setW(rs.getString(2));
		    	co.setX(rs.getString(3));
		    	co.setY(rs.getString(4));
		    	co.setZ(rs.getString(5));
		    	list.add(co);
		    	System.out.println("Boleta = "+id_boleta);
		    	System.out.println("ID: "+rs.getString(1)+" Nombre: "+ rs.getString(2)+" Cantidad: "+rs.getString(3)+" Valor: "+rs.getString(4)+" Total: "+rs.getString(5));
		    }
	    }catch(SQLException e){
	    	e.printStackTrace();
	    }
		return (CaminantesOscuros[])list.toArray(new CaminantesOscuros[list.size()]);
	}
	
	@WebMethod(operationName = "selectPedido")
	public String selectPedido (@WebParam(name="id_boleta") String id_boleta,@WebParam(name="rut")String rut){
        Conexion db = new Conexion();
        Connection cn = db.Conectar();
        String pedido=null;
    	try{
    	    String sql = "SELECT ID_PEDIDO FROM PEDIDO WHERE ID_BOLETA = "+id_boleta;
    	    ResultSet rs= null;
    	    Statement st = cn.createStatement();
    		rs = st.executeQuery(sql);	
    		while(rs.next()){
    			Pedido p = new Pedido();
    		    p.setIdPedido(rs.getString(1));
    		    System.out.println("Pedido: "+rs.getString(1));
    		    pedido=rs.getString(1);
    		   }
    	   }catch(SQLException e){
    	    e.printStackTrace();
    	    pedido = "0";
    	   }  
    	return pedido;
	}

	
	@WebMethod(operationName = "actualizarPedido")
	public int actualizarPedido (@WebParam(name="id_pedido") String id_pedido,@WebParam(name="id_boleta")String id_boleta){
		int resultado = 0;
		String txt;
		Conexion db = new Conexion();
        Connection cn = db.Conectar();
        try{
        	Statement st = cn.createStatement();
        	String sql = "UPDATE PEDIDO SET ID_TIPOESTADO = 3 ,"
        			+ "FECHA_ENTREGA = GETDATE() WHERE ID_PEDIDO = "+id_pedido+" AND ID_BOLETA = "+id_boleta;
        	st.executeUpdate(sql);
        	txt = "Modificado Pedido : "+id_pedido+", Boleta : "+id_boleta;
        	resultado = 1;
        	System.out.println(txt);
        }catch(SQLException ex){
        	System.out.println("fallo en el try");
        	txt = "Error al actualizar Usuario";
        	ex.printStackTrace();
        }
		return resultado;
	}
}

