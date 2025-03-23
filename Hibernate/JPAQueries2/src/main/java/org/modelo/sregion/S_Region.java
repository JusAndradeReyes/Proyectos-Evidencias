package org.modelo.sregion;
import java.io.Serializable;
import javax.persistence.*;
/**
 * The persistent class for the S_REGION database table.
 * 
 */
@Entity
//ESTO SE PUEDE INVOCAR DIRECTAMENTE
@NamedQueries({
	@NamedQuery(name="S_REGION_SELECT_ALL",query = "select a from S_Region a"),
	@NamedQuery(name="S_REGION_BY_ID",query = "select a from S_Region a where a.id = :p"),
})
public class S_Region implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String name;

	public S_Region() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
}