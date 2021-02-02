package com.t9.octavo.models;

public class Factura {

	String IdFactura;
	int iva;
	double totalVenta;
	int tipoFactura;
	
	public Factura(String idFactura, int iva, double totalVenta, int tipoFactura) {
		super();
		IdFactura = idFactura;
		this.iva = iva;
		this.totalVenta = totalVenta;
		this.tipoFactura = tipoFactura;
	}

	public String getIdFactura() {
		return IdFactura;
	}

	public void setIdFactura(String idFactura) {
		IdFactura = idFactura;
	}

	public int getIva() {
		return iva;
	}

	public void setIva(int iva) {
		this.iva = iva;
	}

	public double getTotalVenta() {
		return totalVenta;
	}

	public void setTotalVenta(double totalVenta) {
		this.totalVenta = totalVenta;
	}

	public int getTipoFactura() {
		return tipoFactura;
	}

	public void setTipoFactura(int tipoFactura) {
		this.tipoFactura = tipoFactura;
	}
	
	
	
	
}
