package com.easy.entidad;

public class Pedido {
	
	private String idPedido;
	private String idBoleta;
	private String idTipoPedido;
	private String idTipoEstado;
	private String Direccion;
	private String rut;
	private String fechaIngreso;
	private String fechaEntrega;
	
	public Pedido() {
		super();
	}
	
	public String getIdPedido() {
		return idPedido;
	}
	public void setIdPedido(String idPedido) {
		this.idPedido = idPedido;
	}
	public String getIdBoleta() {
		return idBoleta;
	}
	public void setIdBoleta(String idBoleta) {
		this.idBoleta = idBoleta;
	}
	public String getIdTipoPedido() {
		return idTipoPedido;
	}
	public void setIdTipoPedido(String idTipoPedido) {
		this.idTipoPedido = idTipoPedido;
	}
	public String getIdTipoEstado() {
		return idTipoEstado;
	}
	public void setIdTipoEstado(String idTipoEstado) {
		this.idTipoEstado = idTipoEstado;
	}
	public String getDireccion() {
		return Direccion;
	}
	public void setDireccion(String direccion) {
		Direccion = direccion;
	}
	public String getRut() {
		return rut;
	}
	public void setRut(String rut) {
		this.rut = rut;
	}
	public String getFechaIngreso() {
		return fechaIngreso;
	}
	public void setFechaIngreso(String fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	public String getFechaEntrega() {
		return fechaEntrega;
	}
	public void setFechaEntrega(String fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}
	

}
