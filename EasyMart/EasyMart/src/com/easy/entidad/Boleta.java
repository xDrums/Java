package com.easy.entidad;

public class Boleta {
	private int idBoleta;
    private int rut;
    private int idSucursal;
    private int total;
    private String fecha;
    private int idEmpleado;
    
    public Boleta(){
    	super();
    }
    public Boleta(int idBoleta,int rut, int idSucursal, int total, String fecha, int idEmpleado){
        super();
        this.idBoleta = idBoleta;
        this.rut = rut;
        this.idSucursal = idSucursal;
        this.total = total;
        this.fecha = fecha;
        this.idEmpleado = idEmpleado;

    }
    
    public int getIdBoleta() {
		return idBoleta;
	}
    public void setIdBoleta(int idBoleta) {
		this.idBoleta = idBoleta;
	}
    public int getRut() {
		return rut;
	}
    public void setRut(int rut) {
		this.rut = rut;
	}
    public int getIdSucursal() {
		return idSucursal;
	}
    public void setIdSucursal(int idSucursal) {
		this.idSucursal = idSucursal;
	}
    public int getTotal() {
		return total;
	}
    public void setTotal(int total) {
		this.total = total;
	}
    public String getFecha() {
		return fecha;
	}
    public void setFecha(String fecha) {
		this.fecha = fecha;
	}
    public int getIdEmpleado() {
		return idEmpleado;
	}
    public void setIdEmpleado(int idEmpleado) {
		this.idEmpleado = idEmpleado;
	}
	
}
