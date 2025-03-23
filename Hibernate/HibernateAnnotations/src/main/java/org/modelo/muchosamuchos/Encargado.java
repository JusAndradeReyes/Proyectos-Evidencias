package org.modelo.muchosamuchos;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
/*
 * EJEMPLO: RELACION MUCHOS A MUCHOS
 *         *                                    *
 * ENCARGADO -----|-< ENCEVE >-|--------------- EVENETO
 * ID_ENC				ID_ENCEVE				ID_EVE
 * NOMBRE				ID_EVE					NOMBRE
 * 
 * UN ENCARGADO TIENE MUCHOS EVENTOS
 * 					  MUCHOS EVENTOS TIEN UN ENCARGADO
 */
@Entity
public class Encargado {
	
	private int id_enc;
	private String nombre;
	private List<Evento> eventos = new ArrayList<Evento>();
	
	@Id
	@Column(nullable = false)
	@GeneratedValue
	
	public int getId_enc() {
		return id_enc;
	}
	
	public void setId_enc(int id_enc) {
		this.id_enc = id_enc;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@ManyToMany
	@JoinTable(name="EncEve",
	joinColumns = {@JoinColumn(name="id_enc")},
	inverseJoinColumns = {@JoinColumn(name="id_eve")})
	
	public List<Evento> getEventos() {
		return eventos;
	}
	
	public void setEventos(List<Evento> eventos) {
		this.eventos = eventos;
	}
}