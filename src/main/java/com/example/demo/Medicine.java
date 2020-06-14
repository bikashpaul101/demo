package com.example.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "medicine")
public class Medicine {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "medicineid")
	private long id;
	@Column(name = "name")
	private String Name;
	@Column(name = "power")
	private String power;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getPower() {
		return power;
	}
	public void setPower(String power) {
		this.power = power;
	}

}
