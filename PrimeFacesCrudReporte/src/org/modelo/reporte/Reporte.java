package org.modelo.reporte;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Reporte implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String nombre;
	private String tipo;
	private String comentario;
	
	public Reporte() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Reporte(int id, String nombre, String tipo, String comentario) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.tipo = tipo;
		this.comentario = comentario;
	}

	@Id
	@GeneratedValue
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

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
}
