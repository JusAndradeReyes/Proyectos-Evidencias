package org.modelo.unoamuchos;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/*
 * EJEMPLO: RELACION UNO A MUCHOS
 * 			1          *
 * DEPARTAMENTO ------< PERSONAL
 * ID					ID
 * NOMBRE				NOMBRE
 * 						APEPAT
 * 						ID_DEPARTAMENTO_FK
 * 
 * LECTURA DE RELACIÓN: UN DEPARTAMENTO CONTIENE MUCHO PERSONAL,
 * 												 MUCHO PERSONAL PERTENECE A UN DEPARTAMENTO
 * 												 MUCHO = LIST 
 */
@Entity
public class Departamento {
	private int id;
	private String nombre;
	private List<Personal> personal;
	
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
	
	@OneToMany(mappedBy = "id_departamento_fk",cascade = CascadeType.ALL,
			fetch = FetchType.EAGER)
	
	public List<Personal> getPersonal() {
		return personal;
	}
	
	public void setPersonal(List<Personal> personal) {
		this.personal = personal;
	}
}
