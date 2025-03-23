package com.item.modelo;
public class Producto {
	
	private int id;
	private String nombre;
	private double precio;
	
	
	//CONTRUCTORS METHODS
	public Producto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Producto(int id, String nombre, double precio) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
	}
	
	//GETTERS AND SETTERS
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public double getPrecio() {
		return precio;
	}
	
	public void setPrecio(double precio) {
		this.precio = precio;
	}
}
