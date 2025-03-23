package com.producto.modelo;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name="PRODUCTO")
public class Producto {
	
	@Id
	@Column(name="ID")
	
	@GeneratedValue
	private int id;
	@Column(name="NOMBRE")
	private String nombre;
	@Column(name="PRECIO")
	private String precio;
	
	//CONSTRUCTOR METHODS
	public Producto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Producto(int id, String nombre, String precio) {
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

	public String getPrecio() {
		return precio;
	}

	public void setPrecio(String precio) {
		this.precio = precio;
	}
}
