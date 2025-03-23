package org.modelo.empleado;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the EMPLEADO database table.
 * 
 */
@Entity
//ESTO SE PUEDE INVOCAR DIRECTAMENTE
@NamedQueries({
	@NamedQuery(name="EMPLEADO_SELECT_ALL",query = "select a from Empleado a"),
	@NamedQuery(name="EMPLEADO_BY_ID",query = "select a from Empleado a where a.id = :p"),
})
@NamedQuery(name="Empleado.findAll", query="SELECT e FROM Empleado e")
public class Empleado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String nombre;

	private double salario;

	public Empleado() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getSalario() {
		return this.salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

}