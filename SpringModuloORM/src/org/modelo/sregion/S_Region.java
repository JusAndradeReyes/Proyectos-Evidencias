package org.modelo.sregion;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class S_Region {
	
	private int id;
	private String name;
	
	public S_Region() {
		super();
		// TODO Auto-generated constructor stub
	}

	public S_Region(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	@Id
	@GeneratedValue

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
