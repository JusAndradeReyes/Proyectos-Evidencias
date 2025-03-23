package com.reporte.modelo;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name= "REPORTE")
public class Reporte {
	
	@Id
	@Column(name ="ID")
	@GeneratedValue
	private int id;
	@Column(name ="NOMBRE")
	private String nombre;
	@Column(name ="TIPO")
	private String tipo;
	@Column(name ="COMENTARIO")
	private String comentario;
	
	//CONSTRUCTORS METHODS
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
