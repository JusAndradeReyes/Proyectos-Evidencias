package org.modelo.estudiante;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class Estudiante {
	
	private int id;
	private String nombre;
	private String email;
	private int edad;
	private float apoyo;
	private String fecha;
	
	@Id
	@Column(nullable = false)
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
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public int getEdad() {
		return edad;
	}
	
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	public float getApoyo() {
		return apoyo;
	}
	
	public void setApoyo(float apoyo) {
		this.apoyo = apoyo;
	}
	
	public String getFecha() {
		return fecha;
	}
	
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
}
