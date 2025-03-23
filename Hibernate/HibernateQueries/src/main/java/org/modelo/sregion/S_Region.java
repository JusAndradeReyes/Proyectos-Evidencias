package org.modelo.sregion;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
/*
 * HIBERNATE QUERIES
 * 
 * SAVE=INSERT	UPDATE=UPDATE	DELETE=DELETE	=GET=sELECT
 * 
 *						hibernate.cfg.xml 
 * 
 * 		ORACLE	---------- MAPPING	------ DAO
 * TABLE S_REGION		 CLASS, XML	     QUERIES
 */
@Entity
public class S_Region {
	
	private int id;
	private String name;
	
	@Id
	@Column(nullable = false)
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
