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
@Entity
public class Evento {
	
	public int id_eve;
	public String nombre;
	private List<Encargado> encargados = new ArrayList<Encargado>();
	
	@Id
	@Column(nullable = false)
	@GeneratedValue
	
	public int getId_eve() {
		return id_eve;
	}
	
	public void setId_eve(int id_eve) {
		this.id_eve = id_eve;
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
	
	public List<Encargado> getEncargados() {
		return encargados;
	}
	
	public void setEncargados(List<Encargado> encargados) {
		this.encargados = encargados;
	}
}

