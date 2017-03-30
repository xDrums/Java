/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.easy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.swing.text.StyledEditorKit.BoldAction;

import com.easy.util.Conexion;
import com.easy.entidad.Usuario;
import com.sun.jndi.cosnaming.CNCtx;

@WebService(serviceName = "UsuarioWebService")
public class UsuarioWebService {
    
    @WebMethod(operationName = "loginUser")
    public String loginUser(@WebParam(name = "username") String username, @WebParam(name = "password") String password) {
    	String nom = null;
        ResultSet rs = null;
        Conexion db = new Conexion();
        Connection cn = db.Conectar();
    	try{
			Statement st = cn.createStatement();
			String sql="SELECT RUT_USER,PASSWRD,NOMBRE FROM USUARIO "
					+ "WHERE RUT_USER ="+username+" AND PASSWRD ='"+password+"'";
			rs = st.executeQuery(sql);
			while(rs.next()){
				String rut = rs.getString("RUT_USER");
				String pass = rs.getString("PASSWRD");
				nom = rs.getString("NOMBRE");
				if(username.equalsIgnoreCase(rut) && password.equalsIgnoreCase(pass)){
					System.out.println(nom);
					System.out.println("Funciono Correctamente");
					return nom;
				}
				rs.close();
			}					
		}catch(SQLException ex){
					System.out.println("fallo el try");
					ex.printStackTrace();
		}
		return nom;
    }
    @WebMethod(operationName="agregarUsuario")
    public int agregarUsuario (@WebParam(name="rut")String rut,@WebParam(name="nombre")String nombre,
    		@WebParam(name="correo")String correo,@WebParam(name="password")String password,
    		@WebParam(name="direccion")String direccion, @WebParam(name="telefono")String telefono)
    {
    	int resultado=1;
        Conexion db = new Conexion();
        Connection cn = db.Conectar();
        String sql = "INSERT INTO USUARIO(RUT_USER,NOMBRE,CORREO,PASSWRD,DIRECCION,TELEFONO) "
    			+ "VALUES('"+rut+"','"+nombre+"','"+correo+"','"+password+"','"+direccion+"','"+telefono+"')";
        try{        	
            Statement st = cn.createStatement();
        	st.executeUpdate(sql);
        	resultado=0;
        	//pruebas por consola
        	System.out.println("Usuario Ingresado");
        }catch(SQLException ex){
        	ex.printStackTrace();
        	resultado=1;
        	//pruebas por consola
        	System.out.println("Error al insertar el usuario");
        }
        return resultado;
    }
    @WebMethod(operationName="modificarUsuario")
    public String modificarUsuario (@WebParam(name="rut")String rut,@WebParam(name="nombre")String nombre,
    		@WebParam(name="correo")String correo,@WebParam(name="password")String password,
    		@WebParam(name="direccion")String direccion, @WebParam(name="telefono")String telefono)
    {
    	String txt = null;
        Conexion db = new Conexion();
        Connection cn = db.Conectar();
        try{
        	Statement st = cn.createStatement();
        	String sql = "UPDATE USUARIO SET CORREO='"+correo+"',PASSWRD='"+password+"',DIRECCION='"+direccion+"',"
        			+ "TELEFONO='"+telefono+"' WHERE RUT_USER = '"+rut+"'";
        	st.executeUpdate(sql);
        	txt = nombre+" Modificado";  
        	System.out.println("Usuario Modificado"+ nombre);
        }catch(SQLException ex){
        	System.out.println("fallo en el try");
        	txt = "Error al actualizar Usuario";
        	ex.printStackTrace();
        }
    	return txt;
    }
    @WebMethod(operationName="selectUsuario")
    public Usuario[] selectUsuario(@WebParam(name="rut")String rut)
    {
    	ArrayList<Usuario> list = new ArrayList<Usuario>();
    	String txt = null;
    	ResultSet rs = null;
        Conexion db = new Conexion();
        Connection cn = db.Conectar();
        try{
        	Statement st = cn.createStatement();
        	String sql = "SELECT NOMBRE,CORREO,PASSWRD,DIRECCION,TELEFONO FROM USUARIO WHERE RUT_USER="+rut+"";
        	rs = st.executeQuery(sql);
        	while(rs.next()){
        		Usuario usr = new Usuario();
        		usr.setNombre(rs.getString(1));
        		usr.setCorreo(rs.getString(2));
        		usr.setPassword(rs.getString(3));
        		usr.setDireccion(rs.getString(4));
        		usr.setTelefono(rs.getString(5));
        		list.add(usr);
        		//pruebas por consola
            	System.out.println("Usuario Ingresado");
        	}
        	cn.close();
        }catch(SQLException ex){
        	ex.printStackTrace();
        	//pruebas por consola
        	System.out.println("Error al insertar el usuario");
        }
    	return (Usuario[])list.toArray(new Usuario[list.size()]);
    }
}
