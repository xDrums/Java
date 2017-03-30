package com.easy.entidad;


public class Producto {
	private int idProducto;
    private String nombre;
    private String detalle;
    private String valor;
    private int id_tipoproducto;
    private int stock;
    private byte[] foto;
    
    
    public Producto(){
    	super();
    }
    public Producto(int idProducto,String nombre, String detalle, String valor, int id_tipoproducto, int stock,byte[] foto){
        super();
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.detalle = detalle;
        this.valor = valor;
        this.id_tipoproducto = id_tipoproducto;
        this.stock = stock;
        this.foto = foto;
    }
    public int getIdProducto(){
        return idProducto;
    }
   public void setIdProducto(int idProducto){
	   this.idProducto = idProducto;
   }
    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
 	   this.nombre = nombre;
    }
    public String getDetalle(){
        return detalle;
    }
   public void setDetalle(String detalle){
	   this.detalle = detalle;
   }
    public String getValor(){
        return  valor;
    }
    public void setValor(String valor){
    	this.valor = valor;
    }
    public int getId_Tipo(){
        return id_tipoproducto;
    }
    public void setId_Tipo(int id_tipoproducto){
    	this.id_tipoproducto = id_tipoproducto;
    }
    public int getStock(){
        return stock;
    }
    public void setStock(int stock){
    	this.stock = stock;
    }
    public byte[] getFoto(){
        return foto;
    }
    public void setFoto(byte[] foto){
    	this.foto = foto;
    }
    
}