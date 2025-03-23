package com.persona.modelo;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name = "persona")
public class Persona {
	
	@Id
	@Column(name = "id")
	@GeneratedValue
	private int id;
	@Column(name = "nombre")
	private String nombre;
	@Column(name = "telefono")
	private String telefono;
	
	
	//CONSTRUCTORS METHODS
	public Persona() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Persona(int id, String nombre, String telefono) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.telefono = telefono;
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

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
}
