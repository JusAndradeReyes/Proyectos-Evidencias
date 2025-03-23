package com.item.modelo;
public class Item {
	
	private Producto producto;
	private Integer cantidad;
	
	//CONSTRUCTORS
	public Item() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Item(Producto producto, Integer cantidad) {
		super();
		this.producto = producto;
		this.cantidad = cantidad;
	}
	
	//GETTERS AND SETTERS
	public Producto getProducto() {
		return producto;
	}
	
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	
	public Integer getCantidad() {
		return cantidad;
	}
	
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	
	//MÉTODO PARA CALCULAR LA CANTIDAD DE PRODUCTOS
	public double getTotalProductos() {
		return producto.getPrecio()*cantidad.doubleValue();
	}
}
