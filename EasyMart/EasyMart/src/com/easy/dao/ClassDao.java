package com.easy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import com.easy.util.Conexion;

public class ClassDao {
	

	//Inicio Modificar Producto
	
	public static boolean validateModificarProducto(String idProd,String nom,String det,int vlr,int idtipo,int stock,int idProveedor) {          
        boolean status = false;  
        PreparedStatement pst = null;
        PreparedStatement pst2 = null;
        
        Conexion db = new Conexion();
        Connection cn = db.Conectar();
        Connection cn2 = db.Conectar();
        try {  
      	
            pst = cn.prepareStatement("UPDATE PRODUCTO SET NOMBRE='"+nom+"',DETALLE='"+det+"',VALOR="+vlr+",ID_TIPOPRODUCTO="+idtipo+",STOCK="+stock+" where ID_PRODUCTO = "+idProd+"");
            pst.executeUpdate();
            pst2 = cn2.prepareStatement("UPDATE PROVEEDOR_PRO SET ID_PROVEEDOR ="+idProveedor+" WHERE ID_PRODUCTO ="+idProd+"");
            pst2.executeUpdate();
            status = true;
  
        } catch (Exception e) {  
            System.out.println(e);  
        } finally {  
            if (cn != null) {  
                try {  
                	db.Desconectar(cn);
                } catch (Exception e) {  
                    e.printStackTrace();  
                }  
            }  
            if (pst != null) {  
                try {  
                    pst.close(); 
                } catch (SQLException e) {  
                    e.printStackTrace();  
                }   
            }  
        }  
        return status;
    }
	//Fin Modificar Empleado
	public static boolean validateModificarEmpleado(int idUser, String user,String pass,String email,String paterno,String materno,String nom,int rol) {          
        boolean status = false;  
        PreparedStatement pst = null;  
        Conexion db = new Conexion();
        Connection cn = db.Conectar();
        try {  
            pst =cn.prepareStatement("UPDATE usuario set USUARIO ='"+user+"',CONTRASENA='"+pass+"',EMAIL='"+email+"',PATERNO='"+paterno+"',MATERNO ='"+materno+"',NOMBRE='"+nom+"',ROL="+rol+" where USUARIO_ID = "+idUser+"");
            pst.executeUpdate();  
        } catch (Exception e) {  
            System.out.println(e);  
        } finally {  
            if (cn != null) {  
                try {  
                	db.Desconectar(cn); 
                } catch (Exception e) {  
                    e.printStackTrace();  
                }  
            }  
            if (pst != null) {  
                try {  
                    pst.close();  
                } catch (SQLException e) {  
                    e.printStackTrace();  
                }   
            }  
        }  
        return status;
    }
	//Fin Modificar Empleado
	public static boolean validateModificarSucursal(String idsuc,int idcom,String dir,int tel,int rut) {          
        boolean status = false;  
        PreparedStatement pst = null;        
        Conexion db = new Conexion();
        Connection cn = db.Conectar();

        try {  
            pst = cn.prepareStatement("UPDATE SUCURSAL SET ID_COMUNA = "+idcom+", DIRECCION='"+dir+"',TELEFONO="+tel+",RUT="+rut+" where ID_SUCURSAL = "+idsuc+"");
            pst.executeUpdate();
            status = true;
        } catch (Exception e) {  
            System.out.println(e);  
        } finally {  
            if (cn != null) {  
                try {  
                	db.Desconectar(cn);
                } catch (Exception e) {  
                    e.printStackTrace();  
                }  
            }  
            if (pst != null) {  
                try {  
                    pst.close(); 
                } catch (SQLException e) {  
                    e.printStackTrace();  
                }   
            }  
        }  
        return status;
    }
	
	//Eliminar Producto
	 public static boolean validateEliminarProducto(String id_producto) {          
	        boolean status = false;  
	        PreparedStatement pst = null;  
	        Conexion db = new Conexion();
	        Connection cn = db.Conectar();  
	        try {  

	            pst = cn.prepareStatement("DELETE FROM PRODUCTO WHERE ID_PRODUCTO ="+id_producto+"");
	            pst.executeUpdate();
	  
	        } catch (Exception e) {  
	            System.out.println(e);  
	        } finally {  
	        	 if (cn != null) {  
	                 try {  
	                 	db.Desconectar(cn); 
	                 } catch (Exception e) {   
	                    e.printStackTrace();  
	                }  
	            }  
	            if (pst != null) {  
	                try {  
	                    pst.close();  
	                } catch (SQLException e) {  
	                    e.printStackTrace();  
	                }   
	            }  
	        }  
	        return status;
	    }
	 
	 //Fin Eliminar Producto
	 
	 //Inicio Eliminar Empleado
	 
	 public static boolean validateEliminarEmpleado(String codigo) {          
	        boolean status = false;  
	        PreparedStatement pst = null;  
	        Conexion db = new Conexion();
	        Connection cn = db.Conectar();
            
	        try {  

	            pst = cn.prepareStatement("DELETE FROM EMPLEADO where ID_EMPLEADO ="+codigo+"");
	            pst.executeUpdate();
	  
	        } catch (Exception e) {  
	            System.out.println(e);  
	        } finally {  
	        	 if (cn != null) {  
	                 try {  
	                 	db.Desconectar(cn); 
	                 } catch (Exception e) {  
	                    e.printStackTrace();  
	                }  
	            }  
	            if (pst != null) {  
	                try {  
	                    pst.close();  
	                } catch (SQLException e) {  
	                    e.printStackTrace();  
	                }   
	            }  
	        }  
	        return status;
	    }
	//Fin Eliminar Usuario
	 public static boolean validateEliminarSucursal1(String idSuc) {          
	        boolean status = false;  
	        PreparedStatement pst = null;  
	        Conexion db = new Conexion();
	        Connection cn = db.Conectar();  
	        try {  

	            pst = cn.prepareStatement("DELETE FROM SUCURSAL WHERE ID_SUCURSAL ="+idSuc+"");
	            pst.executeUpdate();
	  
	        } catch (Exception e) {  
	            System.out.println(e);  
	        } finally {  
	        	 if (cn != null) {  
	                 try {  
	                 	db.Desconectar(cn); 
	                 } catch (Exception e) {   
	                    e.printStackTrace();  
	                }  
	            }  
	            if (pst != null) {  
	                try {  
	                    pst.close();  
	                } catch (SQLException e) {  
	                    e.printStackTrace();  
	                }   
	            }  
	        }  
	        return status;
	    }
	 public static boolean validateEliminarSucursal2(String id_sucursal) {          
	        boolean status = false;  
	        PreparedStatement pst = null;  
	        Conexion db = new Conexion();
	        Connection cn = db.Conectar();  
	        try {  

	            pst = cn.prepareStatement("DELETE FROM SUCURSAL WHERE ID_SUCURSAL ="+id_sucursal+"");
	            pst.executeUpdate();
	  
	        } catch (Exception e) {  
	            System.out.println(e);  
	        } finally {  
	        	 if (cn != null) {  
	                 try {  
	                 	db.Desconectar(cn); 
	                 } catch (Exception e) {   
	                    e.printStackTrace();  
	                }  
	            }  
	            if (pst != null) {  
	                try {  
	                    pst.close();  
	                } catch (SQLException e) {  
	                    e.printStackTrace();  
	                }   
	            }  
	        }  
	        return status;
	    }
	//Inicio Validar Login
	 
	 public static boolean validateLogin(String n, String p) {          
	        boolean status = false;  
	        PreparedStatement pst = null;  
	        ResultSet rs = null;
	        Conexion db = new Conexion();
	        Connection cn = db.Conectar();
            
	        try {  
	            pst = cn.prepareStatement("SELECT USUARIO, PASSWRD, ID_TIPOEMPLEADO FROM EMPLEADO where USUARIO =? and PASSWRD=?");
	            pst.setString(1, n);
	            pst.setString(2, p);
	            rs = pst.executeQuery();
	            status = rs.next();  
	  
	        } catch (Exception e) {  
	            System.out.println(e);  
	        } finally {  
	            if (db.Conectar() != null) {  
	                try {  
	                	cn.close();  
	                } catch (SQLException e) {  
	                    e.printStackTrace();  
	                }  
	            }  
	            if (pst != null) {  
	                try {  
	                    pst.close();  
	                } catch (SQLException e) {  
	                    e.printStackTrace();  
	                }  
	            }  
	            if (rs != null) {  
	                try {  
	                    rs.close();  
	                } catch (SQLException e) {  
	                    e.printStackTrace();  
	                }  
	            }  
	        }  
	        return status;  
	    }  
	 //Fin Validar Login
	 
	 //Busqueda Productos Nombre
	 public static boolean validarBusqueda(String codbusq) {          
	        boolean status = false;  
	        PreparedStatement pst = null;  
	        Conexion db = new Conexion();
	        Connection cn = db.Conectar();  
	        try {  

	            pst = cn.prepareStatement("select NOMBRE,DETALLE,VALOR,ID_TIPOPRODUCTO,STOCK,FECHA_INGRESO,ID_PROVEEDOR from producto where NOMBRE like ='%"+codbusq+"%'");
	            pst.executeQuery();
	  
	        } catch (Exception e) {  
	            System.out.println(e);  
	        } finally {  
	        	 if (cn != null) {  
	                 try {  
	                 	db.Desconectar(cn); 
	                 } catch (Exception e) {   
	                    e.printStackTrace();  
	                }  
	            }  
	            if (pst != null) {  
	                try {  
	                    pst.close();  
	                } catch (SQLException e) {  
	                    e.printStackTrace();  
	                }   
	            }  
	        }  
	        return status;
	    }
}
