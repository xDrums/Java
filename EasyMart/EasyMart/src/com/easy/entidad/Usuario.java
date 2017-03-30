package com.easy.entidad;

public class Usuario {
	String rut;
	String nombre;
	String correo;
	String password;
	String direccion;
	String telefono;
	
	public Usuario(){
		super();
	}
	public Usuario(String rut,String nombre,String correo,String password,String direccion,String telefono){
		super();
		this.rut=rut;
		this.nombre=nombre;
		this.correo=correo;
		this.password=password;
		this.direccion=direccion;
		this.telefono=telefono;
				
	}
	public String getRut() {
		return rut;
	}
	public void setRut(String rut) {
		this.rut = rut;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
}
