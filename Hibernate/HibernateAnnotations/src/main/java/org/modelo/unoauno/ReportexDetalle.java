package org.modelo.unoauno;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class ReportexDetalle {
	
	private int id;
	private String comentario;
	private String observaciones;
	private Reportex id_reportex_fk;
	
	@Id
	@Column(nullable = false)
	@GeneratedValue
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getComentario() {
		return comentario;
	}
	
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	
	public String getObservaciones() {
		return observaciones;
	}
	
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	
	/*
	 * ALL: PERSIST, MERGE, REMOVE REFRESH
	 * 
	 * CUAL ES LA DIFERENCIA ENTRE EAGER Y LAZY?
	 * EAGRE(ANSIOSO) = CARGA TODAS LAS TABLAS ASOCIADAS.
	 * LAZY(PEREZOSO) = CARGA TABLA POR TABLA
	 * 
	 * JOIN(UNIR): UNIÓN ENTRE LAS DOS COLUMNAS ID -- ID_REPORTEX_FK
	 */
	
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name = "id_reportex_fk")
	public Reportex getId_reportex_fk() {
		return id_reportex_fk;
	}
	
	public void setId_reportex_fk(Reportex id_reportex_fk) {
		this.id_reportex_fk = id_reportex_fk;
	}
}
