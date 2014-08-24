package com.example.test.lib;

public class Deptartment {

	private int id ;
	private String name;

	public Deptartment() {}

	public Deptartment(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
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
	
	@Override
	public String toString() {
		return "Deptartment [id=" + id + ", name=" + name + "]";
	}
}
