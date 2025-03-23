package org.modelo.unoamuchos;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Personal {
	
	private int id;
	private String nombre;
	private String apepat;
	private Departamento id_departamento_fk;
	
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
	
	public String getApepat() {
		return apepat;
	}
	
	public void setApepat(String apepat) {
		this.apepat = apepat;
	}
	
	@ManyToOne
	@JoinColumn(name = "id_departamento_fk")
	
	public Departamento getId_departamento_fk() {
		return id_departamento_fk;
	}
	
	public void setId_departamento_fk(Departamento id_departamento_fk) {
		this.id_departamento_fk = id_departamento_fk;
	}
}
