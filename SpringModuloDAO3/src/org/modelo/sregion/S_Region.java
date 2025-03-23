package org.modelo.sregion;

public class S_Region {
	
	private int id;
	private String name;
	
	public S_Region() {
		super();
	}
	
	//SELECT * FROM S_REGION WHERE ID = ?
	//DELETE FROM S_REGION WHERE ID = ?
	public S_Region(int id) {
		super();
		this.id = id;
	}
	//INSERT INTO S_REGION (ID,NAME) VALUES (?,?)
	public S_Region(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	//UPDATE S_REGION SET NAME = ? WHERE ID = ?	
	public S_Region(String name, int id) {
		super();
		this.name = name;
		this.id = id;
	}
	
	//GETERS AND SETTERS
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
