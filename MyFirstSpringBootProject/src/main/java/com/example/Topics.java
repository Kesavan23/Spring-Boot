package com.example;



//@Entity
public class Topics {

	public Topics(String id, String description) {
		super();
		this.id = id;
		this.description = description;
	}
	public Topics() {
		// TODO Auto-generated constructor stub
	}
	//@Id
	public String id;
	public String description;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

}
