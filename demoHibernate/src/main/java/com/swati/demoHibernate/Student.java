package com.swati.demoHibernate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "student_details")
public class Student {
	
	@Id
	private int id;
	private StudentName name;
	
	//use @Transient annotation when you don't want to store this record in the table
	private String color;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public StudentName getName() {
		return name;
	}
	public void setName(StudentName name) {
		this.name = name;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", color=" + color + "]";
	}
}
