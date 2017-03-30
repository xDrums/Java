package com.easy.entidad;

public class Boleta_pro {
	private int id_boleta;
	private int id_producto;
	private int cantidad;
	private String nom;
	
	public Boleta_pro() {
		
	}

	/*public Boleta_pro(int id_boleta,int id_producto, int cantidad) {
		this.id_boleta= id_boleta;
		this.id_producto= id_producto;
		this.cantidad = cantidad;
	}*/
	public int getId_boleta() {
		return id_boleta;
	}

	public void setId_boleta(int id_boleta) {
		this.id_boleta = id_boleta;
	}

	public int getId_producto() {
		return id_producto;
	}

	public void setId_producto(int id_producto) {
		this.id_producto = id_producto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public void setNombre(String nombre){
		this.nom = nom;
	}
	public String getNombre(){
		return nom;
	}

}
