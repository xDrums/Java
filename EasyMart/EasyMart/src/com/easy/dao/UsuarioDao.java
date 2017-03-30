package com.easy.dao;

import java.sql.*;

import javax.swing.JOptionPane;

import jdk.nashorn.internal.runtime.regexp.joni.ast.StateNode;

import com.easy.util.Conexion;

public class UsuarioDao {

	Conexion con = new Conexion();
	Connection cn = con.Conectar();
	int rut;
	String pass;
	String nom;
	
	public String conectarUser(int login,String password){
		try{
			Statement st = cn.createStatement();
			String sql="SELECT RUT_USER,PASSWRD,NOMBRE WHERE RUT_USER ="+login+" AND PASSWRD ='"+password+"'";
			ResultSet rs;
			rs = st.executeQuery(sql);

			while(rs.next()){
				rut = rs.getInt("RUT_USER");
				pass = rs.getString("PASSWRD");
				nom = rs.getString("NOMBRE");
				
			}
		}catch(SQLException ex){

					ex.printStackTrace();
		}
		return nom;
	}
}
