package org.modelo.uno;
import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/*
 * EJEMPLO: CREAR UNA TABLA
 * 
 * BITACORA
 * ID			NUMBER
 * NOMBRE		VARCHAR2
 * FECHA		DATE
 * COMENTARIO	VARCHAR2
 * 
 * 1.- DECLARAR VARIABLES ENCAPSULADAS(PRIVATE)
 * 2.- GENERAR GETTERS AND SETTERS
 * 3.- AGREGAR LAS ANOTACIONES: @Entity, @Id, @Column, @GeneratedValue
 */
@Entity //ENTIDAD
public class Bitacora {
	private int id;
	private String nombre;
	private Date fecha;
	private String comentario;
	
	@Id //PRIMARY KEY
	@Column(nullable = false) //NOT NULL
	@GeneratedValue //CREATE SEQUENCEINCREMENT BY
	
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
	
	public Date getFecha() {
		return fecha;
	}
	
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	public String getComentario() {
		return comentario;
	}
	
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	
	

}
