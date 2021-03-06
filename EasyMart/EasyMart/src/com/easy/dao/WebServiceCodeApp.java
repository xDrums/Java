package com.easy.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.easy.entidad.Boleta_pro;
import com.easy.entidad.Pedido;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import com.easy.entidad.Producto;
import com.easy.util.Conexion;


@WebService(serviceName = "WebServiceCodeApp")
public class WebServiceCodeApp {
	
	//Enlista todos los Pedidos 
	@WebMethod(operationName = "pedidosTodos")
    public Pedido[] pedidosTodos(@WebParam(name = "id_boleta") String id_boleta) {
		ArrayList<Pedido> list = new ArrayList<Pedido>();
		ResultSet rs = null;
        Conexion db = new Conexion();
        Connection cn = db.Conectar();
    	try{
			Statement st = cn.createStatement();
			String sql="SELECT P.ID_PEDIDO,P.ID_BOLETA,TE.DESCRIPCION,P.RUT_USUARIO,P.FECHA_INGRESO "+
						"FROM PEDIDO P "+
						"JOIN TIPO_ESTADO TE ON TE.ID_TIPOESTADO = P.ID_TIPOESTADO "+
						"WHERE TE.ID_TIPOESTADO = 1 AND FECHA_ENTREGA IS NULL";
			rs = st.executeQuery(sql);
			while(rs.next()){
				Pedido pd = new Pedido();
				pd.setIdPedido(rs.getString(1));
				pd.setIdBoleta(rs.getString(2));
				pd.setIdTipoEstado(rs.getString(3));
				pd.setRut(rs.getString(4));
				pd.setFechaIngreso(rs.getString(5));
				list.add(pd);
				//Pruebas Error
        		System.out.println("Pedido Boleta Ok "+ id_boleta+"");
			}
		}catch(SQLException ex){
			//Pruebas Error
			System.out.println("fallo en el try Pedidos Todos");
        	ex.printStackTrace();
		}
    	return (Pedido[])list.toArray(new Pedido[list.size()]);
    }
	
	//Enlista todos los productos del pedido
	@WebMethod(operationName = "productosPedidos")
    public Boleta_pro[] productosPedidos(@WebParam(name = "id_boleta") String id_boleta) {
		ArrayList<Boleta_pro> list = new ArrayList<Boleta_pro>();
		ResultSet rs = null;
        Conexion db = new Conexion();
        Connection cn = db.Conectar();
    	try{
			Statement st = cn.createStatement();
			String sql="SELECT BP.ID_BOLETA,BP.ID_PRODUCTO,P.NOMBRE,SUM(BP.CANTIDAD) AS CANTIDAD "+
						"FROM BOLETA_PRO BP JOIN PRODUCTO P ON P.ID_PRODUCTO = BP.ID_PRODUCTO "+
						"WHERE BP.ID_BOLETA = "+id_boleta+" GROUP BY BP.ID_BOLETA,BP.ID_PRODUCTO,NOMBRE";
			rs = st.executeQuery(sql);
			while(rs.next()){
				Boleta_pro bp = new Boleta_pro();
				bp.setId_boleta(Integer.parseInt(rs.getString(1)));
				bp.setId_producto(Integer.parseInt(rs.getString(2)));
				bp.setNombre(rs.getString(3));
				bp.setCantidad(Integer.parseInt(rs.getString(4)));
				list.add(bp);
				//Pruebas Error
        		System.out.println("Productos Pedidos Ok "+ id_boleta+"");
			}
		}catch(SQLException ex){
			//Pruebas Error
			System.out.println("fallo en el try Productos Pedidos");
        	ex.printStackTrace();
		}
    	return (Boleta_pro[])list.toArray(new Boleta_pro[list.size()]);
    }
	
	@WebMethod(operationName = "updatePedido")
    public String updatePedido(@WebParam(name = "id_pedido") String id_pedido,@WebParam(name = "id_boleta")String id_boleta) {
		ResultSet rs = null;
        Conexion db = new Conexion();
        Connection cn = db.Conectar();
        String codigoQR="0";
        
    	try{
    		
    		Statement st = cn.createStatement();
        	String sql = "UPDATE PEDIDO SET ID_TIPOESTADO = 4 WHERE ID_PEDIDO = "+id_pedido;
        	st.executeUpdate(sql);
        	codigoQR = id_boleta+""+id_pedido;
        	
		}catch(SQLException ex){
			//Pruebas Error
			
			codigoQR = "0";
			System.out.println("fallo en el try Productos Pedidos");
        	ex.printStackTrace();
		}
    	return codigoQR;
    }
	
}
