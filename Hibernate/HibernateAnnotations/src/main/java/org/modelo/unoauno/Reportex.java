package org.modelo.unoauno;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/*
 * EJEMPLO: RELACION UNO A UNO
 * 
 * RPORTEX _____________REPORTEXDETALLE
 * ID					ID
 * NOMBRE				COMENTARIO
 * 						OBSERVACIONES
 * 						ID_REPORTEX_FK
 */
@Entity
public class Reportex {
	private int id;
	private String nombre;
	
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
}
